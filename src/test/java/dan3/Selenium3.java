package dan3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in", "dragoljubqa%7C1845054980%7CUT67Y9cllgukFWVtgvFMiSFvPPcH4XU1yLIx46xe8Db%7C2232851c62a6e9c1b487718b56563b8302ebd230be2f3cbab07eeb4045156b76");
        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        // Logovanje preko kolacica necemo raditi kao poseban test jer to nije slucaj gde bi se korisnici logovali na ovaj nacin
        // Mozemo da se ulogujemo preko kolacica da sebi skratimo posao logovanja kada zelimo nesto dalje da radimo na aplikaciji
        // na primer u ovom slucaju zelimo da testiramo promenu username-a

        // Takodje moze da sluzi kao 'workaround' kada postoji problem kod samo logovanja gde neki deo aplikacije
        // ne radi i da ne bismo ostali blokirani mozemo da se logujemo na ovaj nacin

        // U dogovoru sa developerima moze se na test okruzenjima podesiti veca duzina trajanja sesije i ova vrednost
        // kolacica bi mogla da bude aktivna mnogo duze pod uslovom da se ne izlogujete rucno, jer bi to poslalo zahtev
        // da se ponisti vrednost kolacica


    }
}