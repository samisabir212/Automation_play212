package EdmundsCalcSuite;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Edmunds_MonthlyPayment_Calculator extends BaseAPI_URL_BY_TEST {



    private String monthly_payment = "444";
    private String zipcode = "22042";
    private String financeRate = "1.99";
    private String tradeinvalue = "15000";
    private String valueOwed = "2000";
    private String cashDownPayment = "5000";


    @Parameters({"url"})
    @Test(enabled = true)
    public void what_can_i_afford(String url) {


        //launch app navigate to edmunds
        driver.get(url);
        log.debug("Edmunds Calc app is launched");

        maximize_ToolKit();
        implicitWait((long) 10);

        //verify you are on edmunds.com/calculators page
        //verifyURL("http://edmunds.com/calculators");

        getCurrentPageUrl();
        waitForElement(10, By.id("calc_input3"));
        //enter 444 in 'enter monthly payment field'
        //typeByID("calc_input3",System.getProperty(OR.getProperty("monthly_payment")));
        typeByID("calc_input3", monthly_payment);
        waitForElement(3, By.cssSelector("button[class='medium blue button calculator-go']"));

        //click go button
        //clickByCss("button[class='medium blue button calculator-go']");
        clickByXpath("//div[@id='calc_index_affordability_calc']/form[@action='/calculators/affordability.html']//button[@name='Go']/span[.='Go']");
        //okAlert();
        goBackToHomeWindow();
        // clickByXpath("//div[@id='calc_index_affordability_calc']/form[@action='/calculators/affordability.html']//button[@name='Go']/span[.='Go']");

        waitForElement(20, By.id("ac_zip_code"));
        //enter 22042 in zipcode field
        //typeBy(By.id("ac_zip_code"), System.getProperty(OR.getProperty("zipcode")));
        typeBy(By.id("ac_zip_code"), zipcode);

        //click 'update zipcode' button
        click(By.id("ac_zip_code_update"));

        //select '72 months' as loan term from drop down list
        selectFromDropDownList(By.name("ac_loan_term"), "72 months", 3);


        //enter '1.99' in finance field
        //typeBy(By.id("ac_market_finance_rate"),System.getProperty(OR.getProperty("financeRate")));
        typeBy(By.id("ac_market_finance_rate"), financeRate);


        //enter '15000' in "Value of Your Trade-In " field
        //typeBy(By.id("ac_vehicle2_price"), System.getProperty(OR.getProperty("tradeinvalue")));
        typeBy(By.id("ac_vehicle2_price"), tradeinvalue);

        //enter '' in "Amount Owed on Your Trade-In "
        typeBy(By.id("ac_vehicle2_value_owed"), valueOwed);


        //enter '' in "Cash Down Payment "
        typeBy(By.id("ac_cash_down_payment"), cashDownPayment);

        //waitUntilClickAble(By.xpath("//fieldset[@class='calc-calculate-button']//button[@id='calculate-button']"));
        //click calculate button
        //clickByXpath("//fieldset[@class='calc-calculate-button']//button[@id='calculate-button']");

        clickJavaScriptActionsClick(By.id("calculate-button"));



        okAlert();

        //verify expected resullt vs actual result


    }

}
