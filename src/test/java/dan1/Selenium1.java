package dan1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        // u ovoj komandi postavljam driver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //kako oces prozor da otvara

       // driver.get("https://www.google.com"); // odma loaduje
        driver.navigate().to("https://www.google.com");// prvo saceka da se ucita strana pa radi dalji kod
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println(driver.getCurrentUrl());
      //  driver.close(); //zatvara trenutni tab
        driver.quit(); //zatvara ceo browser ( cesce ovo furaj)


    }
}
