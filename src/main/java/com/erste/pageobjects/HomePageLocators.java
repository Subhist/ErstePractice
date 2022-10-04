package com.erste.pageobjects;

import com.erste.config.DriverConfig;
import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePageLocators {


    Helper helper;
    private String productName;
    private String priceValue;

    public HomePageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @AndroidFindBy(id = "menuIV")
    private WebElement hamburgerIconMenu;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup")
    private List<WebElement> productsList;

    @AndroidFindBy(id = "priceTV")
    private List<WebElement> price;

    @AndroidFindBy(id = "sortIV")
    private WebElement sortItemsMenu;



    @AndroidFindBy(id = "titleTV")
    private List<WebElement> productTitle;

    @AndroidFindBy(id = "productIV")
    private List<WebElement> productImage;

    @AndroidFindBy(id = "twitterIV")
    private WebElement twitterIcon;

    @AndroidFindBy(id = "FacebookIV")
    private WebElement facebookIcon;

    @AndroidFindBy(id = "//android.widget.LinearLayout/android.widget.TextView")
    private WebElement copyWriteText;

    @AndroidFindBy(id = "LinkedInIV")
    private WebElement linkedinIcon;

    @AndroidFindBy(id = "productTV")
    private WebElement productsHeader;

    @AndroidFindBy(id = "itemTV")
    private List<WebElement> menuItems;

    @AndroidFindBy(id = "priceAscCL")
    private WebElement priceAscendingOrder;


    @AndroidFindBy(id = "tickPriceAscIV")
    private WebElement tickPriceAscOrder;

    public WebElement getTickPriceAscOrder() {
        return tickPriceAscOrder;
    }

    public void setTickPriceAscOrder(WebElement tickPriceAscOrder) {
        this.tickPriceAscOrder = tickPriceAscOrder;
    }

    public WebElement getPriceAscendingOrder() {
        return priceAscendingOrder;
    }

    public void setPriceAscendingOrder(WebElement priceAscendingOrder) {
        this.priceAscendingOrder = priceAscendingOrder;
    }

    public WebElement getSortItemsMenu() {
        return sortItemsMenu;
    }

    public void setSortItemsMenu(WebElement sortItemsMenu) {
        this.sortItemsMenu = sortItemsMenu;
    }

    public List<WebElement> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<WebElement> menuItems) {
        this.menuItems = menuItems;
    }

    public List<WebElement> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<WebElement> productImage) {
        this.productImage = productImage;
    }

    public WebElement getHamburgerIconMenu() {
        return hamburgerIconMenu;
    }

    public void setHamburgerIconMenu(WebElement hamburgerIconMenu) {
        this.hamburgerIconMenu = hamburgerIconMenu;
    }

    public List<WebElement> getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(List<WebElement> productTitle) {
        this.productTitle = productTitle;
    }

    public WebElement getProductsHeader() {
        return productsHeader;
    }

    public void setProductsHeader(WebElement productsHeader) {
        this.productsHeader = productsHeader;
    }

    public WebElement getCopyWriteText() {
        return copyWriteText;
    }

    public void setCopyWriteText(WebElement copyWriteText) {
        this.copyWriteText = copyWriteText;
    }










    public WebElement getLinkedinIcon() {
        return linkedinIcon;
    }

    public void setLinkedinIcon(WebElement linkedinIcon) {
        this.linkedinIcon = linkedinIcon;
    }




    public WebElement getFacebookIcon() {
        return facebookIcon;
    }

    public void setFacebookIcon(WebElement facebookIcon) {
        this.facebookIcon = facebookIcon;
    }




    public WebElement getTwitterIcon() {
        return twitterIcon;
    }

    public void setTwitterIcon(WebElement twitterIcon) {
        this.twitterIcon = twitterIcon;
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<WebElement> productsList) {
        this.productsList = productsList;
    }

    public WebElement getHamburgerIconmenu() {
        return hamburgerIconMenu;
    }

    public void setHamburgerIconmenu(WebElement hamburgerIconmenu) {
        this.hamburgerIconMenu = hamburgerIconmenu;
    }

    public void tapOnmenu(){
        helper.tap(getHamburgerIconmenu());
    }

    public List<WebElement> getPrice() {
        return price;
    }

    public void setPrice(List<WebElement> price) {
        this.price = price;
    }

    public void selectRandomProduct( ) throws InterruptedException {
        int min=0;
        helper.waitForElementToBeVisible(getProductsList().get(0));
        int max=getProductsList().size()-1;
        Random random = new Random();
        int randVal= random.nextInt(max - min) + min;
        productName=getProductTitle().get(0).getText();
        helper.tap(getProductsList().get(0));
         priceValue=helper.getText(getPrice().get(0));
    }


    public String getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(String priceValue) {
        this.priceValue = priceValue;
    }

    public void goToSocialLinks(){

        DriverConfig.getInstance().getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"© 2021 Sauce Labs All Rights Reserved. Terms of Service | Privacy Policy\").instance(0))");


    }

    public boolean verifyTwitterIconPresent(){
        return getTwitterIcon().isDisplayed();
    }

    public boolean verifyFacebookIconPresent(){
        return getFacebookIcon().isDisplayed();
    }


    public boolean verifyLinkedInIconPresent(){
        return getLinkedinIcon().isDisplayed();
    }

    public void goToMenuItem(String vals){

        for (int items=0;items<getMenuItems().size();items++){
            if(getMenuItems().get(items).getText().equalsIgnoreCase(vals)){
                helper.click(getMenuItems().get(items));
            }
        }
    }

    public boolean sortTheItemsByPrice(){
        double initialPrice=helper.getThePrice((getPrice().get(0).getText()));
        helper.tap(getSortItemsMenu());
        helper.click(getPriceAscendingOrder());
        double afterSortPrice=helper.getThePrice((getPrice().get(0).getText()));
        if(initialPrice<=afterSortPrice){
            return true;
        }


        return false;
    }

    public boolean verifyAssendingByPriceIsSelected(){
        helper.tap(getSortItemsMenu());
        return getTickPriceAscOrder().isDisplayed();
    }




}
