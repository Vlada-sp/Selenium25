package dan2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class DomaciLosPassword {
    private static final Logger log = LoggerFactory.getLogger(Domaci.class);

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement loginn = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginn.isDisplayed());

        WebElement login = driver.findElement(By.id("user-name"));
        login.click();
        login.sendKeys("standard_user", Keys.TAB);
        driver.findElement(By.id("password")).sendKeys("secret_saucejj",Keys.ENTER);




        driver.quit();


    }
}
