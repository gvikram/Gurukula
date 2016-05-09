package com.org.gurukula.pages;

import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.gurukula.common.ConfigValues;
import com.org.gurukula.pages.BasePage;


public class LoginPage extends BasePage {
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}
	
	
	// Below are Login Page locators
	@FindBy(how = How.ID, using = "username")
	private WebElement txtbx_UserName;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement txtbx_Password;
	
	@FindBy(how = How.ID, using = "rememberMe")
	private WebElement chkbx_RememberMe;
	
	@FindBy(how = How.XPATH, using = "//button[text() = 'Authenticate']")
	private WebElement btn_Authenticate;
	
	@FindBy(how = How.LINK_TEXT, using = "Did you forget your password?")
	private WebElement lnkTxt_ResetRequest;
	
	@FindBy(how = How.LINK_TEXT, using = "Register a new account")
	private WebElement lnkTxt_Register;
	
	@FindBy(how = How.LINK_TEXT, using = "login")
	private WebElement lnkTxt_login;
	
	@FindBy(how = How.XPATH, using = "//div/h1[text() = 'Welcome to Gurukula!']")
	private WebElement login_PageTitle;	
	
	@FindBy(how = How.XPATH, using = "//div/strong[text() = 'Authentication failed!']")
	private WebElement errmsg_Authenticationfailed;
	
	
	// Below are Login Page methods
	public void openGurukula ()
	{
		try{
			logger.info("Launch Gurukula application");
			navigateToUrl(ConfigValues.gurukulaURL);	
		}catch(NoSuchElementException exception){
			logger.error("Unable to login to application" + exception.toString() );			
		}		
	}
	
	public LoginPage clickOnLoginLink(){
		try{
			click (lnkTxt_login);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );			
		}			
		return this;	
	}
	
	public LoginPage enterUserName (String userName){
		try{
			logger.info("Enter user name");
			clear (txtbx_UserName);
			type(userName, txtbx_UserName);	
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );			
		}						
		return this;		
	}
	
	public LoginPage enterPassword (String password){
		try{
			logger.info("Enter password");
			clear (txtbx_Password);
			type(password, txtbx_Password);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );			
		}					
		return this;
	}
	
	public boolean checkRememberMe () {
		try{
			logger.info("Check Remember Me checkbox");
			return chkbx_RememberMe.isSelected();	
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );	
			return false;
		}
					
	}
	
	public LoginPage clickOnAuthenticateButton(){
		try{
			logger.info("Click on Authenticate Button");
			click(btn_Authenticate);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );				
		}				
		return this;
	}
	
	public LoginPage clickOnResetLink (){
		try{
			logger.info("Click on Reset Link");
			click(lnkTxt_ResetRequest);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );				
		}				
		return this;		
	}
	
	public boolean isLoginLinkExists(){
		try{
			logger.info("Login link enabled or exists");
			return (lnkTxt_login.getSize().toString().length()>0);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );	
			return false;
		}					
	}
	
	public LoginPage clickOnRegisterLink (){
		try{
			logger.info("Click on Register Link");
			click (lnkTxt_Register);	
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );			
		}				
		return this;
	}
	
	public LoginPage login (String username, String password) {		
		try{
			isLoginLinkExists();
			click(lnkTxt_login);		
			enterUserName(username);
			enterPassword(password);
			clickOnAuthenticateButton();	
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );			
		}			
		return this;		
	}
	
	public boolean verifyLoginPageTitle (String titleName){		
		try{
			return login_PageTitle.getText().equals(titleName);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );	
			return false;
		}						
	}	
	
	
	public boolean isLoginAuthenticationFailed(String authErrMsg){	
		try{
			return errmsg_Authenticationfailed.getText().contains(authErrMsg);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );	
			return false;	
		}		
	}
	

	
}
