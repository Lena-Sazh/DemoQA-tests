package com.sazhina.pages;

import com.codeborne.selenide.SelenideElement;
import com.sazhina.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private final String MODAL_TITLE = "Thanks for submitting the form";

    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            imageUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateCityDropdown = $("#stateCity-wrapper"),
            cityDropdown = $("#city"),
            submitButton = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            modalTable = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void setGender(String value) {
        genderRadioButton.$(byText(value)).click();
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    public void typeSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
    }

    public void uploadImage(String value) {
        imageUpload.uploadFromClasspath(value);
    }

    public void checkHobbies(String value) {
        hobbiesCheckBox.$(byText(value)).click();
    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.scrollTo();
        currentAddressInput.setValue(value);
    }

    public void selectStateDropdown(String value) {
        stateDropdown.click();
        stateCityDropdown.$(byText(value)).click();
    }

    public void selectCityDropdown(String value) {
        cityDropdown.click();
        stateCityDropdown.$(byText(value)).click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void checkFinalTitle() {
        modalTitle.shouldHave(text(MODAL_TITLE));
    }

    public void checkResult(String key, String value) {
        modalTable.$(byText(key)).parent().shouldHave(text(value));
    }
}