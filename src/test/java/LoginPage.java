import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    final SelenideElement userInput = $("[placeholder='Work email']");
    final SelenideElement loginInput = $x("//*[placeholder='Password']");
    final SelenideElement submitBtn = $x("//*[text()='Sign in']");

    public LoginPage openPage() {
        open("login");

        return this;
    }

    public LoginPage login() {
        userInput.setValue("belov.dmitry.working.email@gmail.com");
        loginInput.sendKeys("TenisaStolowego51$!");
        submitBtn.submit();
        submitBtn.contextClick();

        return this;
    }
}
