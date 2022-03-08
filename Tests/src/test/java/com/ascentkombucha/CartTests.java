package com.ascentkombucha;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class CartTests {

    String urlRoot = "https://ascent-website-mpnbh.ondigitalocean.app/";

    static ChromeOptions options;

    @BeforeAll
    public static void createOptions() {
        options = new ChromeOptions();
        options.addArguments("headless");
    }

    @Test
    public static void addOneItemToCart() {

    }

    @Test
    public static void leaveSiteAndReturnToCart() {

    }

    @Test
    public static void addTwoOfTheSameItemToCart() {

    }

    @Test
    public static void addMultipleItemsToCart() {

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
