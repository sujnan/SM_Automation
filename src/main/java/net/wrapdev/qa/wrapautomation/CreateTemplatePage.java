package net.wrapdev.qa.wrapautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTemplatePage {
	protected WebDriver driver;
	WebDriverWait wait;

	public CreateTemplatePage(WebDriver driver) {
		this.driver = driver;
	}
	 
	private WebElement getUserName(){
		return driver.findElement(By.cssSelector("div.global-nav_user-name.ng-binding"));
	}
	
	private WebElement clickCreateNewWrap(){
		return driver.findElement(By.cssSelector("button.wraps_create-btn.ng-scope"));
	}
	
	public String getUserCreated(){
		String name = getUserName().getText();
		System.out.println("Account created for: "+ name);
		return name;
	}
	
	public CreateWrapPage createTemp(){
		wait = new WebDriverWait(driver, 900);
		wait.until(ExpectedConditions.elementToBeClickable(clickCreateNewWrap()));
		clickCreateNewWrap().click();
		return new CreateWrapPage(driver);
	}
}
