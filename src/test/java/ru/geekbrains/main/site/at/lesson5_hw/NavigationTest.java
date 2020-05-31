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



/*
    @Test
    void careerSearchTest() {
        WebElement careerNavItemButton = driver.findElement(By.cssSelector("nav>a[href='/career']"));
        careerNavItemButton.click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals("Карьера", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        assertTrue(footer.isDisplayed());

    }

    @Test
    void coursesSearchPanel() {
        // Поиск кнопки "Курсы" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/courses']")).click();
        driver.findElement(By.xpath("//div/div/button[*]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals("Курсы", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        assertTrue(footer.isDisplayed());

    }

    @Test
    void eventsSearchTest() {
        // Поиск кнопки "Вебинары" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/events']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals("Вебинары", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        assertTrue(footer.isDisplayed());
    }

    @Test
    void forumSearchPanel() {
        // Поиск кнопки "Форум" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/topics']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals("Форум", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        assertTrue(footer.isDisplayed());
    }

    @Test
    void testSearchPanel() {
        // Поиск кнопки "Тесты" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/tests']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals("Тесты", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        assertTrue(footer.isDisplayed());
    }

    @Test
    void topicsSearchPanel() {
        // Поиск кнопки "Блог" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/posts']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        assertEquals("Блог", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        assertTrue(footer.isDisplayed());
    }
    */
}
