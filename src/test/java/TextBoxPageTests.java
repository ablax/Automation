import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import sabev.test.test.pages.HomePage;

@ExtendWith(SeleniumExtension.class)
public class TextBoxPageTests {

    @Test
    public void testSubmittingForm(final ChromeDriver chromeDriver) {
        new HomePage(chromeDriver).navigateToElementPage()
                .isPageExpanded()
                .navigateToTextBoxPage()
                .setUsername("Ablax")
                .setEmail("murad.m.m@abv.bg")
                .setCurrentAddress("Nope")
                .setPermanentAddress("Nope Nope")
                .submit();
    }


}
