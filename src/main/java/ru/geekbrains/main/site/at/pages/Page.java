package ru.geekbrains.main.site.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Page extends BasePage {

    @FindBy(className = "gb-header__title")
    private WebElement pageHeader;

    private NavigationTab navigationTab;

    public Page(WebDriver driver) {
        super(driver);
        navigationTab = new NavigationTab(driver);

    }

    public NavigationTab getNavigationTab() {
        return navigationTab;
    }

    public Page checkHeader(String expected) {
        assertEquals(expected, pageHeader.getText());
        return this;
    }

    public void findSearchForm(final String text){
        driver.findElement(By.xpath("//div/div/button[*]")).click();
        driver.findElement(By.cssSelector("li>a[class='show-search-form']")).click();
        driver.findElement(By.name("q")).sendKeys("Java" + Keys.ENTER);
    }


}
