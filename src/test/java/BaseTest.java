import com.codeborne.selenide.Configuration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    public void setup() {
        Configuration.browser = "edge";
        Configuration.timeout = 20000;
        Configuration.headless = false;

        Configuration.baseUrl = "https://qase.io/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        loginPage = new LoginPage();
    }

    @AfterMethod
    public void close() {
        clearBrowserCookies();
        closeWebDriver();
    }
}
