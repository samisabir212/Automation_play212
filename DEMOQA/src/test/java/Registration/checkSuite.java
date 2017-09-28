package Registration;

import Utilities.DataUtility;
import Utilities.ExcelReader;

/**
 * Created by sami on 9/28/17.
 */
public class checkSuite {

    public static void main(String[] args) {


        String suiteName = "DemoQASuite";

        boolean suiteRunmode = DataUtility.isSuiteRunnable(suiteName, new ExcelReader(System.getProperty("user.dir") + "/src/TestData/DemoQA_Excel.xlsx"));

        System.out.println(suiteRunmode);

    }
}
