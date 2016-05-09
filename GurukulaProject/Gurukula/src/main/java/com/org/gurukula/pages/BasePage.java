package com.org.gurukula.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BasePage {
	
	protected WebDriver driver;	
	
	final static Logger logger = LoggerFactory.getLogger(BasePage.class);
	
	public BasePage (WebDriver driver)
	{
		try{
			this.driver = driver;
			this.driver.manage().window().maximize();
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception exception){
			logger.error("Driver not initiated"+exception.toString());
		}		
	}
	
	
	public void navigateToUrl (String url) {
		if (url.contains("http://"))
		{
			driver.get(url);
			
		}
		else {
			driver.get("http://"+url);
		}
	}
		
	
	public void click (WebElement locator) {
		try{
			locator.click();
		} catch (NoSuchElementException exception) {
			logger.error("Element not found"+exception.toString());
		}		
	}
	
	public void clear (WebElement locator) {
		try{
			locator.clear();
		} catch (NoSuchElementException exception) {
			logger.error("Element not found"+exception.toString());
		}
	}
	
		
	public void type (String inputText, WebElement locator) {
		try{
			locator.sendKeys(inputText);
		}catch(NoSuchElementException exception) {
			logger.error("Element not found"+exception.toString());
		}
	}
	
	public void isSelected (WebElement locator ) {
		try{
			locator.isSelected();
		}catch(NoSuchElementException exception) {
			logger.error("Element not found"+exception.toString());
		}
		
	}
	
	public boolean isDisplayed (WebElement locator) {
		try {
			return locator.isDisplayed();			
		} catch(NoSuchElementException exception) {
			logger.error("Element not found"+exception.toString());
			return false;
		}		
	}
	
	/*public void selectItemFromList (WebElement locator){
		locator.click();
	}*/
	
	/*public boolean isLocatorEnabled(WebElement locator){
		try{
		return locator.isEnabled();
		} catch(NoSuchElementException exception)
		{
			return false;
		}
		
	}*/
	
	public boolean waitForIsDisplayed(WebElement locator, Integer... timeout) {
		try {
			waitFor(ExpectedConditions.visibilityOf(locator), (timeout.length > 0 ? timeout[0] : null));
			return true;
		} catch (Exception exception) {
			logger.error("Element not displayed"+exception.toString());
			return false;
		}		
	}
	
	private boolean waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
		try{
			timeout = timeout != null ? timeout : 5;
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(condition);
			return true;
		}catch (Exception exception) {
			logger.error("Element not displayed"+exception.toString());
			return false;
		}		
	}
	
	
	


	
	
}
