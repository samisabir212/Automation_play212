package UtilitiesDQ;


/**
 * Created by sami on 9/29/17.
 */
public class checkExcution {


    public static void main(String[] args) {

        boolean suiteRunmode = DataUtil.isSuiteRunnable("RegistrationSuite");


        System.out.println(suiteRunmode);

    }
}
