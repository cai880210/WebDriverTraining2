package com.octopus;

import org.junit.Test;

public class ProxyTest {
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();

    @Test
    public void modifyRequests() {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Firefox");

        automatedBrowser.init();
        automatedBrowser.blockRequestTo(".*?\\.png", 201);
        automatedBrowser.blockRequestTo("https://.*?twitter\\.com/", 500);
        automatedBrowser.goTo("https://octopus.com/");
    }
}
