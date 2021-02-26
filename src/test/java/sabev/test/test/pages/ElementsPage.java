package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;

public class ElementsPage extends HomePage<ElementsPage> {

    private WebDriver webDriver;

    public ElementsPage(final WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

}
