package com.cybertek.practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class vytrack {
    @Test
    public void refreshButton() {
        //enter username
        Driver.getDriver().findElement(By.xpath("//input[@type='text']"))
                .sendKeys(ConfigurationReader.getProperty("username"));

        //enter password
        Driver.getDriver().findElement(By.xpath("//input[@type='password']"))
                .sendKeys(ConfigurationReader.getProperty("password"));

        //click on login
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        //click on fleet menu
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();

        //click on vehicles
        Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']")).click();

        //click on refresh
        Driver.getDriver().findElement(By.xpath("//i[@class='fa-repeat']")).click();

    }
}
