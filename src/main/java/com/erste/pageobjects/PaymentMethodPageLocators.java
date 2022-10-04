package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPageLocators {

    Helper helper;

    public PaymentMethodPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "nameET")
    private WebElement name;


    @AndroidFindBy(id = "cardNumberET")
    private WebElement cardNumber;

    @AndroidFindBy(id = "expirationDateET")
    private WebElement expDate;

    @AndroidFindBy(id = "securityCodeET")
    private WebElement cvv;

    @AndroidFindBy(id = "billingAddressCB")
    private WebElement billingAddress;

    @AndroidFindBy(id = "paymentBtn")
    private WebElement reviewOrderBtn;

    @AndroidFindBy(id = "cartCircleRL")
    private WebElement itemsinCart;

    public WebElement getName() {
        return name;
    }

    public void setName(WebElement name) {
        this.name = name;
    }

    public WebElement getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(WebElement cardNumber) {
        this.cardNumber = cardNumber;
    }

    public WebElement getExpDate() {
        return expDate;
    }

    public void setExpDate(WebElement expDate) {
        this.expDate = expDate;
    }

    public WebElement getCvv() {
        return cvv;
    }

    public void setCvv(WebElement cvv) {
        this.cvv = cvv;
    }

    public WebElement getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(WebElement billingAddress) {
        this.billingAddress = billingAddress;
    }

    public WebElement getReviewOrderBtn() {
        return reviewOrderBtn;
    }

    public void setReviewOrderBtn(WebElement reviewOrderBtn) {
        this.reviewOrderBtn = reviewOrderBtn;
    }

    public WebElement getItemsinCart() {
        return itemsinCart;
    }

    public void setItemsinCart(WebElement itemsinCart) {
        this.itemsinCart = itemsinCart;
    }

    public void fullname() throws Exception {
        helper.sendValue(getName(), Helper.getValue("testdata","fullname"));
    }

    public void cardNumber() throws Exception {
        helper.sendValue(getCardNumber(), Helper.getValue("testdata","cardnumber"));
    }

    public void exp() throws Exception {
        helper.sendValue(getExpDate(), Helper.getValue("testdata","exp"));
    }



    public void cvv() throws Exception {
        helper.sendValue(getCvv(), Helper.getValue("testdata","cvv"));
    }



    public void reviewOrder(){
        helper.tap(getReviewOrderBtn());
    }
}
