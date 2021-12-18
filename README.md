# Logging
 
Repository for logging

**Create logger**
```java
Log log = new Log(path);

Log log2 = new Log();
log2.set_path(path);
```
Also you can set paths
```java
Log logs = new Log(paths);
```
**For get path use _get_path()_ or _get_paths()_**
```java
log.get_path(); // String path
logs.get_paths(); // String[] paths
```
**For out in console use _log(content)_**
```java
Log.log(content); // content
```
Also you can logging with date and time
```java
Log.log(content, true); // [yyyy/MM/dd HH:mm:ss] content
```
**For out in file use _logFile(content)_ or _logFiles(content)_ and _logFile(content, true)_ or _logFiles(content, true)_**
```java
log.logFile(content); // content
logs.logFiles(content, true); // [yyyy/MM/dd HH:mm:ss] content
```