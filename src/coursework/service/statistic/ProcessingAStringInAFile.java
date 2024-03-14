package coursework.service.statistic;

import coursework.logger.LogRecorder;
import coursework.util.constant.ICurrency;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static coursework.util.constant.ILogMessages.COMPLETE_INFO_MES_LOGS;

/**
 * the ProcessingAStringInAFile class contains three methods:
 * searchForCheckAmount, searchForInvoiceAmount, searchForOrderAmount for searching the information we need in files.
 * regular expressions and working with strings are used.
 * The class contains another method for converting currencies. The currencyTransfer method checks
 * each string that the previous three methods find and multiplies by the value that are stored
 * in currency transfer constants.
 */
public class ProcessingAStringInAFile {

    public static double searchForCheckAmount(String str) throws IOException {
        double num = currencyTransfer(str);
        if (str.contains("Bill total amount")) {
            Pattern pattern = Pattern.compile("[0-9]*[.,][0-9]+$");
            Matcher numStr = pattern.matcher(str);
            while (numStr.find()) {
                String newNumStr = numStr.group().replace(",", ".");
                num = num * Double.parseDouble(newNumStr);

            }
        }
        return num;
    }

    public static double searchForInvoiceAmount(String str) throws IOException {
        double num = currencyTransfer(str);
        if (str.toLowerCase().contains("total amount") || str.toLowerCase().contains("total")) {
            Pattern pattern = Pattern.compile("[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?");
            Matcher numStr = pattern.matcher(str);
            while (numStr.find()) {
                String newNumStr = numStr.group().replace(",", ".");
                num = num * Double.parseDouble(newNumStr);
            }
        }
        return num;
    }

    public static double searchForOrderAmount(String str) throws IOException {
        double num = ICurrency.USD;
        if (str.toLowerCase().replace(" ", "").contains("ordertotal")) {
            StringBuilder isNumberString = new StringBuilder();
            char[] trueElement = str.toCharArray();
            for (char s : trueElement) {
                if (Character.isDigit(s) || s == '.') {
                    isNumberString.append(s);
                }
            }
            num = num * Double.parseDouble(String.valueOf(isNumberString));
        }
        return num;
    }

    private static double currencyTransfer(String str) throws IOException {
        double trueAmount = 0;
        if (str.contains("GBR")) {
            trueAmount = ICurrency.GBR_USD;
        } else if (str.contains("EURO")) {
            trueAmount = ICurrency.EURO_USD;
        } else if (str.contains("$")) {
            trueAmount = ICurrency.USD;
        }
        LogRecorder.logCompl(COMPLETE_INFO_MES_LOGS + "Converting currency ");

        return trueAmount;
    }
}
