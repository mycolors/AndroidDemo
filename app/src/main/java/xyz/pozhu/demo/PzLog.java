package xyz.pozhu.demo;

import android.text.TextUtils;
import android.util.Log;

public class PzLog {

    public final static int VERBOSE = 1;
    public final static int DEBUG = 2;
    public final static int INFO = 3;
    public final static int WARN = 4;
    public final static int ERROR = 5;
    public final static int NOTHING = 6;
    public static final String SEPARATOR = ",";

    private static int level = 0;

    public static void setLevel(int level) {
        PzLog.level = level;
    }

    public static void v(String message) {
        v("", message);
    }

    public static void v(String tag, String message) {
        if (level <= VERBOSE) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            Log.v(tag, getLogInfo(stackTraceElement) + message);
        }
    }

    public static void d(String message) {
        d("", message);
    }

    public static void d(String tag, String message) {
        if (level <= DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            Log.d(tag, getLogInfo(stackTraceElement) + message);
        }
    }

    public static void i(String message) {
        i("", message);
    }

    public static void i(String tag, String message) {
        if (level <= INFO) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            Log.i(tag, getLogInfo(stackTraceElement) + message);
        }
    }

    public static void w(String message) {
        w("", message);
    }

    public static void w(String tag, String message) {
        if (level <= WARN) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            Log.w(tag, getLogInfo(stackTraceElement) + message);
        }
    }

    public static void e(String message, Throwable throwable) {
        e("", message, throwable);
    }

    public static void e(String tag, String message, Throwable throwable) {
        if (level <= ERROR) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            Log.e(tag, getLogInfo(stackTraceElement) + message, throwable);
        }
    }

    /**
     * 获取默认的TAG名称.
     * 比如在MainActivity.java中调用了日志输出.
     * 则TAG为MainActivity
     */
    public static String getDefaultTag(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        String stringArray[] = fileName.split("\\.");
        String tag = stringArray[0];
        return tag;
    }

    /**
     * 输出日志所包含的信息
     */
    public static String getLogInfo(StackTraceElement stackTraceElement) {
        StringBuilder logInfoStringBuilder = new StringBuilder();
        // 获取线程名
        String threadName = Thread.currentThread().getName();
        // 获取线程ID
        long threadID = Thread.currentThread().getId();
        // 获取文件名.即xxx.java
        String fileName = stackTraceElement.getFileName();
        // 获取类名.即包名+类名
        String className = stackTraceElement.getClassName();
        // 获取方法名称
        String methodName = stackTraceElement.getMethodName();
        // 获取生日输出行数
        int lineNumber = stackTraceElement.getLineNumber();

        logInfoStringBuilder.append("[ ");
//        logInfoStringBuilder.append("threadID=").append(threadID).append(SEPARATOR);
//        logInfoStringBuilder.append("threadName=").append(threadName).append(SEPARATOR);
//        logInfoStringBuilder.append("fileName=").append(fileName).append(SEPARATOR);
        logInfoStringBuilder.append("className=").append(className).append(SEPARATOR);
//        logInfoStringBuilder.append("methodName=").append(methodName).append(SEPARATOR);
//        logInfoStringBuilder.append("lineNumber=").append(lineNumber);
        logInfoStringBuilder.append(" ] ");
        return logInfoStringBuilder.toString();
    }


}
