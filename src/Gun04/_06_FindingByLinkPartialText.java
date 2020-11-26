package Gun04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _06_FindingByLinkPartialText extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com/"); // siteyi açtım

        WebElement e = driver.findElement(By.partialLinkText("Passion"));
        System.out.println(e.getAttribute("href"));

        Thread.sleep(3000);
        driver.quit();

    }
}
