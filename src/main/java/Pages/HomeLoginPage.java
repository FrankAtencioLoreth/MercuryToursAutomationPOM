package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeLoginPage extends BasePage {
    private final By welcomeMsg = By.xpath("//h3");
    private final WebDriver driver;

    public HomeLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String loginSuccessFullyMsg() {
      return this.getElementText(this.welcomeMsg);
    }
}
