package com.ascentkombucha;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrlTest {

    String ascentKombuchaTitle = "Ascent Kombucha";

    @Test
    public void canGoToHomePage() {
        Pages.homePage().goTo();
        Assertions.assertTrue(Pages.homePage().isTitle(ascentKombuchaTitle));
    }

    @Test
    public void canGoToAboutPage() {
        Pages.aboutPage().goTo();
        Assertions.assertTrue(Pages.aboutPage().isTitle(ascentKombuchaTitle));
    }

    @Test
    public void canGoToShopPage() {
        Pages.shopPage().goTo();
        Assertions.assertTrue(Pages.shopPage().isTitle(ascentKombuchaTitle));
    }

    @Test
    public void canGoToCartPage() {
        Pages.cartPage().goTo();
        Assertions.assertTrue(Pages.cartPage().isTitle(ascentKombuchaTitle));
    }

    @AfterAll
    public static void cleanUp() {
        Browser.close();
    }
}
