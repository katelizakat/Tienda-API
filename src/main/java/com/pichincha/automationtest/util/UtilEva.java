package com.pichincha.automationtest.util;


public class UtilEva {
    private UtilEva() {
        throw new IllegalStateException("Utility class");
    }

    public static String sleep(int timeInMillis) {
        try {
            System.out.println();
            Thread.sleep(timeInMillis);
            return "OK";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String setProp(String param) {
        System.setProperty("EVAL", param);
        return "OK";
    }

    public static String getProp(String nameEnv) {
        return System.getProperty(nameEnv);
    }
}
