package com.example.loginflow;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    private AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.example.loginflow");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("autoGrantPermissions", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidCredentials() {
        driver.findElement(MobileBy.id("com.example.loginflow:id/login")).sendKeys("validemail@example.com");
        driver.findElement(MobileBy.id("com.example.loginflow:id/password")).sendKeys("validpassword");
        driver.findElement(MobileBy.id("com.example.loginflow:id/buttonLogin")).click();
        assert(driver.findElement(MobileBy.id("com.example.loginflow:id/tv_welcome")).isDisplayed());
    }

    @Test
    public void testInvalidCredentials() {

        driver.findElement(MobileBy.id("com.example.loginflow:id/login")).sendKeys("invalidemail@example.com");
        driver.findElement(MobileBy.id("com.example.loginflow:id/password")).sendKeys("invalidpassword");
        driver.findElement(MobileBy.id("com.example.loginflow:id/buttonLogin")).click();
        assert(driver.findElement(MobileBy.id("com.example.loginflow:id/tv_error_message")).isDisplayed());
    }

    @Test
    public void testEmptyFields() {
        driver.findElement(MobileBy.id("com.example.loginflow:id/buttonLogin")).click();
    }
}

