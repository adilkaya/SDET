package Gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _03_FindElements_tag extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("http://www.practiceselenium.com/"); // siteyi açtım

        List<WebElement> liste=driver.findElements(By.tagName("li")); // yani etiketi "li olan butun elemanlar"

        driver.manage().window().maximize(); // tarayiciyi tam ekran yapar

        for (WebElement e: liste){
            System.out.println(e.getText());
        }





        Thread.sleep(3000);
        driver.quit();

    }
}

