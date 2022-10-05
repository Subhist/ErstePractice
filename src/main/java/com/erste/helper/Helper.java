package com.erste.helper;

import com.erste.config.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Helper {


    AppiumDriver driver;
    public Helper(AppiumDriver driver) {
        this.driver=driver;
    }

    WebDriverWait wait;

    public void getScreenShot(String testCasesName) throws IOException {

        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File screen=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").format(new Date());
        FileUtils.copyFile(screen, new File("./reports/"+fileName+""+testCasesName+".png"));

    }

    public static String getValue(String whichfile,String valueFor) throws Exception{
        Properties properties=new Properties();
        FileInputStream fileInputStream;
        if(whichfile.equalsIgnoreCase("testdata")) {
            fileInputStream = new FileInputStream("src/main/resources/testData.properties");
        }
        else{
            fileInputStream = new FileInputStream("src/main/resources/deviceDetails.properties");
        }

        properties.load(fileInputStream);
        return properties.getProperty(valueFor);

    }



    //Wait for element to be visible and click
    public void click(WebElement element){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element)).click();

    }

    //Send values to the TextBox
    public void sendValue(WebElement element,String values){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(values);
    }





   public void tap(WebElement element){
       TouchAction touchAction=new TouchAction((PerformsTouchActions) DriverConfig.getInstance().getDriver());
       touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(1))).release().perform();
   }

   public double getThePrice(String price){
       String[] prices= price.split("\\$");
       String price1 = prices[1];
       return Double.parseDouble(price1);
   }




    //Wait till the element is clickable
    public void waitTillElementIsClickable(WebElement element){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }


    //Wait for element to be visible
    public void waitForElementToBeVisible(WebElement element){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));

    }


    //Click on element without waiting for element
    public void clickWithoutWaitingForElement(WebElement element){

        element.click();

    }

    public String getText(WebElement element){
        wait = new WebDriverWait(driver,30);
       return wait.until(ExpectedConditions.visibilityOf(element)).getText();

    }

}
