package com.Main;

import Log.Log;
import java.util.Random;

class Main {
    public static void logRand(Log log) {
        log.log("Random number is " + new Random().nextInt(1, 50), true);
    }

    public static void main(String[] args) {
        // Set log settings
        Log log = new Log();
        log.set_dateFormatPattern("[HH:mm:ss] ");

        // Logging random numbers
        for (int i = 0; i < 10; i++) {
            logRand(log);
        }
        // Example out:
        // [00:55:10] 17
        // [00:55:10] 50
        // [00:55:10] 35
        // [00:55:10] 49
        // [00:55:10] 26
        // [00:55:10] 7
        // [00:55:10] 43
        // [00:55:10] 10
        // [00:55:10] 22
        // [00:55:10] 8

        String[] l = log.get_logs();
        for (String str: l) {
            System.out.println(str);
        }
        // Example out:
        // Console: [00:55:10] 17
        // Console: [00:55:10] 50
        // Console: [00:55:10] 35
        // Console: [00:55:10] 49
        // Console: [00:55:10] 26
        // Console: [00:55:10] 7
        // Console: [00:55:10] 43
        // Console: [00:55:10] 10
        // Console: [00:55:10] 22
        // Console: [00:55:10] 8
    }
}