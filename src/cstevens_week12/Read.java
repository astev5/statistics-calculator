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
import java.util.*;

//Begin Read subclass
public class Read {

    //Declarations
    ArrayList numbers = new ArrayList<>();
    double avgNumbers;
    double min;
    double max;
    double result;
    double num1;
    String fileName;
    String line;

    /**
     * Constructor
     *
     * @param fileName
     */
    public Read(String fileName) {
        this.fileName = fileName;

    }

    /**
     * Method @readFile: read data from specified file
     *
     * @throws FileNotFoundException
     */
    public void readFile() throws FileNotFoundException {

        File file = new File("C:/W12Assignment/" + fileName + ".txt");

        try (Scanner input = new Scanner(file)) {
            System.out.println("\nThe numbers in this file are:");
            while (input.hasNextLine()) {
                line = input.nextLine();
                System.out.println(line);
                num1 = Double.parseDouble(line);
                numbers.add(num1);
                setAvg();
            }
        }
    } //End readFile method

    /**
     * Method @setNumbers: convert data from file to arrayList of doubles
     */
    public void setNumbers() {
        num1 = Double.parseDouble(line);
        numbers.add(num1);
        setAvg();
    } //End setNumbers method

    /**
     * Method @getNumbers
     *
     * @return arrayList: numbers
     */
    public ArrayList getNumbers() {
        return numbers;
    } //End getNumbers method

    /**
     * Method @setAvg: calculate average of arrayList: numbers
     */
    public void setAvg() {
        //Average
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + (double) numbers.get(i);
        }
        avgNumbers = (sum / numbers.size());
        setMin();
    } //End setAvg method

    /**
     * Method @getAvg
     *
     * @return average of arrayList: numbers
     */
    public double getAvg() {
        return avgNumbers;
    } //End getAvg method

    /**
     * Method @setMin: determine minimum value in arrayList: numbers
     */
    public void setMin() {
        min = (double) Collections.min(numbers);
        setMax();
    } //End setMin method

    /**
     * Method @getMin
     *
     * @return minimum value in arrayList: numbers
     */
    public double getMin() {
        return min;
    } //End getMin method

    /**
     * Method @setMax: determine maximum value in arrayList: numbers
     */
    public void setMax() {
        max = (double) Collections.max(numbers);
        setSD();
    } //End setMax method

    /**
     * Method @getMax
     *
     * @return maximum value in arrayList: numbers
     */
    public double getMax() {
        return max;
    } //End getMax method

    /**
     * Method @setSD: calculate standard deviation (set only, non population) of
     * values in arrayList: numbers
     */
    public void setSD() {

        int n = numbers.size();
        double sumNum = 0;
        double mean;

        for (int i = 0; i < n; i++) {
            sumNum = sumNum + (double) numbers.get(i);
        }

        mean = (sumNum / n);
        sumNum = 0;

        for (int i = 0; i < n; i++) {
            sumNum += Math.pow(((double) numbers.get(i) - mean), 2);
        }

        mean = sumNum / (n);
        double deviation = Math.sqrt(mean);
        result = deviation;
    } //End setSD method

    /**
     * Method getSD
     *
     * @return standard deviation of values in arrayList: numbers
     */
    public double getSD() {
        return result;
    }

} //End Read class
