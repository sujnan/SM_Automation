package net.wrapdev.qa.wrapautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	protected WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement getPlansPricing(){
		return driver.findElement(By.xpath("(//a[@href='//authoring.qa.wrapdev.net/#/plans'])[3]"));
	}
	
	public PlansPricingPage	clickPlansPricing(){
		getPlansPricing().click();
		return new PlansPricingPage(driver);
	}
}
