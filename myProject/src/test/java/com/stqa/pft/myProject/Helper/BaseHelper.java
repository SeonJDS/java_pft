package com.stqa.pft.myProject.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper {

    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }


    //method to click
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    //method to type
    public  void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }
}
