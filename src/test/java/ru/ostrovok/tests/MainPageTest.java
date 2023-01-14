package ru.ostrovok.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ostrovok.pages.MainPage;

import static io.qameta.allure.Allure.step;

class MainPageTest extends BaseTest {

    @Feature("Mainpage")
    @Owner("Smkjke")
    @DisplayName("Check main page title")
    @Test
    void checkTitlePage() {
        step("Open main page", () ->
                mainPage.openPage());
        step("Click on language menu", () ->
                mainPage.clickOnLanguageMenu());
        step("Choose language", () ->
                mainPage.clickOnChoosedLanguage("Русский"));
        step("Check main page title", () ->
                mainPage.checkTitle(MainPage.TITLE_TEXT));
    }

    @Feature("Mainpage")
    @Owner("Smkjke")
    @DisplayName("Check MainSubmenu")
    @Test
    void checkMainSubMenu() {
        step("Open main page", () ->
                mainPage.openPage());
        step("Click on language menu", () ->
                mainPage.clickOnLanguageMenu());
        step("Choose language", () ->
                mainPage.clickOnChoosedLanguage("Русский"));
        step("Click on main menu", () ->
                mainPage.clickOnMainMenu());
        step("Check main sub menu is visible", () ->
                mainPage.checkMainSubMenuIsVisible("Служба поддержки"));
    }

}
