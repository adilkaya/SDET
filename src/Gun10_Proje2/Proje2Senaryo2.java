package proje2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.Random;

public class Proje2Senaryo2 extends BaseStaticDriver {
    /*
    1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html

2) Login'e "username" -- Password'a "password" yazın. Sign in button'una tıklayınız.

3) Paybils button'ına tıklayınız.

4) Payee dropdown'unundan rastgele (Random) bir değer seçiniz.

5) Account dropdown'unundan rastgele (Random) bir değer seçiniz..

6) Amount'a bir değer girin..

7) Date'de bir tarih seçiniz.

8) Description'ı her hangi bir şekilde doldurun.

11) Pay button'una tıklayınız.

12) The payment was successfully submitted. mesajının göründüğünü doğrulayınız.

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


        int random1 = (int)(Math.random()*4+1); // String str= Integer.toString(num);   //  (//select[@id='sp_payee']/option)[1] den basliyor.....
        driver.findElement(By.xpath("(//select[@id='sp_payee']/option)["+random1 +"]")).click();

        random1 = (int)(Math.random()*6+1); // String str= Integer.toString(num);
        driver.findElement(By.xpath("(//select[@id='sp_account']/option)["+random1 +"]")).click(); Thread.sleep(500);

        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("100");

        WebElement date=driver.findElement(By.id("sp_date"));
        date.sendKeys("2020-09-08");
        Thread.sleep(500);

        WebElement descript = driver.findElement(By.xpath("//input[@id='sp_description']"));
        descript.sendKeys("100");

        WebElement pay = driver.findElement(By.className("btn-primary"));
        pay.click();



        WebElement gelecekOlanmesaj = driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));

        String beklenenMesaj="The payment was successfully submitted.";

        Assert.assertEquals(beklenenMesaj,gelecekOlanmesaj.getText());


        Thread.sleep(2000);
        driver.quit();

    }

}
