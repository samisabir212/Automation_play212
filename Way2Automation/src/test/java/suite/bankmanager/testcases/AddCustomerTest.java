package suite.bankmanager.testcases;

import java.net.MalformedURLException;
import java.util.Hashtable;

import BaseAPI.BaseAPIs;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;


public class AddCustomerTest extends BaseAPIs {
	
	
	
	@Test(dataProviderClass= DataProviders.class,dataProvider="bankManagerDP")
	public void addCustomerTest(Hashtable<String,String> data) throws MalformedURLException{

	}

	
	

}
