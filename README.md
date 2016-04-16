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

This solution features: 
- Spring WS to write contract-first Web Services.
- Spring Boot to bootstrap the Spring Application without breaking a sweat.
- Maven for a portable way of building and testing the application without depending on an IDE.
- JUnit 4 for Unit Testing.
- Java 8 goodies as: Streaming API, java.util.Optional.
- OO Patterns and refactorings: Strategy Pattern, Object Method.

Make sure you have installed:
- Java 1.8
- Apache Maven 3

Run the project:

`mvn spring-boot:run`

Invoke the web service on a Linux/Unix shell:
`curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws`

Run unit tests with
` mvn test`


This solution was based on the following guides:
https://spring.io/guides/gs/producing-web-service/
http://www2.lawrence.edu/fast/GREGGJ/CMSC270/Infix.html
