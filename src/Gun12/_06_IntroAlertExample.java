package Gun12;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;
/*

 */

public class _04_IntroAlertExample extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php"); // siteyi açtım
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();



        WebElement textActual=driver.findElement(By.name("cusid"));
        Thread.sleep(2000);
        WebElement clickFor=driver.findElement(By.xpath("//input[@name='submit']"));
        Thread.sleep(2000);
        clickFor.click();
        Thread.sleep(2000);

        String alertmesaj=driver.switchTo().alert().getText();
        System.out.println(alertmesaj);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();


        Thread.sleep(3000);
        driver.quit();

    }
}
