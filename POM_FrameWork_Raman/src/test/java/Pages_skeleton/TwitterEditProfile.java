package Pages_skeleton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sami on 10/16/17.
 */
public class TwitterEditProfile extends TwitterMyProfile {


    @FindBy
    WebElement addProfilePhotoButton;

    @FindBy
    WebElement changeBioField;


    public TwitterEditProfile changePicture() {


        addProfilePhotoButton.click();


        return PageFactory.initElements(driver, TwitterEditProfile.class);


    }


    //create another method.
    //change bio

    public TwitterEditProfile changeBio() {


        changeBioField.sendKeys("my name is... slim shady");


        return PageFactory.initElements(driver, TwitterEditProfile.class);
    }

}
