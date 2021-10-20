package com.sazhina.tests.demo;

import com.sazhina.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.sazhina.tests.demo.TestDataFaker.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

@Test
    void fillFormTest() {

    step("Open registration form", () -> {
        registrationPage.openPage();
    });

    step("Type personal data", () -> {
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.setGender(gender);
        registrationPage.typePhone(phone);
        registrationPage.calendar.setDateOfBirth(day, month, year);
    });

    step("Set subjects and hobbies", () -> {
        registrationPage.typeSubject(subject);
        registrationPage.checkHobbies(hobby);
    });

    step("Upload image", () -> {
        registrationPage.uploadImage(fileName);
    });

    step("Type address", () -> {
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.selectStateDropdown(state);
        registrationPage.selectCityDropdown(city);
    });

    step("Submit form", () -> {
        registrationPage.clickSubmit();
    });

    step("Assert values", () -> {
        registrationPage.checkFinalTitle();
        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Student Email", userEmail);
        registrationPage.checkResult("Mobile", phone);
        registrationPage.checkResult("Date of Birth", day + " " + month + "," + year);
        registrationPage.checkResult("Subjects", subject);
        registrationPage.checkResult("Hobbies", hobby);
        registrationPage.checkResult("Picture", fileName);
        registrationPage.checkResult("Address", currentAddress);
        registrationPage.checkResult("State and City", state + " " + city);
    });

    }
}

