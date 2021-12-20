package Log;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Log {
    protected String _path;
    protected String[] _paths = new String[64];
    protected String _dateFormatPattern;
    protected List<String> _logs = new ArrayList<>();
    public Log(String path) {
        _path = path;
    }
    public Log(String[] paths) {
        _paths = paths;
    }
    public Log() {}

    /**
     * <h1>Set pattern</h1>
     * @param pattern
     * <ul>
     * <li>yy - last 2 numbers of year</li>
     * <li>yyyy - full year</li>
     * <li>MM - month</li>
     * <li>dd - day</li>
     * <li>HH - hour</li>
     * <li>hh - 12-hour time</li>
     * <li>mm - minutes</li>
     * <li>ss - seconds</li>
     * </ul>
     * <h3>Example:</h3>
     * [yyyy/MM/dd HH:mm:ss]
     */
    public void set_dateFormatPattern(String pattern) {
        _dateFormatPattern = pattern;
    }
    /**
     * <h1>Set path</h1>
     * @param path
     */
    public void set_path(String path) {
        _path = path;
    }
    /**
     * <h1>Set paths</h2>
     * @param paths
     */
    public void set_paths(String[] paths) {
        _paths = paths;
    }

    /**
     * <h1>Get all logs</h1>
     * @return log
     */
    public String[] get_logs() {
        return _logs.toArray(new String[0]);
    }
    /**
     * <h1>Get path</h1>
     * @return path
     */
    public String get_path() {
        return _path;
    }
    /**
     * <h1>Get paths</h1>
     * @return paths
     */
    public String[] get_paths() {
        return _paths;
    }

    /**
     * <h1>Print log in console</h1>
     * @param content
     */
    public void log(String content) {
        System.out.println(content);
        _logs.add("Console: " + content);
    }
    /**
     * <h1>Print logs in console</h1>
     * @param content
     */
    public void log(String[] content) {
        for (String line:
                content) {
            System.out.println(line);
            _logs.add("Console: " + line);
        }
    }
    public void log(String content, boolean withDate) {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
            Date date = new Date();
            System.out.println(dateFormat.format(date) + content);
            _logs.add("Console: " + dateFormat.format(date) + content);
        }
        else {
            System.out.println(content);
            _logs.add("Console: " + content);
        }
    }
    public void log(String[] content, boolean withDate) {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
            Date date = new Date();
            for (String line:
                    content) {
                System.out.println(dateFormat.format(date) + line);
                _logs.add("Console: " + dateFormat.format(date) + line);
            }
        }
        else {
            for (String line :
                    content) {
                System.out.println(line);
                _logs.add("Console: " + line);
            }
        }
    }

    /**
     * <h1>Print log in file</h1>
     * @param content
     */
    public void logFile(String content) {
        try(FileWriter fw = new FileWriter(_path, true)) {
            fw.append(content + "\n");
            _logs.add("File: " + content);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * <h1>Print logs in file</h1>
     * @param content
     */
    public void logFile(String[] content) {
        try(FileWriter fw = new FileWriter(_path, true)) {
            for (String line:
                    content) {
                fw.append(line + "\n");
                _logs.add("File: " + line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logFile(String content, boolean withDate) {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
            Date date = new Date();
            try (FileWriter fw = new FileWriter(_path, true)) {
                fw.append(dateFormat.format(date) + content + "\n");
                _logs.add("File: " + dateFormat.format(date) + content);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileWriter fw = new FileWriter(_path, true)) {
                fw.append(content + "\n");
                _logs.add("File: " + content);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void logFile(String[] content, boolean withDate)
    {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
            Date date = new Date();
            try (FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content) {
                    fw.append(dateFormat.format(date) + line + "\n");
                    _logs.add("File: " + dateFormat.format(date) + content);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content) {
                    fw.append(line + "\n");
                    _logs.add("File: " + content);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <h1>Print log in files</h1>
     * @param content
     */
    public void logFiles(String content) {
        for (String path:
                _paths) {
            try(FileWriter fw = new FileWriter(path, true)) {
                fw.append(content + "\n");
                _logs.add("File: " + content);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <h1>Print logs in files</h1>
     * @param content
     */
    public void logFiles(String[] content) {
        for (String path:
                _paths) {
            try(FileWriter fw = new FileWriter(path, true)) {
                for (String line:
                        content) {
                    fw.append(line + "\n");
                    _logs.add("File: " + content);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void logFiles(String content, boolean withDate) {
        for (String path:
                _paths) {
            if(withDate) {
                DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
                Date date = new Date();
                try (FileWriter fw = new FileWriter(path, true)) {
                    fw.append(dateFormat.format(date) + content + "\n");
                    _logs.add("File: " + dateFormat.format(date) + content);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try (FileWriter fw = new FileWriter(path, true)) {
                    fw.append(content + "\n");
                    _logs.add("File: " + content);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void logFiles(String[] content, boolean withDate) {
        for (String path:
                _paths) {
            if(withDate) {
                DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
                Date date = new Date();
                try (FileWriter fw = new FileWriter(path, true)) {
                    for (String line:
                            content) {
                        fw.append(dateFormat.format(date) + line + "\n");
                        _logs.add("File: " + dateFormat.format(date) + content);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try (FileWriter fw = new FileWriter(path, true)) {
                    for (String line:
                            content) {
                        fw.append(line + "\n");
                        _logs.add("File: " + content);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
