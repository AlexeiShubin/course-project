package coursework.util.filePath;

import coursework.logger.LogRecorder;
import coursework.service.fileDescription.FileChecking;
import coursework.service.fileDescription.InvalidFiles;
import coursework.service.fileDescription.path.CheckingPath;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

import static coursework.util.constant.ILogMessages.WRONG_LOGS_MES;

/**
 * the Order class contains a method that opens the Order folder
 */
public class Order{

    public static LinkedList<File> openingOrders(String path) throws IOException {
        String wayOrders = path + "//orders";
        File order = new File(wayOrders);
        LinkedList<File>trueOrders=new LinkedList<>();
        if (CheckingPath.checkingForFolders(order, "Orders")) {

            try {
                File[] orders = order.listFiles();
                for (File oneOrder : Objects.requireNonNull(orders)) {
                    if (FileChecking.fileIsTrue(oneOrder)) {
                        trueOrders.add(oneOrder);
                    } else {
                        InvalidFiles.invalidFiles(oneOrder);
                    }
                }
            } catch (NullPointerException orders) {
                throw new IOException();
            }
        }
        return trueOrders;
    }
}
