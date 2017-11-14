package Execution.Cucumber.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sami on 10/5/17.
 */
public class HomePage {


    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "find-pets-btn")
    public WebElement petFinderButton;


    @FindBy(how = How.XPATH, using = ".//div[@class='siteFooter-main-logo']")
    public WebElement footerMainLogoBottomLeftOnHomePage;


    public void verifyFooterBottomLeftOfPage() {

        if (footerMainLogoBottomLeftOnHomePage.isDisplayed()) {
            System.out.println("bottom footer is displayed");
        }


    }







}
