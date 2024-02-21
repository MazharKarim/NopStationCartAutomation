package nopstation.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class NavBar {
    public MobileElement categoriesButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_categories"));
    }

    public MobileElement cartButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/menu_cart"));
    }
}
