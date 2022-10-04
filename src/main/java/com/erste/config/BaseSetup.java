package com.erste.config;

import com.erste.helper.Helper;
import com.erste.pageobjects.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

        driver.quit();
    }




}
