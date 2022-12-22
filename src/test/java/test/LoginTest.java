package test;

import Pages.HomeLoginPage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private HomeLoginPage homePage;

    public LoginTest() {
        super();
    }

    @Before
    public void setUp() {
       this.getDriver();
       this.loginPage = new LoginPage(this.driver);
    }

    @Test
    public void testTitle() {
       Assert.assertEquals(true, this.loginPage.titleIs());
    }

    @Test
    public void testLoginSuccess() {
        this.loginPage.login("frank.atencio.loreth@gmail.com","admin@123456");
        homePage = new HomeLoginPage(this.driver);
        Assert.assertEquals("Login Successfully", homePage.loginSuccessFullyMsg());
    }

    @Test
    public void testLoginFail() {
        this.loginPage.login("frank.atencio.loreth@gmail.com","admin@12345");
        homePage = new HomeLoginPage(this.driver);
        Assert.assertEquals("Enter your userName and password correct", this.loginPage.loginErrorMsg());
    }

    @Test
    public void testVisibleSingLink() {
        Assert.assertEquals(true, this.loginPage.isDisplayed(this.loginPage.SINGUP_LINK));
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

}
