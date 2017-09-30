package Utilities;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by sami on 9/28/17.
 */
public class DataProvidors {



    @DataProvider(name="DemoQA_Registration_DP")
    public static Object[][] getdata_Regitration(Method m) {

        System.out.println(m.getName());

        ExcelReader excel = new ExcelReader(Constants.DEMOQA_EXCEL_PATH);

        String testcase = m.getName();

        return DataUtility_Base.getData(testcase, excel);

    }





}
