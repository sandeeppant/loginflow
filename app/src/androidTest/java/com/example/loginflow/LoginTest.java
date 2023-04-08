package com.example.loginflow;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTest {
    public static void main(String[] args) {
        // Set desired capabilities for the test
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.example.loginflow");
        caps.setCapability("appActivity", "com.example.loginflow.MainActivity");

        // Initialize the driver with the desired capabilities
        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Find the elements on the login page and interact with them
        MobileElement emailInput = driver.findElementById("com.google.android.apps.authenticator2:id/email_input");
        MobileElement passwordInput = driver.findElementById("com.google.android.apps.authenticator2:id/password_input");
        MobileElement loginButton = driver.findElementById("com.google.android.apps.authenticator2:id/login_button");

        emailInput.sendKeys("testuser@gmail.com");
        passwordInput.sendKeys("testpassword");
        loginButton.click();

        // Close the driver session
        driver.quit();

    }

}
