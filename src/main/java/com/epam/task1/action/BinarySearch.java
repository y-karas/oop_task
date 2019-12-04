package com.epam.task1.action;

import com.epam.task1.exceptions.MyBinarySearchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearch {

    static final Logger rootLogger = LogManager.getRootLogger();

    public int binarySearch(double[] arr, double searchingItem) throws MyBinarySearchException {
        if (arr.length == 0){
            throw new MyBinarySearchException("Array is empty");
        }
        rootLogger.debug("Start to search element {}", searchingItem);
        bubbleSort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int m = (l + r) >> 1;

            if (arr[m] == searchingItem) {
                rootLogger.debug("Position of element in array is {}", m);
                return m;
            }else if (arr[m] > searchingItem) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        rootLogger.debug("Element was not found");
        return -1;
    }

    public static void bubbleSort(double[] arr) {
        rootLogger.debug("Start to sort array");
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        rootLogger.debug("Sorted array: {}", arr);
    }
}
