import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationCode1 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.automationanywhere.com/");

        try {
            // Create an instance of Actions class for mouse hover
            Actions actions = new Actions(driver);

            // Identify the "Products" menu and perform a mouse hover
            WebElement productsMenu = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
            actions.moveToElement(productsMenu).perform();

            // Identify and click on "Process Discovery"
            WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[contains(text(), 'Process Discovery')]"));
            processDiscoveryLink.click();

            // Wait for a moment to allow the page to load
            Thread.sleep(2000);

            // Verify the URL of the current page
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Navigation to the correct URL is successful.");
            } else {
                System.out.println("Navigation to the correct URL has failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
