package com.epam.task1.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {

    static final Logger rootLogger = LogManager.getRootLogger();

    public static boolean isValidDoubleValue(String stringValue) {
        try {
            Double.parseDouble(stringValue);
            rootLogger.debug("{} is valid double number", stringValue);
            return true;
        } catch (NumberFormatException e) {
            rootLogger.debug("{} is not valid double number", stringValue);
            return false;
        }
    }
}
