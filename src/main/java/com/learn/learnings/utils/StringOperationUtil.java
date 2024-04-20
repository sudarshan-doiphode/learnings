package com.learn.learnings.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringOperationUtil {

    //Method to sanitize user provided data for logging
    public static String sanitizeLogData(String data) {
        return data.replace("\n", "_")
                .replace("\r", "_")
                .replace("\t", "_");
    }

    public static String generateRandomString(String prefix, int length) {
        return prefix + RandomStringUtils.randomAlphanumeric(length);
    }
}
