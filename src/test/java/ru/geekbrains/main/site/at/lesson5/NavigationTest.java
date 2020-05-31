package ru.geekbrains.main.site.at.lesson5_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.lesson5_hw.base.BaseTest;
import ru.geekbrains.main.site.at.pages.NavigationTab;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
public class NavigationTest extends BaseTest {
    @BeforeEach
    public void openSite() {
        driver.get(BASE_URL + "/career");
    }

    @ParameterizedTest
    @DisplayName("check navigation items")
    @MethodSource("pageGenerator")
    public void navigationPanelTest(String buttonTitle) {

        new NavigationTab(driver)
                .clickButton(buttonTitle)
                .checkHeader(buttonTitle);
    }

    public static Stream<String> pageGenerator() {
        return Stream.of("Курсы", "Тесты", "Карьера", "Блог", "Форум", "Вебинары");
    }

}