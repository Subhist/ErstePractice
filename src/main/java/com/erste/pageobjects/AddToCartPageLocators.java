package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCartPageLocators {

    Helper helper;

    public AddToCartPageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "priceTV")
    private WebElement priceOfTheProduct;

    @AndroidFindBy(id = "plusIV")
    private WebElement plusButton;

    @AndroidFindBy(id = "minusIV")
    private WebElement minusButton;

    @AndroidFindBy(id = "cartBt")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "start5IV")
    private WebElement fiveStarRating;

    @AndroidFindBy(id = "noTV")
    private WebElement countOfProductAddedToCart;

    @AndroidFindBy(id = "sortTV")
    private WebElement reviewConfirmPopUp;


    public WebElement getReviewConfirmPopUp() {
        return reviewConfirmPopUp;
    }

    public void setReviewConfirmPopUp(WebElement reviewConfirmPopUp) {
        this.reviewConfirmPopUp = reviewConfirmPopUp;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public void setContinueBtn(WebElement continueBtn) {
        this.continueBtn = continueBtn;
    }

    @AndroidFindBy(id = "closeBt")
    private WebElement continueBtn;






    @AndroidFindBy(id = "descTV")
    private WebElement indivisualProductDesc;

    @AndroidFindBy(id = "productHeightLightsTV")
    private WebElement productHighlightText;

    @AndroidFindBy(id = "cartCircleRL")
    private WebElement itemInCartBadge;

    @AndroidFindBy(id = "productIV")
    private WebElement productImage;

    public WebElement getProductImage() {
        return productImage;
    }

    public void setProductImage(WebElement productImage) {
        this.productImage = productImage;
    }

    public WebElement getItemInCartBadge() {
        return itemInCartBadge;
    }

    public void setItemInCartBadge(WebElement itemInCartBadge) {
        this.itemInCartBadge = itemInCartBadge;
    }

    public WebElement getProductHighlightText() {
        return productHighlightText;
    }

    public void setProductHighlightText(WebElement productHighlightText) {
        this.productHighlightText = productHighlightText;
    }

    public WebElement getIndivisualProductDesc() {
        return indivisualProductDesc;
    }

    public void setIndivisualProductDesc(WebElement indivisualProductDesc) {
        this.indivisualProductDesc = indivisualProductDesc;
    }

    public WebElement getCountOfProductAddedToCart() {
        return countOfProductAddedToCart;
    }

    public void setCountOfProductAddedToCart(WebElement countOfProductAddedToCart) {
        this.countOfProductAddedToCart = countOfProductAddedToCart;
    }

    public WebElement getPriceOfTheProduct() {
        return priceOfTheProduct;
    }

    public void setPriceOfTheProduct(WebElement priceOfTheProduct) {
        this.priceOfTheProduct = priceOfTheProduct;
    }

    public WebElement getPlusButton() {
        return plusButton;
    }

    public void setPlusButton(WebElement plusButton) {
        this.plusButton = plusButton;
    }

    public WebElement getMinusButton() {
        return minusButton;
    }

    public void setMinusButton(WebElement minusButton) {
        this.minusButton = minusButton;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void setAddToCartButton(WebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    public WebElement getFiveStarRating() {
        return fiveStarRating;
    }

    public void setFiveStarRating(WebElement fiveStarRating) {
        this.fiveStarRating = fiveStarRating;
    }

    public void addToCart(){
        helper.click(getAddToCartButton());
    }

    public void goToCheckoutPage(){
        helper.click(getItemInCartBadge());
    }

    public void ratingAproduct(){
        helper.click(getFiveStarRating());
    }

    public String ratingConfirmation(){
        return helper.getText(getReviewConfirmPopUp());
    }

    public void continueBtn(){
        helper.tap(getContinueBtn());
    }
}
