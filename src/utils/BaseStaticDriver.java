package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseStaticDriver {

    // public olmasi diger classlardanda cagirilsin
    // diye, static olmasi herzaman canli olmasi icin
    public static WebDriver driver;
    // direkt bu class cagirildigin anda canli olmasi
    static {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        // concola yazilan gereksiz bilgileri sessize aldi.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // hangi browserı kullanacağımı ve tarayıcının path ini verdim.
        driver = new ChromeDriver();
    }


}
