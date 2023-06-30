import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class Utils {
    public static WebDriverWait wait;
    static WebDriver driver;
    static By elementoTexto;
    public static void clicar(By btn) {
        WebElement element = null;
        element = waitForElement(btn);
        element.click();
    }

    public static void screenshot(String SCNumber) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\"+SCNumber+"screenshot.png"));
    }

    public static void clicaTexto(String botão) {
        //button[contains(text(),'Entrar')]
        WebElement element = null;
        elementoTexto = By.xpath("//*[contains(text(),'" + botão + "')]");
        element = waitForElement(elementoTexto);
        element.click();
    }

    public static void botao(String botão) {
        //button[contains(text(),'Entrar')]
        WebElement element = null;
        elementoTexto = By.xpath("//button[contains(text(),'" + botão + "')]");
        element = waitForElement(elementoTexto);
        element.click();
    }

    public static void voltar() {
        //button[contains(text(),'Entrar')]
        WebElement element = null;
        elementoTexto = By.xpath("//button[contains(@class, 'ut-navigation-button-control')]");
        element = waitForElement(elementoTexto);
        element.click();
    }

    protected static WebElement waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected static void clearAndSendKeys(By locator, CharSequence text) {
        WebElement webElement = waitForElement(locator);
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(text);
    }

    protected static boolean returnIfElementExists(By locator) {
        boolean result = false;

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        } catch (Exception var4) {
            result = false;
        }

        return result;
    }

    protected static boolean returnIfElementExistsByTime(By locator, int time) {
        boolean result = false;
        wait = new WebDriverWait(driver, 20);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
            wait = new WebDriverWait(driver, 20);
        } catch (Exception e) {
        }
        wait = new WebDriverWait(driver, 20);
        return result;
    }
}