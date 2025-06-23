package dan2;


  import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
public class Selenium3 {

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.bing.com");

            Thread.sleep(3000);
            WebElement bingSearchBox = driver.findElement(By.id("sb_form_q"));
            bingSearchBox.sendKeys("Wikipedia");
            bingSearchBox.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            WebElement wikipediaButton = driver.findElement(By.linkText("Wikipedia"));
            wikipediaButton.click();
            ArrayList<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowHandleList.get(1));
            WebElement wikipediaSearchBox = driver.findElement(By.id("searchInput"));
            wikipediaSearchBox.sendKeys("Nikola Tesla");

            // Prvi nacin je pronalazenje elementa preko klase koja u sebi ima razmak
            //WebElement wikipediaSearchButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
            WebElement wikipediaSearchButton = driver.findElement(By.cssSelector("button[type='submit']"));
            wikipediaSearchButton.click();

            //--------------------------------

            Thread.sleep(3000);

            String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL);

            WebElement pageTitle = driver.findElement(By.id("firstHeading"));
            Assert.assertEquals(pageTitle.getText(), "Nikola Tesla");

            WebElement pageImage = driver.findElement(By.className("infobox-image"));
            Assert.assertTrue(pageImage.isDisplayed());

            //-------------------------

            String expectedAltText = "Head-and-shoulder photograph of a slender man with dark hair and moustache, dark suit and white-collar shirt";
            String actualAltText = pageImage.findElement(By.tagName("img")).getAttribute("alt");
            Assert.assertEquals(actualAltText, expectedAltText);

            driver.quit();
        }
    }