package com.epam.task1;

import com.epam.task1.action.ArrayFilter;
import com.epam.task1.action.BinarySearch;
import com.epam.task1.exceptions.MyArrayFilterException;
import com.epam.task1.exceptions.MyBinarySearchException;
import com.epam.task1.exceptions.MyFileUtilException;
import com.epam.task1.util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Runner {
    static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {

        rootLogger.info("Start application");

        ArrayFilter arrayFilter = new ArrayFilter();
        BinarySearch binarySearch = new BinarySearch();

        try {
            String[] fileLines = FileUtil.readLines("file.txt");
            double[][] allArrays = FileUtil.parsingLines(fileLines);

            rootLogger.debug("New array is {}",arrayFilter.getNewArray(allArrays[0]));

/*            for (int i = 0; i < allArrays.length; i++) {
                for (int j = 0; j < allArrays[i].length; j++) {
                    System.out.print(allArrays[i][j] + "\t");
                }
                System.out.println();
            }
*/
            rootLogger.debug("Searched element is {}",
                    allArrays[0][binarySearch.binarySearch(allArrays[0], -1.0)]);
        } catch (MyArrayFilterException | MyBinarySearchException | MyFileUtilException e) {
            rootLogger.error(e);
        } finally {
            rootLogger.info("End application");
        }
    }
}
