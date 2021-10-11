package cstevens_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 12 Assignment
 * @Date: August 7, 2021
 * @Description: Exception Handling & File I/O
 */
//Imports
import java.util.*;
import java.io.File;
import java.io.IOException;

//Begin Class Main
public class Main {

    //Begin Main Method
    public static void main(String[] args) throws IOException {

        //Variable declarations
        int choice = 0;             //data menu
        final int LOW = 1;
        final int HIGH = 3;
        String choice2;        //data submenu... case 1
        String choice3;        //data submenu... case 2
        String choice4;         //case 2
        String answer;          //input for yes/no
        String fileName;
        String filePath;
        int qtyNumbers;     //quantity of numbers to enter into file

        //`New instance of subclass Validate
        Validate val = new Validate();

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("\nWelcome to my Statistics Calculator\nEnter the "
                + "name of your text file (e.g. MyNumbers)\nThe file extension "
                + "will be added after entry.\n->: ");
        fileName = sc.nextLine();
        filePath = "C:/W12Assignment/" + fileName + ".txt";

        //Instantiate two new File class objects
        File fileDir = new File("C:/W12Assignment");
        File file = new File(filePath);

        //Check if directory exists, if not create it
        if (!fileDir.exists()) {
            fileDir.mkdir();
            System.out.printf("\nThe directory does not exist.\n"
                    + "Creating directory...\n");
            System.out.printf("Directory created at this location ->: "
                    + "%s\n", fileDir.getAbsolutePath());
        } else {
            System.out.printf("\nThe directory already exists at this location:"
                    + " \n%s\n", fileDir.getAbsolutePath());
        }

        //Check if file exists, if not create it        
        if (!file.exists()) {
            System.out.println("\nThe file does not exist.\nCreating file...");
            file.createNewFile();
            System.out.printf("File created ar this location ->: "
                    + "%s\n", file.getAbsolutePath());
        } else {
            System.out.printf("\nThe file already exists and is located here: "
                    + "%s\n", file.getAbsolutePath());
        }

        //Begin outer validation loop
        do {
            do { //Begin data menu loop
                System.out.print("\nPlease select from the following menu of "
                        + "options:\n1. Enter Data\n2. Read Data\n"
                        + "3. Exit\n->: ");
                try { //Begin try block
                    do { //Begin validate loop
                        choice = sc.nextInt();
                        sc.nextLine();
                        val.setValidateRange(choice, LOW, HIGH);
                    } while (!val.getRange()); //End validate loop
                } catch (InputMismatchException IME) { //Catch IME
                    System.err.printf("Exception: %s\n", IME); //Output error info
                    sc.nextLine(); //Clear input buffer
                    System.out.println("You must enter a number. Please try "
                            + "again.");
                }
            } while (!val.getRange()); //End data menu loop

            //Create object of Write class
            Write yourWrite = new Write(filePath);

            //Instantiate object of Read class
            Read yourRead = new Read(filePath);

            //Begin SWITCH CASE
            switch (choice) {

                case 1:
                    do { //Begin write data menu loop
                        System.out.print("\nHow many numbers would you like "
                                + "to send "
                                + "to the file? ->: ");
                        try { //Begin try block                                                    
                            sc.hasNextInt();
                        } catch (InputMismatchException IME) { //Catch IME
                            //Output error information
                            System.err.printf("Exception: %s\n", IME); 
                            System.out.print("\nYou must enter a number. "
                                    + "Please try again.");
                            sc.nextLine(); //Clear input buffer
                        } //End try block
                    } while (!sc.hasNextInt()); //End write data menu 
                    qtyNumbers = sc.nextInt();
                    //Begin request numbers loop
                    for (int i = 1; i <= qtyNumbers; i++) {
                        System.out.printf("Enter number %d -> ", i);
                        double num = sc.nextDouble();
                        sc.nextLine();
                        yourWrite.setNumbers(num);
                    }
                    //End request numbers loop
                    System.out.print("\nWould you like to read the file to "
                            + "see the results? ->: ");
                    do { //Yes/No validation loop
                        choice2 = sc.next();
                        sc.nextLine();
                        val.setYesNo(choice2); //Send answer to Validation subclass
                    } while (!val.getYesNo());

                    if (choice2.equalsIgnoreCase("Y")) {

                        //Check if file exists, if not ask if user wants to create        
                        if (!file.exists()) {
                            System.out.println("The file does not exist.\n"
                                    + "Would you like to create one? ");
                            do { //Validation loop
                                answer = sc.next(); //Send to Validation subclass
                                val.setYesNo(answer);
                            } while (!val.getYesNo());
                            if (answer.equalsIgnoreCase("Y")) {
                                file.createNewFile();
                                System.out.printf("File created ar this "
                                        + "location ->: "
                                        + "%s\n", file.getAbsolutePath());
                            } else {
                                break;
                            }
                        } else {
                            yourRead.readFile();

                            //Get average, min, max, standard deviation                                
                            System.out.printf("\nThe average of the numbers"
                                    + " in %s.txt is: %.4f",
                                    fileName, yourRead.getAvg());
                            System.out.printf("\nThe smallest number in the "
                                    + "file is: %.4f", yourRead.getMin());
                            System.out.printf("\nThe largest number in the "
                                    + "file is: %.4f", yourRead.getMax());
                            System.out.printf("\nThe standard deviation for "
                                    + "the numbers in this file is: %.4f",
                                    yourRead.getSD());
                        }
                    }
                    break;

                case 2:

                    //Check if file exists, if not ask if user wants to create        
                    if (!file.exists()) {
                        System.out.println("The file does not exist.\nWould "
                                + "you like to create one? ");
                        do { //Validation loop
                            answer = sc.next(); //Send to Validation subclass
                            val.setYesNo(answer);
                        } while (!val.getYesNo());
                        if (answer.equalsIgnoreCase("Y")) {
                            file.createNewFile();
                            System.out.printf("File created ar this location "
                                    + "->: %s\n", file.getAbsolutePath());
                        } else {
                            break;
                        }
                    } else {

                        //Check file for data
                        //If data present print data
                        //If data not present prompt to enter data
                        if (file.length() != 0) {
                            yourRead.readFile();
                            //Get average, min, max, standard deviation                                
                            System.out.printf("\nThe average of the numbers"
                                    + " in %s.txt is: %.4f",
                                    fileName, yourRead.getAvg());
                            System.out.printf("\nThe smallest number in the "
                                    + "file is: %.4f", yourRead.getMin());
                            System.out.printf("\nThe largest number in the "
                                    + "file is: %.4f", yourRead.getMax());
                            System.out.printf("\nThe standard deviation for "
                                    + "the numbers in this file is: %.4f",
                                    yourRead.getSD());
                            break;
                        } else {
                            System.out.print("The file contains no data.\nEnter "
                                    + "data? ->: ");
                            do { //Yes/No validation loop
                                choice4 = sc.next();  //Send to Validation subclass
                                val.setYesNo(choice4);
                            } while (!val.getYesNo());

                            if (choice4.equalsIgnoreCase("Y")) {
                                System.out.print("\nHow many numbers would you "
                                        + "like to send to the file? ->: ");
                                //Request user input for quantity of numbers 
                                qtyNumbers = sc.nextInt();
                                sc.nextLine();

                                for (int i = 1; i <= qtyNumbers; i++) {
                                    System.out.printf("Enter number %d -> ", i);
                                    double num = sc.nextDouble();
                                    sc.nextLine();
                                    yourWrite.setNumbers(num);
                                }

                                System.out.print("\nWould you like to read the "
                                        + "file to see the results? ->: ");
                                do { //Yes/No validation loop
                                    choice3 = sc.next();
                                    //Send to Validation subclass                                    
                                    val.setYesNo(choice3); 
                                } while (!val.getYesNo());
                                if (choice3.equalsIgnoreCase("Y")) {
                                    yourRead.readFile();
                                    //Get average, min, max, standard deviation                                
                                    System.out.printf("\nThe average of the "
                                            + "numbers in %s.txt is: %.4f",
                                            fileName, yourRead.getAvg());
                                    System.out.printf("\nThe smallest number "
                                            + "in the file is: %.4f",
                                            yourRead.getMin());
                                    System.out.printf("\nThe largest number "
                                            + "in the file is: %.4f",
                                            yourRead.getMax());
                                    System.out.printf("\nThe standard deviation "
                                            + "for the numbers in this file "
                                            + "is: %.4f", yourRead.getSD());
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nThank you for using My Statistics "
                            + "Calculator. Goodbye.\n\n");
                    System.exit(0);

            }
            System.out.print("\nWould you like to run the program again? "
                    + "Y for Yes, N for No: ");
            do { //Yes/No validation loop
                answer = sc.next();
                val.setYesNo(answer); //Send to Validation subclass
            } while (!val.getYesNo());

        } while (answer.equalsIgnoreCase("Y")); //End outer validation loop

        System.out.print("\nThank you for using My Statistics Calculator. "
                + "Goodbye.\n\n");

    } //End Main method

}
