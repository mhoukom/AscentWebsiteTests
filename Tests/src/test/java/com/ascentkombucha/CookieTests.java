package com.ascentkombucha;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CookieTests {

    String urlRoot = "https://ascent-website-mpnbh.ondigitalocean.app/";

    static ChromeOptions options;

    @BeforeAll
    public static void createOptions() {
        options = new ChromeOptions();
        options.addArguments("headless");
    }

    @Test
    public void handleCartCookie() {
        WebDriver driver = new ChromeDriver(options);
        addToCart(driver);
        Cookie cartCookie = driver.manage().getCookieNamed("cartId");
        Assertions.assertNotNull(cartCookie);
        driver.close();
    }

    @Test
    public void cookiePersists() {
        WebDriver driver = new ChromeDriver(options);
        addToCart(driver);
        driver.get("https://www.google.com");
        driver.get(urlRoot);
        Cookie cartCookie = driver.manage().getCookieNamed("cartId");
        Assertions.assertNotNull(cartCookie);
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
