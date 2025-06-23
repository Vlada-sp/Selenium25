package dan4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        // Ovaj deo je bitan u ovom momentu jer se nekada prikaze poruka pre odlaska na stranicu
        // Iz razloga sto se nekad pojavi, a nekad ne, stavljamo try catch blok
        Thread.sleep(4000);
        try {
            driver.findElement(By.cssSelector("button[type='submit']")).click();
        } catch (Exception e) {

        }

        // Pre pocetka testa zelim da proverim da li je korpa prazna
        // da ne dodjem u situaciju da je korpa puna, ne radi dugme za dodavanje
        // i meni prodje test jer bih ocitao nesto u korpi

        // Takodje kada proveravam korpu zelim da proverim da li sam dodao bas tu knjigu koju sam hteo
        // Iz tog razloga je potrebno da na ovom koraku pronadjem naziv knjige i sacuvam u string koji
        // cu kasnije koristiti za asertaciju
        WebElement bookTitle = driver.findElement(By.id("productTitle"));
        String bookTitleText = bookTitle.getText();

        // Proveravam da li na korpi pise 0 pre pocetka
        WebElement cartBeforeAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartBeforeAdding.getText(), "0");

        // Odlazim na korpu da proverim da li je zaista prazna
        WebElement goToCartButton = driver.findElement(By.id("nav-cart"));
        goToCartButton.click();

        WebElement emptyCartMessage = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCartMessage.isDisplayed());

        driver.navigate().back();

        // Dodajem knjigu u korpu
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Proveravam da li je dodata i da li se broj promenio sa 0 na 1
        WebElement successMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(successMessage.isDisplayed());

        WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterAdding.getText(), "1");

        WebElement goToCartButtonAfterAdding = driver.findElement(By.id("nav-cart"));
        goToCartButtonAfterAdding.click();

        // Sad proveravam da li sam dodao bas tu knjigu u korpu
        WebElement bookTitleInCart = driver.findElement(By.className("a-truncate-cut"));
        String bookTitleInCartText = bookTitleInCart.getText();
        Assert.assertEquals(bookTitleInCartText, bookTitleText);

        // Nakon provera brisem cookie koji ce obrisati sadrzaj iz korpe
        Thread.sleep(3000);
        //driver.manage().deleteAllCookies();
        //Cookie cookie = new Cookie("session-id", "132-2990563-4347620");
        //driver.manage().deleteCookie(cookie);
        driver.manage().deleteCookieNamed("session-id");
        driver.navigate().refresh();

        // Onda proveravam da li je ponovo korpa prazna
        WebElement emptyCartMessageAfterRemoval = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCartMessageAfterRemoval.isDisplayed());

        WebElement cartAfterRemoving = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterRemoving.getText(), "0");
    }
}