package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    public WebElement loginusername;

    @FindBy(id = "loginpassword")
    public WebElement loginpassword;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginBtn;

    public void login() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        homePage_loginBtn.click();
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        loginBtn.click();
    }

    public void login(String username, String password) {
        homePage_loginBtn.click();
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        loginBtn.click();
        BrowserUtils.waitFor(1);
    }

    public void verifyWrongAccessMessage(String expectedMessage) {
        alert = Driver.get().switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
