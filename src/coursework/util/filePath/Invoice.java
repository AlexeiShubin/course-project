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
 * the Invoice class contains a method that opens the Invoices folder
 */
public class Invoice{

    public static LinkedList<File> openingInvoices(String path) throws IOException {
        String wayInvoices = path + "//invoices";
        File invoice = new File(wayInvoices);
        LinkedList<File>trueInvoices=new LinkedList<>();
        if (CheckingPath.checkingForFolders(invoice, "invoices")) {

            try {
                File[] invoices = invoice.listFiles();


                for (File oneInvoice : Objects.requireNonNull(invoices)) {
                    if (FileChecking.fileIsTrue(oneInvoice)) {
                        trueInvoices.add(oneInvoice);
                    } else {
                        InvalidFiles.invalidFiles(oneInvoice);
                    }
                }
            } catch (NullPointerException invoices) {
                throw new IOException();
        }
        }
        return trueInvoices;
    }
}
