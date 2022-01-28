package com.kitapyurdu.Pages;

import com.kitapyurdu.Methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.kitapyurdu.Constants.Constants.*;

public class HomePage {
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);


    public HomePage() {
        methods = new Methods();
    }
    public void switchPage(){
        methods.waitBySeconds(1);
        methods.switchPage(HOME_PAGE_LOCATER);
        methods.waitBySeconds(1);
    }

    public void assertHomePage() {
        String url = methods.getUrl();
        methods.assertPage("Anasayfada değilsin","https://www.kitapyurdu.com/",url);
        logger.info("Bu sayfaya geçildi " + url);
    }

}
