package com.epam.task1.action;

import com.epam.task1.exceptions.MyArrayFilterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.net.www.content.audio.basic;

public class ArrayFilter {

    static final Logger rootLogger = LogManager.getRootLogger();

    //-1.0 2.0 3.0
    public int[] getNewArray(double[] arr) throws MyArrayFilterException{

        rootLogger.debug("Start to generate new array");
        if (arr.length == 0){
            rootLogger.error("Input array is empty");
            throw new MyArrayFilterException("Input array is empty");
        }

        int[] filteredArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int temp = (int) Math.round(arr[i]);
            String binaryString = Integer.toBinaryString(temp);
            rootLogger.debug("Binary string of number {} is {}", temp, binaryString);
            if (isPalindrome(binaryString)) {
                filteredArr[i] = 0;
            } else {
                filteredArr[i] = temp;
            }
        }
        rootLogger.debug("Finish generate new array {}", filteredArr);
        return filteredArr;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                rootLogger.debug("{} is not palindrome", s);
                return false;
            }
        }
        rootLogger.debug("{} is palindrome", s);
        return true;
    }
}
