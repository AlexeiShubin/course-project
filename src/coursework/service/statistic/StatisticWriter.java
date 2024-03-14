package coursework.service.statistic;

import coursework.logger.LogRecorder;
import coursework.util.filePath.Check;
import coursework.util.filePath.Invoice;
import coursework.util.filePath.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static coursework.util.constant.ILogMessages.COMPLETE_INFO_MES_LOGS;
/*
the StatisticWriter class contains three methods, separate for each type of file.
methods sumChecks, sumInvoices, sumOrders open files
 */

public class StatisticWriter {

    public static double sumChecks(String path) throws IOException {
        Check.openingChecks(path);
        double sum = 0;
        for (int i = 0; i < Check.openingChecks(path).size(); i++) {
            BufferedReader reader = new BufferedReader(new FileReader(Check.openingChecks(path).get(i)));
            String str;
            while ((str = reader.readLine()) != null) {
                sum += ProcessingAStringInAFile.searchForCheckAmount(str);

            }
        }
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + "reading checks ");
        return sum;
    }

    public static double sumInvoices(String path) throws IOException {
        Invoice.openingInvoices(path);
        double sum = 0;
        for (int i = 0; i < Invoice.openingInvoices(path).size(); i++) {
            BufferedReader reader = new BufferedReader(new FileReader(Invoice.openingInvoices(path).get(i)));
            String str;
            while ((str = reader.readLine()) != null) {
                sum += ProcessingAStringInAFile.searchForInvoiceAmount(str);
            }
        }
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + "reading invoices ");
        return sum;
    }

    public static double sumOrders(String path) throws IOException {
        Order.openingOrders(path);
        double sum = 0;
        for (int i = 0; i < Order.openingOrders(path).size(); i++) {
            BufferedReader reader = new BufferedReader(new FileReader(Order.openingOrders(path).get(i)));
            String str;
            while ((str = reader.readLine()) != null) {
                sum += ProcessingAStringInAFile.searchForOrderAmount(str);
            }
        }
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + "reading orders ");
        return sum;
    }
}
