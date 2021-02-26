package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends HomePage<FormsPage> {

    private final WebDriver webDriver;

    public FormsPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

}
