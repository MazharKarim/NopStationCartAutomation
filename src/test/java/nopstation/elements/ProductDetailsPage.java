package nopstation.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ProductDetailsPage {
    public MobileElement plusButton(AndroidDriver<io.appium.java_client.MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus"));
    }
    public MobileElement addToCartButton(AndroidDriver<io.appium.java_client.MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart"));
    }
}
