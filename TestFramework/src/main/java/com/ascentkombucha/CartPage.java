package com.ascentkombucha;

public class CartPage {

    static String url = "https://ascent-website-mpnbh.ondigitalocean.app/cart";

    public void goTo() {
        Browser.goTo(url);
    }

    public boolean isTitle(String title) {
        return Browser.title().equals(title);
    }
}
