package ru.geekbrains.main.site.at.lesson5_hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.lesson5_hw.base.BaseTest;
import ru.geekbrains.main.site.at.pages.NavigationTab;
import ru.geekbrains.main.site.at.pages.Page;
import ru.geekbrains.main.site.at.pages.SearchTab;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest extends BaseTest {

    //String professionCount;

    @BeforeEach
    public void openSite() {
        driver.get(BASE_URL + "/courses");
    }


    @Test
    void searchPanelTest() {

        driver.findElement(By.cssSelector("li>a[class='show-search-form']")).click();
        driver.findElement(By.name("q")).sendKeys("Java" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[class=search-page-tabs]")));

    }

    @Test
    public void searchPanelForm() {
        new Page(driver)
                .findSearchForm("Java");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[class=search-page-tabs]")));
    }

/*
        WebElement professionTab = driver
                .findElement(By.cssSelector("ul[class='search-page-tabs']>li>a[data-tab='professions']"));
        Assertions.assertTrue(professionTab.isDisplayed());
        professionCount = driver
                .findElement(By.xpath("//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'professions']/child::span"))
                .getText();
        // Assertions.assertTrue(Integer.parseInt(professionCount) >= 2);
        assertThat(Integer.parseInt(professionCount), greaterThanOrEqualTo(2));

    */
}
