package Gun06.Css_Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_CSS_Selector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://formsmarts.com/form/yu?mode=h5");

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[id$='4586_0']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("select[id$='_4588']")).click();
        driver.findElement(By.cssSelector("option[value='Online Advertising']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value='Every Day']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value='Good']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("select[id$='_4597']")).click();
        driver.findElement(By.cssSelector("select[id$='_4597'] > :nth-child(4)")).click();



        Thread.sleep(6000);
        driver.quit();



        /* TODO    2nci bir cozum
            public class CssSelectorOrnek extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5"); // siteyi açtım

        WebElement businessRadio=driver.findElement(By.cssSelector("input[id$='4586_0']"));
        businessRadio.click();

        Thread.sleep(1000);
        WebElement dropdownDiscover=driver.findElement(By.cssSelector("select[id$='_4588']"));
        dropdownDiscover.click(); // select e tıklattım
        Thread.sleep(1000);
        WebElement optionOnlineAdvertising=driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        optionOnlineAdvertising.click(); // seçime tıklattım
        Thread.sleep(1000);
        WebElement buttonEveryDay=driver.findElement(By.cssSelector("input[value='Every Day']"));
        buttonEveryDay.click(); //
        Thread.sleep(1000);
        WebElement goodRadio=driver.findElement(By.cssSelector("input[value='Good']"));
        goodRadio.click(); //
        Thread.sleep(1000);
        WebElement howLongDropdown=driver.findElement(By.cssSelector("select[id$='_4597']"));
        howLongDropdown.click(); //
        Thread.sleep(1000);
        WebElement secenek4=driver.findElement(By.cssSelector("select[id$='_4597'] > :nth-child(4)"));
        secenek4.click(); //


        Thread.sleep(15000);
        driver.quit();
    }
}
         */



    }
}
