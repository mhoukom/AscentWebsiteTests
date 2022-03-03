package com.ascentkombucha;

public class ShopPage {

    static String url = "https://ascent-website-mpnbh.ondigitalocean.app/shop";

    public void goTo() {
        Browser.goTo(url);
    }

    public boolean isTitle(String title) {
        return Browser.title().equals(title);
    }
}
