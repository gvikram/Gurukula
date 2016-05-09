package com.org.gurukula.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Registration extends BasePage {
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	public Registration(WebDriver driver) {
		super(driver);			
	}
	
	
	// Below are Registration page locators
		@FindBy(how = How.XPATH, using = "//h1[text()='Registration' and @translate='register.title']")
		private WebElement title_Registration;
		
		@FindBy(how = How.XPATH, using = "//input[@name = 'login']")
		private WebElement editbx_Login;
		
		@FindBy(how = How.XPATH, using = "//input[@name = 'email']")
		private WebElement editbx_Email;
		
		@FindBy(how = How.XPATH, using = "//input[@name = 'password']")
		private WebElement editbx_Password;
		
		
		@FindBy(how = How.XPATH, using = "//input[@name = 'confirmPassword']")
		private WebElement editbx_ConfirmPassword;
		
		@FindBy(how = How.XPATH, using = "//button[text() = 'Register']")
		private WebElement btn_Register;
		
		@FindBy(how = How.XPATH, using = "//a[text() = 'login']")
		private WebElement lnk_Login;
		
			
	// Below are Registration page methods
		public Registration enterLogin (String loginName){
			try{
				type(loginName, editbx_Login);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}				
			return this;			
		}
		
		public Registration enterEmail(String email){
			try{
				clear (editbx_Email);
				type(email, editbx_Email);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}				
			return this;
		}
		
		public Registration enterPassword(String password){
			try{
				clear (editbx_Password);
				type(password, editbx_Password);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}			
			return this;
		}
		
		public Registration enterConfirmPassword(String confirmPassword){
			try{
				clear (editbx_ConfirmPassword);
				type(confirmPassword, editbx_ConfirmPassword);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}				
			return this;
		}
		
		
		public Registration clickOnRegisterButton(){
			try{
				click(btn_Register);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}
			return this;
		}
		
		public LoginPage clickOnLoginLink(){
			try{
				click(lnk_Login);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}			
			return new LoginPage(driver);
		}
		
		public boolean verifyRegistrationTitle(String registrationTitle){
			try{
				return title_Registration.getText().equals(registrationTitle);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );	
				return false;
			}		
		}
		
		public boolean verifyRegistrationFields(){
			
			try{
				isDisplayed(title_Registration);
			
				isDisplayed(editbx_Login);
				isDisplayed(editbx_Email);
				isDisplayed(editbx_Password);
				isDisplayed(editbx_ConfirmPassword);
				isDisplayed(btn_Register);
				isDisplayed(lnk_Login);			
				return true;
			}catch(NoSuchElementException exception){
				logger.error("Not found elements in registration page");
				return false;
			}
			
		}
		
		public Registration RegisterUser(String loginName, String email, String password,String confirmPassword){
			try{
				enterLogin(loginName);
				enterEmail(email);
				enterPassword(password);
				enterConfirmPassword(confirmPassword);
				clickOnRegisterButton();
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}				
			return this;
		}
	

}
