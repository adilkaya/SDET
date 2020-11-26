package Gun16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _04_RobotOrnek3 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get("http://demo.guru99.com/test/upload/");

        Robot rbt=new Robot();

        // ctrl+s  : kaydet kısayol
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);

        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_S);

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        // Aşağıdaki bölüm üzerine kaydetme durumunda
        // tekrar kaydetmesini sağlamak için.
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_LEFT);
        rbt.keyPress(KeyEvent.VK_ENTER);

        rbt.keyRelease(KeyEvent.VK_LEFT);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);
        driver.quit();


    }
}