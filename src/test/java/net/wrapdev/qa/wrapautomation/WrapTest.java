package net.wrapdev.qa.wrapautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WrapTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void startBrowser(){
		driver = new FirefoxDriver();
		driver.get("https://www.qa.wrapdev.net/index/");	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String expectedTitle = "Wrap: Native Web App - Mobile Branding, Publishing & Ecommerce Platform";
		System.out.println("Asserting the title of the page...");
		System.out.println("Title of the home page is - "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(expectedTitle));		
	}
	
	@Test
	public void testPublish(){
		HomePage ip = new HomePage(driver);
		PlansPricingPage pp = ip.clickPlansPricing();
		RegistrationPage rp= pp.signUp();
		rp.signUp();
		rp.createAccount();
		CreateTemplatePage ct = rp.completeAccountInfo();
		String userName = ct.getUserCreated();
		Assert.assertNotNull(userName, "Account not Created");
		
		CreateWrapPage cw = ct.createTemp();
		String expected = "Publish Successful";
		String actual = cw.wrapCreation();
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public static void closeBrowser(){
		driver.close();
	}
}
