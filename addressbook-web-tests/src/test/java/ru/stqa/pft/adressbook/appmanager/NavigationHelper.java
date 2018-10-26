package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void goToAddContactsPage() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public void goToHomePage() {
        click(By.xpath("//a[contains(text(),'home')]"));
    }
}
