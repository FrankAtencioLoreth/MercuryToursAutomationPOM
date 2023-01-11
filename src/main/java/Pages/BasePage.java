package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private final WebDriver driver;
    private Integer time = 20;
    private Integer d = 0;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.time));
    }

    public boolean titleIs() {
        String title = this.driver.getTitle();
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public void click(By locator) {
        this.delay(this.d);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void sendKeys(By locator, String text) {
        this.delay(this.d);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void clear(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    public boolean isDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public String getElementText(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean containText(By locator, String textSequence) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().contains(textSequence);
    }

    public void selectItemByText(By locator, String text) {
        this.delay(this.d);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        Select select = new Select(this.driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    private void delay(int d) {
        try {
            TimeUnit.SECONDS.sleep(d);
        }catch (InterruptedException e) {
            System.err.println("ERROR MSG = " + e.getMessage());
            System.err.println("ERROR LINE = " + e.getLocalizedMessage());
        }
    }

}
