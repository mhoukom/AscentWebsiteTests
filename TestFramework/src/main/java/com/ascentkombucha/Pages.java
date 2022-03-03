package com.ascentkombucha;

public class Pages {

    public static HomePage homePage() {
        HomePage homePage = new HomePage();

        return homePage;
    }

    public static AboutPage aboutPage() {
        AboutPage aboutPage = new AboutPage();
        return aboutPage;
    }

    public static ShopPage shopPage() {
        ShopPage shopPage = new ShopPage();
        return shopPage;
    }

    public static CartPage cartPage() {
        CartPage cartPage = new CartPage();
        return cartPage;
    }
}
