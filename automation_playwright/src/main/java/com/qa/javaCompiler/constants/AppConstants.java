package com.qa.javaCompiler.constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AppConstants {
    public static final String LOGIN_PAGE_TITLE = "OrangeHRM";
    public static final String FIRST_NAME = "Pham";
    public static final String MIDDLE_NAME = "Gia";
    public static final String LAST_NAME = "Bao";
    public static final String USERNAME = "giabao";
    public static final String PASSWORD = "1112002bao";
    public static final String OTHER_ID = "abc123456";
    public static final String DRIVER_LISCENCE = "387976542";
    public static final String URS_ID = "0.1.1.1";
    public static String MODULE ="";
    public static String TC_INDEX="";
    public static Integer SCREENSHOT_INDEX = 0 ;
    public static final String RANDOM_EMPLOYEE_ID;
    static {
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHH")); // 8 digits
        int randomPart = new Random().nextInt(90) + 10; // 2 digits, 10-99
        RANDOM_EMPLOYEE_ID = datePart + randomPart; // 10 digits
    }
    public static final String USERNAME_WITH_ID;
    static {
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHH")); // 8 digits
        int randomPart = new Random().nextInt(9000) + 1000; // 4 digits, 1000-9999
        USERNAME_WITH_ID = USERNAME + datePart + randomPart; // e.g., giabao0111240528101234
    }
}
