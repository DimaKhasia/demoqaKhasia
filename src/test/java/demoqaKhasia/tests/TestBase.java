package demoqaKhasia.tests;

import com.codeborne.selenide.Configuration;
import demoqaKhasia.pages.RegistrationPage;
import demoqaKhasia.pages.components.CalendarComponent;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void BeforeAll (){
        Configuration.baseUrl = ("https://demoqa.com");
//        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }
}
