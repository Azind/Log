# Log
 
Repository for logging

***

## Creating

**Create logger**
```java
Log log = new Log(path);

Log log2 = new Log();
log2.set_path(path);
```
Also, you can set paths
```java
Log logs = new Log(paths);
```
***

## Getters

**For get path use _get_path()_ or _get_paths()_**
```java
log.get_path(); // String path
logs.get_paths(); // String[] paths
```
**For get all logs use _get_logs()_**
```java
log.get_logs() // String[] logs
```
***

## Logs

**For out in console use _log(content)_**
```java
log.log(content); // content
```
Also, you can log with date and time
```java
log.log(content, true); // dateFormatPattern content
```
**For out in file use _logFile(content)_ or _logFiles(content)_ and _logFile(content, true)_ or _logFiles(content, true)_**
```java
log.logFile(content); // content
logs.logFiles(content, true); // dateFormatPattern content
```
***

## Settings

**For set date format pattern use _set_dateFormatPattern()_**<br>
format:
* yy - last 2 numbers of year
* yyyy - full year
* MM - month
* dd - day
* HH - hour
* hh - 12-hour time
* mm - minutes
* ss - seconds
* **Example:**
* [yyyy/MM/dd HH:mm:ss]
```java
log.set_dateFormatPattern("[yyyy/MM/dd HH:mm:ss] ");
```
***

## Example

```java
package com.Main;

import Log.Log;
import java.util.Random;

class Main {
    public static void logRand(Log log) {
        log.log("Random number is " + new Random().nextInt(1, 50), true);
        log.logFile("Random number is " + new Random().nextInt(1, 50), true);
    }

    public static void main(String[] args) {
        // Set log settings
        Log log = new Log();
        log.set_path("C\\example.log");
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
        // File: [00:55:10] 17
        // Console: [00:55:10] 50
        // File: [00:55:10] 50
        // Console: [00:55:10] 35
        // File: [00:55:10] 35
        // Console: [00:55:10] 49
        // File: [00:55:10] 49
        // Console: [00:55:10] 26
        // File: [00:55:10] 26
        // Console: [00:55:10] 7
        // File: [00:55:10] 7
        // Console: [00:55:10] 43
        // File: [00:55:10] 43
        // Console: [00:55:10] 10
        // File: [00:55:10] 10
        // Console: [00:55:10] 22
        // File: [00:55:10] 22
        // Console: [00:55:10] 8
        // File: [00:55:10] 8
    }
}
```
