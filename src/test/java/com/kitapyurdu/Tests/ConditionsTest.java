package com.kitapyurdu.Tests;
import com.kitapyurdu.Base.BaseTest;
import com.kitapyurdu.Pages.*;
import org.junit.Test;

public class ConditionsTest extends BaseTest {


    @Test
    public void testCases(){
        HomePage homePage=new HomePage();
        LoginPage loginPage=new LoginPage();
        SearchPage searchPage=new SearchPage();
        ProductPage productPage=new ProductPage();
        BasketPage basketPage=new BasketPage();
        FavoritePage favoritePage=new FavoritePage();

        //ANA SAYFA KONTROL
        homePage.assertHomePage();
        //LOGİN İŞLEMLERİ
        loginPage.login();
        //ÜRÜN ARAMA İŞLEMİ
        searchPage.searchProduct();
         //FAVORİLERE EKLEME
        favoritePage.addProductToFavorites();
        //FAVORİ SAYFASINA GİDİŞ
        favoritePage.switchPage();
        //FAVORİ SAYFASINI KONTROL
        favoritePage.assertFavoritePage();
        //ANA SAYFA YÖNLEDİRME
        homePage.switchPage();
        //ÜRÜN FİLTRELEME
        productPage.selectFilter();
        //SEPETE ÜRÜN EKLEME
        productPage.addToBasket();
        //FAVORİM SAYFASINA GİT
        favoritePage.switchPage();
        //FAVORİ SİLME
        favoritePage.favoriteProductDeleteByIndex();
        //SEPETİM SAYFASINA GİT
        basketPage.switchBasketPage();
        //ÜRÜN ADETİNİ ARTTIR
        basketPage.addQuantity("2");
        //SATIN AL CLİCK
        basketPage.clickBuyProduct();
        //ADRES EKLEME
        basketPage.createAddress();
        //SATIN ALMA İŞLEMLERİ
        basketPage.buyProduct();
        //HESAPTAN ÇIKIŞ İŞEMİ
        loginPage.logout();



    }
}
