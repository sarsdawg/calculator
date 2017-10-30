# Calculator
This Java program is a simple arithmetic calculator that utilizes the JavaAppMath class by paalonge located at https://github.com/paalonge/seng560Alonge_1.

# Using the Calculator
This repository includes the source (.java) and binary (.class) files for both the Calculator and JavaAppMath classes.  The Calculator class includes a main method that runs the program in a user interactive mode on the Java terminal.

# Reuse of JavaAppMath
I was able to reuse JavaAppMath with only one minor edit to the source code, which was commenting out the original package name.  In this regard, it was relatively easy to use.  However, I did add a significant amount of error checking and type conversion to my code in Calculator.java to get it to work seamlessly.

# Description of Calculator.java

##    main 
This method runs a continual loop that lets the user choose the operation to perform.  It then calls the respective method for the chosen operation.
##    addition
This method performs addition.
##    subtraction
This method performs subtraction.
##    multiplication
This method performs multiplication.
##    division
This method performs division.
##    squareRoot
This method finds the square root of a number.
##    exponentiation
This method raises a number to a certain power.
##    conversion
This method converts between binary, octal, decimal, hexadecimal, and floating point numbers.
##    getBase
This method asks the user which base they want to work with: binary, octal, decimal, hexadecimal, or floating point numbers.  The result of the chosen operation will appear in the same base as the base chosen for the operation's arguments.  This method was a necessary addition to get JavaAppMath to work properly with Calculator.java.
##    argCheck
This method performs error checking to ensure that the arguments match the chosen base and that they are formatted correctly.  This method was a necessary addition to get JavaAppMath to work properly with Calculator.java.




