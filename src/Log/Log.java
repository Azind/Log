package Log;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    protected String _path;
    protected String[] _paths = new String[64];
    public Log(String path) {
        _path = path;
    }
    public Log(String[] paths) {
        _paths = paths;
    }
    public Log() {}
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
    public static void log(String content) {
        System.out.println(content);
    }
    /**
     * <h1>Print logs in console</h1>
     * @param content
     */
    public static void log(String[] content) {
        for (String line:
                content)
            System.out.println(line);
    }
    public static void log(String content, boolean withDate) {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
            Date date = new Date();
            System.out.println(dateFormat.format(date) + content);
        }
        else System.out.println(content);
    }
    public static void log(String[] content, boolean withDate) {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
            Date date = new Date();
            for (String line:
                    content)
                System.out.println(dateFormat.format(date) + line);
        }
        else {
            for (String line :
                    content)
                System.out.println(line);
        }
    }

    /**
     * <h1>Print log in file</h1>
     * @param content
     */
    public void logFile(String content) {
        try(FileWriter fw = new FileWriter(_path, true)) {
            fw.append(content + "\n");
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
                    content)
                fw.append(line + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logFile(String content, boolean withDate) {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
            Date date = new Date();
            try (FileWriter fw = new FileWriter(_path, true)) {
                fw.append(dateFormat.format(date) + content + "\n");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileWriter fw = new FileWriter(_path, true)) {
                fw.append(content + "\n");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void logFile(String[] content, boolean withDate)
    {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
            Date date = new Date();
            try (FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content)
                    fw.append(dateFormat.format(date) + line + "\n");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content)
                    fw.append(line + "\n");
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
            try(FileWriter fw = new FileWriter(_path, true)) {
                fw.append(content + "\n");
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
            try(FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content)
                    fw.append(line + "\n");
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
                DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
                Date date = new Date();
                try (FileWriter fw = new FileWriter(_path, true)) {
                    fw.append(dateFormat.format(date) + content + "\n");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try (FileWriter fw = new FileWriter(_path, true)) {
                    fw.append(content + "\n");
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
                DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
                Date date = new Date();
                try (FileWriter fw = new FileWriter(_path, true)) {
                    for (String line:
                            content)
                        fw.append(dateFormat.format(date) + line + "\n");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try (FileWriter fw = new FileWriter(_path, true)) {
                    for (String line:
                            content)
                        fw.append(line + "\n");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
