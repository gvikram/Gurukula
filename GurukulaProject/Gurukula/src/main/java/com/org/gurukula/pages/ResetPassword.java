package com.org.gurukula.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResetPassword extends BasePage {
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	public ResetPassword(WebDriver driver) {
		super(driver);		
	}

	// Below are Reset Password page locators
		@FindBy(how = How.XPATH, using = "//h1[text()='Reset your password' and @translate='reset.request.title']")
		private WebElement title_ResetPassword;		
		
		@FindBy(how = How.XPATH, using = "//p[text()='Enter the e-mail address you used to register' and @translate='reset.request.messages.info']")
		private WebElement msg_EmailInfo;
		
		@FindBy(how = How.XPATH, using = "//div[@ng-show = 'errorEmailNotExists']")
		private WebElement msg_EmailErrorMsg;
		
		@FindBy(how = How.XPATH, using = "//input[@placeholder='Your e-mail' and @name = 'email']")
		private WebElement editbox_Email;
		
		@FindBy(how = How.XPATH, using = "//button[text()='Reset password']")
		private WebElement btn_ResetPassword;
		
		@FindBy(how = How.XPATH, using = "//p[text()='Your e-mail is invalid.']")
		private WebElement errMsg_InvalidEmail;
		
	// Below are Reset Password methods
		public boolean verifyRestPageTitle (String resetPageTitle){
			try{
				return title_ResetPassword.getText().equals(resetPageTitle);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );	
				return false;
			}						
		}
		
		public boolean verifyEmailInfoMessage (String emailInfoMsg){
			try{
				return msg_EmailErrorMsg.getText().contains(emailInfoMsg);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );	
				return false;
			}							
		}
		
		public boolean verifyEmailInvalid(String emailInvalidErrMsg){
			try{
				return errMsg_InvalidEmail.getText().equals(emailInvalidErrMsg);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );	
				return false;
			}				
		}
		
		public ResetPassword enterEmailAddress (String emailAddress){
			try{
				clear (editbox_Email);
				type(emailAddress, editbox_Email);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}				
			return this;
		}
		
		public ResetPassword clickOnResetPasswordButton (){
			try{
				click(btn_ResetPassword);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}			
			return this;
		}
		
}
