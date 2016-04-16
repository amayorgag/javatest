# Solvo's Java test 

Fork this repository to do your work.

# Statement 

You need to build a SOAP webservice in Java that receive a list of numbers and mathematical operations and return the result of solving them in order of precedence.

Features:

* This list is built by an external web application (do not implement it),  it allows the user to insert the numbers without any validation.
* The application will only solve basic operations (addition, subtraction, multiplication and division) to whole numbers and decimals.
* To represent numbers in thousands can use "commas" or "spaces" or both, for example 10,000 or 5,000,321 or 10, 321 or 3 000 that can be combined with points to set a valid number 10,592.76. 
* You should be careful with the position of the comma, realize that 100,02 or 10,0000 or ,302 are not valid.
* Return or raise an error if exist an invalid input.

These are valid inputs ([ ] denotes list):

    [10,592.76, '+', '780', '+', 10000, '*', 200.76]
    [1, '/', 323, '-', 765]
    [1, '+', 2]

# Solution

Make sure you have installed:
- Java 1.8
- Apache Maven 3

Run the project:

`mvn spring-boot:run`

Invoke the web service:
`curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws`
