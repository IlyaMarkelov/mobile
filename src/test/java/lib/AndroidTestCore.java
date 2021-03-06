package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidTestCore extends TestCase {

    protected AppiumDriver driver;
    private static final String Appium_URL = "http://127.0.0.1:4723/wd/hub";


    @Override
    protected void setUp() throws  Exception {

        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("appPackage","ru.webinar.mobile");
        capabilities.setCapability("appActivity","UI.Activity.LoadingActivity");
        capabilities.setCapability("automationName","Appium");
        //capabilities.setCapability("noReset", false);
        capabilities.setCapability("app","/Users/ilya_markelov/Downloads/webinar_v2.1.10rc3.apk");

        driver = new AndroidDriver(new URL(Appium_URL), capabilities);
        this.rotateScreenPortrait();
    }

    @Override
    public void tearDown() throws  Exception {

        super.tearDown();
        driver.quit();
    }

    protected  void rotateScreenPortrait() {driver.rotate(ScreenOrientation.PORTRAIT); }
    protected  void rotateScreenLandscape() {driver.rotate(ScreenOrientation.LANDSCAPE);}
}
