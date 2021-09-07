package com.sazhina;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void befireAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Carol");
        $("#lastName").setValue("Denvers");
        $("#userEmail").setValue("Captain@Marvel.com");
        //$("#gender-radio-2 + label").click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("1968")).click();
        $(byText("1")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/picture.jpg"));
        $("#currentAddress").setValue("Cape Canaveral Air Force Station, USA");
        $("#state").find("input").setValue("NCR").pressEnter();
        $("#city").find("input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $("tbody").find(withText("Name")).parent().shouldHave(text("Carol Denvers"));
        $("tbody").find(withText("Email")).parent().shouldHave(text("Captain@Marvel.com"));
        $("tbody").find(withText("Gender")).parent().shouldHave(text("Female"));
        $("tbody").find(withText("Mobile")).parent().shouldHave(text("1234567890"));
        $("tbody").find(withText("Birth")).parent().shouldHave(text("01 March,1968"));
        $("tbody").find(withText("Subjects")).parent().shouldHave(text("Maths"));
        $("tbody").find(withText("Hobbies")).parent().shouldHave(text("Sports"));
        $("tbody").find(withText("Picture")).parent().shouldHave(text("picture.jpg"));
        $("tbody").find(withText("Address")).parent().shouldHave(text("Cape Canaveral Air Force Station, USA"));
        $("tbody").find(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));
    }
}
