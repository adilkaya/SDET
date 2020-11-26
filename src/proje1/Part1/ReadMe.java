package Proje1.Part1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class ReadMe extends BaseStaticDriver {

    /*

        1) Bu siteye gidin. ->  http://demoqa.com/text-box

        2) Full Name kısmına "Automation" girin.

        3) Email kısmına "Testing" girin.

        4) Current Address kısmına "Testing Current Address" girin.

        5) Permanent Address kısmına "Testing Permanent Address" girin.

        6) Submit butonuna tıklayınız.

        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.

        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demoqa.com/text-box"); // siteyi açtım

        WebElement name=driver.findElement(By.id("userName")) ;
        name.sendKeys("Automation");
        Thread.sleep(1500);

        driver.manage().window().maximize();


        WebElement email=driver.findElement(By.id("userEmail")) ;
        email.sendKeys("Testing@outlook.com");
        Thread.sleep(1500);

        WebElement adress=driver.findElement(By.id("currentAddress")) ;
        adress.sendKeys("Testing Current Address");
        Thread.sleep(1500);

        WebElement permAdress=driver.findElement(By.id("permanentAddress")) ;
        permAdress.sendKeys("Testing Permanent Address");
        Thread.sleep(1500);

        WebElement button2=driver.findElement(By.className("btn-primary"));
        button2.click();


        WebElement checkName=driver.findElement(By.id("name")) ;
        String fullName=checkName.getText();

        Assert.assertEquals("Name:Automation", fullName);

        WebElement checkEmail=driver.findElement(By.id("email")) ;
        String fullEmail=checkEmail.getText();

        Assert.assertEquals("Email:Testing@outlook.com", fullEmail);


        Thread.sleep(3000);
        driver.quit();
    }
}
