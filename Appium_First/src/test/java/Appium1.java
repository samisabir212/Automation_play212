import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Appium1 {

    public WebDriver wd = null;


    public static void main(String[] args) throws MalformedURLException {

        File file = new File("src");
        File fis = new File(file, "ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Sami_Nexus");
        cap.setCapability(MobileCapabilityType.APP, fis.getAbsoluteFile());
        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);


    }
}
