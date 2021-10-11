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

        //Declarations
        int choice;      //data menu
        final int LOW = 1;
        final int HIGH = 3;        
        String choice2;        //data submenu... case 1
        String choice3;        //data submenu... case 2
        String answer;          //input for yes/no
        String fileName;
        int qtyNumbers;     //quantity of numbers to enter into file

        //`New instance of subclass Validate
        Validate val = new Validate();        

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("\nWelcome to my Statistics Calculator\nEnter the "
                + "name of your text file (e.g. MyNumbers)\nThe file extension "
                + "will be added after entry.\n->: ");
        fileName = sc.nextLine();
        

        //Instantiate two new File class objects
        File fileDir = new File("C:/W12Assignment");
        File file = new File("C:/W12Assignment/" + fileName + ".txt");

        //Check if directory exists, if not create it
        if (!fileDir.exists()) {
            fileDir.mkdir();
            System.out.printf("The directory does not exist.\n"
                    + "Creating directory...\n");
            System.out.printf("Directory created at this location ->: "
                    + "%s\n", fileDir.getAbsolutePath());
        } else {
            System.out.printf("The directory already exists at this location:"
                    + " \n%s\n", fileDir.getAbsolutePath());
        }

        //Check if file exists, if not create it        
        if (!file.exists()) {
            System.out.println("The file does not exist.\nCreating file...");
            file.createNewFile();
            System.out.printf("File created ar this location ->: "
                    + "%s\n", file.getAbsolutePath());
        } else {
            System.out.printf("The file already exists and is located here: "
                    + "%s\n", file.getAbsolutePath());
        }

        //Begin DO WHILE loop
        do {

            //Data menu
            System.out.print("\nPlease select from the following menu of "
                    + "options:\n1. Enter Data\n2. Read Data\n3. Exit\n->: ");
            do {
                choice = sc.nextInt();
                val.setValidateRange(choice, LOW, HIGH);
            } while (!val.getRange());

            //Create object of Write class
            Write yourWrite = new Write(fileName);

            //Instantiate object of Read class
            Read yourRead = new Read(fileName);

            //Begin SWITCH CASE
            switch (choice) {

                case 1:

                    System.out.print("\nHow many numbers would you like to send "
                            + "to the file? ->: ");

                    qtyNumbers = sc.nextInt();
                    sc.nextLine();

                    for (int i = 1; i <= qtyNumbers; i++) {
                        System.out.printf("Enter number %d -> ", i);
                        double num = sc.nextDouble();
                        sc.nextLine();
                        yourWrite.setNumbers(num);
                    }

                    System.out.print("\nWould you like to read the file to "
                            + "see the results? ->: ");
                    choice2 = sc.nextLine();
 
                    if (choice2.equalsIgnoreCase("Y")) {

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
                    break;

                case 2:

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
                        do { //Validation loop
                            answer = sc.next();
                            val.setYesNo(answer); //Send answer to Validation 
                                                    //subclass
                        } while (!val.getYesNo());
                        
                        if (answer.equalsIgnoreCase("Y")) {
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
                            choice3 = sc.nextLine();
                            if (choice3.equalsIgnoreCase("Y")) {

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
                    }
                    break;

                case 3:
                    System.out.print("\nThank you for using My Statistics "
                            + "Calculator. Goodbye.\n\n");
                    System.exit(0);

            }
            System.out.print("\nWould you like to run the program again? "
                    + "Y for Yes, N for No: ");
            do { //Validation loop
                answer = sc.next();
                val.setYesNo(answer); //Send answer to Validation subclass
            } while (!val.getYesNo()); 

        } while (answer.equalsIgnoreCase("Y"));

        System.out.print("\nThank you for using My Statistics Calculator. "
                + "Goodbye.\n\n");

    } //End Main method

}
