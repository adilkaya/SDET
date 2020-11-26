package odevActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class Odev1 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/auto-complete"); // siteyi açtım
        driver.manage().window().maximize();

        WebElement textInput=driver.findElement(By.id("autoCompleteMultipleContainer"));

        Actions builder=new Actions(driver);
        Action build=builder
                .moveToElement(textInput) // inputa gidildi.
                .click() // içine tıklandı.
                .sendKeys("b") // a tuşuna basığımızda shift basılı olduğundan büyük yazdı
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build();


        Thread.sleep(2000);
        build.perform();



        Thread.sleep(3000);
        //driver.quit();


    }
}
