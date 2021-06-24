package com.cybertek.practice;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TaskFromCommencis {

    @Test
    public void TaskFromOscar() {
        List<WebElement> news = Driver.getDriver().findElements(By.xpath("(//div[@class='content'])[3]//h2"));
        for (WebElement each : news) {
            WebElement author = Driver.getDriver().findElement(By.xpath("(//div[@class='content'])[3]//span//a"));

        }


    }

}
