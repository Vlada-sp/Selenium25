package dan1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("https://www.google.com");
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea")).sendKeys("IT Bootcamp", Keys.ENTER);
//
//
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea")).sendKeys("IT Bootcamp");
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[1]")).click();


        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/form/div/div/input")).sendKeys("Wikipedia");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/form/div/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[4]/div/div/div/div[2]/section[1]/ol/li[1]/article/div[3]/h2/a/span")).click();

        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input")).sendKeys("Nikola Tesla", Keys.ENTER);

        //sad sam mu dao zadatak da u to polje ( ovo gore je xpath browser bara googlovog) i onda u taj bar senduj "itbootcamp" i stisni enter.



    }
}
//Zadatak 3
//Otici na Bing
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola Tesla"