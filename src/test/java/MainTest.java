import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;

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
        if (utils.returnIfElementExistsByTime(campoEmail, 10)) {
            System.out.println("PRECISOU LOGAR");
            utils.clearAndSendKeys(campoEmail, "felipe.machado@proversolucoes.com.br");
            utils.clearAndSendKeys(campoSenha, "84141398aB");
            utils.clicaBy(entrar);
        }
        utils.waitAtime(1);

        int[] values = {60, 120, 180, 240, 300};
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isBefore(LocalTime.of(11, 0)) || currentTime.isAfter(LocalTime.of(15, 0))) {
            Random random = new Random();
            int index = random.nextInt(values.length);
            int randomValue = values[index];
            System.out.println("RANDOM VAI ESPERAR " + randomValue / 60 + " minutos");
            utils.waitAtime(randomValue);
        } else {
            System.out.println("dentro de meio dia, vai esperar 2 segundos");
            utils.waitAtime(2);
        }
        utils.clicaTexto("Utilizar essa localização");
        System.out.println("CLICOU LOCALIZAÇÃO");
        utils.clicaBy(batePonto);
        System.out.println("BATEU PONTO -- ESPERANDO REGISTRAR O PONTO");
        utils.waitAtime(10);
        utils.screenshot();
        utils.waitAtime(2);
        System.out.println("TIROU FOTO");
        driver.quit();
    }
}
