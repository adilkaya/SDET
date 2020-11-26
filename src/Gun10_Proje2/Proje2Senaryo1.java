package proje2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class Proje2Senaryo1 extends BaseStaticDriver {

    /*

1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html

2) Login'e "username" -- Password'a "password" yazın . Sign in button'ına tıklayınız.

3) Transfer founds butonuna tıklayınız.

4) From account kısmından herhangı bir(Random'la tıklatın) değer seçınız.

5) To account kısmından herhangı bir(Random'la tıklatın.) değer seçınız.

6) Her hangi bir amount gırınız.

7) Her hangi bir description giriniz.

8)Continue butonuna tiklayiniz.

9)Submit butonuna tiklayiniz.

10) "You successfully submitted your transaction" Yazısı gözükmesi gerekiyor.

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

        WebElement transfer = driver.findElement(By.xpath("//*[@id=\"transfer_funds_tab\"]/a"));
        transfer.click();


        WebElement fromAccount = driver.findElement(By.cssSelector("select[id='tf_fromAccountId']"));
        Select fromSecim = new Select(fromAccount);

        fromSecim.selectByIndex(randomSayi(6));

        WebElement toAccount = driver.findElement(By.cssSelector("select[id='tf_toAccountId']"));
        Select toSecim = new Select(fromAccount);

        toSecim.selectByIndex(randomSayi(6));

        WebElement amount = driver.findElement(By.xpath("//input[@id='tf_amount']"));
        amount.sendKeys("100");

        WebElement descript = driver.findElement(By.xpath("//input[@id='tf_description']"));
        descript.sendKeys("100");

        WebElement cont = driver.findElement(By.className("btn-primary"));
        cont.click();

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"btn_submit\"]"));
        submit.click();


        WebElement gelecekOlanmesaj = driver.findElement(By.xpath("//*[@id=\"transfer_funds_content\"]/div/div/div[1]"));

        String beklenenMesaj="You successfully submitted your transaction";

        Assert.assertEquals(beklenenMesaj,gelecekOlanmesaj.getText());


        Thread.sleep(2000);
        driver.quit();

    }

    public static int randomSayi(int sayi){


        return (int)((Math.random()*sayi)+1);
    }

    }
