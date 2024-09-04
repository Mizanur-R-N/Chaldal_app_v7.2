package testsPackage;

import PagesPackage.*;
import com.google.common.collect.ImmutableMap;
import driverPackage.Initialization;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductCart extends Initialization{

    Home_page objHome;
    cartpage objcart;
    productDetails_page objdetails;



    @Test(priority = 0)
    void AcceptApp() throws InterruptedException {
        objHome = new Home_page(driver);
        Thread.sleep(10000);
        Boolean alertvisible = objHome.alertPresent();
        System.out.println(1);
        if (alertvisible = true){
            System.out.println(1);
            objHome.setalartClk();
            Thread.sleep(10000);
            objHome.setBlankclick();
        }

        Thread.sleep(10000);
        Boolean alertvisible1 = objHome.alertPresent();
        System.out.println(1);
        if (alertvisible1 = true){
            System.out.println(1);
            objHome.setalartClk();
            Thread.sleep(10000);
            objHome.setBlankclick();
        }
    }

    @Test(priority = 1)
    void searchProduct() throws InterruptedException{
        objHome.setSearchClk();
        objHome.setSearchBarTextField(config.getProperty("search_text"));
        Thread.sleep(10000);
//        objHome.scrollToElement();
        boolean ScrollMore;
        do {
            ScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (ScrollMore);
        Thread.sleep(10000);
        objHome.setProduct();
    }



    @Test(priority = 2)
    void toProductDetails() throws InterruptedException {
        objdetails = new productDetails_page(driver);

        objdetails.setAddquantity();
        objdetails.setClose();
        objdetails.setCartPage();
    }

    @Test(priority = 3)
    void ProductCart() throws InterruptedException {
        objcart = new cartpage(driver);
            objcart.setLessquantity();

        String actual_text = objcart.getText();
        System.out.println(actual_text);
        Assert.assertEquals(actual_text,"Nothing to see here");
    }

}
