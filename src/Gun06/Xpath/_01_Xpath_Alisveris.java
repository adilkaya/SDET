package Gun06.Xpath;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _01_Xpath_Alisveris extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
//TODO xpath de css selectordeki tag basina // koyulur ve parametrenin basina @ konulur
//   css in eleman bulmada zorlandigi veya ise yaramadigi yerlerde kullanilir
//
//   css selector de tag in text i kullanilmazken xpath de text ile eleman bulunabilir
//   //div[text()='text'] -->> parametre girmedigimiz icin @ isareti kullanmadik

        driver.get("https://www.saucedemo.com/"); // siteyi açtım

        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        Thread.sleep(2000);

        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();

        Thread.sleep(2000);

        WebElement canta2 = driver.findElement(By.xpath(" //div[text()='Sauce Labs Backpack']"));
        canta2.click();
        Thread.sleep(1000);

        WebElement addtocart2 = driver.findElement(By.xpath(" //button[text()='ADD TO CART']"));
        addtocart2.click();
        Thread.sleep(1000);

        WebElement backbutton = driver.findElement(By.xpath(" //button[text()='<- Back']"));
        backbutton.click();
        Thread.sleep(1000);

        WebElement tshirt = driver.findElement(By.xpath(" //div[text()='Sauce Labs Bolt T-Shirt']"));
        tshirt.click();
        Thread.sleep(1000);

        WebElement addtshirt = driver.findElement(By.xpath(" //button[text()='ADD TO CART']"));
        addtshirt.click();
        Thread.sleep(1000);

        WebElement shopping = driver.findElement(By.xpath("//div[@class='shopping_cart_container']")); //div[@id='shopping_cart_container']
        shopping.click();
        Thread.sleep(1000);

        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement checkout = driver.findElement(By.xpath("//a[text()='CHECKOUT']")); //a[text()='CHECKOUT']
        checkout.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("Adil");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("Kaya");
        Thread.sleep(1000);

        WebElement postalCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCode.sendKeys("06145");
        Thread.sleep(1000);

        WebElement contains = driver.findElement(By.xpath("//div[@class='checkout_buttons']//following::input[1]"));
        //input[@class='btn_primary cart_button']
        contains.click();
        Thread.sleep(1000);

        WebElement urun1 = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
        String txtFiyat1 = urun1.getText();
        Thread.sleep(1000);

        WebElement urun2 = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[2]"));
        String txtFiyat2 = urun2.getText();
        Thread.sleep(1000);


        WebElement subtotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        //*[contains(@class,'summary_subtotal_label')]
        String txtToplam = subtotal.getText();

        System.out.println("fiyat1=" + txtFiyat1);
        System.out.println("fiyat2=" + txtFiyat2);
        System.out.println("toplamfiyat=" + txtToplam);

        double urunFiyatToplam=stringToDouble(txtFiyat1)+stringToDouble(txtFiyat2);
        double toplam=stringToDouble(txtToplam);

        Assert.assertTrue(toplam==urunFiyatToplam);

        System.out.println("Alisverisiniz basariyla gerceklesti, iyi gunlerde kullanmaniz dilegiyle :)");



        Thread.sleep(2000);
        driver.quit();

    }

    public static double stringToDouble(String strTutar)
    {
        double tutar=0;

        String duzeltilmisHali=strTutar.replaceAll("[^\\d.]","");
        // d yani sayı ve . haricindekileri(^) , bosluk ata yani sil

        return  Double.parseDouble(duzeltilmisHali);
    }

}
