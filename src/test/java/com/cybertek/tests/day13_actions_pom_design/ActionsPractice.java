package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void p2_double_click_test() {

        // 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // 2.Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        // 3.Double click on the text “Double-click me to change my text color.”
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.doubleClick(textToDoubleClick);
        actions.perform();

        // 4.Assert: Text’s “style” attribute value contains “red”.
        String expectedInStyle = "red";
        String actual = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actual.contains(expectedInStyle));

    }
}
