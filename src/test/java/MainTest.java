import org.junit.Test;
import org.openqa.selenium.*;
import java.io.IOException;

public class MainTest {
    static WebDriver driver;
    @Test
    public void initTest() throws InterruptedException, IOException {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://app2.pontomais.com.br/registrar-ponto");
        Utils.clicaTexto("Pesquisa Google");
        Utils.screenshot("1");
        driver.quit();
    }

}