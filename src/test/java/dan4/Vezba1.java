package dan4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Vezba1 {

    // u anotacijama nema maina

    WebDriver driver;
    int i = 1;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @BeforeMethod
    public void navigateToLoginPage() {
        driver.findElement(By.xpath("//*[@id='menu-item-20']/a")).click(); // Click on "Practice"
        driver.findElement(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")).click(); // Click on "Test Login Page"
    }

    @Test(priority = 1)
    public void testValidLogin() throws InterruptedException {
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys("student");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Password123");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        // Assertion: URL should match expected after login
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Assertion: logo should be visible
        WebElement logo = driver.findElement(By.className("custom-logo"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority = 2)
    public void  testInvalidLogin2 () throws InterruptedException {
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys("studennnt");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Password123");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        // Assertion: URL should match expected after login
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Assertion: logo should be visible
        WebElement logo = driver.findElement(By.className("custom-logo"));
        Assert.assertTrue(logo.isDisplayed());

        // Assertion: invalid username message should be displayed

        WebElement poruka = driver.findElement(By.id("error"));
        Assert.assertTrue(poruka.isDisplayed());
        Assert.assertEquals(poruka.getText(), "Your username is invalid!"); // u idiu error ima na sajtu poruka your username is invalid!

    }

    @Test(priority = 0)
    public void  testInvalidPass () throws InterruptedException {
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys("student");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Password123ss");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        // Assertion: URL should match expected after login
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Assertion: invalid username message should be displayed

        WebElement poruka = driver.findElement(By.id("error"));
        Assert.assertTrue(poruka.isDisplayed());
        Assert.assertEquals(poruka.getText(), "Your password is invalid!");

    }

    @AfterMethod
    public void pozz() throws InterruptedException {



        System.out.println("test:"+ i  + " Hvala vam na ucescu u testiranju");
        i++;


        Thread.sleep(1500);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}