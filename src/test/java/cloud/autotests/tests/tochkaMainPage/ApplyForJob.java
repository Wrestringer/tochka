package cloud.autotests.tests.tochkaMainPage;

import cloud.autotests.config.tochka.App;
import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import java.io.File;

@Story("Apply tests")
public class ApplyForJob extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = App.config.webUrl();
    }

    @Test
    @Tag("tochka")
    @DisplayName("Successful apply for a job QA Engineer")
    void applyTest() {

        step("Open main page", () -> {
            open("/");
        });

        step("Move to apply form", () -> {
            $(byText("О нас")).hover();
            $(byText("Работа в Точке")).click();
        });

        step("Successful transition to the form of vacancies", () ->
                $(".hr_heroTitle__GYYT2").shouldHave(text("Давай работать")));

        step("Choose IT", () -> {
            $(byText("IT")).click();
        });

        step("Search 'Тестировщик'", () -> {
            $("input[placeholder='Найти вакансию']").setValue("Тестировщик");
            Thread.sleep(3000);
        });


        step("Check job availability", () -> {
            $(".jobs_jobsSearchMeta__Bi0Vg").shouldHave(text("Найдено 2 вакансий"));
        });

        step("Click on the vacancy of 'Тестировщик Москва'", () -> {
            $("a[href='/hr/it/testirovshhik/moskva/']").click();
        });

        step("Check the opening of the desired vacancy", () -> {
            $(".row").shouldHave(text("Тестировщик"));
        });

        step("Input FIO", () -> {
            $("#hr-form-name-input").setValue("Мартюшев Данил Александрович");
        });

        step("Input Number phone", () -> {
            $("#hr-form-phone-input").setValue("9028020904");
        });

        step("Input link to Github project tochka", () -> {
            $("#hr-form-href-input").setValue("https://github.com/Wrestringer/tochka");
        });

        step("Attach CV", () -> {
            File CV = new File("src/test/resources/Мартюшев Данил Александрович.pdf");
            $("input[type='file']").uploadFile(CV);
        });

        step("Check CV upload", () ->{
            $(".input-file_fileListName__1auW6").shouldBe(visible);
        });

        step("Click button 'Откликнуться'", () -> {
            $("button[class=kit-button.kit-button_style_primary.kit-button_size_adaptive.kit-button_backgroundMode_light]");
        });
    }
}
