package com.erste.pageobjects;

import com.erste.config.DriverConfig;
import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class WebViewPageLocators {

    Helper helper;

    public WebViewPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "urlET")
    private WebElement enterurl;

    @AndroidFindBy(id = "webViewTV")
    private WebElement webViewTextPreset;


    @AndroidFindBy(id = "goBtn")
    private WebElement goToWebsite;



    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement webViewTextBox;








    public WebElement getEnterurl() {
        return enterurl;
    }

    public void setEnterurl(WebElement enterurl) {
        this.enterurl = enterurl;
    }

    public WebElement getGoToWebsite() {
        return goToWebsite;
    }

    public void setGoToWebsite(WebElement goToWebsite) {
        this.goToWebsite = goToWebsite;
    }



    public WebElement getWebViewTextPreset() {
        return webViewTextPreset;
    }

    public void setWebViewTextPreset(WebElement webViewTextPreset) {
        this.webViewTextPreset = webViewTextPreset;
    }


    public WebElement getWebViewTextBox() {
        return webViewTextBox;
    }

    public void setWebViewTextBox(WebElement webViewTextBox) {
        this.webViewTextBox = webViewTextBox;
    }

    public void enterUrl() throws Exception{
        helper.sendValue(getEnterurl(), Helper.getValue("testData","url") );
    }


    public void goToWebSite(){
        helper.tap(getGoToWebsite());
    }


    public boolean verifyWebViewPresent(){
       return getWebViewTextPreset().isDisplayed();
    }

    public void enterTextInWebSite() throws Exception{

        Set views=DriverConfig.getInstance().getDriver().getContextHandles();
        for (Object values:views){
            System.out.println(values.toString());
        }
        helper.sendValue(getWebViewTextBox(), Helper.getValue("testData","webviewtext"));

    }




}
