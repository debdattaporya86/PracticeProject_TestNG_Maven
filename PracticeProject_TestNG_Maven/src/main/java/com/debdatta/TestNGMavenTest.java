package com.debdatta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGMavenTest {
WebDriver driver ;
	
	@Test(dataProvider = "dp")
	public void salesforceLogin(String userName, String passWord) {
	    String baseUrl = "https://login.salesforce.com/";
	    SoftAssert sa = new SoftAssert();
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\porya\\eclipse-workspace\\Selenium Jars\\chromedriver_win32_v94\\chromedriver.exe");
        System.out.println("Launching Google Chrome browser"); 
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String testTitle = "Login | Salesforce";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
        System.out.println("UserName = "+userName); 
        System.out.println("PassWord = "+passWord); 
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);
        if(driver.findElements(By.id("Login")).size() > 0) {
        	System.out.println("Salesforce Login Button IS VISIBLE."); 
        } else {
        	System.out.println("Salesforce Login Button IS NOT VISIBLE."); 
        }
  }
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser");
	}
	
	@AfterMethod
	public void afterMethod() {
		 driver.close();
		System.out.println("Finished Test On Chrome Browser");
	}
	
    @DataProvider
    public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "debdattaporya86@curious-narwhal-21tggr.com", "Apple@2021" },
	      new Object[] { "gopal_poria@salesforce-practice.com", "Covid@2021" },
	    };
	  }

}
