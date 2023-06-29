import org.apache.commons.io.FileUtils;
import org.example.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainTest {
    static WebDriver driver;
    public static Dimension newDimension = new Dimension(1300, 800);

    @Test
    public void initTest() throws InterruptedException, IOException {
        driver = DriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        driver.quit();
    }
}