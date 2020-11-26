package Gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class _01_OpenWindows extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.selenium.dev/");

        // Sayfada yeni pencere açan linkleri bulmak için target=_blank attribute olan a (link) tagleri bulundu.
        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target=_blank]"));
        for(WebElement link: linkler)
        {
            link.click();
        }

        // driverdan bu açılan yeni pencerelerin id leri alındı.Bu idlerin driver.getWindowHandles() ile
        // alıyoruz. üretin idler Set<String> olarak döndüğünden bu tür bir değişkene aldık.
        Set<String> windowIdleri=driver.getWindowHandles();

        // idleri yazdırdık.
        for(String id: windowIdleri){
            System.out.println(id);
        }

//        CDwindow-6172DC94ED3F58BA311747BA9DF64E2F
//        CDwindow-6C0728503E3895494BE436220953D911
//        CDwindow-FA0D1679520D14D68139EB347BDEBEC6

        Thread.sleep(5000);
        driver.quit();
    }
}