package Gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;


/*
   1- https://www.selenium.dev/ sayfasına gidiniz.
   2- yeni syafa açan linklere tıklayınız.
   3- Ana sayfanın haricindeki diğer sayfaları kapatınız.
   4- Ana sayfaya tekrar driverı set ediniz.
 */

public class _03_CloseWindows extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        String anaSayfaID=driver.getWindowHandle();

        // Sayfada yeni pencere açan linkleri bulmak için target=_blank attribute olan a (link) tagleri bulundu.
        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));
        for(WebElement link: linkler)
        {
            link.click();
        }

        Set<String> windowIDler=driver.getWindowHandles();
        for(String ID: windowIDler)
        {
            System.out.println(ID);

            if (ID.equals(anaSayfaID)) continue; // ana sayfa id si geldiğinde sonraki kodları pas geç
            // yani çalıştırma.

            driver.switchTo().window(ID);
            System.out.println("Window title="+driver.getTitle());
            driver.close();
        }

        // driver en son yukarıdaki kapatılan sayfaya switch olmuştu onu gösteriyordu,
        // eğer alttaki anasayfaya switch eden set eden komut olmasa idi, driver kapatılan sayfayı gösterdiğinden
        // hata verecekti.Bu yüzden en son stiwch işlemini yaparak driver ı ana sayfaya set(switch) ettik
        driver.switchTo().window(anaSayfaID);
        System.out.println("Window title="+driver.getTitle());

        Thread.sleep(8000);
        driver.quit();
    }
}