package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends HomePage<AlertsPage> {

    private WebDriver webDriver;

    public AlertsPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

}
