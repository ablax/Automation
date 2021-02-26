package sabev.test.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class HomePage<T> extends BasePage<HomePage> {

    private final WebDriver webDriver;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public ElementsPage navigateToElementPage(){
        webDriver.navigate().to(BASE_URL + "elements/");
        return new ElementsPage(webDriver);
    }

    public AlertsPage navigateToAlertsPage(){
        webDriver.navigate().to(BASE_URL + "alertsWindows/");
        return new AlertsPage(webDriver);
    }

    public FormsPage navigateToFormsPage(){
        webDriver.navigate().to(BASE_URL + "forms/");
        return new FormsPage(webDriver);
    }

    public T isPageExpanded(){
        try{
            webDriver.findElement(By.xpath("//div[@class='element-list collapse show']"));
        }catch (Exception e){
            fail("Not expanded");
        }
        return (T) this;
    }
}
