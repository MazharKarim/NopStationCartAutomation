package nopstation.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import nopstation.utils.Utils;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    public MobileElement checkoutButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut"));
    }
    public MobileElement checkoutAsGuestButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout"));
    }
    public void fillUpBillingAddress(AndroidDriver<MobileElement> driver, String firstName,
                                     String lastName, String email, String company,
                                     String city, String address, String zip) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName")).sendKeys(firstName);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName")).sendKeys(lastName);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail")).sendKeys(email);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")).click();
        Utils utils = new Utils();
        utils.scrollDown2(driver);
        driver.findElement(By.xpath("//android.widget.TextView[@index='15']")).click();
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/stateSpinner")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@index='1']")).click();
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")).sendKeys(company);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity")).sendKeys(city);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")).sendKeys(address);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode")).sendKeys(zip);
    }
    public MobileElement continueButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue"));
    }
    public MobileElement selectShippingMethod(AndroidDriver<MobileElement> driver, String shippingMethod) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ shippingMethod +"']"));
    }
    public MobileElement selectPaymentMethod(AndroidDriver<MobileElement> driver, String paymentMethod) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ paymentMethod +"']"));
    }
    public MobileElement continueButton2(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']"));
    }
    public MobileElement nextButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("//android.widget.Button[@text='Next']"));
    }
    public MobileElement confirmButton(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/checkoutButton"));
    }
    public MobileElement confirmModal(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message"));
    }
    public MobileElement confirmModalContinue(AndroidDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_button_positive"));
    }
}
