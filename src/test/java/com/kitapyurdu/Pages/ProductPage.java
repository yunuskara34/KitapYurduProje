package com.kitapyurdu.Pages;

import com.kitapyurdu.Base.BaseTest;
import com.kitapyurdu.Methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.kitapyurdu.Constants.Constants.*;


public class ProductPage {
    WebDriver driver;
    Methods methods;
    public ProductPage(){
        driver = BaseTest.driver;
        methods = new Methods();
    }

    public void selectFilter(){
        methods.switchPage(POINT_PAGE_LOCATER);
        methods.waitBySeconds(2);
        methods.switchPage(TURK_KLASIKLERI_LOCATER);
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector(".sort > select"),"Yüksek Oylama");
        methods.waitBySeconds(2);
        WebElement element= methods.findElement(By.cssSelector(".js-bookCt > li:nth-of-type(3) > .mn-strong"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        methods.click(By.linkText("Hobi"));
    }
    public void addToBasket(){
        methods.waitBySeconds(1);
        methods.clickRandomInList(methods.findElements(By.xpath("//div[@class='product-cr']//img")));
        methods.selectRandomProduct();
        methods.waitBySeconds(2);
        methods.click(By.xpath("//span[.='Sepete Ekle']"));
        methods.waitBySeconds(2);
    }
}
