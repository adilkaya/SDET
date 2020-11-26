package Gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Instant;

public class _02_ExplicitWait2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
        WebElement name= driver.findElement(By.id("title"));
        name.sendKeys("Techno");

        WebElement comment= driver.findElement(By.id("description"));
        comment.sendKeys("Study");

        WebElement submit= driver.findElement(By.id("btn-submit"));
        submit.click();

        WebDriverWait wait=new WebDriverWait(driver, 10);
        Boolean yaziOlustu=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='submit-control']"),"Form submited Successfully!"));
        System.out.println("Islem tamamlandi mi? " + yaziOlustu);


        Thread.sleep(6000);
        driver.quit();

    }
}