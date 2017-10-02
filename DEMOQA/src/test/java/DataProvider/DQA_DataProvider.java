/*
package DataProvider;

import Utilities_Base.Constants;
import Utilities_Base.DataUtil;
import Utilities_Base.ExcelReader;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

*/
/**
 * Created by sami on 10/2/17.
 *//*



public class DQA_DataProvider {


    */
/*
    this is where we are getting our data.
    must look at DataUtil to see how data is being read and implemented into the test
    *//*

    @DataProvider(name = "Registration001DP", parallel = true)
    public static Object[][] getDataSuite001(Method m) {

        System.out.println(m.getName());

		*/
/*
        * just getting the excel path  and returning the testcase
		* *//*


        ExcelReader excel = new ExcelReader(Constants.RegistrationPageSuite_XLPATH);
        String testcase = m.getName();
        return DataUtil.getData(testcase, excel);

    }






}
*/
