package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    private final By FIRTSNAME_INPUT = By.name("firstName");
    private final By LASTNAME_INPUT = By.name("lastName");
    private final By PHONE_INPUT = By.name("phone");
    private final By EMAIL_INPUT = By.name("userName");
    private final By ADDRESS_INPUT = By.name("address1");
    private final By CITY_INPUT = By.name("city");
    private final By STATE_INPUT = By.name("state");
    private final By POSTALCODE_INPUT = By.name("postalCode");
    private final By COUNTRY_SELECT = By.name("country");
    private final By USERNAME_INPUT = By.name("email");
    private final By PASSWORD_INPUT = By.name("password");
    private final By PASSWORD_CONFIRM_INPUT = By.name("confirmPassword");
    private final By SUBMIT_BTN = By.name("submit");
    public final By REGISTER_LINK = By.partialLinkText("REGISTER");
    private final By REGISTER_PAR = By.xpath("(//p)[5]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(String firstName, String lastName, String phone, String email, String address, String city, String state, String postalCode, String country, String userName, String password) {
        this.click(REGISTER_LINK);
        this.sendKeys(this.FIRTSNAME_INPUT, firstName);
        this.sendKeys(this.LASTNAME_INPUT, lastName);
        this.sendKeys(this.PHONE_INPUT, phone);
        this.sendKeys(this.EMAIL_INPUT, email);
        this.sendKeys(this.ADDRESS_INPUT, address);
        this.sendKeys(this.CITY_INPUT, city);
        this.sendKeys(this.STATE_INPUT, state);
        this.sendKeys(this.POSTALCODE_INPUT, postalCode);
        this.click(this.COUNTRY_SELECT);
        this.selectItemByText(this.COUNTRY_SELECT, country);
        this.sendKeys(this.USERNAME_INPUT, userName);
        this.sendKeys(this.PASSWORD_INPUT, password);
        this.sendKeys(this.PASSWORD_CONFIRM_INPUT, password);
        this.click(this.SUBMIT_BTN);
    }

    public String welcomeRegisterMsg() {
        return this.getElementText(this.REGISTER_PAR);
    }
}
