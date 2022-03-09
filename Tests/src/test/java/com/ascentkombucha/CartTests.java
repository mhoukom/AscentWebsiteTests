package com.ascentkombucha;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CartTests {

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
    public void addOneItemToCart() {
        addToCart(driver);
        driver.get(urlRoot + "cart");
        sleep(2000);
        WebElement productTitle = driver.findElement(By.id("0-product-title"));
        Assertions.assertTrue(productTitle.isDisplayed());
    }

    @Test
    public void leaveSiteAndReturnToCart() {
        addToCart(driver);
        driver.get("https://www.google.com");
        driver.get(urlRoot + "cart");
        sleep(2000);
        WebElement productTitle = driver.findElement(By.id("0-product-title"));
        Assertions.assertTrue(productTitle.isDisplayed());
    }

    @Test
    public void addTwoOfTheSameItemToCart() {
        addToCart(driver);
        WebElement button1 = driver.findElement(By.id("button-1"));
        button1.click();
        sleep(2000);
        driver.get(urlRoot + "cart");
        sleep(2000);
        WebElement quantity = driver.findElement(By.id("0-quantity"));
        Assertions.assertEquals(quantity.getText(), "2");
    }

    @Test
    public void addMultipleItemsToCart() {
        addToCart(driver);
        WebElement button2 = driver.findElement(By.id("button-2"));
        button2.click();
        sleep(2000);
        WebElement button3 = driver.findElement(By.id("button-3"));
        button3.click();
        sleep(2000);
        WebElement button4 = driver.findElement(By.id("button-4"));
        button4.click();
        sleep(2000);
        WebElement button5 = driver.findElement(By.id("button-5"));
        button5.click();
        sleep(2000);
        driver.get(urlRoot + "cart");
        sleep(2000);
        WebElement productTitle = driver.findElement(By.id("0-product-title"));
        Assertions.assertTrue(productTitle.isDisplayed());
        WebElement productTitle2 = driver.findElement(By.id("1-product-title"));
        Assertions.assertTrue(productTitle2.isDisplayed());
        WebElement productTitle3 = driver.findElement(By.id("2-product-title"));
        Assertions.assertTrue(productTitle3.isDisplayed());
        WebElement productTitle4 = driver.findElement(By.id("3-product-title"));
        Assertions.assertTrue(productTitle4.isDisplayed());
        WebElement productTitle5 = driver.findElement(By.id("4-product-title"));
        Assertions.assertTrue(productTitle5.isDisplayed());
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
