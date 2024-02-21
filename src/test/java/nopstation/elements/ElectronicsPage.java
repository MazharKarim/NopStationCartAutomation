package nopstation.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ElectronicsPage {
    public MobileElement findProduct(AndroidDriver<MobileElement> driver, String productName) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ productName +"']"));
    }
}
