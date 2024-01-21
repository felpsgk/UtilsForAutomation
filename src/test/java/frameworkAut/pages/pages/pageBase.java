package frameworkAut.pages.pages;

import frameworkAut.pages.utils.driverFactory;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class pageBase extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger((pageBase.class));
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jsexec;

    pageBase(WebDriver driver) {
        this.driver = driver;  // Use a DriverFactory para criar uma instância do WebDriver
//        this.driver = driverFactory.createChromeDriver();  // Use a DriverFactory para criar uma instância do WebDriver
        this.jsexec = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(750));
    }

    protected By waitForBy(By loc) {
        wait.until(ExpectedConditions.presenceOfElementLocated(loc));
        return loc;
    }

    protected void click(By loc) {
        waitForBy(loc);
        WebElement elemento = this.driver.findElement(loc);
        elemento.click();
    }
    protected void clearAndSendKeys(String texto, By loc) {
        waitForBy(loc);
        WebElement elemento = this.driver.findElement(loc);
        elemento.clear();
        elemento.sendKeys(texto);
    }
    protected void pressKey(Keys k, By loc) {
        waitForBy(loc);
        WebElement elemento = this.driver.findElement(loc);
        elemento.clear();
        elemento.sendKeys(k);
    }
}
