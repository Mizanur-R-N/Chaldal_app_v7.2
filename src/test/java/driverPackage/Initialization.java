package driverPackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class Initialization {
    public AppiumDriver driver;
    public AppiumDriverLocalService service;
    public static Properties config = new Properties();
    public static FileInputStream fis;

    @BeforeTest
    public void Devicesetup() throws MalformedURLException {

        //Start appium server automatically
        service = new AppiumServiceBuilder().withAppiumJS(
                new File("C:\\Users\\mhl\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }



        //setup dependency
        UiAutomator2Options opt = new UiAutomator2Options();
        opt.setDeviceName("Nexus 5X API 24");
        opt.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\app\\Chaldal_ Online Grocery_7.2.3_apkcombo.com.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }



    @AfterTest
    public void quitDriver() {
        driver.quit();
        service.stop();
    }

}
