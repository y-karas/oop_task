package com.epam.task1.util;

import com.epam.task1.exceptions.MyArrayFilterException;
import com.epam.task1.exceptions.MyFileUtilException;
import com.epam.task1.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    static final Logger rootLogger = LogManager.getRootLogger();

    public static String[] readLines(String fileName) throws IOException, MyFileUtilException {
        if (fileName == "") {
            rootLogger.error("File name is empty!");
            throw new MyFileUtilException("File name is empty!");
        }
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        if (!file.exists()){
            rootLogger.error("File does not exists!");
            throw new MyFileUtilException("File does not exists!");
        }
        rootLogger.debug("Read lines from file {}", fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        List<String> lines = new ArrayList<String>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
            rootLogger.debug("Read line: {}", line);
        }

        bufferedReader.close();

        rootLogger.debug("File was successfully read.");
        return lines.toArray(new String[lines.size()]);
    }

    public static double[][] parsingLines(String[] lines) throws MyFileUtilException{
        rootLogger.debug("Start to parse lines");
        if (lines.length == 0){
            rootLogger.error("Lines to parse are not exists!");
            throw new MyFileUtilException("Lines to parse are not exists!");
        }
        double parsedLines[][] = new double[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String[] splitedValues = lines[i].split(" ");
            double values[] = new double[0];
            int count = 0;
            for (int j = 0; j < splitedValues.length; j++) {
                boolean isValidDoubleValue = Validation.isValidDoubleValue(splitedValues[j]);
                if (isValidDoubleValue) {
                    values = increaseSizeOfArray(values);
                    double value = Double.parseDouble(splitedValues[j]);
                    values[count] = value;
                    count++;
                }
            }
            rootLogger.debug("Parsed line is {}", values);
            parsedLines[i] = values;
        }
        rootLogger.debug("All lines are parsed.");
        return parsedLines;
    }


    private static double[] increaseSizeOfArray(double[] arr) {
        rootLogger.debug("Start to increase size of array");
        double[] brr = new double[(arr.length + 1)];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        rootLogger.debug("Array length was increased from {} to {}", arr.length, brr.length);
        rootLogger.debug("End to increase size of array");
        return brr;
    }
}
