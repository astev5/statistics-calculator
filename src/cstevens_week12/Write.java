package cstevens_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 12 Assignment
 * @Date: August 7, 2021
 * @Description: Exception Handling & File I/O
 */
//Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//Begin Write subclass
public class Write {

    //Declarations
    ArrayList numbers = new ArrayList<>();
    String fileName;

    /**
     * Constructor
     *
     * @param fileName
     */
    public Write(String fileName) {
        this.fileName = fileName;

    }

    /**
     * Method @setNumbers: adds inputted doubles to arrayList: numbers
     *
     * @param num
     * @throws FileNotFoundException
     */
    public void setNumbers(double num) throws FileNotFoundException {
        numbers.add(num);
        writeNumbers();
    } //End setNumbers method

    /**
     * Method @writeNumbers: writes arrayList to specified file
     *
     * @throws FileNotFoundException
     */
    public void writeNumbers() throws FileNotFoundException {

        File file = new File("C:/W12Assignment/" + fileName + ".txt");

        try (PrintWriter myWriter = new PrintWriter(file)) {

            for (int i = 0; i < numbers.size(); i++) {
                //            System.out.printf("Enter number %d -> ", i);
                double num = (double) numbers.get(i);

                myWriter.printf("%.4f" + System.getProperty("line.separator"),
                        num);
            }
        }
    } //End writeNumbers method

} //End Write Class
