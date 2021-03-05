package me.ablax.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    private final WebDriver webDriver;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public ConvertorsPage navigateToConvertorsPage() {
        webDriver.findElement(By.xpath("//a[contains(text(), 'конвертори')]")).click();
        return new ConvertorsPage(webDriver);
    }



}
