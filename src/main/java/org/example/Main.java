package org.example;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.example.DriverFactory.getDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static WebDriver driver;
    public static Dimension newDimension = new Dimension(1300, 800);

    public static void main(String[] args) throws InterruptedException {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }
}