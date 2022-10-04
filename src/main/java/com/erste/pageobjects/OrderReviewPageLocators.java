package com.erste.pageobjects;

import com.erste.config.DriverConfig;
import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderReviewPageLocators {

    Helper helper;
     double deliveryAmount;
     double productPricdeValue;
     double totalPricdeValue;

    public OrderReviewPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "titleTV")
    private WebElement productTitle;

    @AndroidFindBy(id = "priceTV")
    private WebElement productPrice;

    @AndroidFindBy(id = "itemNumberTV")
    private WebElement totalNumberOfItems;

    @AndroidFindBy(id = "cardNumberTV")
    private WebElement cardNumber;


    @AndroidFindBy(id = "expirationDateTV")
    private WebElement expDate;

    @AndroidFindBy(id = "billingAddressTV")
    private WebElement billingAddress;

    @AndroidFindBy(id = "dhlTV")
    private WebElement deliveryType;

    @AndroidFindBy(id = "amountTV")
    private WebElement deliveryPrice;

    @AndroidFindBy(id = "totalAmountTV")
    private WebElement totalPrice;


    public WebElement getProductImage() {
        return productImage;
    }

    public void setProductImage(WebElement productImage) {
        this.productImage = productImage;
    }

    @AndroidFindBy(id = "productIV")
    private WebElement productImage;

    @AndroidFindBy(id = "paymentBtn")
    private WebElement placeOrderbtn;



    public WebElement getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(WebElement productTitle) {
        this.productTitle = productTitle;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(WebElement productPrice) {
        this.productPrice = productPrice;
    }

    public WebElement getTotalNumberOfItems() {
        return totalNumberOfItems;
    }

    public void setTotalNumberOfItems(WebElement totalNumberOfItems) {
        this.totalNumberOfItems = totalNumberOfItems;
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

    public WebElement getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(WebElement billingAddress) {
        this.billingAddress = billingAddress;
    }

    public WebElement getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(WebElement deliveryType) {
        this.deliveryType = deliveryType;
    }

    public WebElement getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(WebElement deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(WebElement totalPrice) {
        this.totalPrice = totalPrice;
    }

    public WebElement getPlaceOrderbtn() {
        return placeOrderbtn;
    }

    public void setPlaceOrderbtn(WebElement placeOrderbtn) {
        this.placeOrderbtn = placeOrderbtn;
    }


    public String getProductName(){
       String productName= helper.getText(getProductTitle());
        return productName;
    }

    public String getProductpriceValue(){
        String productprice= helper.getText(getProductPrice());
        return productprice;
    }

    public void placeOrder(){
        helper.tap(getPlaceOrderbtn());
    }

    public double getDeliveryPriceValue(){
        DriverConfig.getInstance().getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"DHL Standard Delivery\").instance(0))").click();

       String price= helper.getText(getDeliveryPrice());
        deliveryAmount=helper.getThePrice(price);
        return deliveryAmount;
    }

    public double getProductPriceValue(){
        String price= helper.getText(getProductPrice());
        productPricdeValue=helper.getThePrice(price);
        return productPricdeValue;
    }

    public double getTotalPriceValue(){
        String price= helper.getText(getTotalPrice());
        totalPricdeValue=helper.getThePrice(price);
        return totalPricdeValue;

    }

    public double grandTotal(){
//        System.out.println(totalPricdeValue);
//        System.out.println(productPricdeValue);
//        System.out.println(deliveryAmount);
//        totalPricdeValue=productPricdeValue+deliveryAmount;
        double grandTotal = getProductPriceValue()+getDeliveryPriceValue();
        return grandTotal;
    }















}
