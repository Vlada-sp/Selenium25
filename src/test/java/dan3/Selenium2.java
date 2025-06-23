package dan3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/");

        WebElement logInButton = driver.findElement(By.linkText("Log in"));
        logInButton.click();

        String username = "NEKI VAS USERNAME ILI EMAIL";
        String password = "NEKI VAS PASSWORD";
        WebElement usernameOrEmailField = driver.findElement(By.id("usernameOrEmail"));
        usernameOrEmailField.clear();
        usernameOrEmailField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        continueButton.click();

        WebElement profile = driver.findElement(By.className("masterbar__item-howdy-howdy"));
        Assert.assertTrue(profile.isDisplayed());
        Assert.assertTrue(profile.getText().contains(username));

    }
}