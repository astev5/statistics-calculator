package cstevens_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 12 Assignment
 * @Date: August 7, 2021
 * @Description: Exception Handling & File I/O
 */
//Imports

//Begin Validate subclass
public class Validate {

    //Declarations
    private boolean FLAG;

    /**
     * Method @setYesNo: Set result for checking proper entry of Yes or No to
     * continue program
     *
     * @param answer
     */
    public void setYesNo(String answer) {
        if (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))) {
            System.err.print("Exception!\nPlease enter only a Y for Yes or "
                    + "an N for No: ");
            FLAG = false;
        } else if (answer.equalsIgnoreCase("y")) {
            System.out.println();
            FLAG = true;
        } else {
            FLAG = true;
        }
    } //End setYesNo method

    /**
     * Method @getYesNo
     *
     * @return boolean value
     */
    public boolean getYesNo() {
        return FLAG;
    } //End getYesNo method

//    static boolean isInteger(int number){
//        return Math.ceil(number) == Math.floor(number); 
//    }
    /**
     * Validate a range of choices
     *
     * @param x
     * @param minVal
     * @param maxVal
     */
    public void setValidateRange(int x, int minVal, int maxVal) {
        if ((x < minVal) || (x > maxVal) /*|| (!isInteger(x))*/) {
            System.err.printf("Exception!\nPlease limit your choice to "
                    + "between %d and %d: ", minVal, maxVal);
            FLAG = false;
        } else {
            FLAG = true;
        }
    }

    /**
     * Return boolean value for range checking
     *
     * @return
     */
    public boolean getRange() {
        return FLAG;
    }

}
