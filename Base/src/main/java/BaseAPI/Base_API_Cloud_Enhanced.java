package BaseAPI;

import Utilities_Base.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base_API_Cloud_Enhanced {

/*
    public static ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");11````
        }

        ExtentTestManager.endTest();

        extent.flush();

        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }*/

    public static WebDriver driver = null;
    private String saucelabs_username = "";
    private String browserstack_username = "";
    private String saucelabs_accesskey = "";
    private String browserstack_accesskey = "";

    @Parameters({"useCloudEnv",
            "cloudEnvName",
            "useGrid",
            "os",
            "os_version",
            "browserName",
            "browserVersion",
            "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv,
                      @Optional("false")String cloudEnvName,
                      @Optional("false") boolean useGrid,
                      @Optional("Windows") String os,
                      @Optional("Sierra") String os_version,
                      @Optional("firefox") String browserName,
                      @Optional("34") String browserVersion,
                      @Optional("http://www.amazon.com") String url)throws IOException {
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName, browserstack_username, browserstack_accesskey, os,os_version, browserName, browserVersion);

            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else if (useGrid == true){
            //run in local
        }else{

            getLocalDriver(os, browserName);


        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public WebDriver getLocalDriver(@Optional("Mac") String os,String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("Mac")){
                System.setProperty("webdriver.chrome.driver", "/Users/sami/Desktop/RocketLauncher/Mac/Drivers/chromedriver2_25");
            }else if(os.equalsIgnoreCase("Win")){
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            if(os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver", "../Base/src/main/java/Drivers/geckodriverMAC");
            }else if(os.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();

        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;

    }

    public WebDriver getLocalGridDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String envName,
                                    String envUsername,
                                    String envAccessKey,
                                    String os,
                                    String os_version,
                                    String browserName,
                                    String browserVersion)
                                    throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }

    public WebDriver getGridDriver(String platform,
                                   String browserName,
                                   String browserVersion) throws MalformedURLException {


        //passing node url to remote driver
        String nodeURL = "http://192.168.1.175:4444/wd/hub";

        WebDriver driver = null;

        DesiredCapabilities caps = new DesiredCapabilities();

        // Platforms
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            caps.setPlatform(org.openqa.selenium.Platform.MAC);
        }
        if (browserName.equalsIgnoreCase("Linux")) {
            caps.setPlatform(org.openqa.selenium.Platform.LINUX);
        }

        // Browsers
        if (browserName.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            caps = DesiredCapabilities.firefox();
        }
        // Version
        caps.setVersion(browserVersion);

        driver = new RemoteWebDriver(new URL(nodeURL), caps);
        // Maximize the browserName's window
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open the Application
        //driver.get(url);
        return driver;


    }

    @AfterMethod
    public void cleanUp(){
        System.out.println("It has been called");
        driver.quit();
    }





    /*******************************ACTION METHODS****************************************/


    /*******************************MAXIMIZE WINDOWS FOR DIFFERENT BROWSERS****************************************/

    public void maximize_IEandFirefox_Browsers() {

        driver.manage().window().maximize();


    }

    public void maximize_ToolKit() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenResolution = new Dimension((int)
                toolkit.getScreenSize().getWidth(), (int)
                toolkit.getScreenSize().getHeight());

        driver.manage().window().setSize(screenResolution);

    }

    /***********************************************************************/



    /*******************************CLICKING ACTIONS****************************************/

    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    //click by xpath
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    //click by css
    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    //click by locator
    public void click(By locator) {

        driver.findElement(locator).click();

    }

    /*******************************JAVA SCRIPT ACTIONS CLASS CLICKING****************************************/

    public void clickJavaScriptActionsClick(By locator) {

        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        /*
        * 1. The element is not visible to click.
        * 2. The page is getting refreshed before it is clicking the element.
        * 3. The element is clickable but there is a spinner/overlay on top of it

            in some cases this will happen and we have to us the Javascript Actions class
        * */
    }

    /***********************************************************************/

    /**********TYPE SEND KEYS  (typing in fields)*********/

    public void typeBy(By locator, String value) {

        driver.findElement(locator).sendKeys(value);



    }


    public void typeByCss(String locator, String value) {

        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    //typeing by id locator
    public void typeByID(String locator, String value) {

        driver.findElement(By.id(locator)).sendKeys(value);
    }

    //type by id and enter key
    public void typeByIdEnter(String locator, String value) {

        driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
    }


    //type by xpath and ENTER key
    public void typeByXpathEnter(String locator, String value) {

        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }

    //type by css and ENTER key
    public void typeByCssEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    //type by xpath
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    //?????
    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }


    /***************************Select from dropdown list***************************************/


    public void selectFromDropDownList(By locator, String text, int index) {

        Select DropDownList = new Select(driver.findElement(locator));
        DropDownList.selectByVisibleText(text);
        DropDownList.selectByIndex(index);

    }

    public void selectOptionByVisibleText(By locator, String value) {
        WebElement object = driver.findElement(locator);
        Select select = new Select(object);
        select.selectByVisibleText(value);
    }


    /*****************************CLEAR INPUT FIELD*************************************/


    public void clearInputField(By locator) {

        driver.findElement(locator).clear();
    }


    //pass the locator and pass the type of locator and it will automatically generate
    public WebElement getElement(String locator, String type) {


        type = type.toLowerCase();

        if (type.equals("id")) {
            System.out.println("Element found with id: " + locator);// you can change it and make it print ID by changing locator to type
            return this.driver.findElement(By.id(locator));
        }
        else if (type.equals("xpath")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        }
        else if (type.equals("css")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.cssSelector(type));
        }
        else if (type.equals("linktext")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.linkText(locator));
        }
        else if (type.equals("partiallinktext")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.partialLinkText(type));
        }
        else {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    //get Links
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }


    public List<String> getTextFromWebElements(String locator){


        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }

        return text;
    }



    //verifying >>>>>>><<<<<<<<<<<<>>>>>>>>>>>><<<<<<<<<<<<<>>>>>>>

    public void verifyRadioButtonSelection(String locator) {
        WebElement roundTripRadioBtn = driver.findElement(By.id(locator));

        boolean radioButton = roundTripRadioBtn.isSelected();

        System.out.println(radioButton);

        if (radioButton = true) {
            System.out.println("(Passed) Radio Button is selected");

        } else {
            System.out.println("(failed) Radio button not selected ");
        }


    }

    public void verifyTextFieldisDisplayed(String locator) {

        WebElement textField = driver.findElement(By.id(locator));
        boolean textFieldObject = textField.isDisplayed();

        if (textFieldObject = true) {
            System.out.println("(Pass) text field is present");

        } else {

            System.out.println("(Fail) Text field is not present");

        }
    }

    //verify a button is present
    public void verifyButtonIsPresent(String locator, String True, String False) {
        WebElement button = driver.findElement(By.xpath(locator));
        boolean verifyButton = button.isDisplayed();

        if (verifyButton = true) {
            System.out.println(True);

        } else {
            System.out.println(False);

        }
    }

    public void verifyURL(String ExpectedURL) {

        String url = driver.getCurrentUrl();

        if(url.equals(ExpectedURL)) {
            System.out.println("verify url :: Passed");
        }else {
            System.out.println("verify url :: Failed");
        }

    }

    public void verifyTitle(String ExpectedTitle) {


        String title = driver.getTitle();

        if(title.equals(ExpectedTitle)) {
            System.out.println("verify title :: Passed");
        }else {
            System.out.println("verify title :: Failed");
        }


    }

    public String getCurrentPageUrl() {

        String url = driver.getCurrentUrl();

        System.out.println(url.toString());

        return url;
    }

    //***********************************************




    /*sleep*/
    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }



    //***********************************************


    //get list of dropdown option1
    public void getDropDownList(String locator) {

        //if this doesnt work, use getAllOptions() method
        List<WebElement> options = driver.findElements(
                By.xpath(locator));

        List<String> text = new ArrayList<String>();
        for(int i=1; i<options.size(); i++) {
            text.add(options.get(i).getText());
        }

    }




    //get list of dropdown option2
    public List<String> getAllOptions(By by) {
        List<String> options = new ArrayList<String>();
        for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
            String txt = option.getText();
            if (option.getAttribute("value") != "") options.add(option.getText());
        }
        return options;
    }






    //get list of elements by xpath
    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));

        return list;

    }



    public List<WebElement> getListOfWebElementsByID(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));

        System.out.println(list.toString());

        return list;
    }

    public List<WebElement> printListOfWebElementsByID(String locator) {

        WebElement element = driver.findElement(By.id(locator));
        Select sel = new Select(element);
        List<WebElement> options = sel.getOptions();
        int size = options.size();
        System.out.println("***Data from WebApp***");

        for (int i = 0; i < size; i++) {

            String optionName = options.get(i).getText();
            System.out.println(optionName);

        }


        return options;
    }


    public List<String> getListOfString(List<WebElement> list) {

        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {

            items.add(element.getText()); //using the Element Text
        }
        return items;

    }


    //*********************SCREEN SHOT**************************

    //used to capture screen shot create file name
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) Math.random() * characters.length();
            sb.append(characters.charAt(index));

        }
        return sb.toString();


    }


    //***********************************************


    //handling Alert
    public boolean isAlertPresent() {

        try{
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void alertAccept() throws InterruptedException {

        WebDriver driver = null;
        Alert alert = driver.switchTo().alert();

        alert.accept();
    }


    //same as alertAccept method
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }


    public void getAlertText(Alert verifiedText) {

        Alert text = driver.switchTo().alert();
        System.out.println("Text of the alert is : " + text);

        if (verifiedText != text) {
            System.out.println("alert does not equal : " + verifiedText);

        }

    }


    //iFrame Handle
    public void iframeHandle(WebElement element) {

        //make sure you get the id or name of the iframe and pass it as element
        //so create a variable and store the webelement object and pass it to the method parameter
        driver.switchTo().frame(element);

    }

    //counting iframe handles
    public void countIframeHandles(String tagNameLocator) {

        int iFrameElements = driver.findElements(By.tagName(tagNameLocator)).size();

        System.out.println("total count of iframes on this page is : " + iFrameElements);

    }

    public void goBackToHomeWindow(){


        driver.switchTo().defaultContent();
    }


    //Working with Window Handles
    public void getWindowHandle() {
        //returns parent window handle
        String primeWindow = driver.getWindowHandle();

    }

    //switching from parent window to child window
    public void switchParentToChildWindow() {

        Set<String> allWindows = driver.getWindowHandles();

        Iterator<String> allWindow = allWindows.iterator();

        String parentWindow = allWindow.next();

        String childWindow = allWindow.next();

        driver.switchTo().window(childWindow);



    }

    public void getAllWindowHandles() {

        Set<String> allWindows = driver.getWindowHandles();

        System.out.println(allWindows);

    }


    public void navigateBack(){


        driver.navigate().back();
    }


    public void navigateForward(){
        driver.navigate().forward();
    }

    //***************************************************


    //wait for element to be clickable by any type
    public void waitUntilClickable_UsingBy(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((locator)));


    }

    //wait for element to be clickable by xpath
    public void waitUntilClickAble(By locator){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }


    //wait for page to load completely
    public void implicitWait(int impWait,int pageLoadT) {

        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);


    }




    //use this as an example to all other wait types
    public void waitUntilVisible(By locator){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Explicit wait for an element to be present and then utilize it
    public WebElement waitForElement(int timeout, By locator) {

        WebElement element = null;

        try {
            //create an element object before action

            System.out.println("waiting for maximum :: " + timeout + "seconds for the element to be available");
            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("element appeared on the webpage");

        } catch (Exception e) {

            System.out.println("element not appeared on the webpage");

        }
        return element;

    }


    //wait for element to be selecatable by any locator using By
    public void waitUntilSelectable(By locator){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));

        //create an element object before action
    }


    public void mouseHoverByCSS(String locator){
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }


    //mousehover by
    public void mouseHover(By locatorAttemp1, By locatorAttempt2) {

        try {
            WebElement element = driver.findElement(locatorAttemp1);
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception e) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(locatorAttempt2);
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }

    }

    public void mouseHoverByXpath(String locator){
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }


    //drag and drop using By method
    public void dragAndDropByAnyLocatorType(By fromLocator, By toLocator) throws InterruptedException {


        WebElement fromElement1 = driver.findElement((fromLocator));
        WebElement toElement1 = driver.findElement((toLocator));

        Actions action = new Actions(driver);

        // Click and hold, move to element, release, build and perform
        action.clickAndHold(fromElement1).perform();
        sleepFor(2);
        action.moveToElement(toElement1).perform();
        sleepFor(2);
        action.release(toElement1).perform();


    }

    //Drag and drop method option1
    public void dragAndDrop(String fromLocatorXpath, String toLocatorXpath) throws InterruptedException {


        WebElement fromElement1 = driver.findElement(By.xpath(fromLocatorXpath));
        WebElement toElement1 = driver.findElement(By.xpath(toLocatorXpath));

        Actions action = new Actions(driver);

        // Click and hold, move to element, release, build and perform
        action.clickAndHold(fromElement1).perform();
        sleepFor(2);
        action.moveToElement(toElement1).perform();
        sleepFor(2);
        action.release(toElement1).perform();

    }

    //drag and drop method option2
    public void dragAndDropMethod(String fromLocatorXpath, String toLocatorXpath) {


        WebElement fromElement1 = driver.findElement(By.xpath(fromLocatorXpath));
        WebElement toElement1 = driver.findElement(By.xpath(toLocatorXpath));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(fromElement1, toElement1);


    }

    //getting  coordinates of window
    public void getWindowCoordinates() {

        int xCoordinate = driver.manage().window().getPosition().getX();
        int yCoordinate = driver.manage().window().getPosition().getY();

        System.out.println("x Coordinate is " + xCoordinate);
        System.out.println("y Coordinate is " + yCoordinate);

/*
        Point point = driver.manage().window().getPosition();

        point.getX();
        point.getY();

*/

    }


    public static void moveToNewWindows(WebDriver driver, String windowTitle) {
        boolean windowExists = false;
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(windowTitle)) {
                windowExists = true;

                break;
            }
        }
        if (!windowExists) {
            Assert.fail(windowTitle + " Title window not exists");
        }
    }





    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }



    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }

    public String getTextByXpath(String locator){
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextById(String locator){

        return driver.findElement(By.id(locator)).getText();
    }


    public String getTextByName(String locator){
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }



    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }




    public static void captureScreenshot(WebDriver driver, String screenshotName){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }

    }
    //Taking Screen shots
    public void takeScreenShot()throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));
    }

    public void upLoadFile(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }
    public void clearInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void keysInput(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public String converToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }



}
