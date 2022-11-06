import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

   // private ChromeDriver driver;
    private WebDriver driver;


    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstLink() {

        return driver.findElement(
                By.xpath("//div[@class='yuRUbf']/a[@href='https://automated-testing.info/']")
        ).getText();

    }
}