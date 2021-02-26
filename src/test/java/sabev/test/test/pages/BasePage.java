package sabev.test.test.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage<T> {

    public final static String BASE_URL = "https://demoqa.com/";
    private final WebDriver webDriver;

    public BasePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public T openHomePage(){
        webDriver.navigate().to(BASE_URL);
        return (T) new HomePage(webDriver);
    }
}
