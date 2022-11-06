
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class GooglePageTest {

    private ChromeDriver driver;


    @BeforeMethod
    public void setUp() {
       // ChromeDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

    /**
     * 1. Given user is on Google home page
     * 2. When I search text "automated testing info"
     * 3. Then I should see first link contains text "automated"
     */
    @Test
    public void testSearch() {
      //  System.setProperty("webdriver.chrome.driver","/Users/olgasafronova/Downloads/chromedriver 2");
      //    WebDriver driver = new ChromeDriver();

        HomePage home = new HomePage(driver);
        ResultPage result = home.search("automated testing info");

        Assert.assertTrue(result.getFirstLink().contains("automated"));

    }
}
