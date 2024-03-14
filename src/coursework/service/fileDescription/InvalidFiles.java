package coursework.service.fileDescription;

import coursework.logger.LogRecorder;
import coursework.util.constant.IFolderPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static coursework.util.constant.ILogMessages.COMPLETE_INFO_MES_LOGS;

/**
 *The invalidFiles method sorts files and puts all invalid files in a separate folder
 */
public class InvalidFiles {

    public static void invalidFiles(File file) throws IOException {

        if (!FileChecking.fileIsTrue(file)) {

            Files.copy(file.toPath(), new File(IFolderPath.INVALID_FOLDER + File.separator + file.getName()).toPath());
            Files.delete(file.toPath());
        }
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + ":Invalid files have been moved to a separate folder");
    }

}
