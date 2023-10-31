import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductNavigationTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testProductNavigation() {
        driver.get("https://www.automationanywhere.com/");
        Actions actions = new Actions(driver);

        WebElement productsMenu = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        actions.moveToElement(productsMenu).perform();
        
        WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[contains(text(), 'Process Discovery')]"));
        processDiscoveryLink.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
        Assert.assertEquals(currentUrl, expectedUrl, "URL does not match expected.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
