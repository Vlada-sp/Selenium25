package dan1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver Linkedin = new ChromeDriver();
        Linkedin.manage().window().maximize();

        Linkedin.navigate().to("https://linkedin.com");
        Linkedin.navigate().refresh();
        Linkedin.navigate().to("https://www.joberty.com");
        String previousUrl = Linkedin.getCurrentUrl();
        Linkedin.navigate().back();
        System.out.println("trenutni sajt je "+ Linkedin.getCurrentUrl());
        System.out.println("prethodni je " + previousUrl);

        Linkedin.quit();



    }
}

//Zadatak 1
//Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
//vratite se nazad i odstampajte poslednji URL na kom se nalazite
//na kraju zatvorite driver