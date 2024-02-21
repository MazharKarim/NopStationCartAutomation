package nopstation.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import nopstation.elements.*;
import nopstation.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver<MobileElement> driver;
    static ExtentReports extentReports = new ExtentReports();
    static ExtentTest extentTest;
    String projectDir = System.getProperty("user.dir");

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "1A021FDF600EPB");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
        capabilities.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report/report.html");
        extentReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Nop Commerce Test");
        sparkReporter.config().setReportName("Nop Commerce Test Results");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver<>(url, capabilities);
    }

    @Test
    public void addProductsInShoppingCart() throws InterruptedException {
        extentTest = extentReports.createTest("Add to cart", "This is a test to add a product to cart");
        extentTest.log(Status.INFO, "Test started");

        Common common = new Common();
        try {
            common.acceptButton(driver).click();
        } catch (NoSuchElementException e) {
            System.out.println("Permission already given");
        }

        NavBar navBar = new NavBar();
        navBar.categoriesButton(driver).click();

        CategoriesMenu categoriesMenu = new CategoriesMenu();
        categoriesMenu.electronicsButton(driver).click();

        ElectronicsPage electronicsPage = new ElectronicsPage();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = projectDir + "\\report\\screenshot\\product.png"; // Specify the screenshot file path
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Utils utils = new Utils();
        utils.scrollDown2(driver);
        electronicsPage.findProduct(driver, "Mattress Bedroom").click();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        int quantity = 2;
        while (quantity > 1) {
            productDetailsPage.plusButton(driver).click();
            quantity--;
        }

        File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = projectDir + "\\report\\screenshot\\product2.png"; // Specify the screenshot file path
            FileUtils.copyFile(screenshot2, new File(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        productDetailsPage.addToCartButton(driver).click();

        Thread.sleep(5000);
    }

    @Test
    public void placeOrderAsGuest() throws InterruptedException {
        extentTest = extentReports.createTest("Place order", "This is a test to place order");
        extentTest.log(Status.INFO, "Test started");
        NavBar navBar = new NavBar();
        navBar.cartButton(driver).click();

        ShoppingCart shoppingCart = new ShoppingCart();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = projectDir + "\\report\\screenshot\\check.png"; // Specify the screenshot file path
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        shoppingCart.checkoutButton(driver).click();
        shoppingCart.checkoutAsGuestButton(driver).click();
        shoppingCart.fillUpBillingAddress(driver, "Mazhar", "Shanto",
                "test@emaail.com", "BS", "Dhaka", "Address line 1", "1216");

        File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = projectDir + "\\report\\screenshot\\check2.png"; // Specify the screenshot file path
            FileUtils.copyFile(screenshot2, new File(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Utils utils = new Utils();
        utils.scrollDown(driver);
        shoppingCart.continueButton(driver).click();
        shoppingCart.selectShippingMethod(driver, "Next Day Air").click();

        File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = projectDir + "\\report\\screenshot\\check3.png"; // Specify the screenshot file path
            FileUtils.copyFile(screenshot3, new File(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        utils.scrollDown(driver);
        Thread.sleep(2000);
        shoppingCart.continueButton2(driver).click();

        int i = 5;
        while (i>0) {
            utils.scrollDown(driver);
            i--;
        }

        shoppingCart.selectPaymentMethod(driver, "Check / Money Order").click();

        File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = projectDir + "\\report\\screenshot\\check4.png"; // Specify the screenshot file path
            FileUtils.copyFile(screenshot4, new File(screenshotPath));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        utils.scrollDown(driver);
        shoppingCart.continueButton(driver).click();
        shoppingCart.nextButton(driver).click();
        shoppingCart.confirmButton(driver).click();
        if(shoppingCart.confirmModal(driver).getText().contains("Your order has been successfully processed!")) {
            shoppingCart.confirmModalContinue(driver).click();
        }

        Thread.sleep(5000);
    }

    @AfterSuite
    public void tearDown() {
        extentTest.info("Test completed.");
        extentReports.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}
