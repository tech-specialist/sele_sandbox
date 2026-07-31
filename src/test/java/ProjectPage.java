import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {
    final SelenideElement createBtn = $x("//*[text()='Create new project']");
    final SelenideElement createBtnV = $x("//*[text()='Create new project']//../..");
    final ElementsCollection projectLinks = $$x("//tr//a");

    public ProjectPage waitOpen() {
        createBtn.should(exist).shouldBe(visible, Duration.ofSeconds(10));

        return this;
    }

    public ProjectPage checkBtnColor() {
        // 1. Проверяем, что цвет кнопки соответствует синему в формате RGBA
        createBtnV.shouldHave(cssValue("background-color", "rgba(64, 64, 220, 1)"));
        // 2. Проверяем, что кнопка кликабельна
        createBtn.shouldHave(enabled);
        // 3. Проверки коллекции элементов bbb
        projectLinks.shouldHave(size(6)); // В списке должно быть строго 6 элементов
        projectLinks.shouldHave(texts("jkjbj", "lhbkjb", "iihbhh")); // Проверка текста у первых элементов
        projectLinks.findBy(text("Sharelane")).shouldBe(exist); // В списке должен быть элемент с текстом Sharelane

        //4. Это локатор. Он ищет элемент <span>, внутри которого находится текст "asdg"
        $(byTagAndText("span", "asdg"));

        // 5. Взаимодействие с элементом
        createBtn.getWrappedElement().sendKeys(); // Имитация ввода (сейчас пустая)

        return this;
    }
}
