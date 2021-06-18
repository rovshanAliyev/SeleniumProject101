package com.cybertek.OfficeHours;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FakerPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("dataTablesUrl");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void form() {


        List<WebElement> list = driver.findElements(By.xpath("//input"));

        Faker faker = new Faker();

        for (int i = 0; i <= list.size(); i++) {

            switch (i) {
                case 0:
                    String firstNameFaker = faker.name().firstName();
                    list.get(i).sendKeys(firstNameFaker);
                    break;
                case 1:
                    String lastNameFaker = faker.name().lastName();
                    list.get(i).sendKeys(lastNameFaker);
                    break;
                case 2:
                    list.get(i).sendKeys("stefanaufderhar");
                    break;
                case 3:
                    String emailFaker = faker.internet().emailAddress();
                    list.get(i).sendKeys(emailFaker);
                    break;
                case 4:
                    String passwordFaker = faker.internet().password();
                    list.get(i).sendKeys(passwordFaker);
                    break;
                case 5:
                    list.get(i).sendKeys("875-169-7019");
                    break;
                case 6:
                    list.get(i).click();
                    break;
                case 9:
                    list.get(i).sendKeys("12/21/1232");
                    break;
                case 11:
                    list.get(i).click();
                    break;
            }
        }
//        11.Select Department/Office
        Select departmentDropdown = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByVisibleText("Select your Department/Office");

        //14.Click to sign up button
        BrowserUtils.sleep(2);
        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        //15.Verify success message
        BrowserUtils.sleep(2);
        WebElement actualResult = driver.findElement(By.xpath("//p"));
        actualResult.isDisplayed();

    }
}

//        @Test
//        public void registrationForm () {

//        Faker faker = new Faker();
//        //// 3.Enter first name
//        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='first name']"));
//        String firstNameFaker = faker.name().firstName();
//        firstName.sendKeys(firstNameFaker);
//
//        //// 4.Enter last name
//        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='last name']"));
//        String lastNameFaker = faker.name().lastName();
//        lastName.sendKeys(lastNameFaker);
//
//        //// 5.Enter username
//        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='username']"));
//        userName.sendKeys("johnnielockman");
//
//        //// 6.Enter email address
//        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email@email.com']"));
//        String emailFaker = faker.internet().emailAddress();
//        email.sendKeys(emailFaker);
//
//        //// 7.Enter password
//        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
//        String passwordFaker = faker.internet().password();
//        password.sendKeys(passwordFaker);
//
//        //// 8.Enter phone number
//        WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='tel']"));
//        phoneNumber.sendKeys("253-431-1143");
//
//        //// 9.Select a gender from radio buttons
//        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
//        gender.click();
//
//        //10.Enter date of birth
//        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
//        dateOfBirth.sendKeys("12/12/2343");
//
//        //11.Select Department/Office
//        Select departmentDropdown = new Select(driver.findElement(By.xpath("//select[@name='department']")));
//        departmentDropdown.selectByVisibleText("Select your Department/Office");
//
//        //12.Select Job Title
//        Select selectJobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
//        selectJobTitle.selectByIndex(4);
//
//        //13.Select programming language
//        BrowserUtils.sleep(2);
//        WebElement selectProLan = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
//        selectProLan.click();
//
//        //14.Click to sign up button
//        BrowserUtils.sleep(2);
//        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
//        signUpButton.click();
//
//        //15.Verify success message
//        BrowserUtils.sleep(2);
//        String expectedResult = "You've successfully completed registration";
//        WebElement actualResult = driver.findElement(By.xpath("//p"));
//        actualResult.isDisplayed();
//    }
