package com.kitapyurdu.Pages;

import com.kitapyurdu.Methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);
    public LoginPage(){
        methods = new Methods();
    }
    public void login(){
        methods.click(By.linkText("Giriş Yap"));
        methods.sendKeys(By.id("login-email"),"yunuskaratest1@outlook.com");
        methods.sendKeys(By.id("login-password"),"samsun12345");
        methods.sendKeysEnter(By.id("login-password"));
        methods.waitBySeconds(5);
        String actual = methods.getText(By.cssSelector(".common-sprite > b"));
        methods.assertPage("Hesaba giriş Yapılmadı", "yunus kara", actual);
        logger.info("Hesaba giriş yapıldı " + actual);


    }

    public void logout() {
        methods.selectByText(By.cssSelector(".common-sprite>b"), "Çıkış");
    }
}
