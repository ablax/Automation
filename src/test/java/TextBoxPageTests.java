import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import sabev.test.test.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SeleniumExtension.class)
public class TextBoxPageTests {

    @Test
    public void testSubmittingForm(final ChromeDriver chromeDriver) {
        final String username = "Ablax";
        assertThat(new HomePage(chromeDriver)
                .navigateToElementPage()
                .isPageExpanded()
                .navigateToTextBoxPage()
                .fillForm(username, "murad.m.m@abv.bg", "Nope", "Nope Nope")
                .getSubmittedName()
        ).isEqualTo("Name:" + username);
    }


}
