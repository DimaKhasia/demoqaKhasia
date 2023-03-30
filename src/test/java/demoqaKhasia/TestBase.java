package demoqaKhasia;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestBase {
    @BeforeAll
    static void BeforeAll (){
        Configuration.baseUrl = ("https://demoqa.com");
//        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }
}
