package com.cybertek.tests.day14_synchronization;

import com.cybertek.pages.DynamicLoadPage1;
import com.cybertek.pages.DynamicLoadPage7;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class WebDriverWaitPractice {

    @Test
    public void dynamic_loading_7_test() {
//        1. Go to http://practice.cybertekschool.com/dynamic_loading/7
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

//        2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

//        wait.until(ExpectedConditions.visibilityOf(dynamicLoadPage7));
//        3. Assert : Message “Done” is displayed.
        DynamicLoadPage7 dynamicLoadPage7 = new DynamicLoadPage7();

        Assert.assertTrue(dynamicLoadPage7.doneMessage.isDisplayed());


//        4. Assert : Image is displayed.
        Assert.assertTrue(dynamicLoadPage7.spongeBobImage.isDisplayed());

    }

    @Test
    public void dynamic_loading_1_test() {
//        1. Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        DynamicLoadPage1 dynamicLoadPage1 = new DynamicLoadPage1();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

//        2. Click to start
        dynamicLoadPage1.startButton.click();

//        3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadPage1.loadingBar));

//        4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoadPage1.inpurUsername.isDisplayed());

//        5. Enter username: tomsmith
        dynamicLoadPage1.inpurUsername.sendKeys("tomsmith");

//        6. Enter password: incorrectpassword
        dynamicLoadPage1.inputPassword.sendKeys("incorrectpassword");

//        7. Click to Submit button
        dynamicLoadPage1.submitButton.click();

//        8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoadPage1.errorMessage.isDisplayed());

    }

}
