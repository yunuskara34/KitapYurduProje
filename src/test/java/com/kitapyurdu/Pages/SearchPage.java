package com.kitapyurdu.Pages;

import com.kitapyurdu.Methods.Methods;
import org.openqa.selenium.By;

public class SearchPage {
    Methods methods;
    public SearchPage(){
        methods = new Methods();
    }
    public void searchProduct(){
        methods.sendKeys(By.id("search-input"),"Oyuncak");
        methods.sendKeysEnter(By.id("search-input"));
       methods.scrollWithAction(By.xpath("(//div[@class='product-cr']//img)[7]"));
       methods.waitBySeconds(2);
    }

}
