package PagesPackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class cartpage {
    AppiumDriver driver;
    By lessquantity = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup");
    By nothingText = By.xpath("//android.widget.TextView[@text=\"Nothing to see here\"]");

    public cartpage(AppiumDriver driver){
        this.driver = driver;
    }
    public void setLessquantity() {
        for (int i = 0; i < 3; i++) {
            driver.findElement(lessquantity).click();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getText(){
        return driver.findElement(nothingText).getText();
    }


}
