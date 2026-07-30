import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {
    final SelenideElement createBtn = $x("//*[text()='Create new project']");
    final SelenideElement createBtnV = $x("//*[text()='Create new project']//../..");
    final ElementsCollection bbb = $$x("//tr//a");

    public ProjectPage waitOpen() {
        createBtn.should(exist).shouldBe(visible, Duration.ofSeconds(10));

        return this;
    }

    public ProjectPage checkBtnColor() {
        // 1. Проверяем, что цвет кнопки соответствует синему в формате RGBA
        createBtnV.shouldHave(cssValue("background-color", "rgba(64, 64, 220, 1)"));
        // 2. Проверяем, что кнопка (или чекбокс) находится в состоянии "выбрано"
        createBtn.shouldHave(attribute("checked"));
        // 3. Проверки коллекции элементов bbb
        bbb.shouldHave(size(6)); // В списке должно быть строго 6 элементов
        bbb.shouldHave(texts("jkjbj", "lhbkjb", "iihbhh")); // Проверка текста у первых элементов
        bbb.findBy(text("Sharelane")).shouldBe(exist); // В списке должен быть элемент с текстом Sharelane

        //4. Это локатор. Он ищет элемент <span>, внутри которого находится текст "asdg"
        $(byTagAndText("span", "asdg"));

        // 5. Взаимодействие с элементом
        createBtn.getWrappedElement().sendKeys(); // Имитация ввода (сейчас пустая)
        createBtn.getText(); // Получение текста кнопки
        $(By.id("")).should(Condition.matchText("STG([1-9][0-9]{0,3})"));
        /*$(By.id("...")) - Ищет элемент на странице по его уникальному атрибуту id.
        Condition.matchText(...): Проверяет, что видимый текст элемента соответствует регулярному выражению (Regex).
        Regex - регулярное выражение, когда мы прописываем не само значение, а формат.
        "STG([1-9][0-9]{0,3})": Это шаблон регулярного выражения. Он ищет текст, который:Начинается со строгого префикса STG.
        Дальше содержит число, где первая цифра — от 1 до 9 (не ноль).
        После первой цифры может идти еще от 0 до 3 любых цифр (от 0 до 9).Примеры совпадений: STG1, STG54, STG100, STG9999.*/
        return this;
    }
}
