package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TableUtils {

    public static void verifyOrder(WebDriver driver, String name) {

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));

        for (WebElement each : allNames) {
            if (each.getText().equals(name)) {
                Assert.assertTrue(true);
                return;
            }
        }
        //Assert.fail("this line will fail the code");

        Assert.assertTrue(false, "Name does not exist in the list.");
    }
    //task 5 - create new method to print out names and emails
    public static void printNamesAndEmails(WebDriver driver){

        //Create a locator that returns all the names in the table
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));

        //Create a locator that returns all the emails in the list
        List<WebElement> allEmails = driver.findElements(By.xpath("//table[@id='table1']//tr/td[3]"));

        for (int i = 0; i < allNames.size(); i++) {

            System.out.println("Name \t: " + allNames.get(i).getText());
            System.out.println("Email \t: " + allEmails.get(i).getText());
            //System.out.println("Name " + i + ": " + allNames.get(i) + ". Email " + i + ": " + allEmails.get(i));
        }


    }

}
