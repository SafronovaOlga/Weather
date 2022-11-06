package HW_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;

public class HW_011 {
    /**
     *
     TC_11_01
     1.  Открыть базовую ссылку
     2.  Нажать на пункт меню Guide
     3.  Подтвердить, что вы перешли на страницу
     со ссылкой https://openweathermap.org/guide
     и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap
     */
    @Test
    public void testOpenMenuGuide () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/olgasafronova/Downloads/chromedriver 2");

        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String urlGuide = "https://openweathermap.org/guide";

        String expectedResult = "OpenWeatherMap API guide";

        driver.get(url);
        sleep(5000);



        driver.quit();
    }

    /**
     * TC_11_05
     * 1. Открыть базовую ссылку
     * 2. Нажать пункт меню Support → Ask a question
     * 3. Заполнить поля Email, Subject, Message
     * 4. Не подтвердив CAPTCHA, нажать кнопку Submit
     * 5. Подтвердить, что пользователю будет показана ошибка
     * “reCAPTCHA verification failed, please try again.”
     */

    @Test
    public void testTC_11_05() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Application//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        sleep(4000);
        driver.manage().window().maximize();

        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id='support-dropdown']"));

        menuSupport.click();
        driver.findElement(
                        By.xpath("//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"))
                .click();

        sleep(4500);

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindowHadles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHadles.iterator();


        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!originalWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.name("question_form[email]"));
                text.click();
                text.sendKeys("tatianapak0210@gmail.com");
            }
        }

        Select select = new Select(driver.findElement(By.id("question_form_subject")));

        select.getFirstSelectedOption();
        driver.findElement(By.name("question_form[message]")).sendKeys("Message");
        driver.findElement(By.name("commit")).click();

        String actualResult = driver.findElement(By.xpath("//div[@class='has-error']/div")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
