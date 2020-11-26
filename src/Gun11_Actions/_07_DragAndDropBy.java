package Gun11_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _06_ActionDragAndDropTest3 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php"); // siteyi açtım
        driver.manage().window().maximize();

        WebElement krediButton=driver.findElement(By.id("credit1"));
        WebElement kutu=driver.findElement(By.id("loan"));

        Actions builder=new Actions(driver);


        Action build=builder.clickAndHold(krediButton).moveToElement(kutu).release().build();
        Thread.sleep(2000);
        build.perform();




        Thread.sleep(3000);
        driver.quit();
    }
}
