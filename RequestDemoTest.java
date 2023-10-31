import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RequestDemoTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testRequestDemo() {
        driver.get("https://www.automationanywhere.com/");
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(), 'Request Demo')]"));
        requestDemoButton.click();
        
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
        Assert.assertEquals(currentUrl, expectedUrl, "URL does not match expected.");

        WebElement firstNameLabel = driver.findElement(By.xpath("//label[contains(text(), 'First Name')]"));
        WebElement lastNameLabel = driver.findElement(By.xpath("//label[contains(text(), 'Last Name')]"));
        
        Assert.assertTrue(firstNameLabel.isDisplayed(), "First Name label is not displayed.");
        Assert.assertTrue(lastNameLabel.isDisplayed(), "Last Name label is not displayed.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
