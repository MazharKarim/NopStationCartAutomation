package nopstation.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CategoriesMenu {
    public MobileElement electronicsButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//android.view.ViewGroup[@index='6']"));
    }
}
