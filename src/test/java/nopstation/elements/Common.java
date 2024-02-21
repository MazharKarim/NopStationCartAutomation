package nopstation.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Common {
    public MobileElement acceptButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept"));
    }
}
