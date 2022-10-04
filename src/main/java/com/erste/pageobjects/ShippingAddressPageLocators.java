package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPageLocators {

    Helper helper;

    public ShippingAddressPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "fullNameET")
    private WebElement fullName;


    @AndroidFindBy(id = "address1ET")
    private WebElement addressLine1;

    @AndroidFindBy(id = "address2ET")
    private WebElement addressLine2;

    @AndroidFindBy(id = "cityET")
    private WebElement city;

    @AndroidFindBy(id = "stateET")
    private WebElement state;

    @AndroidFindBy(id = "zipET")
    private WebElement zipCode;

    @AndroidFindBy(id = "countryET")
    private WebElement country;

    @AndroidFindBy(id = "paymentBtn")
    private WebElement paymentBtn;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(WebElement pageTitle) {
        this.pageTitle = pageTitle;
    }

    @AndroidFindBy(id = "enterPaymentTitleTV")
    private WebElement pageTitle;



    public WebElement getCheckoutTitle() {
        return checkoutTitle;
    }

    public void setCheckoutTitle(WebElement checkoutTitle) {
        this.checkoutTitle = checkoutTitle;
    }

    @AndroidFindBy(id = "checkoutTitleTV")
    private WebElement checkoutTitle;



    public WebElement getFullName() {
        return fullName;
    }

    public void setFullName(WebElement fullName) {
        this.fullName = fullName;
    }

    public WebElement getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(WebElement addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public WebElement getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(WebElement addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public WebElement getCity() {
        return city;
    }

    public void setCity(WebElement city) {
        this.city = city;
    }

    public WebElement getState() {
        return state;
    }

    public void setState(WebElement state) {
        this.state = state;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public void setZipCode(WebElement zipCode) {
        this.zipCode = zipCode;
    }

    public WebElement getCountry() {
        return country;
    }

    public void setCountry(WebElement country) {
        this.country = country;
    }

    public WebElement getPaymentBtn() {
        return paymentBtn;
    }

    public void setPaymentBtn(WebElement paymentBtn) {
        this.paymentBtn = paymentBtn;
    }

    public boolean waitforCheckoutToBePresent(){
        String text= helper.getText(getCheckoutTitle());
        return text.equalsIgnoreCase("Checkout");

    }

    public void fullname() throws Exception {
        helper.sendValue(getFullName(), Helper.getValue("testdata","fullname"));
    }

    public void address1() throws Exception {
        helper.sendValue(getAddressLine1(), Helper.getValue("testdata","addressline1"));
    }

    public void address2() throws Exception {
        helper.sendValue(getAddressLine2(), Helper.getValue("testdata","addressline2"));
    }

    public void city() throws Exception {
        helper.sendValue(getCity(), Helper.getValue("testdata","city"));
    }

    public void state() throws Exception {
        helper.sendValue(getState(), Helper.getValue("testdata","state"));
    }

    public void country() throws Exception {
        helper.sendValue(getCountry(), Helper.getValue("testdata","country"));
    }

    public void zipcode() throws Exception {
        helper.sendValue(getZipCode(), Helper.getValue("testdata","zipcode"));
    }

    public void paymentBtn(){
        helper.tap(getPaymentBtn());
    }



    public boolean PaymentPagetitleisPresent(){
       String title= helper.getText(getPageTitle());
       return title.equalsIgnoreCase("Checkout");
    }






}
