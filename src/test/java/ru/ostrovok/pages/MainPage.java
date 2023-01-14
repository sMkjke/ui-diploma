package ru.ostrovok.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.ostrovok.pages.components.LoginComponent;
import ru.ostrovok.pages.components.ReactHeaderComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class MainPage {

    private final SelenideElement
            title = $x(".//div[@class='homepage-howdy-title']"),
            controlModule = $x(".//div[contains(@class,'Control-module__value--1KWj3')]");

    private final ReactHeaderComponent reactHeaderComponent = new ReactHeaderComponent();
    private final LoginComponent loginComponent = new LoginComponent();
    public static final String TITLE_TEXT = "Поиск отелей, хостелов и апартаментов";

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage checkTitle(String expectedTitle) {
        title.shouldHave(text(expectedTitle));
        return this;
    }

    public MainPage checkMenuItemIsVisible(String menuItem) {
        reactHeaderComponent.checkMenuIsVisible(menuItem);
        return this;
    }

    public MainPage clickOnMenu(String menuItem) {
        reactHeaderComponent.clickOnMenu(menuItem);
        return this;
    }

    public MainPage clickOnMainMenu() {
        reactHeaderComponent.clickMainMenu();
        return this;
    }

    public MainPage checkLanguageMenuCollectionSize(int size) {
        reactHeaderComponent.languageMenuCollection(size);
        return this;
    }

    public MainPage checkMainSubMenuIsVisible(String name) {
        reactHeaderComponent.checkMainSubMenuIsVisible(name);
        return this;
    }

    public MainPage checkLoginError(String error) {
        loginComponent.loginError(error);
        return this;
    }

    public MainPage clickOnLanguageMenu() {
        reactHeaderComponent.languageMenuClick();
        return this;
    }

    public MainPage clickOnChoosedLanguage(String language) {
        reactHeaderComponent.languageChoose(language);
        return this;
    }

    public MainPage setEmail(String email) {
        loginComponent.enterEmail(email);
        return this;
    }

    public MainPage setPass(String pass) {
        loginComponent.enterPass(pass);
        return this;
    }

    public MainPage clickRegisterPath() {
        loginComponent.clickOnRegisterPath();
        return this;
    }

    public MainPage clickOnEnterButton() {
        loginComponent.clickOnEnterButton();
        return this;
    }

    public MainPage clickOnRegistrationButton() {
        loginComponent.clickOnRegistrationButton();
        return this;
    }

    public MainPage checkUserEmail(String email) {
        loginComponent.checkEmailIsCorrect(email);
        return this;
    }

    public UserSettingsPage clickOnUserSettingsButton() {
        loginComponent.clickOnUserSettings();
        return new UserSettingsPage();
    }

}
