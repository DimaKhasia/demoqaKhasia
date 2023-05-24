package demoqakhasia.tests;

import com.github.javafaker.Faker;
import demoqakhasia.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static demoqakhasia.tests.TestData.*;
import static demoqakhasia.utils.RandomUtils.getRandomCity;
import static demoqakhasia.utils.RandomUtils.getRandomInt;


public class PracticeFormWithTestDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(TestData.gender),
            userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 25)),
            monthOfBirth = faker.options().option(months),
            yearOfBirth = String.valueOf(getRandomInt(1956, 2004)),
            subject = faker.options().option(subjects),
            hobbies = faker.options().option(hobbiess),
            currentAddress = faker.address().streetAddress(),
            randomState = faker.options().option(states),
            randomCity = getRandomCity(randomState);

    @Test
    void practiceFormTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobby(hobbies)
                .uploadPicture("DZK.jpeg")
                .setCurrentAddress(currentAddress)
                .setState(randomState)
                .setCity(randomCity)
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "DZK.jpeg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", randomState + " " + randomCity);
    }
}