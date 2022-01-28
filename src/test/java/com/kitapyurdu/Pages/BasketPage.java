package com.kitapyurdu.Pages;

import com.kitapyurdu.Base.BaseTest;
import com.kitapyurdu.Methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {
    WebDriver driver;
    Methods methods;
    public BasketPage(){
        driver = BaseTest.driver;
        methods = new Methods();
    }
    public void switchBasketPage(){
        methods.click(By.id("cart"));
        methods.waitBySeconds(1);
        methods.click(By.id("js-cart"));
    }
    public void addQuantity(String quantity){
        methods.clearInputArea(By.name("quantity"));
        methods.sendKeys(By.name("quantity"),quantity);
        methods.sendKeysEnter(By.name("quantity"));
    }

    public void clickBuyProduct() {
        methods.click(By.xpath("//div[@class='right']/a[contains(.,'Satın Al')]"));
    }

    public void buyProduct(){

        methods.click(By.id("button-checkout-continue"));
        methods.sendKeys(By.id("credit-card-owner"),"Yunus KARA");
        methods.sendKeys(By.id("credit_card_number_1"),"5555");
        methods.sendKeys(By.id("credit_card_number_2"),"4444");
        methods.sendKeys(By.id("credit_card_number_3"),"3333");
        methods.sendKeys(By.id("credit_card_number_4"),"2222");
        methods.selectByText(By.id("credit-card-expire-date-month"),"01");
        methods.waitBySeconds(2);
        methods.selectByText(By.id("credit-card-expire-date-year"),"2044");
        methods.sendKeys(By.id("credit-card-security-code"),"344");
        methods.waitBySeconds(2);
        WebElement basketCheckBox1= methods.findElement(By.cssSelector("input[type=\"checkbox\"]"));
        basketCheckBox1.click();
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        WebElement basketCheckBox= methods.findElement(By.cssSelector("input[type=\"checkbox\"]"));
        basketCheckBox.click();
        methods.waitBySeconds(2);
        methods.click(By.xpath("//input[@class='button']\n"));
        methods.isElementVisible(By.className("css = .warning\n"));
        String actual= methods.getText(By.className("css = .warning\n"));
        methods.assertPage("Ödeme Alınamadı","Kart bilgileriniz doğrulanamadı, lütfen tekrar deneyiniz.\n",actual);
        methods.selectByText(By.cssSelector(".common-sprite>b"),"Çıkış");
    }



    public void createAddress() {

        methods.sendKeys(By.id("address-firstname-companyname"),"YUNUS");
        methods.sendKeys(By.id("address-lastname-title"),"KARA");
        methods.selectByText(By.id("address-zone-id"),"İstanbul");
        methods.selectByText(By.id("address-county-id"),"KÜÇÜKÇEKMECE");
        methods.sendKeys(By.id("address-address-text"),"Emre sokak no:50 .");
        methods.sendKeys(By.id("address-telephone"),"2164441444");
        methods.sendKeys(By.id("address-mobile-telephone"),"5447190360");
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
    }


}