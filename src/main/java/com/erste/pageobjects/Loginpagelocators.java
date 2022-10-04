package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Loginpagelocators {

    Helper helper;

    public Loginpagelocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "nameET")
    private WebElement userName;

    @AndroidFindBy(id = "passwordET")
    private WebElement password;


    @AndroidFindBy(id = "loginBtn")
    private WebElement loginBtn;

    public WebElement getItemsinCart() {
        return itemsinCart;
    }

    public void setItemsinCart(WebElement itemsinCart) {
        this.itemsinCart = itemsinCart;
    }

    @AndroidFindBy(id = "cartCircleRL")
    private WebElement itemsinCart;




    public WebElement getUserName() {
        return userName;
    }

    public void setUserName(WebElement userName) {
        this.userName = userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(WebElement loginBtn) {
        this.loginBtn = loginBtn;
    }

    public void signInWithValidCreds() throws Exception {
       String username= Helper.getValue("testdata","username");
        String password= Helper.getValue("testdata","password");
       helper.sendValue(getUserName(),username);
       helper.sendValue(getPassword(), password);
       helper.tap(getLoginBtn());
    }
}
