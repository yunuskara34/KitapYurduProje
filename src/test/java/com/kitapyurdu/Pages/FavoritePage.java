package com.kitapyurdu.Pages;

import com.kitapyurdu.Base.BaseTest;
import com.kitapyurdu.Methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.kitapyurdu.Constants.Constants.*;

public class FavoritePage {
    WebDriver driver;
    Methods methods;
    public FavoritePage(){
        driver = BaseTest.driver;
        methods = new Methods();
    }
    public void assertFavoritePage() {
        methods.waitBySeconds(3);
        String actualValue= methods.getText(By.cssSelector(".favorite-tag"));
        String expectedValue="etiketsiz\\\\n4";
        methods.assertPage("Ürün favorilere eklenmemiş",expectedValue,actualValue);
    }
    public void switchPage(){
        methods.waitBySeconds(3);
        WebElement element= methods.findElement(By.xpath("//a[.=\'Listelerim\']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        methods.waitBySeconds(3);
        methods.click(FAVAROİTE_PAGE_LOCATER);

    }

    public void addProductToFavorites(){
        for (int i = 2; i < 6; i++) {
            methods.waitBySeconds(2);
            methods.scrollWithAction(By.xpath("(//div[@class='product-cr']//img)["+i+"]"));
            methods.click(By.xpath("(//div[@class='product-cr']//a[@class='add-to-favorites'])["+i+"]"));
        }

    }


    public void favoriteProductDeleteByIndex(){
        methods.waitBySeconds(3);
        if (methods.iselementToBeClickable(By.cssSelector(".sprite.display-item"))){
            methods.click(By.xpath("//span[@class='sprite sprite-icon-list']"));

        }
        methods.click(By.xpath("(//div[@class='product-list']//i[@class='fa fa-heart-o'])[3]"));
        methods.waitBySeconds(2);
    }
}
