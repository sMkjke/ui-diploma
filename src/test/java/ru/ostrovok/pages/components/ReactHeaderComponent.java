package ru.ostrovok.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ReactHeaderComponent {

    private final SelenideElement
            mainMenu = $x("//div[@class='Widgets-module__widget-desktopUp--3G88_']" +
            "//div[@class='MenuWidget-module__button--2_XeY']" +
            "//*[name()='svg']"),
            languageMenu = $x(".//div[contains(@class,'LanguageWidget-module__arrow--3_2Gi')]");


    private final ElementsCollection
            menuItem = $$x(".//div[@class='clickOutside']//div[@class='Wrapper-module__control--3ewNY']");


    public ReactHeaderComponent clickOnMenu(String name) {
        menuItem.findBy(text(name)).click();
        return this;
    }

    public ReactHeaderComponent clickMainMenu() {
        mainMenu.click();
        return this;
    }

    public ReactHeaderComponent checkMainSubMenuIsVisible(String name) {
        $x(String.format("//div[@class='MenuWidget-module__link--1lgVQ']/a[contains(text(),'%s')]",
                name)).shouldBe(visible);
        return this;
    }


    public ReactHeaderComponent checkMenuIsVisible(String name) {
        menuItem.findBy(text(name)).shouldBe(visible);
        return this;
    }

    public ReactHeaderComponent languageMenuCollection(int num) {
        $$x(".//div[@class='LanguageWidget-module__list--1O5zG']/div").shouldHave(size(num));
        return this;
    }

    public ReactHeaderComponent languageMenuClick() {
        languageMenu.click();
        return this;
    }

    public ReactHeaderComponent languageChoose(String language) {
        $x(String.format(".//div[@class='LanguageWidget-module__list--1O5zG']" +
                "//div[contains(text(),'%s')]/parent::div", language)).click();
        return this;
    }

}
