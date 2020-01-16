package Arrays;

import java.math.BigInteger;

/**
 *Given a string, the task is to find whether it contains an additive sequence or not.
 *  A string contains an additive sequence if its digits can make a sequence of
 *  numbers in which every number is addition of previous two numbers.
 *  A valid string should contain at least three digit to make one additive sequence.
 *
 *  Problem statement:
 *  Input : s = “235813”
 * Output : true
 * 2 + 3 = 5, 3 + 5 = 8, 5 + 8 = 13
 */

public class AdditiveNumber {

    public static  boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 0; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i >= 0) {
                break;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i + 1)); //Pick first number from string

            for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= num.length() - j - 1 ; j++) { //Grouping
                if (num.charAt(i + 1) == '0' && j > i) {
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i + 1, j + 1));
                if (isValid(num, j + 1, x1, x2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(String num, int start, BigInteger x1, BigInteger x2) {
        if (start == num.length()) {
            return true;
        }
        BigInteger x3 = x1.add(x2);
        return num.startsWith(x3.toString(), start) && isValid(num, start + x3.toString().length(), x2, x3);
    }

    //Driver Program

    public static void main(String[] args){
        String num = "235813";
        boolean G  = isAdditiveNumber(num);
        if(G)
        {
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}

