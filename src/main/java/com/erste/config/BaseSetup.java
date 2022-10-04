package com.erste.config;

import com.erste.helper.Helper;
import com.erste.pageobjects.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSetup{
    private String deviceName;
    private String platformVersion;
    private String packageName;
    private String activityName;

    AppiumDriver driver;

public Helper helper;
public HomePageLocators homePageLocators;
public AddToCartPageLocators addToCartLocators;
public CheckoutpageLocators checkoutpageLocators;
public Loginpagelocators loginpagelocators;
public ShippingAddressPageLocators shippingAddressPageLocators;
public PaymentMethodPageLocators paymentMethodPageLocators;
public OrderReviewPageLocators orderReviewPageLocators;
public CheckoutCompletePageLocators checkoutCompletePageLocators;
public WebViewPageLocators webViewPageLocators;


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {


        FileInputStream fileInputStream = new FileInputStream("src/main/resources/deviceDetails.properties");

        Properties properties = new Properties();
        properties.load(fileInputStream);
        this.deviceName = properties.getProperty("devicename");
        System.out.println(this.deviceName);
        this.platformVersion = properties.getProperty("osversion");
        this.packageName = properties.getProperty("apppackage");
        this.activityName=properties.getProperty("activityname");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("deviceName", this.deviceName);
        capabilities.setCapability("udid", this.deviceName);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", this.platformVersion);
        capabilities.setCapability("adbExecTimeout", 50000);
        capabilities.setCapability("newCommandTimeout", "120000");
        capabilities.setCapability("systemPort", "8200");
        capabilities.setCapability("appPackage", this.packageName);
        capabilities.setCapability("--session-override", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("appActivity", this.activityName);
        //capabilities.setCapability("app", appPath);
        this.driver = DriverConfig.getInstance().setDriver(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        this.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);



//
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName","Android");
//        caps.setCapability("appium:deviceName","Google Pixel 6 Pro GoogleAPI Emulator");
//        caps.setCapability("appium:deviceOrientation", "portrait");
//        caps.setCapability("appium:platformVersion","12.0");
//        caps.setCapability("appium:automationName", "UiAutomator2");
//        caps.setCapability("appium:app", "storage:filename=mda-1.0.13-docs-16.apk");
//        caps.setCapability("appPackage", this.packageName);
//        caps.setCapability("appActivity", this.activityName);
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("build", "build4");
//        sauceOptions.setCapability("name", "tests");
//        caps.setCapability("sauce:options", sauceOptions);
//       // URL url = new URL("https://oauth-subhist.sauces-1d435:*****31bd@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//       // this.driver = new AndroidDriver(url, caps);
//        this.driver = DriverConfig.getInstance().setDriver(new AndroidDriver(new URL("https://oauth-subhist.sauces-1d435:cd305ca0-e230-4e69-9b1d-2c3e4a0931bd@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps));
//       // this.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        helper=new Helper(driver);
        homePageLocators=new HomePageLocators(driver);
        addToCartLocators=new AddToCartPageLocators(driver);
        checkoutpageLocators=new CheckoutpageLocators(driver);
        loginpagelocators=new Loginpagelocators(driver);
        shippingAddressPageLocators=new ShippingAddressPageLocators(driver);
        paymentMethodPageLocators=new PaymentMethodPageLocators(driver);
        orderReviewPageLocators=new OrderReviewPageLocators(driver);
        checkoutpageLocators=new CheckoutpageLocators(driver);
        checkoutCompletePageLocators=new CheckoutCompletePageLocators(driver);
        webViewPageLocators=new WebViewPageLocators(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        Helper helper=new Helper(driver);
        if (ITestResult.FAILURE == result.getStatus()) {
            helper.getScreenShot(result.getMethod().getMethodName());

        }
//        String status = result.isSuccess() ? "passed" : "failed";
//        driver.executeScript("sauce:job-result=" + status);

        driver.quit();
    }




}
