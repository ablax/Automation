package me.ablax.project.pages;

import me.ablax.project.utils.DoubleUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.fail;

public class LengthConvertorPage extends BasePage {

    private final WebDriver webDriver;

    @FindBy(xpath = "//input[@id='suma' and @name='suma']")
    private WebElement valueField;

    @FindBy(xpath = "//select[@id='ot' and @name='ot']")
    private WebElement fromField;

    @FindBy(xpath = "//select[@id='kam' and @name='kam']")
    private WebElement toField;

    @FindBy(xpath = "//input[@class = 'presmetni_b']")
    private WebElement submitBtn;

    @FindBy(xpath = "//input[@class = 'izchisti_b']")
    private WebElement clearBtn;

    private String fromType;
    private String toType;

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

    public LengthConvertorPage setFromMilesToKilometers() {
        this.fromType = "Мили";
        this.toType = "km";
        return this.setFrom("миля").setTo("Километър");
    }

    public LengthConvertorPage setFromKilometersToMiles() {
        this.fromType = "km";
        this.toType = "Мили";
        return this.setFrom("Километър").setTo("миля");
    }

    private LengthConvertorPage setFrom(final String fromType) {
        fromField.click();
        fromField.sendKeys(fromType);
        fromField.sendKeys(Keys.ENTER);
        return this;
    }

    private LengthConvertorPage setTo(final String toType) {
        toField.click();
        toField.sendKeys(toType);
        toField.sendKeys(Keys.ENTER);
        return this;
    }

    public LengthConvertorPage setValue(final Double value) {
        valueField.click();
        valueField.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.BACK_SPACE));
        valueField.sendKeys(DoubleUtils.toString(value));
        return this;
    }


    public String getValue() {
        return valueField.getAttribute("value");
    }

    public LengthConvertorPage setValue(final String value) {
        valueField.click();
        valueField.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.BACK_SPACE));
        valueField.sendKeys(value);
        return this;
    }

    public LengthConvertorPage pressCalculateButton() {
        submitBtn.click();
        return this;
    }

    public LengthConvertorPage pressClearButton() {
        clearBtn.click();
        return this;
    }

    public LengthConvertorPage isCalculationCorrect(final Double fromValue, Double toValue) {
        toValue = DoubleUtils.floorDown(toValue);
        try {
            final String xpath = "//p[contains(text(), '" + DoubleUtils.toString(fromValue) + " " + fromType + " = ')]";
            webDriver.findElement(By.xpath(xpath));

            final Double calculatedValue = getCalculatedValue();
            if (Math.abs(toValue - calculatedValue) > 0.02) {
                fail("The calculation is not correct");
            }

        } catch (final Exception ex) {
            fail("The calculation is not correct");
        }
        return this;
    }

    private Double getCalculatedValue() {
        try {
            final String xpath = "//p[contains(text(), '" + fromType + " = ')]";
            final String text = webDriver.findElement(By.xpath(xpath)).getText();
            final String calculatedValue = text.split("=")[1].split(toType)[0].trim();
            return Double.parseDouble(calculatedValue);
        } catch (final Exception ex) {
            fail("The calculation is not correct");
        }
        fail("The calculation is not correct");
        return -1D;
    }

    public LengthConvertorPage hasCalculated() {
        try {
            final String xpath = "//p[contains(text(), '" + fromType + " = ')]";
            webDriver.findElement(By.xpath(xpath));
        } catch (final Exception ex) {
            fail("No calculation was made");
        }
        return this;
    }

}
