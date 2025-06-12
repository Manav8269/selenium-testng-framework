package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Use WebDriverManager or set system property manually
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium GitHub Actions");
        searchBox.submit();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
