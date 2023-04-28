package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    // her 1 thread e ozel local static driver olusturdum
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); //webdriver1 , webdriver2 ...
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox , edge...

    // threadDriver.get();
    // threadDriver.set(driver); -> bulundugum thread e driver set edilyor
    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        // diger senaryolar icin default chrome olsun
        if(threadBrowserName.get() == null) {
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) { // 1 kere calissin
            switch (threadBrowserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    threadDriver.set(new ChromeDriver(options));
            }

        }
        threadDriver.get().manage().window().maximize();
        return threadDriver.get();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }

    public static void threadBrowserSet(String browser){
        threadBrowserName.set(browser);
    }

    public static String threadBrowserGet(){
        return threadBrowserName.get();
    }

}
