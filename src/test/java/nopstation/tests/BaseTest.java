package nopstation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "1A021FDF600EPB");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
        capabilities.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("autoGrantPermissions", true);

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver<>(url, capabilities);
    }

    @Test
    public void addProductsInShoppingCart() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
