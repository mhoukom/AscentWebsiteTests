package com.ascentkombucha;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ContentTests {

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
    public void homePageContent() {
        driver.get(urlRoot);
        WebElement carousel = driver.findElement(By.id("carousel"));
        Assertions.assertTrue(carousel.isDisplayed());

        WebElement slogan = driver.findElement(By.id("slogan"));
        Assertions.assertEquals(slogan.getText(), "pure mountain culture");
    }

    @Test
    public void aboutPageContent() {
        driver.get(urlRoot + "about");
        WebElement missionTitle = driver.findElement(By.id("mission-title"));
        Assertions.assertEquals(missionTitle.getText(), "Our Mission");

        WebElement email = driver.findElement(By.id("email"));
        Assertions.assertEquals(email.getText(), "info@ascentkombucha.com");
    }

    @Test
    public void shopPageContent() {
        driver.get(urlRoot + "shop");
        WebElement product1 = driver.findElement(By.id("product-1"));
        Assertions.assertTrue(product1.isDisplayed());

        WebElement product2 = driver.findElement(By.id("product-2"));
        Assertions.assertTrue(product2.isDisplayed());

        WebElement product3 = driver.findElement(By.id("product-3"));
        Assertions.assertTrue(product3.isDisplayed());

        WebElement product4 = driver.findElement(By.id("product-4"));
        Assertions.assertTrue(product4.isDisplayed());

        WebElement product5 = driver.findElement(By.id("product-5"));
        Assertions.assertTrue(product5.isDisplayed());
    }

    @Test
    public void cartPageContent() {
        driver.get(urlRoot + "cart");
        WebElement cartTitle = driver.findElement(By.id("cart-title"));
        Assertions.assertEquals(cartTitle.getText(), "Added to Your Cart");

        WebElement checkoutButton= driver.findElement(By.id("checkout-button"));
        Assertions.assertEquals(checkoutButton.getText(), "checkout");
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}
