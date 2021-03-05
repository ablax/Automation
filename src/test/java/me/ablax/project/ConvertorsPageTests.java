package me.ablax.project;

import io.github.bonigarcia.seljup.SeleniumExtension;
import me.ablax.project.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Murad Hamza on 26.2.2021 г.
 */
@ExtendWith(SeleniumExtension.class)
public class ConvertorsPageTests {

    @Test
    public void elementsFormOpenTest(final ChromeDriver chromeDriver) {
        new HomePage(chromeDriver)
                .navigateToHomePage()
                .navigateToConvertorsPage().isOnConvertorsPage()
                .navigateToLengthCalculatorPage().isOnLengthConvertorPage()
                .setFromMilesToKilometers()
                .setFromKilometersToMiles();

        System.out.println();
    }


}
