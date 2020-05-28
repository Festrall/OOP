package ru.geekbrains.main.site.at.lesson4_hw;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public abstract class BaseTest {
    protected WebDriver driver;
    protected final String BASE_URL = "https://geekbrains.ru";
    protected String header;


    @BeforeEach
    void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL + "/career");
        // Открывал окно только на половину - не было видно навигационного меню. Поиск не осуществлялся корректно.
        driver.manage().window().maximize();
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}



