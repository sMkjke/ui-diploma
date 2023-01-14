package ru.ostrovok.helpers;

import com.github.javafaker.Faker;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class GenerateData {

    Faker faker = new Faker();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String email = faker.internet().emailAddress(),
            password = faker.internet().password(),
            name = faker.name().firstName(),
            lastName = faker.name().lastName(),
            dateOfBirth = sdf.format(faker.date().birthday()),
            citizenship = "Австралия",
            sex = faker.demographic().sex().toLowerCase(),
            phone = faker.phoneNumber().subscriberNumber(10);

}
