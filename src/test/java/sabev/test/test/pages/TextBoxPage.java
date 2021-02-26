package sabev.test.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.fail;

public class TextBoxPage extends HomePage<TextBoxPage> {

    private final WebDriver webDriver;

    @FindBy(id = "userName")
    private WebElement usernameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    public TextBoxPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public TextBoxPage setUsername(final String username) {
        this.usernameField.sendKeys(username);
        return this;
    }

    public TextBoxPage setEmail(final String email) {
        this.emailField.sendKeys(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(final String currentAddress) {
        this.currentAddressField.sendKeys(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(final String permanentAddress) {
        this.permanentAddressField.sendKeys(permanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        this.submitBtn.click();
        return this;
    }

    public String getSubmittedName() {
        return webDriver.findElement(By.id("name")).getText();
    }

    public TextBoxPage isOnTextBoxPage() {
        try {
            webDriver.findElement(By.xpath("//div[@class=\"main-header\" and contains(text(), \"Text Box\")]"));
        } catch (Exception ex) {
            fail("Not on page");
        }
        return this;
    }

    public String fillForm(final String username, final String email, final String currentAddress, final String permanentAddress) {
        return this
                .setUsername(username)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .getSubmittedName();
    }
}
