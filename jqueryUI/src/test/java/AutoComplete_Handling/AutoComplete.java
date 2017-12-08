package AutoComplete_Handling;

import BaseAPI.BaseAPI_Junit;
import org.junit.After;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class AutoComplete extends BaseAPI_Junit {




    @Test
    public void autocomplete() {

        typeBy(By.id("tags"), "c");
        selectOptionByVisibleText(By.xpath(".//*[@id='tags']"),"ActionScript");



    }

    @After
    public void tearItDown() {



    }
}
