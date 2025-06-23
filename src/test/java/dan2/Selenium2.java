package dan2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

        driver.navigate().to("https://duckduckgo.com/");

        WebElement tsf = driver.findElement(By.id("searchbox_input"));

        Thread.sleep(1000);
        tsf.click();
        Thread.sleep(1000);
       tsf.sendKeys("Wikipedia");
        Thread.sleep(1000);
        tsf.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement wiki = driver.findElement(By.className("ikg2IXiCD14iVX7AdZo1"));
        Thread.sleep(2000);
        wiki.click();

        WebElement tesloni = driver.findElement(By.id("searchInput"));


        Thread.sleep(1000);
        tesloni.sendKeys("Nikola Tesla");
        Thread.sleep(1000);
        tesloni.sendKeys(Keys.ENTER);
    }

    }

    // profa
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.ArrayList;
//
//public class Zadatak4 {
//    public static void main(String[] args) throws InterruptedException {
//
//        //Zadatak 4
//Otici na neki pretrazivac
//Zatim ukucati "Wikipedia" u polje za pretragu
// /Odraditi pretragu i otvoriti stranicu
// /Na stranici Wikipedia pretraziti "Nikola Tesla"
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.bing.com");
//
//        Thread.sleep(3000);
//        WebElement bingSearchBox = driver.findElement(By.id("sb_form_q"));
//        bingSearchBox.sendKeys("Wikipedia");
//        bingSearchBox.sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
//        WebElement wikipediaButton = driver.findElement(By.linkText("Wikipedia"));
//        wikipediaButton.click();
//        ArrayList<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowHandleList.get(1));
//        WebElement wikipediaSearchBox = driver.findElement(By.id("searchInput"));
//        wikipediaSearchBox.sendKeys("Nikola Tesla");
//
//        // Prvi nacin je pronalazenje elementa preko klase koja u sebi ima razmak
//        //WebElement wikipediaSearchButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
//        WebElement wikipediaSearchButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        wikipediaSearchButton.click();
//
//    }
//}