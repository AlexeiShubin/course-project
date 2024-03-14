package coursework.service.statistic;

import coursework.logger.LogRecorder;
import coursework.util.constant.IFolderPath;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import static coursework.util.constant.ILogMessages.COMPLETE_INFO_MES_LOGS;

/**
 * the FileWithStatistic class contains a method
 * fileWithStatistic, which sums the values and writes all statistics to a separate file
 */
public class FileWithStatistic {

    public static void fileWithStatistic(String path) throws IOException {

        double sum1 = StatisticWriter.sumChecks(path);
        double sum2 = StatisticWriter.sumInvoices(path);
        double sum3 = StatisticWriter.sumOrders(path);
        double finalSum = sum1 + sum2 + sum3;
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + "Creating statistic ");
        FileWriter finalWriter = new FileWriter(IFolderPath.STATISTIC_PATH, true);

        String sum1STR = new DecimalFormat("#0.00").format(sum1);
        String sum2STR = new DecimalFormat("#0.00").format(sum2);
        String sum3STR = new DecimalFormat("#0.00").format(sum3);
        String finalSumSTR = new DecimalFormat("#0.00").format(finalSum);

        finalWriter.write("checks sum: " + sum1STR + "\n");
        finalWriter.write("invoices sum: " + sum2STR + "\n");
        finalWriter.write("orders sum: " + sum3STR + "\n");
        finalWriter.write("total turnover: " + finalSumSTR);
        finalWriter.close();
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + ": program completed successfully ");

    }
}
