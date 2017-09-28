package Utilities;

import org.testng.annotations.DataProvider;

/**
 * Created by sami on 9/28/17.
 *
 *
 * DATA UTILITY WITH DATA PROVIDOR FOR GETTING DATA FROM THE SHEET FROM EXCEL
 */
public class DataUtility {

    @DataProvider
    public static Object[][] getData(String testCase, ExcelReader excel) {



        //get the row count of the sheet
        int rows = excel.getRowCount(Constants.TEST_DATA_SHEET);


        // pass the testCase parameter and name it testName
        String testName = testCase;

        //the row of the test case starts at 1
        int testCaseRowNumber = 1;

        //find out where the test case will start by using the test name
        //create a loop where the test ase will start by counting and reading the testcase name

        //incrementing the testcaserownumber until we find where want to start the test.
        for ( testCaseRowNumber =1; testCaseRowNumber<=rows; testCaseRowNumber++) {

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

            testColumns++


        }


    }


}
