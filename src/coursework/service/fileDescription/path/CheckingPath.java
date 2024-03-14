package coursework.service.fileDescription.path;

import coursework.logger.LogRecorder;

import java.io.File;
import java.io.IOException;

import static coursework.util.constant.ILogMessages.WRONG_LOGS_MES;

/**
 * The CheckingPath class contains the checkingForFolders method,
 * which will check for the presence of a file and display error information if the file does not exist
 */

public class CheckingPath {

    public static boolean checkingForFolders(File file1, String massage) throws IOException {
        if (!file1.exists()) {
            LogRecorder.logErrors(WRONG_LOGS_MES + "File not found");

            System.out.println(massage+ " not found!");
            return false;
        }
        return true;
    }
}
