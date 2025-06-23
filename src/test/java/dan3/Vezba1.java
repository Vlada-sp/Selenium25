package dan3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
public class Vezba1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.navigate().to("https://wordpress.com/");
            js.executeScript("window.open()");

            ArrayList<String> ListaTablova = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(ListaTablova.get(0));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.findElement(By.linkText("Log in")).click();

            WebElement username = driver.findElement(By.id("usernameOrEmail"));
            username.clear();
            username.click();
            username.sendKeys("vladaspasicmob@gmail.com", Keys.ENTER);

            driver.findElement(By.id("password")).sendKeys("Itbootcamp123", Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/vlada60.wordpress.com"));

            String expectedURL = "https://wordpress.com/home/vlada60.wordpress.com";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            WebElement howdy = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-howdy.has-subitems.has-global-border"));
            Assert.assertTrue(howdy.isDisplayed());

            WebElement howdyuser = driver.findElement(By.cssSelector(".masterbar__item-howdy-howdy"));
            String tekst = howdyuser.getText();
            Assert.assertTrue(tekst.contains("vladasp"), "Korisnik nije vladasp!");

            System.out.println("dobro je");

            driver.switchTo().window(ListaTablova.get(1));
            driver.close();
            driver.switchTo().window(ListaTablova.get(0));

            Thread.sleep(2000);

        }  finally {
            driver.quit();
        }
    }
}
// Zadatak 6
// Ulogovati se na wordpress aplikaciju koristeci sopstvene kredencijale
// Fokus treba da bude na cekanjima i lokatorima