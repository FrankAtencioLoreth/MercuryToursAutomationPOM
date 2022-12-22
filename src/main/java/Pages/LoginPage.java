package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By USERNAME_INPUT = By.name("userName");
    private final By PASSWORD_INPUT = By.name("password");
    private final By LOGIN_BTN = By.name("submit");
    private final By ERROR_MSG = By.xpath("(//span)[1]");
    public final By SINGUP_LINK = By.partialLinkText("SIGN-ON");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        this.click(this.SINGUP_LINK);
        this.sendKeys(this.USERNAME_INPUT, user);
        this.sendKeys(this.PASSWORD_INPUT, pass);
        this.click(this.LOGIN_BTN);
    }

    public String loginErrorMsg() {
        return getElementText(this.ERROR_MSG);
    }

}
