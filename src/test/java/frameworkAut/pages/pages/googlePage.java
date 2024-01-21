package frameworkAut.pages.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

public class googlePage extends pageBase {
    public googlePage(WebDriver driver) {
        super(driver);
    }

    private By campoBusca = By.id("APjFqb");
    private By firstResult = By.xpath("//*[contains(@class,'pcTkSc')]");

    public void abrirGoogle() {
        openUrl("https://www.google.com/");
    }

    public void digitaBusca(String text) {
        clearAndSendKeys(text, campoBusca);
        waitABit(1000);
    }

    public void buscar() {
        click(firstResult);
    }

    public void esperarTempo(int segundos) {
        waitABit(segundos);
    }
}


