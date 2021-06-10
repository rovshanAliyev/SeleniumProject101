JUNE 2ND, WEDNESDAY

Today's Schedule:
#1- Review
#2- Guest speaker experience sharing
#3- Practices
#4- one more library(dependency)


---------------------------------------------------------------------------

- DROPDOWNS:

    - How many different types are there?
    - 2

  #1- HTML Dropdowns (non-select):
  	- How do we handle HTML dropdown using selenium?
  	- Just like any other web element on the page.
  	- Basically we locate, and click.


	#2- Select Dropdowns
		- How do we handle Select dropdown using selenium?
			1- Create object of Select class (Selenium library)


			2- Locate the <select> dropdown using findElement method and pass it into the Select class' constructer.
			Select select = new Select(driver.findElement(By.LOCATOR));

			3- Use the object of the Select class to reach special methods for <select> dropdowns.

			select.anyMethod();


	- How do we get all of the options from <select> dropdowns?
		- .getOptions() method.

		- What is the return type:
		- Return type is list of webElements

		 - List<WebElement>		 

	- How do we select options from dropdowns?
		- We have 3 different ways to select.

		#1- selectByIndex		: 

			- count the index number of the option and pass it.
			- indexes start from 0.

			syntax: select.selectByIndex(0);

		#2- selectByValue		:

			- We use value of the attribute "value" to select option.

			<option value="OR"> Orange </option>

			syntax: select.selectByValue("OR");


		#3- selectByVisibleText:

			- We use the "text" of the option.
			- Whatever is displayed on the page is used to select options.


			<option value="OR"> Orange </option>

			syntax: select.selectByVisibleText("Orange");


	- How do we get the currently selected option?
		- .getFirstSelectedOption();

		What is the return type of this method?
		- WebElement
		- We can store inside of a Web Element

		- We need to use .getText() method to get the text of it?


---------------------------------------------------------------------------

	- Alerts/Pop-ups

	- How many different types of alerts are there?
	- 2

	#1- HTML Alert (non-javascript alert):
		- We handle as regular web element.
		- We locate and click

		- If it is HTML Alert, you can right click and inspect it in <html> code.

	#2- JS Alerts
		- JavaScript alert is different than HTML alert.
		- Once JS Alert is present, user (or selenium) is not allowed to do anything else until this alert is handled.


	- How many different types?

		#1- Information/Warning Alert : we can only accept
		#2- Confirmation Alert : we can accept and decline
		#3- Prompt Alert : we accept/decline and enter input

	- How do we handle JS Alerts?
		- We handle JS alerts using Alert.

		syntax: Alert alert = driver.switchTo().alert();

		alert.accept()
		alert.dismiss()
		alert.sendKeys()


------------------------------------------------------

Iframe (inline frame)

	- What is an iframe?
	- html inside of another html

- Why do we have to handle iframes?
    - It is an independent HTML from the main HTML.
    - WE must specifically change the focus of the Selenium WebDriver.


- How many ways we have to switch to iframes?
    - 3 ways.

  #1- index:
  	- You count the iframes in the page.
  	- Pass the index number of the iframe you want to switch to
  	- indexes start from 0  

  	driver.switchTo().frame(0);

  #2- id - name :
  	- if there is id or name attributes we can use their values to switch to iframe

  	driver.switchTo().frame("id-nameValue");


	#3- locate as we element WebElement:
		- we can locate it as a regular web element
		- it is <iframe> tag
		- we can locate it using any attribute any values and switch to it.

	
		driver.switchTo().frame(driver.findElement(By.locator));


1	-html
2		-html --> driver.switchTo().parentFrame(); --> will switch back to line 1
--> driver.switchTo().defaultContent(); --> will switch back to line 1

3		-html --> driver.switchTo().parentFrame(); --> will switch back to line 1
--> driver.switchTo().defaultContent();	--> will switch back to line 1

4			-html --> driver.switchTo().parentFrame(); --> will switch back to line 3
--> driver.switchTo().defaultContent(); ;	--> will switch back to line 1


1	<html>
2		<html>
</html>
3		<html>
4			<html></html>
</html>
</html>


- Once you switch browser driver's focus to an iframe, you must switch it back to be able to do action on the web elements outside of it.

------------------------------------------------------------------------
How to handle windows/tabs using Selenium

	Is there any difference for Selenium in between a tab or browser window?	
	- NO. Selenium considers everything as a seperate window.

	- Selenium uses "window handles" to differentiate in between different windows(tabs)

What is a window handle?
- It is an randomly auto-generated alphanumeric and unique string for each window.
- Every single window will have different "window handle".
- We don't have to do anything special for this.
- Every time we run our driver, in each new session, a brand new unique window handle will be generated.

- How do we get the current window's handle?
    - .getWindowHandle() method is used to get current window

    - Return type of .getWindowHandle(): String

- How do we get all of the currently opened windows' handles?
    - .getWindowHandles()
    - This method will return all of the currently opened windows' handles.
    - Selenium will only see the browsers that are opened in the current session.''

    - Return type: Set<String>

























