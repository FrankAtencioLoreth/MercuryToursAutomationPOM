package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {

    public final String URL = "https://demo.guru99.com/test/newtours/index.php";
    public WebDriver driver;
    private final Integer time = 20;

    public BaseTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(this.time));
        this.driver.get(this.URL);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
