import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static WebDriverWait wait;
    public static Duration duration = Duration.ofSeconds(20);
    private static Map<String, WebDriver> webDriverMap = new HashMap<>();
    public static Dimension newDimension = new Dimension(1400, 800);

    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                driver.manage().window().setSize(newDimension);
                wait = new WebDriverWait(driver, 20);
                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                wait =  new WebDriverWait(driver, duration);
//                break;
//            case "ie":
//                driver = new InternetExplorerDriver();
//                wait =  new WebDriverWait(driver, duration);
//                break;
            default:
                throw new IllegalArgumentException("Esse browser não existe");
        }
        webDriverMap.put(browser.toLowerCase(), driver);
        return driver;
    }

    public WebDriverWait setWait(String driver, int time) {
        wait = new WebDriverWait(getDriver(driver), 20);
        return wait;
    }

    public static WebDriver getOneDriver(String browser) {
        WebDriver driver = webDriverMap.get(browser.toLowerCase());
        if (driver == null) {
            throw new IllegalArgumentException("Driver não instanciado");
        }
        return driver;
    }

    public static void quitDriver(String browser) {
        WebDriver driver = webDriverMap.remove(browser.toLowerCase());
        if (driver != null) {
            driver.quit();
        }
    }

    public static void quitAllDrivers() {
        for (WebDriver driver : webDriverMap.values()) {
            driver.quit();
        }
        webDriverMap.clear();
    }



}
