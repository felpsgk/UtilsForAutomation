package frameworkAut.pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driverFactory {

    private static final String CHROME_DRIVER_PATH = "C:\\drivers\\120\\chromedrive.exe"; // Substitua pelo seu caminho real
    private static final String CHROME_DRIVER_PATH2 = "D:\\FELPS\\Trabalho\\Programacao\\automacao\\framework\\frameworkAut\\drivers\\chrome\\120\\chromedriver.exe"; // Substitua pelo seu caminho real

    public static WebDriver createChromeDriver() {
        //System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH2);
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        System.setProperty("webdriver.chrome.logfile", "C:\\drivers\\chromedriver.log");
        ChromeOptions chromeOptions = new ChromeOptions();
        // Adicione opções do Chrome, se necessário
        WebDriver web = new ChromeDriver(chromeOptions);
        return web;
    }

    // Adicione métodos para criar outros drivers, se necessário
}


