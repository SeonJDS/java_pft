package com.stqa.pft.myProject.Tests;


import com.ibm.dtfj.phd.parser.Base;
import com.stqa.pft.myProject.Helper.BaseHelper;
import com.stqa.pft.myProject.Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver wd;
    private BaseHelper bh;

    @BeforeClass
    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        bh = new BaseHelper(wd);
    }

    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(wd);
        wd.get("http://localhost/addressbook");
        bh.type(logInPage.userName, "root");
        bh.type(By.xpath("//*[@id='LoginForm']/input[2]"), "Secret");
        bh.click(By.xpath("//*[@id='LoginForm']/input[3]"));

    }

    @AfterClass
    public void stop() {
        wd.quit();
    }

    public BaseHelper bh() { return  bh; }
}
