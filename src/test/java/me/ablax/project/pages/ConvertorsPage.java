package me.ablax.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.fail;

public class ConvertorsPage extends BasePage {

    private final WebDriver webDriver;

    @FindBy(xpath = "//a[contains(text(), 'преобразуване на мерни единици за дължина')]")
    private WebElement lengthCalculatorAnchor;

    public ConvertorsPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public ConvertorsPage isOnConvertorsPage() {
        try {
            webDriver.findElement(By.xpath("//p/*[contains(text(), 'конвертори за мерни единици')]"));
        } catch (Exception ex) {
            fail("Not on page");
        }
        return this;
    }

    public LengthConvertorPage navigateToLengthCalculatorPage() {
        lengthCalculatorAnchor.click();
        return new LengthConvertorPage(webDriver);
    }

}
