package com.octopus;

import com.octopus.decorators.ChromeDecorator;
import com.octopus.decorators.FirefoxDecorator;
import com.octopus.decorators.ImplicitWaitDecorator;
import com.octopus.decorators.WebDriverDecorator;

public class AutomatedBrowserFactory {

    public AutomatedBrowser getAutomatedBrowser(final String browser) {

        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser();
        }

        if ("Firefox".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser();
        }

        if ("ChromeNoImplicitWait".equalsIgnoreCase(browser)) {
            return getChromeBrowserNoImplicitWait();
        }

        if ("FirefoxNoImplicitWait".equalsIgnoreCase(browser)) {
            return getFirefoxBrowserNoImplicitWait();
        }

        throw new IllegalArgumentException("Unknown browser " + browser);

    }

    private AutomatedBrowser getChromeBrowser() {
        return new ChromeDecorator(
            new ImplicitWaitDecorator(10,
                new WebDriverDecorator()
            )
        );
    }

    private AutomatedBrowser getFirefoxBrowser() {
        return new FirefoxDecorator(
            new ImplicitWaitDecorator(10,
                new WebDriverDecorator()
            )
        );
    }

    private AutomatedBrowser getChromeBrowserNoImplicitWait() {
        return new ChromeDecorator(
                new WebDriverDecorator()
        );
    }

    private AutomatedBrowser getFirefoxBrowserNoImplicitWait() {
        return new FirefoxDecorator(
                new WebDriverDecorator()
        );
    }
}