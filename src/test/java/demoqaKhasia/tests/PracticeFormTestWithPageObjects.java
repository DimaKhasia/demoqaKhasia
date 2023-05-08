package demoqaKhasia.tests;

import demoqaKhasia.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestWithPageObjects extends TestBase {

    @Test
    void successRegistrationTest() {

        registrationPage.openPage()
                        .setFirstname("DIMA")
                        .setLastname("KHASIA")
                        .setUserEmail("dihasiya@mail.ru")
                        .setGender("Male")
                        .setNumber("9999999999")
                        .setBirthDate("30", "July", "1996");
        registrationPage.setSubjects("Math")
                        .setHobbies("Sports")
                        .setPicture("DZK.jpeg")
                        .setAddress("Ukraine, Donetsk, Armavirskaya 21")
                        .setState("Rajasthan")
                        .setCity("Jaipur")
                        .clickSubmit();
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "DIMA KHASIA")
                .verifyResult("Student Email", "dihasiya@mail.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9999999999")
                .verifyResult("Date of Birth", "30 July,1996")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "DZK.jpeg")
                .verifyResult("Address", "Ukraine, Donetsk, Armavirskaya 21")
                .verifyResult("State and City", "Rajasthan Jaipur");

    }
}
