package com.erste.testcases;

import com.erste.config.BaseSetup;
import org.testng.annotations.Test;

public class TestCases extends BaseSetup {


    @Test
    public void login(){
        homePageLocators.tapOnmenu();
    }
}
