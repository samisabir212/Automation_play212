package UtilitiesDQ;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by sami on 11/12/17.
 */
public class DataProvidors_RegistrationDQ {

    @DataProvider(name="RegistrationExcelDP")
    public static Object[][] getDataRegitration(Method method) {

        System.out.println(method.getName());
        ExcelReader excel = new ExcelReader(Constants.RegistrationFormTests);
        String testcase = method.getName();
        return DataUtil.getData(testcase, excel);

    }

}
