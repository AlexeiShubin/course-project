package coursework.logger;

import coursework.util.constant.ILogMessages;
import coursework.util.constant.ILogsPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The logger class contains three methods that are used to record information about errors
 * in a separate file and to record information about successfully completed operations in a separate file.
 * The method uses constants stored in the program with paths to files and text messages.
 */
public class LogRecorder implements ILogsPath {
    public static String logInfo(String START_INFO_MESSAGES_LOGS) throws IOException {
        Date date = new Date();
        String message = date + " - > " + START_INFO_MESSAGES_LOGS + "\n";
        Files.write(Paths.get(INFO_LOGS_WAY), message.getBytes(), StandardOpenOption.APPEND);
        return START_INFO_MESSAGES_LOGS;
    }
    public static String logCompl(String COMPLETE_INFO_MES_LOGS) throws IOException {
        Date date = new Date();
        String message = date + " - > " + COMPLETE_INFO_MES_LOGS + "\n";
        Files.write(Paths.get(INFO_LOGS_WAY), message.getBytes(), StandardOpenOption.APPEND);
        return COMPLETE_INFO_MES_LOGS;
    }


    public static String logErrors (String WRONG_LOGS_MES) throws IOException {
        Date date = new Date();
        String message = date + " - > " + WRONG_LOGS_MES + "\n";
        Files.write(Paths.get(LOGS_ERRORS_WAY), message.getBytes(), StandardOpenOption.APPEND);
        return WRONG_LOGS_MES;
    }
    }

