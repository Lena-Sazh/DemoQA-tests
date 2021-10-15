package com.sazhina.tests;

import com.github.javafaker.Faker;

import java.util.Date;

public class TestDataFaker {

    static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress(),
            gender = "Female",
            month = "January",
            subject = "Math",
            hobby = "Sports",
            fileName = "picture.jpg",
            state = "NCR",
            city = "Gurgaon";

    public static int
            day = faker.random().nextInt(1, 30),
            year = faker.random().nextInt(1960, 2000);

    // experiments
    public static Date
            birthday = faker.date().birthday(15,60);



}
