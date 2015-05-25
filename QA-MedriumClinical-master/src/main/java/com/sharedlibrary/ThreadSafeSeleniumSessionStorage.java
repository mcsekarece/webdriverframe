package com.sharedlibrary;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

/**
 * Utility class making it easy to write tests based on Selenium driver in a multi-thread context.
 
 */

public class ThreadSafeSeleniumSessionStorage {

    private final static Log LOGGER = LogFactory.getLog(ThreadSafeSeleniumSessionStorage.class);

    /**
     * Thread local Selenium driver instance so that we can run in multi-threaded mode.
     */
    private static final ThreadLocal<Selenium> threadLocalSelenium = new ThreadLocal<Selenium>();


    public static void startSeleniumSession(String seleniumHost, int seleniumPort, String browser, String webSite) {
        LOGGER.info("Contacting Selenium RC at " + seleniumHost + ":" + seleniumPort);
        threadLocalSelenium.set(new DefaultSelenium(seleniumHost, seleniumPort, browser, webSite));
        session().start("--disable-web-security");
        LOGGER.info("Got Selenese session:" + session());
    }
    
    
    public static void startSeleniumSessionWebDriver(String seleniumHost, int seleniumPort, String browser, String webSite, WebDriver driver) {
        LOGGER.info("Contacting Selenium RC at " + seleniumHost + ":" + seleniumPort);
        threadLocalSelenium.set(new WebDriverBackedSelenium(driver, webSite));
        LOGGER.info("Got Selenese session:" + session());
    }

    public static void closeSeleniumSession() {
        LOGGER.info("Closing Selenese session: " + session());
        if (null != session()) {
            session().stop();
            resetSession();
        }
    }

    public static Selenium session() {
        return threadLocalSelenium.get();
    }


    public static void resetSession() {
        threadLocalSelenium.set(null);
    }

}