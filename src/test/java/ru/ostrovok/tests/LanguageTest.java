package ru.ostrovok.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.ostrovok.testData.enums.Locale;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageTest extends BaseTest {

    public static final String LOG_IN_ENGLISH = "Log in";
    public static final String LOG_IN_DEUTSCH = "Anmelden";
    public static final String LOG_IN_ITALIANO = "Accedi";


    @Severity(SeverityLevel.BLOCKER)
    @Feature("Language")
    @Owner("Smkjke")
    @DisplayName("Check language menu")
    @Test
    void checkLanguageMenuSize() {
        step("Open main page", () ->
                mainPage.openPage());
        step("Check language menu item is present", () ->
                mainPage.checkMenuItemIsVisible("Русский"));
        step("Click on language menu", () ->
                mainPage.clickOnMenu("Русский"));
        step("Check language menu items number", () ->
                mainPage.checkLanguageMenuCollectionSize(19));
    }

    @Feature("Language")
    @Owner("Smkjke")
    @EnumSource(Locale.class)
    @DisplayName("Check -log in button locale")
    @ParameterizedTest(name = "Check displayed menu -Log in with {0} locale")
    void checkLogInButtonLocaleTest(Locale locale) {
        step("Open main page", () ->
                mainPage.openPage());
        step("Click on language menu", () ->
                mainPage.clickOnLanguageMenu());
        step("Choose language", () ->
                mainPage.clickOnChoosedLanguage(locale.name()));
        step("Log in button check in " + locale.name(), () -> {
            var controlModule = mainPage.getControlModule();
            switch (locale.name()) {
                case ("English"):
                    assertEquals(LOG_IN_ENGLISH, controlModule.text());
                    break;
                case ("Deutsch"):
                    assertEquals(LOG_IN_DEUTSCH, controlModule.text());
                    break;
                case ("Italiano"):
                    assertEquals(LOG_IN_ITALIANO, controlModule.text());
                    break;
            }
        });
    }

}
