package PagesPackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class productDetails_page {
    AppiumDriver driver;

    By addquantity = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup");
    By morequantity = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup");
    By close = By.xpath("//android.widget.TextView[@text=\"Close\"]");

    By cartbtn = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");

    public productDetails_page(AppiumDriver driver){
        this.driver = driver;
    }
    public void setAddquantity() {
        driver.findElement(addquantity).click();
        for (int i = 0; i < 2; i++) {
            driver.findElement(morequantity).click();
        }
    }

    public void setClose(){
        driver.findElement(close).click();
    }
    public void setCartPage(){
        driver.findElement(cartbtn).click();
    }



}
