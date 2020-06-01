package ru.geekbrains.main.site.at.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchTab extends BasePage {

    // Вкладки элементов поиска по Css для полей навигации
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='professions']")
    private WebElement professionsTag;
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='courses']")
    private WebElement coursesTag;
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='webinars']")
    private WebElement webinarsTag;
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='blogs']")
    private WebElement blogsTag;
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='forums']")
    private WebElement forumsTag;
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='tests']")
    private WebElement testsTag;
    @FindBy(css = "ul[class='search-page-tabs']>li>a[data-tab='companies']")
    private WebElement companiesTag;

    // Поиск итоговых значений элементов в разных категориях
    @FindBy(xpath = "//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'professions']/child::span")
    private WebElement professionsCount;
    @FindBy(xpath = "//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'courses']/child::span")
    private WebElement coursesCount;
    @FindBy(xpath = "//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'webinars']/child::span")
    private WebElement webinarsCount;
    @FindBy(xpath = "//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'blogs']/child::span")
    private WebElement blogsCount;
    @FindBy(xpath = "//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'forums']/child::span")
    private WebElement forumsCount;
    @FindBy(xpath = "//ul[@class = 'search-page-tabs']/li/a[@data-tab = 'tests']/child::span")
    private WebElement testsCount;

    public SearchTab(WebDriver driver) {
        super(driver);
    }



    //Вводим конструкцию свич кейса для получения текстового значения их панели итога поиска
    public Page searchTitle(String searchButtonTitle){
        switch (searchButtonTitle){
            case"Профессии":{
                professionsTag.getText();
                break;
            }
            case"Курсы":{
                coursesTag.getText();
                break;
            }
            case"Вебинары":{
                webinarsTag.getText();
                break;
            }
            case"Блоги":{
                blogsTag.getText();
                break;
            }
            case"Форумы":{
                forumsTag.getText();
                break;
            }
            case"Тесты":{
                testsTag.getText();
                break;
            }
            case"Компании":{
                companiesTag.getText();
                break;
            }
            default:{
                throw new  NotFoundException("Nothing else is found");
            }
        }
        return new Page(driver);
    }
}
