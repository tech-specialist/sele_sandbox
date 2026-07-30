import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementsCondition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.text;

public class ProjectPage {
    final SelenideElement createBtn = $x("//*[text()='Create new project']");
    final SelenideElement createBtnV = $x("//*[text()='Create new project']//../..");
    final ElementsCollection bbb = $$x("//tr//a");

    public ProjectPage waitOpen() {
        createBtn.should(exist).shouldBe(visible, Duration.ofSeconds(10));

        return this;
    }

    public ProjectPage checkBtnColor() {
        createBtnV.shouldHave(cssValue("background-color", "rgba(64, 64, 220, 1)"));
        createBtn.shouldHave(attribute("checked"));
        bbb.shouldHave(size(6));
        bbb.shouldHave(texts("jkjbj", "lhbkjb", "iihbhh"));
        bbb.findBy(text("Shakira")).shouldBe(exist);

        $(byTagAndText("span", "asdg"));

        createBtn.getWrappedElement().sendKeys();
        createBtn.getText();
        $(By.id("")).should(Condition.matchText("STG([1-9][0-9]{0,3})"));
        return this;
    }

}
