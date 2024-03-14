package coursework.service.fileDescription;

import coursework.logger.LogRecorder;

import java.io.File;
import java.io.IOException;

import static coursework.util.constant.ILogMessages.COMPLETE_INFO_MES_LOGS;

/**
 *the FileChecking class contains three methods for sorting files.
 * and one method is needed to write the values.
 * The fileTypeCheck method checks files for the format we need.
 * The fileYearCheck method checks the relevance of files. For statistics, we only need files from 2023.
 * The fileStructureCheck method checks whether file names are spelled correctly and whether there are any typos.
 *  all checked files accept fileIsTrue and save these values.
 */
public class FileChecking {

    private static boolean fileTypeCheck(File file){
        return file.getName().endsWith(".txt");
    }

    private static boolean fileYearCheck(File file){
        return file.getName().endsWith("2023.txt") || file.getName().startsWith("2023") || file.getName().endsWith("2023_realhandy.txt");
    }

    private static boolean fileStructureCheck(File file) {
            if (file.getAbsolutePath().contains("invoices")){
                return file.getName().toLowerCase().startsWith("invoice");
            } else if (file.getAbsolutePath().contains("checks")) {
                return file.getName().toLowerCase().contains("electric_bill");
            } else if (file.getAbsolutePath().contains("orders")) {
                return file.getName().toLowerCase().contains("order");
            }

        return false;
    }

    public static boolean fileIsTrue(File file) {
        return fileTypeCheck(file) && fileYearCheck(file) && fileStructureCheck(file);
    }
}
