# statistics-calculator
A program that performs statistical calculations on user supplied data written to a file.

## Assignment
Write a program that writes user supplied data to a text file and can perform a few statistical calculations on the data.

## Constraints
- The file directory will be C:/W12Assignment.
- Only one file will be created, used, and updated while the program runs.

## Requirements
- Use exception handling and validation where appropriate.
- Use PrintWriter and Scanner for writing and reading data.
- Use a separate (external to the main class) subclass to write data.
- Use a separate (external to the main class) subclass to read data.
- Use a separate (external to the main class) subclass to validate entries.
- Use set and get methods in the subclasses.
- Find the average of all the numbers in the file.
- Find the smallest number in the file.
- Find the largest number in the file.
- Find the standard deviation (StdDev) of the number set (Follow the “Basic Example” as a model for your StdDev algorithm located https://en.wikipedia.org/wiki/Standard_deviation).
- Implement a loop to run the program again if the user wishes (Note: this will only allow updates or reading of the same file since only one file is used for duration of the program run).
- Use the supplied MyNumbersLarge.txt file to make sure you are obtaining the correct information as such:
  - All numbers printed (500 numbers)
  - The average of the numbers in file name is: 502.3212
  - The smallest number in the file is: 1.2416
  - The largest number in the file is: 999.3116
  - The standard deviation for the numbers in this file is: 287.6556

## Notes
- Consider using an ArrayList of Doubles to store numbers as they are entered.
- Use Collections to assist with minimums and maximums.
- Write the code to work with all correct entries before implementing validation and exception handling. 
