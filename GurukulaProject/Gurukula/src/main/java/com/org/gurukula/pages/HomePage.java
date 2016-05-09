package com.org.gurukula.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);		
	}
	
	final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	// Below are locators
	@FindBy(how = How.XPATH, using = "//div/h1[text() = 'Welcome to Gurukula!']")
	private WebElement lblTxt_Gurukula; 
	
	
	@FindBy(how = How.LINK_TEXT, using = "login")
	private WebElement lnkTxt_login;
	
	@FindBy(how = How.LINK_TEXT, using = "Register a new account")
	private WebElement lnkTxt_register;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'footer']")
	private WebElement lbl_CopyRight;
	
	@FindBy (how = How.XPATH, using =  "//span[text() = 'Home']")
	private WebElement lnk_Home;
			
	@FindBy (how = How.XPATH, using =  "//span[text() = 'Account']")
	private WebElement lnk_Account;
	

	// Below are Home page methods
	public boolean labelWelcomeGurukulaExists (String welcomeGurukula) {
		try{
			return lblTxt_Gurukula.getText().contains(welcomeGurukula);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );
			return false;
		}					
	}
	
	public boolean linkLoginExists () {
		try{
			return (lnkTxt_login.getSize().toString().length()>0);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );
			return false;
		}					
	}
	
	public boolean linkRegisterExists() {
		try{
			return (lnkTxt_register.getSize().toString().length()>0);
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );
			return false;
		}					
	}
	
	
	public boolean verifyCopyRight(){
		try{
			return lbl_CopyRight.getText().equals("Copyright © 2015. All rights reserved");
		}catch(NoSuchElementException exception){
			logger.error("Element not found" + exception.toString() );
			return false;
		}					
	}
	
	public boolean verifyPageHeaderLinks (){
		try{
			lnk_Home.getText().equalsIgnoreCase("Home");			
			lnk_Account.getText().equalsIgnoreCase("Account");
			return true;
		}catch(NoSuchElementException Exception){
			logger.error("No Home, Entities, Account Links exists");
			return false;
		}
		
		
	}
}
