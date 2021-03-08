package me.ablax.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;


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

    public HomePage isOnHomePage() {
        try {
            webDriver.findElement(By.xpath("//p/*[contains(text(), 'КАЛКУЛАТОР')]"));
        } catch (Exception ex) {
            fail("Not on page");
        }
        return this;
    }


}
