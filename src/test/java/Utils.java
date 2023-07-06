import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private static WebDriverWait wait;
    private static WebDriver driver;
    private static By elementoTexto;

    public Utils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    public static void clicar(By btn) {
        WebElement element = null;
        element = waitForElement(btn);
        element.click();
    }

    public void screenshot(String fase) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime hoje = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String dt = hoje.format(formatter);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\"+dt+"screenshot"+fase+".png"));
    }

    public void clicaTexto(String botão) {
        //button[contains(text(),'Entrar')]
        WebElement element = null;
        elementoTexto = By.xpath("//*[contains(text(),'" + botão + "')]");
        element = waitForElement(elementoTexto);
        System.out.println("achou botão");
        element.click();
    }
    public void clicaBy(By botao) {
        WebElement element = null;
        element = waitForElement(botao);
        element.click();
    }
  public void waitAtime(int tempoEmSegundos) throws InterruptedException {
        int tempoEspera = tempoEmSegundos*1000;
        Thread.sleep(tempoEspera);
    }

    public void botao(String botão) {
        //button[contains(text(),'Entrar')]
        WebElement element = null;
        elementoTexto = By.xpath("//button[contains(text(),'" + botão + "')]");
        element = waitForElement(elementoTexto);
        element.click();
    }

    public void voltar() {
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

    protected void clearAndSendKeys(By locator, CharSequence text) {
        WebElement webElement = waitForElement(locator);
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(text);
    }

    protected boolean returnIfElementExists(By locator) {
        boolean result = false;

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        } catch (Exception var4) {
            result = false;
        }

        return result;
    }

    protected boolean returnIfElementExistsByTime(By locator, int time) {
        boolean result = false;
        wait = new WebDriverWait(driver, time);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
            wait = new WebDriverWait(driver, time);
        } catch (Exception e) {
        }
        wait = new WebDriverWait(driver, time);
        return result;
    }
}