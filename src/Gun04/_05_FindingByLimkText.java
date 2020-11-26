package Gun04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import utils.BaseStaticDriver;

public class _05_FindingByLimkText  extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/"); // siteyi açtım

        WebElement e=driver.findElement(By.linkText("Check Out"));
        System.out.println(e.getAttribute("data-title"));

        Thread.sleep(3000);
        driver.quit();

}

}