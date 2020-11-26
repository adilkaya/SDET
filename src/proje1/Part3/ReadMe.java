package Proje1.Part3;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {

    /*

        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 918 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

        4) Snepdeal logosuna tıklayınız.

        5) URL'in bu olduğunu doğrulayın. (https://www.snapdeal.com/)

     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.snapdeal.com/");
        WebElement search = driver.findElement(By.id("inputValEnter"));
        search.sendKeys("teddy bear");//text gönderme
        Thread.sleep(1500);

        WebElement searchButton = driver.findElement(By.className("searchTextSpan"));
        searchButton.click();
        Thread.sleep(1500);

        WebElement result = driver.findElement(By.id("searchMessageContainer"));
        String resultstr = result.getText();

        Assert.assertEquals("We've got 899 results for 'teddy bear'", resultstr);

        driver.manage().window().maximize(); // tarayiciyi tam ekran yapar

        WebElement logo = driver.findElement(By.className("notIeLogoHeader aspectRatioEqual sdHomepage cur-pointer"));
        logo.click();

        String url=driver.getCurrentUrl();
        Assert.assertEquals("https://www.snapdeal.com/",url);


        Thread.sleep(5000);
        driver.quit();
    }
}
