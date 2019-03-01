package org.andestech.learning.rfb19.g3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Utils {

    public static List<String> searchGoogleTest(WebDriver wd, String keyPhrase, int nPages)
    {

      wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);



      WebDriverWait wwait = new WebDriverWait(wd,5);

      wd.get("https://google.com");
      WebElement el = wd.findElement(By.xpath("//*[@name='q']"));


      WebElement el1 = wwait.until( WebElement -> wd.findElement(By.xpath("//*[@name='q']") ) ) ;
      el.sendKeys(keyPhrase);
      el.submit();

    //  wd.findElement(By.name("btnK")).submit();

      // wait.until(ExpectedConditions.alertIsPresent());

        List<WebElement> elements = wd.findElements(By.cssSelector(".srg .g"));
        List<String> webs = new ArrayList<>();
        int j1=0;

        for(WebElement element: elements)
        {
            WebElement link =   element.findElement(By.cssSelector("a"));
//            System.out.println(j1++ + "==>" + element.getText());
            webs.add(link.getAttribute("href"));
        }

        if(nPages<1 || nPages>20) nPages=1;
        for(int i =1; i<nPages; i++)
        {
            WebElement wel1 =  wd.findElement(By.id("pnnext"));
            wel1.click();


            elements = wd.findElements(By.cssSelector(".srg .g"));
            for(WebElement element: elements)
            {
//              System.out.println(j1++ + "==>" + element.getText());
                WebElement link = element.findElement(By.cssSelector("a"));
                webs.add(link.getAttribute("href"));
            }

    }
    return webs;
    }
}
