package ru.ostrovok.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ostrovok.pages.UserSettingsPage;

import static io.qameta.allure.Allure.step;

public class RegistrationTest extends BaseTest {

    public static final String DATA_IS_SAVED = "Данные сохранены";
    private UserSettingsPage userSettingsPage;

    @Feature("Registration")
    @Owner("Smkjke")
    @DisplayName("Registration and enter Users settings")
    @Test
    void c() {
        step("Open page", () ->
                mainPage.openPage());
        step("Check login menu item is present", () ->
                mainPage.checkMenuItemIsVisible("Войти"));
        step("Click on login menu", () ->
                mainPage.clickOnMenu("Войти"));
        step("Click on Register button", () ->
                mainPage.clickRegisterPath());
        step("Fill the email", () ->
                mainPage.setEmail(generateData.getEmail()));
        step("Click on Registration button", () ->
                mainPage.clickOnRegistrationButton());
        step("Check email label is appeared and registration has been successful", () ->
                mainPage.checkUserEmail(generateData.getEmail()));
        step("Click on user email", () ->
                mainPage.clickOnMenu(generateData.getEmail()));
        step("Click on user email", () ->
                userSettingsPage = mainPage.clickOnUserSettingsButton());
        step("Fill user's credentials", () -> {
            userSettingsPage.setFirstName(generateData.getName())
                    .setLastName(generateData.getLastName())
                    .setBirthDate(generateData.getDateOfBirth())
                    .setCitizenship(generateData.getCitizenship())
                    .setGender(generateData.getSex())
                    .setPhoneNum(generateData.getPhone());
        });
        step("Click on Save button", () ->
                userSettingsPage.clickSaveButton());
        step("Check input data saved and notification is appeared", () ->
                userSettingsPage.checkUserDataIsSaved(DATA_IS_SAVED));
    }
}
