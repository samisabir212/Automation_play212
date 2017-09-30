package com.DemoQA.Suite.Registration.testcaes;

import Utilities.DataUtility_Base;

/**
 * Created by sami on 9/29/17.
 */
public class checkRunmodes {

    public static void main(String[] args) {

        boolean suiteRunmode = DataUtility_Base.isSuiteRunnable("RegistrationSuite");

        System.out.println(suiteRunmode);

    }
}
