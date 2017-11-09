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

public class OpenAccountTest extends BaseAPIs {


	@Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP", enabled = true)
	public void openAccountTest(Hashtable<String, String> data) throws MalformedURLException, InterruptedException {



		ExcelReader excel = new ExcelReader(Constants.BankManagerSuite_XLPATH);

		DataUtil.checkExecution("BankManagerSuite", "OpenAccountTest", data.get("Runmode"), excel);

/*
		waitUntilClickAble(".//div[@class=‘ng-scope’]//button[@ng-click=‘customer()’]");
		clickByXpath(".//div[@class=‘ng-scope’]//button[@ng-click=‘customer()’");*/

		clickByCss("div.center:nth-child(1) > button:nth-child(1)");
		sleepFor(4);

		selectOptionByVisibleText("userSelect",data.get("customer"));



		sleepFor(3);









	}

}
