import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationCode2 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.automationanywhere.com/");

        try {
            // Click on the "Request Demo" button
            WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(), 'Request Demo')]"));
            requestDemoButton.click();

            // Wait for a moment to allow the page to load
            Thread.sleep(2000);

            // Verify the URL of the current page
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Navigation to the correct URL is successful.");
            } else {
                System.out.println("Navigation to the correct URL has failed.");
            }

            // Verify the label names for First Name and Last Name
            WebElement firstNameLabel = driver.findElement(By.xpath("//label[contains(text(), 'First Name')]"));
            WebElement lastNameLabel = driver.findElement(By.xpath("//label[contains(text(), 'Last Name')]"));

            if (firstNameLabel.isDisplayed() && lastNameLabel.isDisplayed()) {
                System.out.println("Label names for First Name and Last Name are present.");
            } else {
                System.out.println("Label names for First Name and Last Name are not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
