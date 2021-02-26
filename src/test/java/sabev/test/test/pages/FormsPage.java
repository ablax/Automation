package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;

public class FormsPage extends HomePage<FormsPage> {

    private WebDriver webDriver;

    public FormsPage(final WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

}
