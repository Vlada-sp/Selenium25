package dan3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Domaci1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

       try{ driver.findElement(By.className("a-button-inner")).click();
       }
       catch (Exception e){

       }
        WebElement carBeforeAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(carBeforeAdding.getText(), "0");



        driver.findElement(By.id("add-to-cart-button")).click();


       // Cookie cookie = new Cookie("session-id","140-2888098-5909043");
      //  driver.manage().deleteCookie(cookie);
        driver.manage().deleteCookieNamed("session-id");
        Thread.sleep(1000);
        driver.navigate().refresh();

        driver.quit();
    }
}
