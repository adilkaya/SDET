package Gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05_IFrameOrnek extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();


        driver.switchTo().frame("flow_close_btn_iframe");

        WebElement kapatbtn=driver.findElement(By.id("closeBtn"));
        kapatbtn.click();

        Thread.sleep(6000);
        driver.quit();


    }
}
