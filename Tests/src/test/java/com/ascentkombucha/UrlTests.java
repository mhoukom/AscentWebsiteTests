package com.ascentkombucha;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UrlTests {

    String ascentKombuchaTitle = "Ascent Kombucha";
    String urlRoot = "https://ascent-website-mpnbh.ondigitalocean.app/";

    WebDriver driver;
    static ChromeOptions options;

    @BeforeAll
    public static void createOptions() {
        options = new ChromeOptions();
        options.addArguments("headless");
    }

    @BeforeEach
    public void newDriver() {
        driver = new ChromeDriver(options);
    }

    @Test
    public void goToHomePage() {
        driver.get(urlRoot);
        Assertions.assertEquals(driver.getTitle(), ascentKombuchaTitle);
    }

    @Test
    public void goToAboutPage() {
        driver.get(urlRoot + "about");
        Assertions.assertEquals(driver.getTitle(), ascentKombuchaTitle);
    }

    @Test
    public void goToShopPage() {
        driver.get(urlRoot + "shop");
        Assertions.assertEquals(driver.getTitle(), ascentKombuchaTitle);
    }

    @Test
    public void goToCartPage() {
        driver.get(urlRoot + "cart");
        Assertions.assertEquals(driver.getTitle(), ascentKombuchaTitle);
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}
