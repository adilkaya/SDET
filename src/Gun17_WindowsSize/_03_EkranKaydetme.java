package Gun17_WindowsSize;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utils.BaseStaticDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
   Senaryo :
        1- https://opensource-demo.orangehrmlive.com/  sitesine gidiniz.
        2- Login işlemini yapınız.
        3- Welcome yazan sağ üst tarafta kullanıcı adının geçip geçmediğini kontrol ediniz.
        4- Eğer Kullanıcı adınız gözükmüyorsa , ekran görünütüsnü kaydedip, ilgili kişiye gönderiniz.
 */

public class _02_EkranKaydetme extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, IOException, IOException {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");

        WebElement Password = driver.findElement(By.id("txtPassword"));
        Password.sendKeys("admin123");//input[@name='Submit']

        WebElement login = driver.findElement(By.xpath("//input[@name='Submit']\n"));
        login.click();

        WebElement welcommen = driver.findElement(By.id("welcome"));

        String welcommenText = welcommen.getText();
        System.out.println(welcommenText);

        if (welcommenText.contains("Admin")) {
            System.out.println("Test basarili");
        } else {
            System.out.println("Test Failed");
            // Ekran kaydetme işlemleri burada olacak.

            // 1. Aşama ekran görüntüsü alma değişkenimizi tanımladık.
            TakesScreenshot ts = (TakesScreenshot) driver;

            // 2. Aşama alınacak Ekran görüntü dosyası tipi seçilerek oluşturuldu.
            File ekranDosyası = ts.getScreenshotAs(OutputType.FILE);

            // 3.Aşama ekranDosyasını bir dosyaya yazma/kopyalama işlemi yapılıyor.
            // DosyaKopyala (ekranDosyası, ekranGoruntusu.png);
            // Yukarıdaki komut JAVA nın için de yok, bunun için diğer yapılmış bir kütüphane
            // bulup AYNI SELENYUMU eklediğimiz ekleyeceğiz. bu kütüphane common.io bu apache isimli siteden indirilecek.

            FileUtils.copyFile(ekranDosyası, new File("ekranGoruntuleri/orangehrm/LoginKontrol.png"));
            // jpg, bmp.gif ... olabilir yani





        }

            Thread.sleep(5000);
            driver.quit();

    }
}
