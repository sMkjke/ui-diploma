package ru.ostrovok.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

class LoginTest extends BaseTest {

    public static final String EMPTY_LOGIN_ERROR = "Пожалуйста, заполните пароль и адрес электронной почты";
    public static final String INCORRECT_LOGIN_AND_PASS = "Указан неправильный пароль или электронный адрес";

    @Feature("Login")
    @Owner("Smkjke")
    @DisplayName("Check login error with empty fields")
    @Test
    void checkLoginErrorWithEmptyLoginAndPass() {
        step("Open page", () ->
                mainPage.openPage());
        step("Click on language menu", () ->
                mainPage.clickOnLanguageMenu());
        step("Choose language", () ->
                mainPage.clickOnChoosedLanguage("Русский"));
        step("Check login menu item is present", () ->
                mainPage.checkMenuItemIsVisible("Войти"));
        step("Click on login menu", () ->
                mainPage.clickOnMenu("Войти"));
        step("Click on Enter button", () ->
                mainPage.clickOnEnterButton());
        step("Check login error with empty fields", () ->
                mainPage.checkLoginError(EMPTY_LOGIN_ERROR));
    }

    @Feature("Login")
    @Owner("Smkjke")
    @DisplayName("Check login error with incorrect fields")
    @Test
    void checkLoginErrorWithIncorrectLoginAndPass() {
        step("Open page", () ->
                mainPage.openPage());
        step("Click on language menu", () ->
                mainPage.clickOnLanguageMenu());
        step("Choose language", () ->
                mainPage.clickOnChoosedLanguage("Русский"));
        step("Check login menu item is present", () ->
                mainPage.checkMenuItemIsVisible("Войти"));
        step("Click on login menu", () ->
                mainPage.clickOnMenu("Войти"));
        step("Fill the email", () ->
                mainPage.setEmail(generateData.getEmail()));
        step("Fill the pass", () ->
                mainPage.setPass(generateData.getPassword()));
        step("Click on Enter button", () ->
                mainPage.clickOnEnterButton());
        step("Check login error with incorrect fields", () ->
                mainPage.checkLoginError(INCORRECT_LOGIN_AND_PASS));
    }

}
