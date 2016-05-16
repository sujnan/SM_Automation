package net.wrapdev.qa.wrapautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlansPricingPage {
	protected WebDriver driver;
	
	public PlansPricingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement getSignupLink(){
		return driver.findElement(By.xpath("(//a[@class='pricing-cta ng-scope ng-isolate-scope' and text()='Sign Up'])[1]"));
	}
	
	public RegistrationPage signUp(){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getSignupLink());
		getSignupLink().click();
		return new RegistrationPage(driver);
	}
	

}
