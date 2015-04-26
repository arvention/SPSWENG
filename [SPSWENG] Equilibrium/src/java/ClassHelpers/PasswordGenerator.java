
/*  Class Name:     PasswordGenerator
*   Developer:      Jet Virtusio
*   Description:    Used to generate a random password. The password generated has 6 characters.
*/  

package ClassHelpers;

import java.util.Random;

public class PasswordGenerator {

    private static PasswordGenerator pg = new PasswordGenerator();
    private Random rand = new Random();

    /*
    *   gets a static instance object of the class.
    */
    public static PasswordGenerator getInstance() {
        return pg;
    }
    
    /*
    *   generates the random password for new accounts.
    */
    public String getPassword() {

        int randomNum;
        char cr;
        String str = "";
        int newnum;
        char[] arr = null;

        for (int c = 0; c < 6; c++) {
            randomNum = rand.nextInt((112 - 97) + 1) + 97;
            cr = (char) randomNum;
            str += cr;
        }
        
        arr = str.toCharArray();
        
        for (int c = 0; c < 1; c++) {
            randomNum = rand.nextInt((5 - 0) + 1);
            newnum = rand.nextInt((9 - 0) + 1);
            cr = Character.forDigit(newnum, 10);;
            arr[randomNum] = cr;
        }

        return new String(arr);
    }
}