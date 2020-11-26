package Gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

/*
     Interview sorusu
       - Alertleri nasıl kullanırsın (handle edersin)

          driver.switchTo().alert()   bununla kullanılır.
          komutları:
          accept -> OK, TAMAM yani olumlu butona basmak
          dismiss -> CANCEL, HAYIR yani olumsuz butona basmak
          getText -> Alertin mesaj alınır.
          SendKeys -> Alertin inputuna mesaj göndermek için kullanılır.
 */


public class _03_IntroAlert extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); // siteyi açtım
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        WebElement clickMe=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        clickMe.click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();



        Thread.sleep(3000);
        driver.quit();

    }
}
