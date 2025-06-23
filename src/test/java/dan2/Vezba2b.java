package dan2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Vezba2b {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement a1 =  driver.findElement(By.xpath("//*[@id=\"menu-item-20\"]/a"));
        a1.click();

        driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a")).click();

        WebElement user =driver.findElement(By.id("username"));
        user.click();
        user.sendKeys("student");
        Thread.sleep(1000);
        user.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Password123456");
        Thread.sleep(1000);
        WebElement submit =driver.findElement(By.id("submit"));

        submit.click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement nesto = driver.findElement(By.className("custom-logo"));
        Assert.assertTrue(nesto.isDisplayed());





        Thread.sleep(2000);
        driver.quit();

    }
}
// provera loseg pass