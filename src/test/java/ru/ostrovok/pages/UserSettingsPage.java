package ru.ostrovok.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class UserSettingsPage {

    private final SelenideElement title = $x(".//div[@class='zenpersonalinformation-title']"),
            firstName = $x(".//input[@name='name']"),
            lastName = $x(".//input[@name='surname']"),
            dateOfBirth = $x(".//input[@name='birthday']"),
            citizenship = $x(".//input[@name='residency']"),
            phoneNum = $x(".//input[@name='phone']"),
            saveButton = $x(".//button[@class='button-view-primary button-size-s zenpersonalinformation-button']"),
            userDataNotification = $x(".//div[@class='zenpersonalinformation-success-notification']");


    public UserSettingsPage checkTitle(String expectedTitle) {
        title.shouldHave(text(expectedTitle));
        return this;
    }

    public UserSettingsPage setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public UserSettingsPage setLastName(String name) {
        lastName.setValue(name);
        return this;
    }

    public UserSettingsPage setBirthDate(String value) {
        dateOfBirth.setValue(value);
        return this;
    }

    public UserSettingsPage setCitizenship(String value) {
        citizenship.setValue(value).pressEnter();
        return this;
    }

    public UserSettingsPage setPhoneNum(String value) {
        phoneNum.setValue(value);
        return this;
    }

    public UserSettingsPage setGender(String value) {
        $x(String.format(".//input[@name='gender_field' and @id='%s']/..", value)).click();
        return this;
    }

    public UserSettingsPage clickSaveButton() {
        saveButton.shouldBe(visible).click();
        return this;
    }

    public UserSettingsPage checkUserDataIsSaved(String text) {
        userDataNotification.shouldBe(visible).shouldHave(text(text));
        return this;
    }


}
