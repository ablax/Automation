package me.ablax.project;

import io.github.bonigarcia.seljup.SeleniumExtension;
import me.ablax.project.pages.HomePage;
import me.ablax.project.pages.LengthConvertorPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Murad Hamza on 26.2.2021 г.
 */
@ExtendWith(SeleniumExtension.class)
public class ConvertorsPageTests {

    @Test
    public void LengthConvertorPageNavigationTest(final ChromeDriver chromeDriver) {
        new HomePage(chromeDriver)
                .navigateToHomePage().isOnHomePage()
                .navigateToConvertorsPage().isOnConvertorsPage()
                .navigateToLengthCalculatorPage().isOnLengthConvertorPage();
    }

    @Test
    public void LengthConvertorPageClearTest(final ChromeDriver chromeDriver) {
        final LengthConvertorPage lengthConvertorPage = new HomePage(chromeDriver)
                .navigateToHomePage()
                .navigateToConvertorsPage()
                .navigateToLengthCalculatorPage()
                .setFromKilometersToMiles()
                .setValue(15D)
                .pressClearButton();
        final String gotValue = lengthConvertorPage.getValue();
        assertEquals("", gotValue);
    }


    @Test
    public void MileToKilometerTest_expected_correct(final ChromeDriver chromeDriver) {
        final Double calculationRate = 1.6094D;
        final List<Double> valuesToTest = Arrays.asList(50D, 60D, 70D);

        final LengthConvertorPage lengthConvertorPage = new HomePage(chromeDriver)
                .navigateToHomePage()
                .navigateToConvertorsPage().isOnConvertorsPage()
                .navigateToLengthCalculatorPage().isOnLengthConvertorPage()
                .setFromMilesToKilometers();

        for (final Double from : valuesToTest) {
            final Double to = from * calculationRate;
            lengthConvertorPage
                    .setValue(from)
                    .pressCalculateButton()
                    .isCalculationCorrect(from, to);
        }
    }


    @Test
    public void MileToKilometerTest_expect_to_fail(final ChromeDriver chromeDriver) {
        final List<String> valuesToTest = Arrays.asList("", "0");

        final LengthConvertorPage lengthConvertorPage = new HomePage(chromeDriver)
                .navigateToHomePage()
                .navigateToConvertorsPage().isOnConvertorsPage()
                .navigateToLengthCalculatorPage().isOnLengthConvertorPage()
                .setFromMilesToKilometers();

        for (final String from : valuesToTest) {
            assertThrows(AssertionError.class, () -> lengthConvertorPage
                    .setValue(from)
                    .pressCalculateButton()
                    .hasCalculated());
        }

    }

    @Test
    public void KilometerToMileTest_expected_correct(final ChromeDriver chromeDriver) {
        final Double calculationRate = 0.6214D;
        final List<Double> valuesToTest = Arrays.asList(5D, 15D, 30D, 40D, 50D, 60D);

        final LengthConvertorPage lengthConvertorPage = new HomePage(chromeDriver)
                .navigateToHomePage()
                .navigateToConvertorsPage().isOnConvertorsPage()
                .navigateToLengthCalculatorPage().isOnLengthConvertorPage()
                .setFromKilometersToMiles();

        for (final Double from : valuesToTest) {
            final Double to = from * calculationRate;
            lengthConvertorPage
                    .setValue(from)
                    .pressCalculateButton()
                    .isCalculationCorrect(from, to);
        }
    }


    @Test
    public void KilometerToMileTest_expect_to_fail(final ChromeDriver chromeDriver) {
        final List<String> valuesToTest = Arrays.asList("", "0");

        final LengthConvertorPage lengthConvertorPage = new HomePage(chromeDriver)
                .navigateToHomePage()
                .navigateToConvertorsPage().isOnConvertorsPage()
                .navigateToLengthCalculatorPage().isOnLengthConvertorPage()
                .setFromKilometersToMiles();

        for (final String from : valuesToTest) {
            assertThrows(AssertionError.class, () -> lengthConvertorPage
                    .setValue(from)
                    .pressCalculateButton()
                    .hasCalculated());
        }

    }

}
