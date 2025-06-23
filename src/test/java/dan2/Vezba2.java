package dan2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Vezba2 {
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
       driver.findElement(By.id("password")).sendKeys("Password123");
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




//Zadatak 5
//Na linku https://practicetestautomation.com/ otici do login stranice, uradite log in i dodajte asertacije
//profa
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//public class Zadatak5 {
//    public static void main(String[] args) {
//
//        //Zadatak 5
// /Na linku https://practicetestautomation.com/ otici do login stranice, uradite log in i dodajte asertacije
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://practicetestautomation.com/");
//
//        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
//        practiceButton.click();
//
//        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
//        testLoginPageButton.click();
//
//        WebElement usernameField = driver.findElement(By.id("username"));
//        WebElement passwordField = driver.findElement(By.id("password"));
//
//        String usernameCredentials = "student";
//        String passwordCredentials = "Password123";
//
//        usernameField.clear();
//        usernameField.sendKeys(usernameCredentials);
//        passwordField.clear();
//        passwordField.sendKeys(passwordCredentials);
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
//
//        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
//        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
//
//        WebElement loginTitle = driver.findElement(By.className("post-title"));
//        Assert.assertTrue(loginTitle.isDisplayed());
//
//        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
//        Assert.assertTrue(logOutButton.isDisplayed());
//
//        WebElement userTitle = driver.findElement(By.className("has-text-align-center"));
//        String expectedUserTitle = "Congratulations " +usernameCredentials+ ". You successfully logged in!";
//        Assert.assertEquals(userTitle.getText(), expectedUserTitle);
//
//    }
//}