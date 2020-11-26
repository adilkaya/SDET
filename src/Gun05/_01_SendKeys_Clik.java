package Gun05;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;
import org.junit.Assert.*;

public class _01_SendKeys_Clik extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/"); // siteyi açtım
        WebElement link=driver.findElement(By.linkText("Check Out")) ;
        Thread.sleep(3000);
        link.click(); // acilan kisma tiklar

        WebElement email=driver.findElement(By.id("email")) ;
        email.sendKeys("info@techno.study"); // acilan kisma teks yazar

        WebElement name=driver.findElement(By.id("name")) ;
        name.sendKeys("Adil"); // acilan kisma teks yazar

        WebElement address=driver.findElement(By.id("address")) ;
        address.sendKeys("buralar karisacak vaziyet alin"); // acilan kisma teks yazar

        WebElement button=driver.findElement(By.className("btn-primary")) ;
        button.click();

        WebElement menu=driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914921")) ;
        String menuTxt=menu.getText();
        Assert.assertEquals("Menu", menuTxt);

        String url=driver.getCurrentUrl();
        Assert.assertEquals("http://www.practiceselenium.com/menu.html?", url);





        Thread.sleep(6000);
        driver.quit();

    }
}
