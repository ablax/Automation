package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;

public class AlertsPage extends HomePage<AlertsPage> {

    private WebDriver webDriver;

    public AlertsPage(final WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

}
