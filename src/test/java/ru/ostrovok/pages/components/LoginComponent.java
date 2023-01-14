package ru.ostrovok.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginComponent {

    private final SelenideElement emailInput = $x(".//input[@name='email']"),
            passInput = $x(".//input[@name='pass']"),
            loginActionButton = $x(".//span[@class='Authorization-module__tab--2zUuu']"),
            enterButton = $x(".//button[@class=" +
                    "'Button-module__button--MR2Ly Button-module__button_size_m--184Hw " +
                    "Button-module__button_wide--eV274 Authorization-module__button--3aF30']"),
            registerButton = $x(".//button[@data-testid='user-widget-sign-up-button']"),
            userEmail = $x(".//div[@class='Control-module__username--3qcGq']"),
            userSettings = $x(".//div[@class='UserInfo-module__settings--3AUPP']");

    public LoginComponent loginError(String error) {
        $x("//div[@class='Authorization-module__error--17cEq']").shouldHave(text(error));
        return this;
    }

    public LoginComponent enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public LoginComponent enterPass(String pass) {
        passInput.setValue(pass);
        return this;
    }

    public LoginComponent clickOnRegisterPath() {
        loginActionButton.shouldBe(visible).click();
        return this;
    }

    public LoginComponent clickOnEnterButton() {
        enterButton.shouldBe(visible).click();
        return this;
    }

    public LoginComponent clickOnRegistrationButton() {
        registerButton.shouldBe(visible).click();
        return this;
    }

    public LoginComponent checkEmailIsCorrect(String email) {
        userEmail.shouldHave(text(email));
        return this;
    }

    public LoginComponent clickOnUserSettings(){
        userSettings.shouldBe(visible).click();
        return this;
    }

}
