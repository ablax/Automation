package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends HomePage<ElementsPage> {

    private WebDriver webDriver;

    public ElementsPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

}
