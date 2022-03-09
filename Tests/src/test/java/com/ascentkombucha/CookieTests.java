package com.ascentkombucha;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CookieTests {

//    String urlRoot = "https://ascent-website-mpnbh.ondigitalocean.app/";
    String urlRoot = "http://localhost:3000/";

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
    public void handleCartCookie() {
        addToCart(driver);
        Cookie cartCookie = driver.manage().getCookieNamed("cartId");
        Assertions.assertNotNull(cartCookie);
    }

    @Test
    public void cookiePersists() {
        addToCart(driver);
        driver.get("https://www.google.com");
        driver.get(urlRoot);
        Cookie cartCookie = driver.manage().getCookieNamed("cartId");
        Assertions.assertNotNull(cartCookie);
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
        }
    }

    private void addToCart(WebDriver driver) {
        driver.get(urlRoot + "shop");
        driver.manage().deleteAllCookies();
        WebElement button1 = driver.findElement(By.id("button-1"));
        button1.click();
        sleep(2000);
    }
}
