package suite.bankmanager.testcases;

import java.net.MalformedURLException;
import java.util.Hashtable;

import BaseAPI.BaseAPIs;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;


public class AddCustomerTest extends BaseAPIs {



	@Test(dataProviderClass= DataProviders.class,dataProvider="bankManagerDP",enabled = false)
	public void addCustomerTest(Hashtable<String,String> data) throws MalformedURLException, InterruptedException {


		ExcelReader excel = new ExcelReader(Constants.BankManagerSuite_XLPATH);

		DataUtil.checkExecution("BankManagerSuite", "AddCustomerTest", data.get("Runmode"), excel);

		//click bank manager button
		waitForElement(10, By.xpath(".//button[@ng-click='manager()']"));
		clickByXpath(".//button[@ng-click='manager()']");

		//click add customer button
		clickByXpath(".//button[@ng-click='addCust()']");

		//enter firstname
		waitForElement(10, By.xpath(".//input[@ng-model='fName']"));
		typeByXpath(".//input[@ng-model='fName']", data.get("firstname"));

		//type last name
		typeByXpath(".//input[@ng-model='lName']", data.get("lastname"));


		//enter postcode
		typeByXpath(".//input[@ng-model='postCd']", data.get("postcode"));

		//click add button
		waitForElement(10, By.xpath(".//button[@type='submit']"));
		//sleepFor(5);

		//click the submit button
		clickByXpath(".//button[@type='submit']");
		sleepFor(3);
		//click the okay alert
		okAlert();

	}

	
	

}
