package com.sazhina.tests;

import com.sazhina.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.sazhina.tests.TestDataFaker.*;

public class StudentRegistrationFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

@Test
    void fillFormTest() {
    registrationPage.openPage();
    registrationPage.typeFirstName(firstName);
    registrationPage.typeLastName(lastName);
    registrationPage.typeEmail(userEmail);
    registrationPage.setGender(gender);
    registrationPage.typePhone(phone);
    registrationPage.calendar.setDateOfBirth(day, month, year);
    registrationPage.typeSubject(subject);
    registrationPage.checkHobbies(hobby);
    registrationPage.uploadImage(fileName);
    registrationPage.typeCurrentAddress(currentAddress);
    registrationPage.selectStateDropdown(state);
    registrationPage.selectCityDropdown(city);
    registrationPage.clickSubmit();

    //assertions
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
    }
}

