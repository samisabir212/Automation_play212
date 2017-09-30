package com.DemoQA.Suite.Registration.testcaes;

import Utilities.Constants;
import Utilities.DataUtility_Base;
import Utilities.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by sami on 9/29/17.
 */
public class Registration001 {




    @Test(dataProviderClass = DataProvider.class, dataProvider = "DemoQA_Registration_DP")
    public void registration001(Hashtable<String, String> data) {

        /*
        * check if testsuite is runnable
        * if testcase is runnable
        * is data runnable?
        * */

        ExcelReader excel = new ExcelReader(Constants.DEMOQA_EXCEL_PATH);

        DataUtility_Base.isSuiteRunnable("RegistrationSuite");

    }
}
