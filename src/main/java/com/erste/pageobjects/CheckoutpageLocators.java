package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutpageLocators {

     Helper helper;

    public CheckoutpageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "titleTV")
    private WebElement productTitle;

    @AndroidFindBy(id = "priceTV")
    private WebElement productPrice;

    @AndroidFindBy(id = "removeBt")
    private WebElement removeItemFromCart;

    @AndroidFindBy(id = "itemsTV")
    private WebElement totalItems;

    @AndroidFindBy(id = "noTV")
    private WebElement numberOfItemsForThatProduct;

    @AndroidFindBy(id = "totalPriceTV")
    private WebElement totalPrice;


    @AndroidFindBy(id = "productIV")
    private WebElement productImage;



    @AndroidFindBy(id = "cartBt")
    private WebElement proceedToCheckOutBtn;

    public WebElement getProductImage() {
        return productImage;
    }

    public void setProductImage(WebElement productImage) {
        this.productImage = productImage;
    }

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

    public WebElement getRemoveItemFromCart() {
        return removeItemFromCart;
    }

    public void setRemoveItemFromCart(WebElement removeItemFromCart) {
        this.removeItemFromCart = removeItemFromCart;
    }

    public WebElement getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(WebElement totalItems) {
        this.totalItems = totalItems;
    }

    public WebElement getNumberOfItemsForThatProduct() {
        return numberOfItemsForThatProduct;
    }

    public void setNumberOfItemsForThatProduct(WebElement numberOfItemsForThatProduct) {
        this.numberOfItemsForThatProduct = numberOfItemsForThatProduct;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(WebElement totalPrice) {
        this.totalPrice = totalPrice;
    }

    public WebElement getProceedToCheckOutBtn() {
        return proceedToCheckOutBtn;
    }

    public void setProceedToCheckOutBtn(WebElement proceedToCheckOutBtn) {
        this.proceedToCheckOutBtn = proceedToCheckOutBtn;
    }

    public void proceedToCheckOut(){
        helper.click(getProceedToCheckOutBtn());
    }
}
