package Gun11_Actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_ActionDragAndDropTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html"); // siteyi açtım

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        WebElement oslo= driver.findElement(By.id("box1"));
        WebElement norvec= driver.findElement(By.id("box101"));

        Actions builder=new Actions(driver);

        Action build=builder.dragAndDrop(oslo,norvec).build();
        Thread.sleep(3000);
        build.perform();;

        WebElement copenhagen= driver.findElement(By.id("box4"));
        WebElement denmark= driver.findElement(By.id("box104"));

        Action build2=builder.dragAndDrop(copenhagen,denmark).build();
        Thread.sleep(3000);
        build2.perform();





        Thread.sleep(6000);
        driver.quit();




    }
}
