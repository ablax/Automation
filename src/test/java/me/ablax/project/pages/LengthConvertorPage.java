package me.ablax.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

import static org.junit.Assert.fail;

public class LengthConvertorPage extends BasePage {

    private final WebDriver webDriver;

    @FindBy(xpath = "//input[@id='suma' and @name='suma']")
    private WebElement valueField;

    @FindBy(xpath = "//select[@id='ot' and @name='ot']")
    private WebElement fromField;

    @FindBy(xpath = "//select[@id='kam' and @name='kam']")
    private WebElement toField;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    public LengthConvertorPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public LengthConvertorPage isOnLengthConvertorPage() {
        try {
            webDriver.findElement(By.xpath("//p/*[contains(text(), 'преобразуване на мерни единици за дължина')]"));
        } catch (Exception ex) {
            fail("Not on page");
        }
        return this;
    }

    public LengthConvertorPage setFromMilesToKilometers(){
       return this.setFrom("миля").setTo("Километър");
    }

    public LengthConvertorPage setFromKilometersToMiles(){
       return this.setFrom("Километър").setTo("миля");
    }

    public LengthConvertorPage setFrom(final String from){
        fromField.click();
        fromField.sendKeys(from);
        fromField.sendKeys(Keys.ENTER);
        return this;
    }

    public LengthConvertorPage setTo(final String to){
        toField.click();
        toField.sendKeys(to);
        toField.sendKeys(Keys.ENTER);
        return this;
    }
//
//    public TextBoxPage setUsername(final String username) {
//        this.usernameField.sendKeys(username);
//        return this;
//    }
//
//    public TextBoxPage setEmail(final String email) {
//        this.fromField.sendKeys(email);
//        return this;
//    }
//
//    public TextBoxPage setCurrentAddress(final String currentAddress) {
//        this.toField.sendKeys(currentAddress);
//        return this;
//    }
//
//    public TextBoxPage setPermanentAddress(final String permanentAddress) {
//        this.permanentAddressField.sendKeys(permanentAddress);
//        return this;
//    }
//
//    public TextBoxPage submit() {
//        this.submitBtn.click();
//        return this;
//    }
//
//    public String getSubmittedName() {
//        return webDriver.findElement(By.id("name")).getText();
//    }
//
//    public String fillForm(final String username, final String email, final String currentAddress, final String permanentAddress) {
//        return this
//                .setUsername(username)
//                .setEmail(email)
//                .setCurrentAddress(currentAddress)
//                .setPermanentAddress(permanentAddress)
//                .submit()
//                .getSubmittedName();
//    }
}
