package Gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseStaticDriver;

public class _01_ActionHoverOverTest_2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.etsy.com/"); // siteyi açtım
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--secondary wt-width-full']")).click();

        WebElement clothingMenu=driver.findElement(By.id("catnav-primary-link-10923"));
        WebElement kidsMenu=driver.findElement(By.id("side-nav-category-link-10941"));

        Actions builder=new Actions(driver);
        Action build=builder.moveToElement(clothingMenu).build();
        build.perform();

        Thread.sleep(1000);

        build=builder.moveToElement(kidsMenu).build();
        build.perform();

        Thread.sleep(6000);
        driver.quit();
    }
}