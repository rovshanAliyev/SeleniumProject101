MAY 12TH, Wednesday

Today's schedule:
- Review
- Practice
- New topic


--------------------------------------------------------------------

- What is maven?
    - Build automation tool for creating java projects

-  What is build?
    - Repeated steps we are following when creating a java project: such as; creating folder structure, compiling, deploying ... etc

- Is maven for testers?
    - No. But as SDET we will take advantage of some of its functionality.

- Is maven the only "Build automation tool"?
    - Gradle, Ant

- .findElement(By.LOCATOR("STRING"));
    - What does it do?
    - Finds and returns a SINGLE web element.

    - What does it accept as parameter?
    - It accepts locators as String.

    - What is the RETURN TYPE?
    - Returns "WebElement" type that comes from Selenium library

    - What kind of exception does it throw?
    - NoSuchElementException

- When exception happens (unless it is handled) the code will not continue to execute.


- P.I.Q : Can you tell me about the common exceptions you are facing when you are using JAVA+SELENIUM?
    - NoSuchElementException


- When do you get NoSuchElementException?
  #1- Your locator is not correct.
  #2- WebElement might not be loaded into the page yet. In this case we need to adjust the speed of the BrowserDriver's speed to the browser's speed.
  	- For now we will be using Thread.sleep to stop our code execution for a few seconds. 


- .click();
    - clicks to the previous located web element.
    - it does not accept any argument
    - no return type, just action method.
    - this method cannot be used alone. We need to locate a web element to be able to use it.

syntax: driver.findElement(By.locator("something")).click();

- .sendKeys("STRING TO BE SENT");
    - it sends the given text as a STRING.
    - it accepts a string arg
    - No return type, only action.
    - this method cannot be used alone. We need to locate a web element to be able to use it.

syntax: driver.findElement(By.locator("something")).sendKeys("string");


- Keys.ENTER;
    - This piece of code can be passed in .sendKeys() method.
    - It will press ENTER, as if user is pressing the ENTER KEY from keyboard.
    - You can either use + or , to have Keys.ENTER in sendKeys



syntax1: driver.findElement(By.locator("something")).sendKeys("string" + Keys.ENTER);
syntax2: driver.findElement(By.locator("something")).sendKeys("string" , Keys.ENTER);


LOCATORS:
- Locators are methods coming from Selenium library that allows us to find WebElements and do action on them.

	- How many types of locators do we have ?
	- 8 locators in Selenium

#1- id :
	- It looks through the id attribute values and returns the matching web element.
	- id is a unique attribute value.
	- it must be unique for each web element. 
	- sometimes it might have "dynamic" id attribute value.

#2- linkText :
	- linkText locator will find and return the LINK by its text.
	- the text that is in between the opening tag and closing tag is used to locate web element.
	- IT ONLY WORKS WITH LINKS.
	- It will LOOK FOR EXACT TEXT MATCH.
	- We can compare this method to .equals() from Java


#3- partialLinkText :
	- partialLinkText locator is VERY SIMILAR TO LINKTEXT
	- This locator will only look for partial text match.
	- We can compare this method to .contains() from Java

#4- name :
	- this locator locates using name attribute's value
	- Does this have to be unique value?
		- NO. 

#5- className :
	- this locator locates using CLASS attribute's value to locate web element
	- Does this have to be unique value?
		- NO. 

#6- tagName
	- this locator uses TAGNAME to locate web elements
	- this is usually not very useful for locating SINGLE web elements
	- this locator is useful when you are trying to locate multiple web elements


- What happens with these 6 locators when there is multiple matching result?
    - it will find and return the first matching result.
    - all the action (sendKeys, click) will be applied to first web element.
    - in that situation, you can consider to use a different locator.


------------------------------------------------------------------------------------

- .getText();
    - What does it do?
    - Gets the text of given web element.

    - Does it accept argument?
    - No.

    - What is the return type?
    - String

    - .getText method can only get the text from in between the OPENING TAG and CLOSING TAG.


- .getAttribute("attribute name"); --> returns attribute value as String
    - What does it do?
    - This method will return the attribute value of given attribute on an already located web element.

    - What is the return type?
    - String

--> The browser Selenium opens will be cache-free.
- It means there will be no history saved.
- No data entered to form will be saved.
- It will be always as if you are opening and entering data to browser for the first time.
	





















