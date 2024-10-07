package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    protected WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
    protected Alert alert;
    protected Faker faker=new Faker();

    @FindBy(id = "login2")
    public WebElement homePage_loginBtn;
    @FindBy(id = "logout2")
    public List<WebElement> logoutBtn;
    @FindBy(partialLinkText = "Home")
    public WebElement homeMenu;
    @FindBy(partialLinkText = "Cart")
    public WebElement cartMenu;

    public void navigateToMenu(String menu){
        By l_menu = By.partialLinkText(menu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(l_menu)).click();
    }
}
