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
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_RESET = "\u001B[0m";

    public Log(String path) {
        _path = path;
    }
    public Log(String[] paths) {
        _paths = paths;
    }
    public Log() {}

    /**
     * <h4>Set pattern</h4>
     * @param pattern <ul>
     *                <li>yy - last 2 numbers of year</li>
     *                <li>yyyy - full year</li>
     *                <li>MM - month</li>
     *                <li>dd - day</li>
     *                <li>HH - hour</li>
     *                <li>hh - 12-hour time</li>
     *                <li>mm - minutes</li>
     *                <li>ss - seconds</li>
     *                <li>a - AM/PM</li>
     *                </ul>
     *                <h3>Example:</h3>
     *                [yyyy/MM/dd HH:mm:ss]
     */
    public void set_dateFormatPattern(String pattern) {
        _dateFormatPattern = pattern;
    }
    /**
     * <h4>Set path</h4>
     * @param path String
     */
    public void set_path(String path) {
        _path = path;
    }
    /**
     * <h4>Set paths</h2>
     * @param paths String[]
     */
    public void set_paths(String[] paths) {
        _paths = paths;
    }

    /**
     * <h4>Get all logs</h4>
     * @return logs
     */
    public String[] get_logs() {
        return _logs.toArray(new String[0]);
    }
    /**
     * <h4>Get path</h4>
     * @return path
     */
    public String get_path() {
        return _path;
    }
    /**
     * <h4>Get paths</h4>
     * @return paths
     */
    public String[] get_paths() {
        return _paths;
    }

    /**
     * <h4>Print log in console</h4>
     * @param content String
     */
    public void log(String content) {
        System.out.println(COLOR_GREEN + content + COLOR_RESET);
        _logs.add("Console: " + content);
    }
    /**
     * <h4>Print logs in console</h4>
     * @param content String[]
     */
    public void log(String[] content) {
        for (String line :
                content) {
            System.out.println(COLOR_GREEN + line + COLOR_RESET);
            _logs.add("Console: " + line);
        }
    }
    /**
     * <h4>Print log in console with date</h4>
     * @param content String
     * @param withDate boolean
     */
    public void log(String content, boolean withDate) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        if (withDate) {
            System.out.println(COLOR_GREEN + dateFormat.format(date) + content + COLOR_RESET);
            _logs.add("Console: " + dateFormat.format(date) + content);
        } else {
            System.out.println(COLOR_GREEN + content + COLOR_RESET);
            _logs.add("Console: " + content);
        }
    }
    /**
     * <h4>Print logs in console with date</h4>
     * @param content String[]
     * @param withDate boolean
     */
    public void log(String[] content, boolean withDate) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        if (withDate) {
            for (String line :
                    content) {
                System.out.println(COLOR_GREEN + dateFormat.format(date) + line + COLOR_RESET);
                _logs.add("Console: " + dateFormat.format(date) + line);
            }
        } else {
            for (String line :
                    content) {
                System.out.println(COLOR_GREEN + line + COLOR_RESET);
                _logs.add("Console: " + line);
            }
        }
    }
    /**
     * <h4>Print log in file</h4>
     * @param content String
     */
    public void logFile(String content) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        try (FileWriter fw = new FileWriter(_path, true)) {
            fw.append(content).append("\n");
            _logs.add("File: " + content);
        } catch (Exception e) {
            _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + content + COLOR_RESET);
            e.printStackTrace();
        }
    }
    /**
     * <h4>Print logs in file</h4>
     * @param content String[]
     */
    public void logFile(String[] content) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        try (FileWriter fw = new FileWriter(_path, true)) {
            for (String line :
                    content) {
                fw.append(line).append("\n");
                _logs.add("File: " + line);
            }
        } catch (Exception e) {
            for (String line :
                    content) {
                _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + line + COLOR_RESET);
            }
            e.printStackTrace();
        }
    }
    /**
     * <h4>Print log in file with date</h4>
     * @param content String
     * @param withDate boolean
     */
    public void logFile(String content, boolean withDate) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        try(FileWriter fw = new FileWriter(_path, true)) {
            if (withDate) {
                fw.append(dateFormat.format(date)).append(content).append("\n");
                _logs.add("File: " + dateFormat.format(date) + content);
                _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + content + COLOR_RESET);
            } else {
                fw.append(content).append("\n");
                _logs.add("File: " + content);
            }
        }
        catch (Exception e) {
            _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + content + COLOR_RESET);
            e.printStackTrace();
        }
    }
    /**
     * <h4>Print logs in file with date</h4>
     * @param content String[]
     * @param withDate boolean
     */
    public void logFile(String[] content, boolean withDate) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        try (FileWriter fw = new FileWriter(_path, true)) {
            if (withDate) {
                for (String line :
                        content) {
                    fw.append(dateFormat.format(date)).append(line).append("\n");
                    _logs.add("File: " + dateFormat.format(date) + line);
                }
            } else {
                for (String line :
                        content) {
                    fw.append(line).append("\n");
                }
            }
        } catch (Exception e) {
            for (String line :
                    content) {
                _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + line + COLOR_RESET);
            }
            e.printStackTrace();
        }
    }
    /**
     * <h4>Print log in files</h4>
     * @param content String
     */
    public void logFiles(String content) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        for (String path :
                _paths) {
            try (FileWriter fw = new FileWriter(path, true)) {
                fw.append(content).append("\n");
                _logs.add("File: " + content);
            } catch (Exception e) {
                _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + content + COLOR_RESET);
                e.printStackTrace();
            }
        }
    }
    /**
     * <h4>Print logs in files</h4>
     * @param content String[]
     */
    public void logFiles(String[] content) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        for (String path :
                _paths) {
            try (FileWriter fw = new FileWriter(path, true)) {
                for (String line :
                        content) {
                    fw.append(line).append("\n");
                }
            } catch (Exception e) {
                for (String line :
                        content) {
                    _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + line + COLOR_RESET);
                }
                e.printStackTrace();
            }
        }
    }
    /**
     * <h4>Print log in files with date</h4>
     * @param content String
     * @param withDate boolean
     */
    public void logFiles(String content, boolean withDate) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        for (String path :
                _paths) {
            try(FileWriter fw = new FileWriter(path, true)) {
                if (withDate) {
                    fw.append(dateFormat.format(date)).append(content).append("\n");
                    _logs.add("File: " + dateFormat.format(date) + content);
                } else {
                    fw.append(content).append("\n");
                    _logs.add("File: " + content);
                    _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + content + COLOR_RESET);
                }
            }
            catch (Exception e){
                _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + content + COLOR_RESET);
                e.printStackTrace();
            }
        }
    }
    /**
     * <h4>Print logs in files with date</h4>
     * @param content String[]
     * @param withDate boolean
     */
    public void logFiles(String[] content, boolean withDate) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(_dateFormatPattern);
        for (String path :
                _paths) {
            try (FileWriter fw = new FileWriter(path, true)) {
                if (withDate) {
                    for (String line :
                            content) {
                        fw.append(dateFormat.format(date)).append(line).append("\n");
                        _logs.add("File: " + dateFormat.format(date) + line);
                    }
                } else {
                    for (String line :
                            content) {
                        fw.append(line).append("\n");
                        _logs.add("File: " + line);
                    }
                }
            } catch (Exception e) {
                for (String line :
                        content) {
                    _logs.add(COLOR_RED + "ERROR: " + dateFormat.format(date) + line + COLOR_RESET);
                }
                e.printStackTrace();
            }
        }
    }
}
