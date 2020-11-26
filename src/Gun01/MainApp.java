package Gun01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BaseStaticDriver;

public class MainApp extends BaseStaticDriver {
    public static void main(String[] args) {
         System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
         // hangi browserı kullanacağımı ve tarayıcının path ini verdim.
        // WebDriver driver = new ChromeDriver(); // çalıştıracağımız driverı kontrol edecek değişkeni tanımladım.
         driver.get("https://www.google.com.tr/"); // siteyi açtım
         driver.navigate().to("https://www.google.com.tr/"); // geri-ileri gelebilme ozelligi var
    }
}
