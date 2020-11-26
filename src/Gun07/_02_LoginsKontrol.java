package Gun07;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_LoginsKontrol  extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); // siteyi açtım

        String[] kullanicilar={"standard_user","locked_out_user","problem_user","performance_glitch_user"};
        String sifre="secret_sauce";


        for(String kullanici: kullanicilar) {
            // login işlemleri
            WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
            usernameInput.clear();
            usernameInput.sendKeys(kullanici);

            Thread.sleep(1000);
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
            passwordInput.clear();
            passwordInput.sendKeys(sifre);

            Thread.sleep(1000);
            WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
            loginButton.click();

            //findelement ile findelements dönüşlerinin farkı nedir?
            //findelement 1 element bulur, bulamazsa NoSuchElementException hatasını üretir.
            //findelements çoklu elements bulur, bulamazsa size 0 gönderir.

            //güzellik burda
            List<WebElement> txtProducts = driver.findElements(By.xpath("//div[text()='Products']"));

            if (txtProducts.size() == 1)
            {
                System.out.println(kullanici + " login oldu");
                driver.navigate().back();
            }
            else
            {
                WebElement errorElement=driver.findElement(By.xpath("//h3[@data-test='error']"));
                System.out.println(kullanici +" "+ errorElement.getText());
            }



//            try {
//                WebElement txtProducts = driver.findElement(By.xpath("//div[text()='Products']"));
//                System.out.println(kullanici + " login oldu");
//                driver.navigate().back();
//            }
//            catch (NoSuchElementException e)
//            {
//                WebElement errorElement=driver.findElement(By.xpath("//h3[@data-test='error']"));
//                System.out.println(kullanici +" "+ errorElement.getText());
//            }

            Thread.sleep(3000);
        }

        Thread.sleep(6000);
        driver.quit();
    }

}
