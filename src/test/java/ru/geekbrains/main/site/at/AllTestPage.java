package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTestPage extends BaseTest {


    @Test
    void careerSearchTest() {
        WebElement careerNavItemButton = driver.findElement(By.cssSelector("nav>a[href='/career']"));
        careerNavItemButton.click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Карьера", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        Assertions.assertTrue(footer.isDisplayed());

    }

    @Test
    void coursesSearchPanel() {
        // Поиск кнопки "Курсы" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/courses']")).click();
        driver.findElement(By.xpath("//div/div/button[*]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Курсы", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        Assertions.assertTrue(footer.isDisplayed());
    }

    @Test
    void eventsSearchTest() {
        // Поиск кнопки "Вебинары" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/events']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Вебинары", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        Assertions.assertTrue(footer.isDisplayed());
    }

    @Test
    void forumSearchPanel() {
        // Поиск кнопки "Форум" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/topics']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Форум", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        Assertions.assertTrue(footer.isDisplayed());
    }

    @Test
    void testSearchPanel() {
        // Поиск кнопки "Тесты" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/tests']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Тесты", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        Assertions.assertTrue(footer.isDisplayed());
    }

    @Test
    void topicsSearchPanel() {
        // Поиск кнопки "Блог" в панели навигации.
        driver.findElement(By.cssSelector("nav>a[href='/posts']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Блог", header);
        WebElement footer = driver.findElement(By.cssSelector("footer.site-footer"));
        Assertions.assertTrue(footer.isDisplayed());
    }
}
