package Gun11_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_ActionRightClickTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/buttons"); // siteyi açtım

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        WebElement rightClickButton= driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        Actions builder=new Actions(driver); // driver üzerinden aksiyonları çalıştırmak için değişken tanımladım

        Action build= builder.moveToElement(rightClickButton).build(); // aksiyonlar değişkenine bir aksiyon ekledim.
        // Henüz işlem olmadı.

        Thread.sleep(2000);
        build.perform(); // Aksiyon yapılıyor.







        Thread.sleep(6000);
        driver.quit();




    }
}
