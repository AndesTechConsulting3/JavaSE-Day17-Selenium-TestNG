package org.andestech.learning.rfb19.g3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class AppTest2
{
    private WebDriver wd = null;
    private FirefoxOptions options = null;
    private FirefoxProfile profile = null;

    @BeforeClass
    public void initData(){

    System.setProperty("webdriver.gecko.driver",
            "E:\\drivers\\selenium\\geckodriver.exe");
        System.out.println("+++ Class: " + this);
    String profile_str = "C:\\Users\\and\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\nywxnvk0.default";
    File f = new File(profile_str);
    profile = new FirefoxProfile(f);

    options = new FirefoxOptions();
    options.setProfile(profile);

    }

    @Test
    public void testCaseFFox01()
    {
        wd = new FirefoxDriver(options);
//        for(String web : Utils.searchGoogleTest(wd,"Moon",2))
//            System.out.println(web);
        wd.get("http://lenta.ru");

        assertTrue( true );
    }


    @AfterClass
    public void tearDown()
    {
        if(wd != null) wd.quit();
        System.out.println("--- Class: " + this);
    }

}
