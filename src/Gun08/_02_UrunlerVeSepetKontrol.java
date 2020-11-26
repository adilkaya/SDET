package Gun08;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _02_RelativeXpathVsAbsoluteXPath extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("secret_sauce");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();


        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> sepeteEkleme = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        for (WebElement tiklar : sepeteEkleme) {
            tiklar.click();
        }

        WebElement sepetTikla = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
        sepetTikla.click();
        Thread.sleep(2000);

        List<WebElement> secim = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        for (WebElement elemnts : products) {
            Assert.assertEquals(products, secim);
        }


        Thread.sleep(1000);
        driver.quit();
    }
}

