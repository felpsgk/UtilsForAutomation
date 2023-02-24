import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriverWait wait;
    private static Map<String, WebDriver> webDriverMap = new HashMap<>();

    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                wait =  new WebDriverWait(driver, 20);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                wait =  new WebDriverWait(driver, 20);
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                wait =  new WebDriverWait(driver, 20);
                break;
            default:
                throw new IllegalArgumentException("Esse browser não existe");
        }
        webDriverMap.put(browser.toLowerCase(), driver);
        return driver;
    }
    
    public static WebDriverWait setWait(String driver, int time) {
        this.wait =  new WebDriverWait(getDriver(driver), int);
        return this.wait;
    }

    public static WebDriver getDriver(String browser) {
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
