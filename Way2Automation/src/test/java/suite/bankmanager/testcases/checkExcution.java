package suite.bankmanager.testcases;


import utilities.DataUtil;

/**
 * Created by sami on 9/29/17.
 */
public class checkExcution {


    public static void main(String[] args) {

        boolean suiteRunmode = DataUtil.isSuiteRunnable("BankManagerSuite");

                //Util.isSuiteRunnable("BankManagerSuite");

        System.out.println(suiteRunmode);

    }
}
