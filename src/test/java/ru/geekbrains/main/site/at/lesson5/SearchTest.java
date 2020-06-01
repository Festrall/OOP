package ru.geekbrains.main.site.at.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.lesson5.base.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest extends BaseTest {
    String professionCount;

    @Test
    void searchPanelTest() {
        driver.findElement(By.cssSelector("nav>a[href='/courses']")).click();
        driver.findElement(By.xpath("//div/div/button[*]")).click();
        driver.findElement(By.cssSelector("li>a[class='show-search-form']")).click();
        driver.findElement(By.name("q")).sendKeys("Java" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[class=search-page-tabs]")));

        WebElement professionTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='professions']"));
        Assertions.assertTrue(professionTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'professions']/child::span"))
                .getText();
        // Assertions.assertTrue(Integer.parseInt(professionCount) >= 2);
        assertThat(Integer.parseInt(professionCount), greaterThanOrEqualTo(2));


        WebElement coursesTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='courses']"));
        Assertions.assertTrue(coursesTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'courses']/child::span"))
                .getText();
        //Assertions.assertTrue(Integer.parseInt(professionCount) > 15);
        assertThat(Integer.parseInt(professionCount), greaterThan(15));


        WebElement webinarsTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='webinars']"));
        Assertions.assertTrue(webinarsTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'webinars']/child::span"))
                .getText();
        //Assertions.assertTrue(Integer.parseInt(professionCount) > 180 && Integer.parseInt(professionCount) < 300);
        assertThat(Integer.parseInt(professionCount), allOf(
                greaterThan(180),
                lessThan(300)
        ));

        WebElement blogsTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='blogs']"));
        Assertions.assertTrue(blogsTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'blogs']/child::span"))
                .getText();
        //Assertions.assertTrue(Integer.parseInt(professionCount) > 300);
        assertThat(Integer.parseInt(professionCount), greaterThan(300));

        WebElement forumsTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='forums']"));
        Assertions.assertTrue(forumsTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'forums']/child::span"))
                .getText();
        //Assertions.assertTrue(Integer.parseInt(professionCount) != 350);
        assertThat(Integer.parseInt(professionCount), not(equalTo(350)));

        WebElement testsTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='tests']"));
        Assertions.assertTrue(testsTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'tests']/child::span"))
                .getText();
        //Assertions.assertTrue(Integer.parseInt(professionCount) != 0);
        assertThat(Integer.parseInt(professionCount), not(equalTo(0)));

        WebElement companiesTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='companies']"));
        Assertions.assertTrue(companiesTab.isDisplayed());
    }
}