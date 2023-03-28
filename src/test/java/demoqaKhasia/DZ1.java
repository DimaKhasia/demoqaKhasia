package demoqaKhasia;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DZ1 {
    @Test
    void mydztest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";

        open ("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.scrollBy(0,1000)");
        $("[id=firstName]").setValue("DIMA");
        $("[id=lastName]").setValue("KHASIA");
        $("[id=userEmail]").setValue("dihasiya@mail.ru");
        $("[id=userNumber]").setValue("9999999999");
        $("[class=subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3]").setValue("Math");

    }
}
