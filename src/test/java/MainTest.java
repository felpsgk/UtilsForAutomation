import org.junit.Test;
import org.openqa.selenium.*;
import java.io.IOException;
public class MainTest {
    //teste
    static WebDriver driver;
    static Utils utils;
    By campoEmail = By.xpath("//div[contains(@class,'inside')]//input[contains(@placeholder,'e-mail')]");
    By campoSenha = By.xpath("//div[contains(@class,'inside')]//input[contains(@type,'pass')]");
    By entrar = By.xpath("//span[contains(text(),'Entrar')]");
    By batePonto = By.xpath("(//span[contains(@class,'pm-button-content') and contains(text(),'Bater ponto')])[3]");
    @Test
    public void initTest() throws InterruptedException, IOException {
        driver = DriverFactory.getDriver("chrome");
        utils = new Utils(driver);
        driver.get("https://app2.pontomais.com.br/registrar-ponto");
        System.out.println("ENTROU SITE");
        if(utils.returnIfElementExistsByTime(campoEmail,10)){
            System.out.println("PRECISOU LOGAR");
            utils.clearAndSendKeys(campoEmail,"felipe.machado@proversolucoes.com.br");
            utils.clearAndSendKeys(campoSenha,"84141398aB");
            utils.clicaBy(entrar);
        }
        utils.waitAtime(1);
        utils.clicaTexto("Utilizar essa localização");
        System.out.println("CLICOU LOCALIZAÇÃO");
        utils.waitAtime(1);
        utils.clicaBy(batePonto);
        System.out.println("BATEU PONTO -- ESPERANDO REGISTRAR O PONTO");
        utils.waitAtime(5);
        utils.screenshot();
        utils.waitAtime(2);
        System.out.println("TIROU FOTO");
        driver.quit();
    }
}
