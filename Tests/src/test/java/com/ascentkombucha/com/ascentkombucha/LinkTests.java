package com.ascentkombucha.com.ascentkombucha;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkTests {

    String urlRoot = "https://ascent-website-mpnbh.ondigitalocean.app/";
    String urlAbout = urlRoot + "about";
    String urlShop = urlRoot + "shop";
    String urlCart = urlRoot + "cart";

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
    public void homePageAboutLink() {
        driver.get(urlRoot);
        WebElement aboutLink = driver.findElement(By.id("about"));
        aboutLink.click();
        Assertions.assertEquals(urlAbout, driver.getCurrentUrl());
    }

    @Test
    public void homePageShopLink() {
        driver.get(urlRoot);
        WebElement shopLink = driver.findElement(By.id("shop"));
        shopLink.click();
        Assertions.assertEquals(urlShop, driver.getCurrentUrl());
    }

    @Test
    public void homePageCartLink() {
        driver.get(urlRoot);
        WebElement cartLink = driver.findElement(By.id("cart"));
        cartLink.click();
        Assertions.assertEquals(urlCart, driver.getCurrentUrl());
    }

    @Test
    public void aboutPageHomeLink() {
        driver.get(urlAbout);
        WebElement aboutToHomeLink = driver.findElement(By.id("home"));
        aboutToHomeLink.click();
        Assertions.assertEquals(urlRoot, driver.getCurrentUrl());
    }

    @Test
    public void aboutPageShopLink() {
        driver.get(urlAbout);
        WebElement aboutToShopLink = driver.findElement(By.id("shop"));
        aboutToShopLink.click();
        Assertions.assertEquals(urlShop, driver.getCurrentUrl());
    }

    @Test
    public void aboutPageCartLink() {
        driver.get(urlAbout);
        WebElement aboutToCartLink = driver.findElement(By.id("cart"));
        aboutToCartLink.click();
        Assertions.assertEquals(urlCart, driver.getCurrentUrl());
    }

    @Test
    public void shopPageHomeLink() {
        driver.get(urlShop);
        WebElement shopToHomeLink = driver.findElement(By.id("home"));
        shopToHomeLink.click();
        Assertions.assertEquals(urlRoot, driver.getCurrentUrl());
    }

    @Test
    public void shopPageAboutLink() {
        driver.get(urlShop);
        WebElement shopToAboutLink = driver.findElement(By.id("about"));
        shopToAboutLink.click();
        Assertions.assertEquals(urlAbout, driver.getCurrentUrl());
    }

    @Test
    public void shopPageCartLink() {
        driver.get(urlShop);
        WebElement shopToCartLink = driver.findElement(By.id("cart"));
        shopToCartLink.click();
        Assertions.assertEquals(urlCart, driver.getCurrentUrl());
    }

    @Test
    public void cartPageHomeLink() {
        driver.get(urlCart);
        WebElement cartToHomeLink = driver.findElement(By.id("home"));
        cartToHomeLink.click();
        Assertions.assertEquals(urlRoot, driver.getCurrentUrl());
    }

    @Test
    public void cartPageAboutLink() {
        driver.get(urlCart);
        WebElement cartToAboutLink = driver.findElement(By.id("about"));
        cartToAboutLink.click();
        Assertions.assertEquals(urlAbout, driver.getCurrentUrl());
    }

    @Test
    public void cartPageShopLink() {
        driver.get(urlCart);
        WebElement cartToShopLink = driver.findElement(By.id("shop"));
        cartToShopLink.click();
        Assertions.assertEquals(urlShop, driver.getCurrentUrl());
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}

