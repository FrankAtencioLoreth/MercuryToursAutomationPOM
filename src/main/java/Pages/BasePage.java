package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    private final int time = 20;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean titleIs() {
        String title = this.driver.getTitle();
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void sendKeys(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
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
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        Select select = new Select(this.driver.findElement(locator));
        select.selectByVisibleText(text);
    }


}
