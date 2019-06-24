package com.stqa.pft.myProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(new AjaxElementLocatorFactory(wd, 10), this);
    }

    public By userName = By.xpath("//*[@id='LoginForm']/input[1]");
    }
