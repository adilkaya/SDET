package Gun04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _02_FindingById {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        // concola yazilan gereksiz bilgileri sessize aldi.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // hangi browserı kullanacağımı ve tarayıcının path ini verdim.
        WebDriver driver = new ChromeDriver(); // çalıştıracağımız driverı kontrol edecek değişkeni tanımladım.
        driver.get("http://www.practiceselenium.com/"); // siteyi açtım
        // driver.navigate().to("https://www.google.com.tr/"); // geri-ileri gelebilme ozelligi var

        WebElement e=driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914887"));
        System.out.println(e.getText());

        Thread.sleep(3000);
        driver.quit();
    }
}