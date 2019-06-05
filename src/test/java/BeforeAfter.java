import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BeforeAfter {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final String URL_TO_HUB = "http://localhost:4444/wd/hub";

    @BeforeEach
    public void openBrowser() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL(URL_TO_HUB), capability);
        wait = new WebDriverWait(driver, 30);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}