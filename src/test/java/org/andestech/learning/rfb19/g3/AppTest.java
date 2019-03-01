package org.andestech.learning.rfb19.g3;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AppTest
{
    private WebDriver wd = null;
    private ChromeOptions co = null;

    @BeforeClass
    public void initData(){
    System.setProperty("webdriver.chrome.driver",
            "E:\\drivers\\selenium\\chromedriver.exe");

    System.out.println("+++ Class: " + this);
    co = new ChromeOptions();
    String my_profile_str = "C:\\Users\\and\\AppData\\Local\\Google\\Chrome\\User Data";

   // co.addArguments("--user-data-dir=" + my_profile_str);
    co.addArguments("--user-data-dir=" + "C:\\Users\\and\\AppData\\Local\\Chromium\\User Data");
    co.setBinary("E:\\progs\\chrome-win\\chrome.exe");

    }

    @Test
    public void testCaseChrome01() throws InterruptedException
    {
        wd = new ChromeDriver(co);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("http://andestech.org/learning/rfb18/index.html");

        wd.findElement(By.linkText("New customer")).click();

        wd.findElement(By.name("reset")).click();

        wd.findElement(By.cssSelector("input#name")).sendKeys("Василий");
        wd.findElement(By.cssSelector("input#sname")).sendKeys("Тёмный");
        wd.findElement(By.cssSelector("input#login")).sendKeys("BasilDark");
        wd.findElement(By.cssSelector("input#pass")).sendKeys("Bd12345!!");

        wd.findElement(By.name("submit")).submit();

        wd.switchTo().alert().accept();


        Thread.sleep(2000);


//        wd.findElement(By.linkText("Logout")).click();
//
//        Alert alert = wd.switchTo().alert();
//        System.out.println(alert.getText());
        //alert.accept();

    }


    @AfterClass
    public void tearDown()
    {
      if(wd != null) wd.quit();
      System.out.println("--- Class: " + this);
    }

}
