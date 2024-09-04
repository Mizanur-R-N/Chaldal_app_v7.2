package PagesPackage;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_page {
    AppiumDriver driver;

    By alart1stbtn = By.id("android:id/button2");
    By blankclick = By.id("android:id/contentPanel");
    By searchicon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup");
    By searchBarTextField = By.xpath("//android.widget.EditText[@text=\"Search Products\"]");
    By product = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView");
    public Home_page(AppiumDriver driver){
        this.driver = driver;
    }

    public Boolean alertPresent(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button2")));

        if (driver.findElement(alart1stbtn).isDisplayed()){
            return true;
        }
        else
            return false;
    }
    public void setalartClk(){
        driver.findElement(alart1stbtn).click();
    }
    public void setBlankclick(){
        driver.findElement(blankclick).click();
    }

    public void setSearchClk(){
        driver.findElement(searchicon).click();
    }

    public void setSearchBarTextField(String text){
        driver.findElement(searchBarTextField).sendKeys(text);
//        driver.findElement(searchBarTextField).sendKeys(Keys.ENTER);
    }

    public void scrollToElement(){
//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Trisa Tooth Brush Focus Pro Clean Soft (Assorted colour)\"));"
//        ));
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Trisa Tooth Brush Focus Pro Clean Soft (Assorted colour)\"))")).click();
        boolean ScrollMore;
        do {
            ScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (ScrollMore);

    }

    public void setProduct() {
        driver.findElement(product).click();
    }


}
