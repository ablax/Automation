package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends ElementsPage {

    private final WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement usernameField;

    public TextBoxPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

}
