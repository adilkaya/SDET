package Gun17_WindowsSize;
/*
    Senaryo
    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
    2- random 100 e kadar 2 sayı üretiniz.
    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
    4- Sonuçları Assert ile kontrol ediniz.
    5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
 */

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.util.Random;

public class _04_CalculatorTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement selectElement = driver.findElement(By.id("selectOperationDropdown"));
        Select islemler = new Select(selectElement);

        Random sayiUreteci = new Random();
        String EkranIslemSonucu = "";

        for (int i = 0; i < 5; i++) {
//             Double sayi1= sayiUreteci.nextDouble() * 100;
//             Double sayi2= sayiUreteci.nextDouble() * 100;

            int sayi1 = sayiUreteci.nextInt(100);
            int sayi2 = sayiUreteci.nextInt(100);

//            System.out.println(sayi1);
//            System.out.println(sayi2);

            for (WebElement islem : islemler.getOptions()) {

                switch (islem.getText()) {
                    case "Add":
                        islemler.selectByVisibleText("Add");
                        EkranIslemSonucu = EkrandaIslemYap(sayi1, sayi2);
                        System.out.println("Beklenen=" + (sayi1 + sayi2) + " EkranSonuc=" + EkranIslemSonucu);
                        Assert.assertEquals(Integer.toString(sayi1 + sayi2), EkranIslemSonucu);
                        break;

                    case "Subtract":
                        islemler.selectByVisibleText("Subtract"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1, sayi2); // sayı1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen=" + (sayi1 - sayi2) + " EkranSonuc=" + EkranIslemSonucu);
                        Assert.assertEquals(Integer.toString(sayi1 - sayi2), EkranIslemSonucu);
                        break;

                    case "Multiply":
                        islemler.selectByVisibleText("Multiply"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1, sayi2); // sayı1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen=" + (sayi1 * sayi2) + " EkranSonuc=" + EkranIslemSonucu); // kendime kontrol
                        Assert.assertEquals(Integer.toString(sayi1 * sayi2), EkranIslemSonucu);
                        break;

                    case "Divide":
                        islemler.selectByVisibleText("Divide"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1, sayi2); // sayı1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        // 3.33333333333
                        Double sonucDouble = Double.parseDouble(EkranIslemSonucu); // 3.333333
                        Integer sonuc = sonucDouble.intValue(); // 3

                        System.out.println("Beklenen=" + (sayi1 / sayi2) + " EkranSonuc=" + sonuc); // kendime kontrol
                        Assert.assertEquals(Integer.toString(sayi1 / sayi2), sonuc.toString());

                        break;

                    case "Concatenate":
                        islemler.selectByVisibleText("Concatenate"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1, sayi2); // sayı1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen=" + sayi1 + sayi2 + " EkranSonuc=" + EkranIslemSonucu); // kendime kontrol
                        String beklenenSonuc= Integer.toString(sayi1) + Integer.toString(sayi2); // yanyana eklendi
                        Assert.assertEquals( beklenenSonuc, EkranIslemSonucu);

                        break;
                }
            }

        }

        Thread.sleep(5000);
        driver.quit();
    }

    //Ekrandaki istenen işlemi yapıp sonucu gönderir.
    public static String EkrandaIslemYap(Integer sayi1, Integer sayi2) {
        //1.Sayıyı gönder
        WebElement num1 = driver.findElement(By.id("number1Field"));
        num1.clear();
        num1.sendKeys(sayi1.toString()); //

        //2.sayıyı gönder
        WebElement num2 = driver.findElement(By.id("number2Field"));
        num2.clear();
        num2.sendKeys(sayi2.toString());

        // hesapla butonuna bas
        WebElement islemBtn = driver.findElement(By.id("calculateButton"));
        islemBtn.click();

        // sonucun gelmesini bekle
        WebDriverWait bekle = new WebDriverWait(driver, 5);
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.id("answerForm")));

        // sonucu value attribute  ndan al.
        String islemSonuc = driver.findElement(By.id("numberAnswerField")).getAttribute("value");

        // sonucu temizle.
        WebElement clearBtn = driver.findElement(By.id("clearButton"));
        clearBtn.click();

        // sonucu gönder.
        return islemSonuc;
    }


}
