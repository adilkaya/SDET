package Gun16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_RobotOrnek2Alternatif extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/upload/");

        WebElement input=driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\TechnoStudy\\Desktop\\ornek.txt");

        WebElement btn = driver.findElement(By.id("submitbutton"));
        btn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}