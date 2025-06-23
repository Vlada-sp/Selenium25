package dan1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium3 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("window.open()"); //novi tab i samo rokas tu komandu za jos tabova
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        driver.navigate().to("https://www.google.com/");

        ArrayList<String> ListaTablova = new ArrayList<>(driver.getWindowHandles()); // mora lista nakon otvaranja zeljenih tabova
        driver.switchTo().window(ListaTablova.get(1));
        driver.navigate().to("https://www.youtube.com");
        driver.switchTo().window(ListaTablova.get(2));
        driver.navigate().to("https://www.youtube.com");

        driver.switchTo().window(ListaTablova.get(1));
        driver.close();


    }
}
