import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import sabev.test.test.pages.HomePage;

/**
 * @author Murad Hamza on 26.2.2021 г.
 */
@ExtendWith(SeleniumExtension.class)
public class ElementsPageTests {

    @Test
    public void elementsFormOpenTest(final ChromeDriver chromeDriver) {
        new HomePage(chromeDriver)
                .navigateToElementPage().isPageExpanded()
                .navigateToAlertsPage().isPageExpanded()
                .navigateToFormsPage().isPageExpanded();
    }


}
