package dan1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium4 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();

        driver2.navigate().to("https://www.google.com");
        JavascriptExecutor js2 = (JavascriptExecutor) driver2;

        js2.executeScript("window.open()");
        js2.executeScript("window.open()");
        js2.executeScript("window.open()");
        js2.executeScript("window.open()");
        js2.executeScript("window.open()");
        ArrayList <String> ListaTabova2 = new ArrayList<>(driver2.getWindowHandles());
        driver2.switchTo().window(ListaTabova2.get(1));
        driver2.navigate().to("https://www.youtube.com");
        driver2.switchTo().window(ListaTabova2.get(2));
        driver2.navigate().to("https://www.warthunder.com");
        driver2.switchTo().window(ListaTabova2.get(3));
        driver2.navigate().to("https://www.worldofwarcraft.com");
        driver2.switchTo().window(ListaTabova2.get(4));
        driver2.navigate().to("https://www.facebook.com");
        driver2.switchTo().window(ListaTabova2.get(5));
        driver2.navigate().to("https://www.instagram.com");

//        for (int i = 1 ; i <ListaTabova2.size();i++){
//            driver2.switchTo().window(ListaTabova2.get(i));
//            driver2.close();
//        }
         for (int i = 0; i< ListaTabova2.size();i++){
             driver2.switchTo().window(ListaTabova2.get(i));
           if (!driver2.getCurrentUrl().equals("https://www.google.com")){
               driver2.close();
           }
         }
// ovo dole ja sam sebi nesto probao
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList <String> ListaTabova = new ArrayList<>(driver.getWindowHandles());

        for (int i = 0; i< ListaTabova.size();i++){
            driver.switchTo().window(ListaTabova.get(i));
            driver.navigate().to("https://www.google.com");

        }
        for (int i = 1; i< ListaTabova.size();i++){
            driver.switchTo().window(ListaTabova.get(i));
            driver.close();

        }


}}








//Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google
// malo sam expandovao