package com.erste.testcases;

import com.erste.config.BaseSetup;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases extends BaseSetup {

    Logger log=Logger.getLogger(TestCases.class);
    SoftAssert softAssert=new SoftAssert();


    @Test(priority = 1)
    public void rateAProduct() throws Exception{

        homePageLocators.selectRandomProduct();
        log.info("Random product selected");
        softAssert.assertTrue(addToCartLocators.getProductImage().isDisplayed());
        addToCartLocators.ratingAproduct();
        log.info("Product is rated");
        softAssert.assertTrue(addToCartLocators.ratingConfirmation().equalsIgnoreCase("Thank you for submitting your review!"));
        addToCartLocators.continueBtn();
        log.info("Continue button is pressed so the pop-up is closed");
        softAssert.assertAll();

    }


    @Test(priority = 2)
    public void placeOrder() throws Exception {

        homePageLocators.selectRandomProduct();
        softAssert.assertTrue(addToCartLocators.getProductImage().isDisplayed());
        addToCartLocators.addToCart();
        log.info("Product is added to cart");
        softAssert.assertTrue(addToCartLocators.getItemInCartBadge().isDisplayed());
        addToCartLocators.goToCheckoutPage();
        log.info("The user is in checkout page");
        softAssert.assertTrue(checkoutpageLocators.getProductImage().isDisplayed());
        checkoutpageLocators.proceedToCheckOut();
        loginpagelocators.signInWithValidCreds();
        log.info("User is signing completed");
        softAssert.assertTrue(shippingAddressPageLocators.waitforCheckoutToBePresent());
        shippingAddressPageLocators.fullname();
        shippingAddressPageLocators.address1();
        shippingAddressPageLocators.address2();
        shippingAddressPageLocators.city();
        shippingAddressPageLocators.state();
        shippingAddressPageLocators.country();
        shippingAddressPageLocators.zipcode();
        log.info("Added shipping address for a purchase");
        shippingAddressPageLocators.paymentBtn();
        softAssert.assertTrue(shippingAddressPageLocators.PaymentPagetitleisPresent());
        paymentMethodPageLocators.fullname();
        paymentMethodPageLocators.cardNumber();
        paymentMethodPageLocators.exp();
        paymentMethodPageLocators.cvv();
        paymentMethodPageLocators.reviewOrder();
        log.info("Card details provided");
        softAssert.assertTrue(orderReviewPageLocators.getProductName().equalsIgnoreCase(homePageLocators.getProductName()));
        softAssert.assertTrue(orderReviewPageLocators.getProductpriceValue().equalsIgnoreCase(homePageLocators.getPriceValue()));
        softAssert.assertEquals(orderReviewPageLocators.grandTotal(), orderReviewPageLocators.getTotalPriceValue());
        orderReviewPageLocators.placeOrder();
        checkoutCompletePageLocators.orderConfirm();
        log.info("Ordered placed successfully");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifySocialLinks(){

        homePageLocators.goToSocialLinks();
        softAssert.assertTrue(homePageLocators.verifyTwitterIconPresent());
        softAssert.assertTrue(homePageLocators.verifyFacebookIconPresent());
        softAssert.assertTrue(homePageLocators.verifyLinkedInIconPresent());
        log.info("verified all the social links");
        softAssert.assertAll();

    }







    @Test(priority = 4)
    public void goToAWebSite() throws Exception{

        homePageLocators.tapOnmenu();
        homePageLocators.goToMenuItem("WebView");
        log.info("Go to web-view tab");
        softAssert.assertTrue(webViewPageLocators.verifyWebViewPresent());
        webViewPageLocators.enterUrl();
        webViewPageLocators.goToWebSite();
        log.info("went to the website");
        webViewPageLocators.enterTextInWebSite();
        softAssert.assertAll();

    }

    @Test(priority = 5)
    public void sortProductsOnPrice() throws Exception{

        homePageLocators.sortTheItemsByPrice();
        log.info("Products sorted based on the ascending order of the price");
        softAssert.assertTrue(homePageLocators.verifyAssendingByPriceIsSelected());
        softAssert.assertAll();

    }

}
