package com.pg.todo.utils;

import com.pg.todo.exception.IllegalArgumentException;

public class RequestUtils {

    public static int parseInt(String stringToParse, String keyName) {
        try {
            return Integer.parseInt(stringToParse);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Cannot parse " + keyName, e);
        }
    }

}
