package net.wrapdev.qa.wrapautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	protected WebDriver driver;
	Properties prop = new Properties();
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement getEmailTxtbx(){
		return driver.findElement(By.xpath("//input[@class='o-auth-input ng-pristine ng-untouched ng-valid ng-empty']"));
	}
	
	private WebElement signupBtn(){
		return driver.findElement(By.xpath("//button[text()='Sign Up']"));
	}
	
	private WebElement userNameTxbx(){
		return driver.findElement(By.xpath("//input[@class='o-auth-input ng-pristine ng-untouched ng-valid ng-empty'][1]"));
	}
	
	private WebElement pwdTxBx(){
		return driver.findElement(By.xpath("//input[@placeholder='Password']"));
	}
	
	private WebElement createAccntBtn(){
		return driver.findElement(By.cssSelector("button.o-auth-button"));
	}

	private WebElement firstNameTxBx(){
		return driver.findElement(By.xpath("//input[@placeholder='First Name *']"));
	}

	private WebElement lastNameTxBx(){
		return driver.findElement(By.xpath("//input[@placeholder='Last Name *']"));		
	}
	
	private WebElement companyTxBx(){
		return driver.findElement(By.xpath("//input[@placeholder='Company *']"));
	}
	
	private WebElement phoneTxBx(){
		return driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
	}
	
	//reading the email properties file
	private void loadProperties(){
		try {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/email.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void signUp(){
			loadProperties();
			getEmailTxtbx().click();
			getEmailTxtbx().sendKeys(prop.getProperty("email", "test@gmail.com"));
			signupBtn().click();	
	}
	
	public void createAccount(){
		loadProperties();
		userNameTxbx().click();
		userNameTxbx().sendKeys(prop.getProperty("username", "test"));
		pwdTxBx().click();
		pwdTxBx().sendKeys(prop.getProperty("password", "test"));
		createAccntBtn().click();
		createAccntBtn().click();
	}
	
	public CreateTemplatePage  completeAccountInfo(){
		loadProperties();
		firstNameTxBx().click();
		firstNameTxBx().sendKeys(prop.getProperty("firstname", "test"));
		lastNameTxBx().click();
		lastNameTxBx().sendKeys(prop.getProperty("lastname", "test"));
		companyTxBx().click();
		companyTxBx().sendKeys(prop.getProperty("company", "TEST"));
		createAccntBtn().click();
		return new CreateTemplatePage(driver);
	}
	
}
