import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SafronovaOlgaTest {

    @Test
    public static void test () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/olgasafronova/Downloads/chromedriver 2");

        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id='weather-widget']//input[@placeholder='Search city']")
        );

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id='weather-widget']//button[@type='submit']")
        );

        searchButton.click();
        Thread.sleep(1000);
        driver.quit();
    }
    /**
     *  WebElement searchCityField = driver.findElement(
     *                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
     *        );
     *        searchCityField.click();
     *        searchCityField.sendKeys(cityName);
     *
     *        WebElement searchButton = driver.findElement(
     *                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
     *        );
     *        searchButton.click();
     *        Thread.sleep(1000);
     */
    // TC_03
    //p[@class='stick-footer-panel__description' ]
    /**
     * WebDriverWait wait = new WebDriverWait(driver, 25);
     *         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
     *                 By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
     *
     *         wait.until(ExpectedConditions.elementToBeClickable(
     *                 By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
     *         Thread.sleep(5000);
     */
}
