package me.ablax.project.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    public final static String BASE_URL = "https://www.calculator.bg/";
    private final WebDriver webDriver;

    public BasePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage navigateToHomePage(){
        webDriver.navigate().to(BASE_URL);
        return new HomePage(webDriver);
    }
}
