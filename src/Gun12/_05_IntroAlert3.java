package Gun12;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;
/*

 */

public class _04_IntroAlert3 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); // siteyi açtım
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        WebElement clickFor=driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        WebElement textActual=driver.findElement(By.id("prompt-demo"));
        Thread.sleep(2000);
        clickFor.click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("hadi yine iyisin");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Assert.assertTrue(textActual.getText().contains("hadi yine iyisin"));//input[@name='submit']

        Thread.sleep(3000);
        driver.quit();

    }
}
