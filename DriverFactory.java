import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    private static Map<String, WebDriver> webDriverMap = new HashMap<>();

    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Esse browser não existe");
        }
        webDriverMap.put(browser.toLowerCase(), driver);
        return driver;
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
