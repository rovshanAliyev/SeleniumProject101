JUNE 6TH, Sunday-Funday

Today's schedule:
#1- Review: xpath + additional functionality
#2- Webtables
#3- Solve tasks
#4- BrowserUtils
#5- Properties


------------------------------------------------------------------------------------------

--> XPATH:
- How many types of xpath are there?
- 2 types of xpath.

	#1- Absolute xpath:
		- Starts with single slash "/"
		- It means it starts from the root element : "html"
		- It goes 1 by 1 from html to the desired web element
		- Because of this reason, this locator is not stable or dependanble.


	#2- Relative xpath
		- Starts with double slash "//"
		- What does // mean?
			- Start from anywhere in the html page.
			- Jump to the given point

		syntax: //tagName[@attribute='value']
				//tagName[@attribute="value"]


		- Can we use // multiple times in our xpath locator?
		- There is no limit in the number of // we can use in our xpath locator.
		- We can use as many as we need.


	- How do we go from parent to child using xpath?
	- / goes from parent to child

	//tagName[@attribute='value']/childTag/childTag2

	- How do we go from child to parent using xpath?
	- /.. will go from child to parent 

	//tagName[.='textOfWebElement']

---------------------------------------------------------

P.I.Q:

	How do you handle dynamic web elements?

	- What is dynamic web element?
		- A web element that has an attribute value changing everytime we refresh the page.

	#1- I would find a static parent or child and create my locator from there.
	#2- I would use the methods coming from xpath locator
		- contains
		- starts-with
		- ends-with

		//tagName[contains(@attribute, 'value')]
		//tagName[starts-with(@attribute, 'value')]
		//tagName[ends-with(@attribute, 'value')]


	- How to move from sibling to sibling?

	/preceding-sibling::



	<select>
2		<option value="11"> orange1 </option>
1		<option value="12"> orange2 </option>
0		<option value="13"> orange3 </option>
1		<option value="14"> orange4 </option>
2		<option value="15"> orange5 </option>
</select>


	//option[@value='13']/preceding-sibling::option[1]
	//option[@value='13']/preceding-sibling::option[2]


	//option[@value='13']/following-sibling::option[1]
	//option[@value='13']/following-sibling::option[2]


(//option[@value='4'])[1]/preceding-sibling::option[3]

(//option[@value='7'])[1]/following-sibling::option[4]


---------------------------------------------------------------------------

HOW DO WE CREATE WEB TABLES?

#1- We create <table> tag
#2- We create <thead> and <tbody>
#3- We create rows <tr>
#4- We create cells <td>


tr: table row
td: table data  --> creating each cell in rows
th: table header --> creating each cell in rows (but will be bolded)


	<table border="1">	
		<thead>
			<tr>
				<td>Name</td>
				<td>Color</td>
				<td>Number</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Elgun</td>
				<td>Ozgur</td>
				<td>Anton</td>
			</tr>
		</tbody>	
	</table>


---------------------------------------------------------------------------

HOW DO WE HANDLE WEB TABLES USING SELENIUM?
- We create custom xpath (or css) locators to handle web tables.


P1_LOCATE EXAMPLE TABLE 1 ITSELF:

	//table[@id='table1']

P2_CREATE A LOCATOR THAT RETURNS ALL OF THE ROWS IN THIS TABLE:

	//table[@id='table1']//tr


P2_a: All rows inside of the body:

	//table[@id='table1']/tbody/tr


P3_CREATE A LOCATOR THAT RETURNS ONLY 3RD ROW

	//table[@id='table1']/tbody/tr[3]

P4_CREATE A LOCATOR THAT RETURNS ALL OF THE CELLS INSIDE OF ALL OF THE ROWS (in tbody)

	//table[@id='table1']/tbody/tr/td

	//table[@id='table1']//tr/td --> this also returns us the same result because in the <thead>, we dont have and <td>


P5_CREATE A LOCATOR THAT RETURNS ALL OF THE FIRST NAMES FROM THE TABLE:

	//table[@id='table1']//tr/td[2]



P6_CREATE A LOCATOR THAT RETURNS FRANK'S CELL DIRECTLY

	//table[@id='table1']//tr[2]/td[2]

What we are saying is:
tr[2] --> get me the second row
td[2] --> get me the second cell (in the previously provided row)


	#2-Locating Frank by its text:

	//table[@id='table1']//td[.='Frank']


P7_CREATE A LOCATOR THAT RETURNS $100 CELL

	//table[@id='table1']//tr[3]/td[4]


	//table[@id='table1']//td[.='$100.00']



P8_CREATE A LOCATOR THAT RETURNS JASON'S DUE AMOUNT USING JASON'S TEXT

There are multiple ways to achieve this result:

#1- locate the jason by text, and go to parent (tr), go back in to rows with index number

	//table[@id='table1']//td[.='Jason']/../td[4]


#2- We can use "/following-sibling::" functionality from xpath

	//table[@id='table1']//td[.='Jason']/following-sibling::td[2]


P9_CREATE A LOCATOR THAT RETURNS JASON'S 'Last name' USING JASON'S TEXT

#1-
	//table[@id='table1']//td[.='Jason']/../td[1]


#2-
	//table[@id='table1']//td[.='Jason']/preceding-sibling::td[1]


P10_LOCATE EVERYONE THAT MADE $50 PURCHASE, LOCATE THEIR NAMES

#1-
	//table[@id='table1']//td[.='$50.00']/../td[2]

#2-

	//table[@id='table1']//td[.='$50.00']/preceding-sibling::td[2]


------------------------------------------------------------

BrowserUtils:
- This class will be used to store common utility methods.
- Whenever we have a repeating action, we can create a method for it and store that method in this class.
- All of the methods in this class will be STATIC.
- So we can reach all of the methods inside just by calling the class name.

	BrowserUtils.method();

JAVA TOPIC (Exception)
- When there is compiling error, we have to handle it somehow.

- We have 2 different ways to handle.
  #1- throws
  #2- try/catch: this tries the code we pass in "try" block, and if expection happens does whatever we have in "catch" block



------------------------------------------------------------

- What is the topic? What are we doing?

- Why are we learning this?
    - What kind of issue we are solving with this?
    - What issue we are addressing?
    - What are we making easy by using this?

- How are we using it? How are we implementing it into our code?


------------------------------------------------------------

What is test data?
- All of the data we pass in to AUT (application under test) such as username, password, search values etc.

How we have been passing our test data into our code?
- We have been directly passing our test data in our tests
- Which means we are keeping our test data in our source code
- This means we are hard coding our test data.

What is hard coding?
- Hard coding is keeping your data (test data) in the source code.
- If you have to go in your java-selenium code to change your data, it means you have hard coded it.
- We will be creating a logic where we read our test data from outside of our code.

	environment:
		qa1.vytrack.com
		qa2.vytrack.com
		staging1.vytrack.com
		staging2.vytrack.com
		prod

qa environment	: is generally used testing purposes
staging env 	: is also used for testing but generally has better server support etc.
prod 			: is actual product that end user is using.

====================================


Properties type:
- Java is keeping track of some of the important properties regarding your computer and project etc.

	- There is a class in Java that handles "properties"
	- Properties files are keeping data in "key=value" format

	username=tester
	password=test
	env=https://library1.application.com
	browser=chrome

Give me examples of different types of files you use in your computer?
- .pdf, .txt, .exe, .jpeg, .html, .zip, .png, .java, .ppt

	- .properties

--> .properties is just another type of file we have.

--> What is special about .properties type of file?
- .properties files stores value in "key=value" format

	test.properties
	testData.properties

	configuration.properties

--> The data we will be storing in our configuration.properties is going to be the kind of data that will be able to change the flow of the execution of our test suites.

	#1- Be able to login with different usernames
	#2- Be able to enter different password
	#3- Be able to change the browser type we are running our test suite
	#4- Be able to change the environment we are running our test suite on


========================================================================

IF YOU ALWAYS DO WHAT YOU HAVE ALWAYS DONE, YOU WILL ALWAYS BE WHERE YOU HAVE ALWAYS BEEN.













