package proje2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class Proje2Senaryo3 extends BaseStaticDriver {
    /*

1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html

2) Login'e "username" -- Password'a "password" yazın. Sign in button'una tıklayınız.

3) Paybils button'ına tıklayınız.

4) Purchase Foreign Currency'ya tıklayınız.

5) Currency kısmından rastgele(RANDOM) bir değer seçiniz. (Dropdown'ın içindeki Select One değerini, Random'a dahil etmeyin.)

6) Amount'a bir değer girin.

7) U.S. dollar (USD)'ı seçiniz.

8) Purchase button'una tıklayınız.

9) Foreign currency cash was successfully purchased. yazısı görünmelidir.


     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/login.html"); // siteyi açtım
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.xpath("//input[@id='user_login']"));
        username.sendKeys("username");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        WebElement singbutton = driver.findElement(By.className("btn-primary"));
        singbutton.click();

        WebElement paybill = driver.findElement(By.xpath("//*[@id=\"pay_bills_tab\"]/a"));
        paybill.click();

        WebElement pfc = driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a"));
        pfc.click();

        Thread.sleep(2000);

        WebElement currency = driver.findElement(By.cssSelector("select[id='pc_currency']"));
        Select currencySecim = new Select(currency);
        currencySecim.selectByIndex(randomSayi(15));

        Thread.sleep(2000);

        WebElement amount = driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amount.sendKeys("100");

        WebElement dollar =driver.findElement(By.cssSelector("input#pc_inDollars_true"));
        dollar.click();
        Thread.sleep(500);

        WebElement purchaseBtn = driver.findElement(By.cssSelector("input[id='purchase_cash']"));
        purchaseBtn.click();
        Thread.sleep(1000);

        WebElement gelecekOlanmesaj = driver.findElement(By.xpath("//*[@id=\"alert_content\"]"));

        String beklenenMesaj="Foreign currency cash was successfully purchased.";

        Assert.assertEquals(beklenenMesaj,gelecekOlanmesaj.getText());



        Thread.sleep(2000);
        driver.quit();

    }


    public static int randomSayi(int sayi){


        return (int)((Math.random()*sayi)+1);
    }
}
