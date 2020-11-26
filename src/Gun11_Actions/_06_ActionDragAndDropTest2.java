package Gun11_Actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _05_ActionDragAndDropTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html"); // siteyi açtım

        driver.get("http://demo.guru99.com/test/drag_drop.html"); // siteyi açtım
        driver.manage().window().maximize();

        WebElement bankButton=driver.findElement(By.id("credit2"));
        WebElement kutu=driver.findElement(By.id("bank"));

        Actions builder=new Actions(driver);
        Action build=builder.dragAndDrop(bankButton, kutu).build();
        //Thread.sleep(2000);
        build.perform();


        WebElement kutuIcerigi=driver.findElement(By.cssSelector("#bank > li"));

        Assert.assertTrue(   kutuIcerigi.getText().equals(bankButton.getText())  );




        Thread.sleep(3000);
        build.perform();;
    }
}
