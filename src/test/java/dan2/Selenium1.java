package dan2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");

        // Lokatori / Selektori
        WebElement searchByID = driver.findElement(By.id("sb_form_q"));
        // Prvi po prioritetu i najcesce jedinstven element
        WebElement searchByName = driver.findElement(By.name("q"));
        // Drugi po prioritetu, nije nuzno jedinstven element
        WebElement searchByClass = driver.findElement(By.className("sb_form_q"));
        // Treci po prioritetu, retko kada jedinstven element
        WebElement searchByRelativeXpath = driver.findElement(By.xpath("//div[1]/div/textarea"));
        // Relativni xpath je nestabilan jer program trazi element koji se zavrsava sa datim stringom
        WebElement searchByAbsoluteXpath = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"));
        // Apsolutni xpath je nestabilan jer program trazi element pocevsi od pocetka html-a

        // Kad zelimo da iskoristimo web element onda cemo pozvati objekat i proslediti komandu nad njim
        searchByID.sendKeys("Wikipedia");
        searchByID.sendKeys(Keys.ENTER);
        searchByID.click();

        // -------------------------

        WebElement wikipediaButtonByLinkText = driver.findElement(By.linkText("Wikipedia"));
        // Retko koriscen lokator zbog slabe pojave unutar html-a
        // Da bi se element mogao pronaci kroz link text taj element mora u sebi da sadrzi <a href i da obavezno u sebi sadrzi neki text

        WebElement wikipediaButtonByClassCss = driver.findElement(By.cssSelector(".cards.card0.card-col-6.card-row-0.b_wpt_aligned"));
        // Ako imamo element koji u klasi ima vise vrednosti (postoji razmak), onda taj element mozemo naci preko
        // Css selektora, tako sto cemo umesto razmaka upisati tacku i staviti tacku na pocetak
        // original - WebElement wikipediaButtonByClassCss = driver.findElement(By.className("cards  card0 card-col-6 card-row-0  b_wpt_aligned"));
        // promenjen u css - WebElement wikipediaButtonByClassCss = driver.findElement(By.cssSelector(".cards.card0.card-col-6.card-row-0.b_wpt_aligned"));

        // <textarea id="sb_form_q" class="sb_form_q" name="q" type="search" inputmode="search" maxlength="2000" autocomplete="off" autofocus="" aria-autocomplete="both" placeholder="" aria-label="0 characters out of 2000" spellcheck="false" autocorrect="off" autocapitalize="none" rows="1" enterkeyhint="search" style="width: 628px;"></textarea>
        WebElement kakoSeKreiraCssSelektor = driver.findElement(By.cssSelector("tag[atribut='vrednost']"));
        WebElement searchByCss = driver.findElement(By.cssSelector("textarea[type='search']"));

        // Ako element nije jedinstven, mozemo napraviti listu elemenata i dati komandu koji element iz liste cemo da pozovemo
        List<WebElement> wikipediaButtonList = driver.findElements(By.className("b_gwaBody"));
        wikipediaButtonList.get(1).click();

        // Ako hocemo da izvrsimo proveru nad elementima iz liste moramo to uraditi kroz petlju
        List<WebElement> wikipediaTitleList = driver.findElements(By.className("b_gwaTitle"));
        // Prvo cemo pronaci sve elemente i ubaciti ih u listu
        for (int i = 0; i < wikipediaTitleList.size(); i++) {
            // Kroz petlju prolazimo kroz sve elemente i zelimo da u svakom elementu proverimo text
            // Dodajemo if uslov koji ce se pokrenuti ako je uslov ispunje
            // Ovde cemo proci kroz svaki element, izvuci text iz svakog elementa i radice se provera
            // da li taj text se podudara sa datim stringom
            // ako se podudara onda cemo uraditi klik nad tim elementom
            if (wikipediaTitleList.get(i).getText().equals("Wikipedia, the free encyclopedia")) {
                wikipediaTitleList.get(i).click();
                break;
            }
            // na kraju obavezno dodati break komandu koja ce prekinuti petlju
        }

        // Pronalazenje elementa preko njegovog 'parent'-a

        //parent -> <div class="search-input" id="search-input">
        //child -> <label for="searchInput" class="screen-reader-text" data-jsl10n="portal.search-input-label">Search Wikipedia</label>

        // Hocemo da pronadjemo child element preko parent elementa
        // Tako sto prvo pronadjemo parent i onda radimo findElement nad tim elementom
        WebElement parent = driver.findElement(By.id("search-input"));
        WebElement child = parent.findElement(By.className("screen-reader-text"));

    }
}