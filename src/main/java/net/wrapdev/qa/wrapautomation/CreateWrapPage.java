package net.wrapdev.qa.wrapautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWrapPage {
	protected WebDriver driver;
	WebDriverWait wait;
	
	public CreateWrapPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement getCategory(){
		return driver.findElement(By.xpath("//div[text()='Storytelling']"));
	}
	
	private WebElement getSearch(){
		return driver.findElement(By.xpath("(//div[@class='search-field_input'])[2]"));
	}
	
	private WebElement getCreateWrapBtn(){
		return driver.findElement(By.cssSelector("button.btn.btn-success.ng-binding"));
	}
	
	private WebElement tourCloseBtn(){
		return driver.findElement(By.xpath("//button[@class='help-tour_nav help-tour_nav--close']"));
	}
	
	private WebElement getCard3(){
		return driver.findElement(By.xpath("//div[@class='card-row-item ng-scope ng-isolate-scope as-sortable-item is-selectable'][2]"));
	}
	
	private WebElement getBodyLnk(){
		return driver.findElement(By.xpath("(//div[@class='components_item ng-binding ng-scope ng-isolate-scope'])[3]"));
	}
	
	private WebElement getBody(){
		return driver.findElement(By.xpath("//div[@class='ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope text-editor ng-not-empty']/p"));
	}
	
	private WebElement getPublishBtn(){
		return driver.findElement(By.cssSelector("button.btn.btn-success"));
	}
	
	private WebElement getIsPublishedTxt(){
		return driver.findElement(By.xpath("//div[@class='modal-header']/h4"));
	}
	
	public String wrapCreation(){
		wait = new WebDriverWait(driver, 800);
		getCategory().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(getCreateWrapBtn()));
		getCreateWrapBtn().click();
		tourCloseBtn().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(getCard3()));
		getCard3().click();
		
		getBodyLnk().click();		
		
		JavascriptExecutor js = (JavascriptExecutor)driver; js.executeScript("document.getElementsByTagName('p')[4].innerHTML = 'Test Automation'");
		wait.until(ExpectedConditions.elementToBeClickable(getBody()));

		wait.until(ExpectedConditions.elementToBeClickable(getPublishBtn()));
		getPublishBtn().click();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		tourCloseBtn().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(getIsPublishedTxt()));
		String isPublishedTxt = getIsPublishedTxt().getText();
		System.out.println("Is Publish Successful? "+ isPublishedTxt);
		
		return isPublishedTxt;
	}
	
}
