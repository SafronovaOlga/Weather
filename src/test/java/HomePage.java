import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    private WebDriver driver;
   // private ChromeDriver driver;

    public HomePage(WebDriver driver) {
       // System.setProperty("webdriver.chrome.driver", "/Users/olgasafronova/Downloads/chromedriver 2");
        // /Users/olgasafronova /Applications/ChromeDriver
      //  System.setProperty("webdriver.chrome.driver","/Users/olgasafronova/Downloads/chromedriver 2");
      //  ChromeDriver driver = new ChromeDriver();
        this.driver = driver;
    }

    public ResultPage search(String text) {
        //div[@id='inputWrapper']/input[@id='input']
        driver.findElement(By.id("//div[@id='inputWrapper']/input[@id='input']")).sendKeys(text);

        return new ResultPage(driver);
    }
}
