package ru.ostrovok.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.ostrovok.config.WebDriverProvider;
import ru.ostrovok.helpers.Attachments;
import ru.ostrovok.helpers.GenerateData;
import ru.ostrovok.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected MainPage mainPage = new MainPage();
    protected GenerateData generateData = new GenerateData();

    @BeforeEach
    void setUp() {
        WebDriverProvider.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttach() {
        Attachments.addVideo();
        Attachments.browserConsoleLogs();
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        closeWebDriver();
    }
}
