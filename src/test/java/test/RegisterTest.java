package test;

import Pages.RegisterPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;

    public RegisterTest() {
        super();
    }

    @Before
    public void setUp() {
        this.getDriver();
        this.registerPage = new RegisterPage(this.driver);
    }

    @Test
    public void testTitle() {
        Assert.assertEquals(true, this.registerPage.titleIs());
    }

    @Test
    public void testRegister() {
        this.registerPage.register(
                "Frank",
                "Atencio Loreth",
                "3222927493",
                "frank.atencio.loreth@gmail.com",
                "Plan Bonito",
                "El Bagre",
                "Antioquia",
                "052430",
                "COLOMBIA",
                "frank.atencio.loreth@gmail.com",
                "admin@123456"
        );

        Assert.assertEquals(
                "Thank you for registering. You may now sign-in using the user name and password you've just entered.",
                this.registerPage.welcomeRegisterMsg()
        );
    }

    @Test
    public void testVisibleRegisterLink() {
        Assert.assertEquals(true, this.registerPage.isDisplayed(this.registerPage.REGISTER_LINK));
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

}
