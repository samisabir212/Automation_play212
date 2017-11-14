package Registration;

import BaseAPI.BaseAPI_URL_BY_TEST;
import UtilitiesDQ.Constants;
import UtilitiesDQ.DataProvidors_RegistrationDQ;
import UtilitiesDQ.DataUtil;
import UtilitiesDQ.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by sami on 11/12/17.
 */
public class Registration_DDExcel extends BaseAPI_URL_BY_TEST {


    @Parameters("url_Registration")
    @Test(enabled = true, dataProviderClass = DataProvidors_RegistrationDQ.class,dataProvider = "RegistrationExcelDP")
    public void RegistrationDemoExcel(Hashtable<String, String> data, String url_Registration) throws AWTException, InterruptedException {


        ExcelReader excel = new ExcelReader(Constants.RegistrationFormTests);

        DataUtil.checkExecution("RegistrationSuite", "AddCustomerTest", data.get("Runmode"), excel);


        driver.get(url_Registration);

        js = (JavascriptExecutor) driver;


        typeByID("name_3_firstname",data.get("firstname"));


        //enter last name
        typeByID("name_3_lastname", data.get("lastname"));


        //click married radio button
        clickByXpath(".//div[@class='radio_wrap']//input[@value='married']");

        sleepFor(3);
        //select country from drop down list
        clickByXpath(".//select[@id='dropdown_7']//option[@value='Argentina']");

        //loop through drop down list
        WebElement countryList = (driver.findElement(By.name("dropdown_7")));
        List<WebElement> countryListOptions = countryList.findElements(By.tagName("option"));
        Iterator<WebElement> iterator = countryListOptions.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getAttribute("value"));

        }

        //select month DOB
        clickByXpath(".//select[@id='mm_date_8']//option[@value=10]");

        //select day DOB

        //select year DOB



        //enter phone number
        typeByCss("input[id='phone_9']", data.get("phone_number"));

        sleepFor(4);

        js.executeScript("window.scrollBy(0,1900)");
        sleepFor(2);


        //enter username
        typeByID("username", data.get("username"));


        //enter email
        typeByID("email_1", data.get("email"));


        //upload profile picture [USE ROBOT FOR MAC}
        uploadFile("profile_pic_10", "/Users/sami/VS2.jpg");


        //enter password
        typeByID("password_2", data.get("password"));

        //enter confirmed password (make them not match)
        typeByID("confirm_password_password_2", data.get("confirm_password"));


        //assert if password notification field level is present as "weak"
        String strengthLevelBox = driver.findElement(By.id("piereg_passwordStrength")).getText();
        System.out.println(strengthLevelBox);
        assertEquals(strengthLevelBox, "Weak");

        sleepFor(3);


    }





    public void uploadFile(String locator, String vsPNGfilePath) throws InterruptedException, AWTException {

        WebElement fileInput = driver.findElement(By.id(locator));
        fileInput.click();
        sleepFor(2);
        fileInput.click();

        String filePathPNG = vsPNGfilePath;
        StringSelection stringSelection = new StringSelection(filePathPNG);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = new Robot();
        //cmd + tab
        robot.keyPress(KeyEvent.VK_META); //meta is for command for key press
        robot.keyPress(KeyEvent.VK_TAB);
        //release the key
        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.delay(2000);


        robot.delay(2000);
        //go to window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        robot.delay(2000);
        //paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2000);
        //hit the enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease((KeyEvent.VK_ENTER));
        robot.keyRelease((KeyEvent.VK_ENTER));
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease((KeyEvent.VK_ENTER));
        robot.keyRelease((KeyEvent.VK_ENTER));

        sleepFor(5);


    }







}


