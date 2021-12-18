package Log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String _path;
    private String[] _paths = new String[64];
    public Log(String path) {
        _path = path;
    }
    public Log(String[] paths) {
        _paths = paths;
    }
    public Log() {}

    public void set_path(String path) {
        _path = path;
    }

    public void set_paths(String[] paths) {
        _paths = paths;
    }

    public String get_path() {
        return _path;
    }
    public String[] get_paths() {
        return _paths;
    }

    public static void log(String content) {
        System.out.println(content);
    }
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

    public void logFile(String content) throws IOException {
        try(FileWriter fw = new FileWriter(_path, true)) {
            fw.append(content + "\n");
        }
    }
    public void logFile(String[] content) throws IOException {
        try(FileWriter fw = new FileWriter(_path, true)) {
            for (String line:
                    content)
                fw.append(line + "\n");
        }
    }
    public void logFile(String content, boolean withDate) throws IOException {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
            Date date = new Date();
            try (FileWriter fw = new FileWriter(_path, true)) {
                fw.append(dateFormat.format(date) + content + "\n");
            }
        }
        else {
            try (FileWriter fw = new FileWriter(_path, true)) {
                fw.append(content + "\n");
            }
        }
    }
    public void logFile(String[] content, boolean withDate) throws IOException
    {
        if(withDate) {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
            Date date = new Date();
            try (FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content)
                    fw.append(dateFormat.format(date) + line + "\n");
            }
        }
        else {
            try (FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content)
                    fw.append(line + "\n");
            }
        }
    }

    public void logFiles(String content) throws IOException {
        for (String path:
                _paths) {
            try(FileWriter fw = new FileWriter(_path, true)) {
                fw.append(content + "\n");
            }
        }
    }
    public void logFiles(String[] content) throws IOException {
        for (String path:
                _paths) {
            try(FileWriter fw = new FileWriter(_path, true)) {
                for (String line:
                        content)
                    fw.append(line + "\n");
            }
        }
    }
    public void logFiles(String content, boolean withDate) throws IOException {
        for (String path:
                _paths) {
            if(withDate) {
                DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ");
                Date date = new Date();
                try (FileWriter fw = new FileWriter(_path, true)) {
                    fw.append(dateFormat.format(date) + content + "\n");
                }
            }
            else {
                try (FileWriter fw = new FileWriter(_path, true)) {
                    fw.append(content + "\n");
                }
            }
        }
    }
    public void logFiles(String[] content, boolean withDate) throws IOException {
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
            }
            else {
                try (FileWriter fw = new FileWriter(_path, true)) {
                    for (String line:
                            content)
                        fw.append(line + "\n");
                }
            }
        }
    }
}
