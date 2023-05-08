package demoqaKhasia.pages;

import com.codeborne.selenide.SelenideElement;
import demoqaKhasia.pages.components.CalendarComponent;
import demoqaKhasia.pages.components.ResultsModal;

import java.net.HttpCookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    // SelenideElements / locator / etc
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstnameInput = $("[id=firstName]"),
            lastnameInput = $("[id=lastName]"),
            userEmailInput = $("[id=userEmail]"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateAndCityChoice = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");


    // Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("window.scrollBy(0,1000)");

        return this;
    }
    public RegistrationPage setFirstname(String value) {
        firstnameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastname(String value) {
        lastnameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);

        return this;
    }
    public void setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value) {
        city.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }
    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }
        public RegistrationPage verifyResult(String key, String value) {
            resultsModal.verifyResult(key, value);
            return this;

        }
}
