package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.module.Configuration;
import java.util.Arrays;

public class HomePage extends BasePage{

    @FindBy(id = "nameofuser")
    public WebElement nameofuser;
    @FindBy(linkText = "Add to cart")
    public WebElement addToCartBtn;
    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceText;

    public void verifyWelcomeMessage(){
        BrowserUtils.waitForVisibility(nameofuser,10);
        String actualMessage= nameofuser.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(ConfigurationReader.get("username")));
    }
    public void verifyWelcomeMessage(String username){
        BrowserUtils.waitForVisibility(nameofuser,10);
        String actualMessage= nameofuser.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(username));
    }

    public int addProduct(String product,String category){

        try {
            WebElement categoryMenu = Driver.get().findElement(By.linkText(category));
            BrowserUtils.waitForClickablility(categoryMenu,5).click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.linkText(category),5);
        }
        try {
            WebElement productItem = Driver.get().findElement(By.linkText(product));
            BrowserUtils.scrollToElement(productItem);
            BrowserUtils.waitForClickablility(productItem,5).click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.linkText(product),5);
        }
        System.out.println("priceText = " + priceText.getText());
        String[] arrayAmount = priceText.getText().split(" ");
        System.out.println(Arrays.toString(arrayAmount));
        int lastPrice= Integer.parseInt(arrayAmount[0].substring(1));
        System.out.println("lastPrice = " + lastPrice);

        addToCartBtn.click();
        alert=wait.until(ExpectedConditions.alertIsPresent());
        alert=Driver.get().switchTo().alert();
        alert.accept();
        // homeMenu.click();
        navigateToMenu("Home");
        return lastPrice;
    }

}
