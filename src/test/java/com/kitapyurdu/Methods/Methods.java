package com.kitapyurdu.Methods;

import com.kitapyurdu.Base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }
    //Element bulma methodu
    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //Elemente tıklatma methodu
    public void click(By by) {
        findElement(by).click();
    }

    //İnput alanına değer gönderme methodu
    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    //İnput alanında enter tuşuna basma methodu
    public void sendKeysEnter(By by) {
        findElement(by).sendKeys(Keys.ENTER);
    }

    //Elementin görünür olduğunu denetleyen method
    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean iselementToBeClickable(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }





    public void switchPage(By by){
        driver.findElement(by).click();
    }
    //Elementin tıklanabilir olup olmadığını denetleyen method
    protected void isClickableElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Saniye cinsinden bekleme methodu
    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Javascript kodu ile element scroll etme methodu
    protected void moveScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    //Action ile element scroll etme methody
    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    //Listede rastgele bir elemente tıklama methodu
    public void clickRandomInList(List<WebElement> listElement) {
        Random rnd = new Random();
        int index = rnd.nextInt(listElement.size());
        moveScrollToElement(listElement.get(index));
        isClickableElement(listElement.get(index));
        listElement.get(index).click();
    }

    //element seçme methodu
    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    //Elementi Text'ine göre seçme methodu
    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    //Elementin niteliğini alma methodu
    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    //Elementin text'ini alma methodu
    public String getText(By by) {
        return findElement(by).getText();
    }

    //Elementin içindeki değeri alma methodu
    public String getValue(By by) {
        return jsdriver.executeScript("return arguments[0].value", findElement(by)).toString();
    }
    public void assertPage(String message,String expectedValue,String actual){
        Assert.assertEquals(message, expectedValue, actual);
    }
     //Rastgele ürün seçme
    public void selectRandomProduct() {
        Random rnd = new Random();
        List<WebElement> products = findElements(By.xpath(("//div[@class='product-cr']//img")));
        int index = rnd.nextInt(products.size());
        products.get(index).click();
    }

    public String getUrl(){
        return  driver.getCurrentUrl();
    }

    public void clearInputArea(By by){
        findElement(by).clear();
    }

}
