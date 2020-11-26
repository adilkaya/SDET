package Gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;
/*

 */

public class _04_IntroAlert extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); // siteyi açtım
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        WebElement clickMe=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        clickMe.click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();



        Thread.sleep(3000);
        driver.quit();

    }
}
