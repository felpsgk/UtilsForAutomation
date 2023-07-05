import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;

public class MainTest {
    //teste
    static WebDriver driver;
    static Utils utils;
    By campoEmail = By.xpath("//input[contains(@name,'username')]");
    By campoSenha = By.xpath("//input[contains(@name,'password')]");
    By entrar = By.xpath("//div[contains(text(),'Entrar')]");
    By criar = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]");
    By upars = By.xpath("//button[contains(@class,'_acan _acap _acas')]");
    By imagem = By.xpath("//input[@type='file']");

    @Test
    public void initTest() throws InterruptedException, IOException {
        String senha = "496476700a";
        driver = DriverFactory.getDriver("chrome");
        utils = new Utils(driver);
        driver.get("https://www.instagram.com/");
        System.out.println("ENTROU SITE");
        if (utils.returnIfElementExistsByTime(campoEmail, 3)) {
            System.out.println("PRECISOU LOGAR");
            utils.clearAndSendKeys(campoEmail,"tifelps");
            utils.clearAndSendKeys(campoSenha,senha);
            utils.clicaBy(entrar);
        }
        utils.waitAtime(1);
        utils.clicaBy(criar);
        utils.clicaBy(upars);
        WebElement chooseFile = driver.findElement(upars);
        System.out.println("TENTANDO ENVIAR IMAGEM");
        chooseFile.sendKeys("C:\\Users\\felps\\IdeaProjects\\UtilsForAutomation\\teste.png");
        // Adicionar legenda (opcional)
        WebElement captionInput = driver.findElement(By.xpath("//textarea[@aria-label='Legenda']"));
        captionInput.sendKeys("Minha foto incrível!");

        // Publicar a foto
        WebElement postButton = driver.findElement(By.xpath("//button[contains(text(), 'Publicar')]"));
        postButton.click();
        utils.waitAtime(10);
        driver.quit();
    }
}
