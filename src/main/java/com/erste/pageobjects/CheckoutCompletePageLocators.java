package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePageLocators {

    Helper helper;

    public CheckoutCompletePageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "horseIV")
    private WebElement horseImage;

    @AndroidFindBy(id = "thankYouTV")
    private WebElement thankyouMsg;

    @AndroidFindBy(id = "orderTV")
    private WebElement orderDispatchedmsg;

    @AndroidFindBy(id = "shoopingBt")
    private WebElement continueShoppingBtn;

    public WebElement getContinueShoppingBtn() {
        return continueShoppingBtn;
    }

    public void setContinueShoppingBtn(WebElement continueShoppingBtn) {
        this.continueShoppingBtn = continueShoppingBtn;
    }

    public WebElement getHorseImage() {
        return horseImage;
    }

    public void setHorseImage(WebElement horseImage) {
        this.horseImage = horseImage;
    }

    public WebElement getThankyouMsg() {
        return thankyouMsg;
    }

    public void setThankyouMsg(WebElement thankyouMsg) {
        this.thankyouMsg = thankyouMsg;
    }

    public WebElement getOrderDispatchedmsg() {
        return orderDispatchedmsg;
    }

    public void setOrderDispatchedmsg(WebElement orderDispatchedmsg) {
        this.orderDispatchedmsg = orderDispatchedmsg;
    }

    public boolean orderConfirm(){
        String thankYoumsg=helper.getText(getThankyouMsg());
        return thankYoumsg.equalsIgnoreCase("Thank you for your order");
    }


}
