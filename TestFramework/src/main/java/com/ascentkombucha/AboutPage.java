package com.ascentkombucha;

public class AboutPage {

    static String url = "https://ascent-website-mpnbh.ondigitalocean.app/about";

    public void goTo() {
        Browser.goTo(url);
    }

    public boolean isTitle(String title) {
        return Browser.title().equals(title);
    }
}
