package dan3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Vezba2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to("http://wordpress.com");

        Cookie cookie =new Cookie("wordpress_logged_in","vladaspasicmob%7C1845055850%7C2AoECUx9YtcNNwkMZgvwOeFBzvJ3dQ1dxbY4HTCPPTK%7Ca33c541ccd1586cfdd7e968dfcaf256e1e556285ec1fc7143d170a67d0f3f3cf");
  driver.manage().addCookie(cookie);
  driver.navigate().refresh();
    }
// odem inspect i onda aplication i onda dole logged in
}
