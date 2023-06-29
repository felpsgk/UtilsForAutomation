package org.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainTest {
    static WebDriver driver;
    public static Dimension newDimension = new Dimension(1300, 800);

    public static void main(String[] args) throws InterruptedException {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }
}