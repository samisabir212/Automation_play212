package Utilities;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

import java.util.Hashtable;

/**
 * Created by sami on 9/28/17.
 *
 *
 * DATA UTILITY WITH DATA PROVIDOR FOR GETTING DATA FROM THE SHEET FROM EXCEL
 */
public class DataUtility_Base {




    public static void checkExecution(String testSuiteName, String testCaseName, String dataRunMode,
                                      ExcelReader excel) {

        if (!isSuiteRunnable(testSuiteName)) {

            throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Suite : "
                    + testSuiteName + " is NO");

        }


        if (!isTestRunnable(testCaseName,excel)) {

            throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Case : "
                    + testCaseName + " is NO");

        }


        if(dataRunMode.equalsIgnoreCase(Constants.RUNMODE_NO)){


            throw new SkipException("Skipping the test : "+testCaseName+" as the Run mode to Data set is NO");
        }

    }




    public static boolean isSuiteRunnable(String suiteName) {



        ExcelReader excel = new ExcelReader(Constants.DEMOQA_EXCEL_PATH);

        int rows = excel.getRowCount(Constants.SUITE_SHEET);

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            String data = excel.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COLOUMN, rowNum);

            if (data.equals(suiteName)) {

                String runmode = excel.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COLOUMN, rowNum);
                if (runmode.equals(Constants.RUNMODE_YES))
                    return true;
                else
                    return false;

            }

        }

        return false;

    }



    public static boolean isTestRunnable(String testCaseName, ExcelReader excel) {

        int rows = excel.getRowCount(Constants.TESTCASE_SHEET_NAME);

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            String data = excel.getCellData(Constants.TESTCASE_SHEET_NAME, Constants.TESTCASE_COLOUMN, rowNum);

            if (data.equals(testCaseName)) {

                String runmode = excel.getCellData(Constants.TESTCASE_SHEET_NAME, Constants.RUNMODE_COLOUMN, rowNum);
                if (runmode.equals(Constants.RUNMODE_YES))
                    return true;
                else
                    return false;

            }

        }

        return false;

    }





    @DataProvider
    public static Object[][] getData(String testCase, ExcelReader excel) {



        //get the row count of the sheet
        int rows = excel.getRowCount(Constants.TEST_DATA_SHEET);


        // pass the testCase parameter and name it testName

        String testName = testCase;

        //the row of the test case starts at 1
        int testCaseRowNumber = 1;

        //find out where the test case will start by using the test name
        //create a loop where the test case will start by counting and reading the testcase name

        //incrementing the testcaserownumber until we find where want to start the test.
        for (testCaseRowNumber =1; testCaseRowNumber<=rows; testCaseRowNumber++) {

            //get the test case name cell data name store it testcase name and campare to the passed parameter "testCase"
            String testCaseName = excel.getCellData(Constants.TEST_DATA_SHEET, 0, testCaseRowNumber);

            //if the testcase name grabbed from cell data in the test data sheet equals testCase then break out the loop
            if (testCaseName.equalsIgnoreCase(testName)) {
                break;
            }

            System.out.println("Test case starts from row num: " + testCaseRowNumber);
        }


        //check the total rows in that specific testcase we just acquired depending on the testCase (testcasename)

        //data will start at the third row after the test case name and after the column name
        //testcasename row number plus 2 rows which is the the third row
        //TOTAL ROWS IN THE TESTCASE  TOTAL ROWS OF DATA!!!

        int dataStartsRowNumber = testCaseRowNumber + 2;



        /*
       the knowledge of the program will reset and start the row at zero when we
       find out where we want to start to read the data
       BASICALLY CREATING A COUNTER CALLED      testDataRows Which starts at ZERO

       THEN ADD THE COUNTER TO THE DATASTARTROWNUMBER SO THE ITERATION CAN CONTINUE TILL THE END OF THE DATA SET

       so its starting at the second row
       until it doesnt equal blank it should iterate and continue to the next row until the row equals blank
       IF IT DOESNT EQUAL BLANK INCREMENT AND CONTINUE UNTIL IT DOES equal blank.....
        * */
        int testDataRows = 0;
        while (!excel.getCellData(Constants.TEST_DATA_SHEET, 0, dataStartsRowNumber + testDataRows).equals("")) {

            testDataRows++;

        }
        System.out.println("Total rows of data are : " + testDataRows);


        //NOW WE HAVE TO CHECK THE TOTAL COLUMNS OF THE TEST CASE


        /*
        which means testcaserownumber plus one
        * */

        int columnNumberStartNumber = testCaseRowNumber + 1;

        //create a counter for the columns
        int testColumns = 0;


        /*
        * THIS IS DIFFERENT THEN HOW WE WROTE ROWS
        * we have to start the column at 0 which means we have to pass testColmns into getcelldata paramater
        * COLUMN STARTS AT ZERO AT THE MOMENT. NOT columnNumberStartNumber plus test colmns
        * WE WANT TO STAY AT THE SAME ROW NOT GO DOWN A ROW. WE WANT TO MOVE TO THE RIGHT TO THE NEXT COLUMN
        * we want to stop going to the next column until the while loop reads an empty cell
        * do this by INCREMENTING testColumns   from zero to 1 2 3 4 5 etc until BLANK!!
        * */
        while (!excel.getCellData(Constants.TEST_DATA_SHEET, testColumns, columnNumberStartNumber).equals("")) {

            testColumns++;

        }

        System.out.println("Total cols are : " + testColumns);


        //NOW WE PRINT THE DATA OUT

        //create a loop where the datastart row number equals rowNumber

        /*
        * WE CREATE A LOOP WITH AN OUTER LOOP  AND INNER LOOP
        *  create a outer loop that reads prints out the
        *
        *  data will start at the datastartrow number
        *
        *  PRINTING OUT  the data from that row number
        *  take the row number where it starts
        *
        * */

        //starting the testdatarows where the loop caught where to start the data
        //and column will be at the second row after testcase row
        Object[][] data = new Object[testDataRows][1];

        int i = 0;
        for (int rowNumber = dataStartsRowNumber; rowNumber < (dataStartsRowNumber+testDataRows); rowNumber++) {

            Hashtable<String, String> table = new Hashtable<String, String>();

            for (int columnNumber = 0; columnNumber<testColumns; columnNumber++) {


               String testData = excel.getCellData(Constants.TEST_DATA_SHEET, columnNumber, rowNumber);
               String colmnName = excel.getCellData(Constants.TEST_DATA_SHEET, columnNumber, columnNumberStartNumber);

               /*
               * column is the KEY and row is the VALUE!!!!
               * */
                table.put(colmnName, testData);


            }

            //for every row of test data we want to create a table to read from

            //test data row will start at i and column will start at 0
            data[i][0] = table;
            i++;

        }

        return data;



    }




}
