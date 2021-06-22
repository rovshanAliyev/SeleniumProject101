package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractice {

    @Test
    public void scroll_using_jsexecutor_test1() {

        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");
        BrowserUtils.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 750)");
        }
    }

    @Test
    public void scroll_using_jsExecutor_test2(){
        //Go to this page: http://practice.cybertekschool.com/large
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Locating the web elements so we can use in js.executeScript method
        WebElement cybertekSchoolLink= Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink= Driver.getDriver().findElement(By.linkText("Home"));

        //use js.executor with different scrolling JavaScript function
        //scroll down to cybertekSchool Link
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);

        //scroll up to Home link
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

    }

}

