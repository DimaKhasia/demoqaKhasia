package demoqaKhasia;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DZ1TEST {
    @Test
    void mydztest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";

        String gender = "Male";
        String birthMonth = "January";
        String birthYear = "1996";
        String birthDay = "24";
        String subjects = "English";
        String hobbies = "Reading";


        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.scrollBy(0,1000)");
        $("[id=firstName]").setValue("DIMA");
        $("[id=lastName]").setValue("KHASIA");
        $("[id=userEmail]").setValue("dihasiya@mail.ru");
        $("#genterWrapper").$(byText(gender)).click();
        $("[id=userNumber]").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(birthYear)).click();
        $(".react-datepicker__month-select").$(byText(birthMonth)).click();
        $(".react-datepicker__day--0" + birthDay).click();
        $("#subjectsContainer input").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/DZK.jpeg"));
        $("#currentAddress").setValue("Ukraine, Donetsk, Armavirskaya 21");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();
//      Решил попробовать разными способами ввода данных

        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("DIMA" + " " + "KHASIA"), text("dihasiya@mail.ru"),
                text("Male"), text("9999999999"), text("24 January,1996"), text("English"),
                text("Reading"), text("DZK.jpeg"), text("Ukraine, Donetsk, Armavirskaya 21"),
                text("Rajasthan" + " " + "Jaipur"));

    }
}
