/*
package Utilities.Excel_Utility;

import Utilities.Constants.Constants;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

import java.util.Hashtable;

public class TestExcelUtility extends Constants {



*/
/*
    //checking if runmode in the suite excel file in suite sheet is set to Y or N
    public static boolean isSuiteRunnable(String suiteName, ExcelReader excel) {

        int rows = excel.getRowCount(Constants.SUITE_SHEET);

        for (int rowNum = 2; rowNum<= rows; rowNum++) {

            excel.getCellData(Constants.SUITE_SHEET, Constants.COL_NAME, rowNum);

        }



    }*//*


    public static void checkExecution(String testSuiteName, String testCaseName, String dataRunMode,
                                      ExcelReader excel) {

        if (!isSuiteRunnable(testSuiteName)) {

            throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Suite : "
                    + testSuiteName + " is NO");

        }


        if (!isTestRunnable(testCaseName, excel)) {

            throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Case : "
                    + testCaseName + " is NO");

        }


        if (dataRunMode.equalsIgnoreCase(Constants.RUNMODE_NO)) {


            throw new SkipException("Skipping the test : " + testCaseName + " as the Run mode to Data set is NO");
        }

    }

    public static boolean isSuiteRunnable(String suiteName) {


        ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH);

        int rows = excel.getRowCount(Constants.SUITE_SHEET);

        //row number starts at 2.. rows gets the count of the rowcount of suite_sheet
        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            String data = excel.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rowNum);

            if (data.equals(suiteName)) {

                String runmode = excel.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COL, rowNum);

                if (runmode.equals(Constants.RUNMODE_YES))
                    return true;
                else
                    return false;

            }

        }

        return false;

    }

    //is the testcase runnable?? we check by the case name using excel reader
    public static boolean isTestRunnable(String testCaseName, ExcelReader excel) {

        int rows = excel.getRowCount(Constants.TESTCASE_SHEET);

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            String data = excel.getCellData(Constants.TESTCASE_SHEET, Constants.TESTCASE_COL, rowNum);

            if (data.equals(testCaseName)) {

                String runmode = excel.getCellData(Constants.TESTCASE_SHEET, Constants.RUNMODE_COL, rowNum);
                if (runmode.equals(Constants.RUNMODE_YES))
                    return true;
                else
                    return false;

            }

        }

        return false;

    }


    //just our data providor method below.

    @DataProvider
    public static Object[][] getData(String testCase, ExcelReader excel) {


        int rows = excel.getRowCount(Constants.DATA_SHEET);


        System.out.println("Total rows are : " + rows);

        String testName = testCase;

        // Find the test case start row

        //TESTCASE ROW!!
        int testCaseRowNum = 1;

        for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

            String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);

            if (testCaseName.equalsIgnoreCase(testName))
                break;

        }

        System.out.println("Test case starts from row num: " + testCaseRowNum);

        // Checking total rows in test case
        //TOTAL ROWS IN THE TESTCASE  TOTAL ROWS OF DATA!!!

        int dataStartRowNum = testCaseRowNum + 2;

        int testRows = 0;
        while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {

            testRows++;
        }

        System.out.println("Total rows of data are : " + testRows);

        // Checking total cols in test case

        int colStartColNum = testCaseRowNum + 1;
        int testCols = 0;

        while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")) {

            testCols++;

        }

        System.out.println("Total cols are : " + testCols);

        // Printing data

        Object[][] data = new Object[testRows][1];

        int i = 0;
        for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

            Hashtable<String, String> table = new Hashtable<String, String>();

            for (int cNum = 0; cNum < testCols; cNum++) {

                // System.out.println(excel.getCellData(Constants_Base.DATA_SHEET,
                // cNum, rNum));
                String testData = excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
                String colName = excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);

                table.put(colName, testData);

            }

            data[i][0] = table;
            i++;

        }

        return data;

    }


}
*/
