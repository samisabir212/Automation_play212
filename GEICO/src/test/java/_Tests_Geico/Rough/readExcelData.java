package _Tests_Geico.Rough;

import Utilities.Constants.Constants;
import Utilities.Excel_Utility.ExcelReader;

public class readExcelData {

    public static void main(String[] args) {


        ExcelReader excel = new ExcelReader("/Users/sami/IdeaProjects/SeleniumBootCamp/GEICO/src/test/java/Utilities/Excel_Data/GeicoExcelData.xlsx");

        int rows = excel.getRowCount(Constants.DATA_SHEET);
        System.out.println("total rows are " + rows);

        String testName = "AutoInsuranceStartQuoteByZipcode";
        String testName2 = "HomeInsuranceStartQuoteByZipcode";

        int testCaseRowNum = 1;

        for(testCaseRowNum=1; testCaseRowNum<=rows; testCaseRowNum++){

			/*reading data from the zero column
			* the testcase name */
            String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);

			/*if test name then break and come out of loop*/
            if(testCaseName.equalsIgnoreCase(testName2))
                break;

        }

        System.out.println("Test case starts from row num: "+testCaseRowNum);



        //checking total rows in test case

        int dataStartRowNum = testCaseRowNum+2;

        int testrows = 0; //just creating a counter that starts at zero

        while (!excel.getCellData(Constants.DATA_SHEET,0,dataStartRowNum+testrows).equals("")) {

            testrows++;
        }

        //checking test columns

        int colStartColNum = testCaseRowNum + 1;
        int testCols = 0;


        while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")) {
            colStartColNum++;
        }

        System.out.println("total columns in this test case are : " + colStartColNum);


        //printing data

        for (int rNum = dataStartRowNum; rNum<(dataStartRowNum+testrows); rNum++) {

            for (int cNum = 0; cNum<colStartColNum; cNum++) {
                System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));

            }
        }
    }
}
