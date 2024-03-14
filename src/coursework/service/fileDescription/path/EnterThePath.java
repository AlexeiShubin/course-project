package coursework.service.fileDescription.path;

import coursework.logger.LogRecorder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static coursework.util.constant.ILogMessages.COMPLETE_INFO_MES_LOGS;
import static coursework.util.constant.ILogMessages.WRONG_LOGS_MES;

/**
 * the EnterThePath class contains two methods.
 * The enterThePath method prompts the user to enter the path to the files.
 * the pathChecking method checks whether the specified path actually exists
 */
public class EnterThePath {
    public static String enterThePath() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("enter the path to the folder: ");
        String path= scanner.nextLine();
        scanner.close();
        EnterThePath.pathChecking(path);
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + " File entered");
        return path;
    }

    private static void pathChecking(String path) throws IOException {
        File file=new File(path);
        if (!file.exists()){
            LogRecorder.logErrors(WRONG_LOGS_MES + "The file does not exist");
            System.out.println("The file does not exist");
            System.exit(1);
        }
    }
}
