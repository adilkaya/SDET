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
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class _04_CalculatorTest extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement selectElement = driver.findElement(By.id("selectOperationDropdown"));

        WebElement answer = driver.findElement(By.xpath("//input[@id='numberAnswerField']"));
       // answer.get_attribute("value")
       // self.assertEqual('40', value)

        Select islemler=new Select(selectElement);

        Random sayiUreteci=new Random();


        for (int i=0; i<5; i++)
        {
            //Double sayi1=sayiUreteci.nextDouble()*100;
            //Double sayi2=sayiUreteci.nextDouble()*100;

            int sayi1=sayiUreteci.nextInt(100);
            int sayi2=sayiUreteci.nextInt(100);

            //System.out.println(sayi1);
            //System.out.println(sayi2);

            for (WebElement islem: islemler.getOptions()){

                switch (islem.getText()){
                    case "Add":
                        islemler.selectByVisibleText("Add");
                       String ekranIslemSonucu = EkrandaIslemYap(sayi1,sayi2);
                        System.out.println("Beklenen = " +sayi1+sayi2+ "Ekran sonuc = "+ ekranIslemSonucu);
                        Assert.assertEquals(Integer.toString(sayi1+sayi2), ekranIslemSonucu);
                       
                        break;
                    case "Subtract":
                        // int ekranIslemSonucu = EkrandaIslemYap(sayi1+sayi2,islem.getText());
                        break;
                    case "Multiply":
                        // int ekranIslemSonucu = EkrandaIslemYap(sayi1-sayi2,islem.getText());
                        break;
                    case "Divide":
                        // int ekranIslemSonucu = EkrandaIslemYap(sayi1/sayi2,islem.getText());
                        break;
                    case "Concatenate":
                        // int ekranIslemSonucu = EkrandaIslemYap(sayi1,sayi2,islem.getText());
                        break;
                }



            }



        }
        Thread.sleep(5000);
        driver.quit();


    }
    public static String EkrandaIslemYap(Integer sayi1, Integer sayi2 ) {



        WebElement num1 = driver.findElement(By.id("number1Field"));
        num1.clear();
        num1.sendKeys(sayi1.toString());

        WebElement num2 = driver.findElement(By.id("number2Field"));
        num2.clear();
        num2.sendKeys(sayi2.toString());

        WebElement islemBtn=driver.findElement(By.id("calculateButton"));
        islemBtn.click();

        WebDriverWait bekle=new WebDriverWait(driver,5);
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.id("answerForm")));

        String islemSonuc=driver.findElement(By.id("numberAnswerField")).getAttribute("value");

        WebElement clearBtn=driver.findElement(By.id("clearButton"));
        clearBtn.click();

        System.out.println(islemSonuc);
        return islemSonuc;
    }
}
