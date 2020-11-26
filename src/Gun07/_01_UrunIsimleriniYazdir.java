package Gun07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_UrunIsimleriniYazdir extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); // siteyi açtım

        // login işlemleri
        WebElement usernameInput=driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("secret_sauce");

        Thread.sleep(1000);
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();


        List<WebElement> urunler=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for(WebElement urun: urunler)
        {
            System.out.println(urun.getText());
        }


        Thread.sleep(6000);
        driver.quit();
    }

}
