package com.erste.pageobjects;

import com.erste.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {


    Helper helper;
    public HomePageLocators(AppiumDriver driver) {
        // TODO Auto-generated constructor stub
        helper=new Helper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "menuIV")
    private WebElement hamburgerIconMenu;

    public WebElement getHamburgerIconmenu() {
        return hamburgerIconMenu;
    }

    public void setHamburgerIconmenu(WebElement hamburgerIconmenu) {
        this.hamburgerIconMenu = hamburgerIconmenu;
    }

    public void tapOnmenu(){
        helper.tap(getHamburgerIconmenu());
    }
}
