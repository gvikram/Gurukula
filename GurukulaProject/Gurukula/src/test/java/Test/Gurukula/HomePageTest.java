package Test.Gurukula;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.gurukula.common.DriverConfig;
import com.org.gurukula.pages.HomePage;
import com.org.gurukula.pages.LoginPage;

public class HomePageTest extends DriverConfig {
	
	final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	/**
	 * TC - home_001
	 * Description: Verify Home page having 
	 * Welcome to Gurukula!" label, login, Register a new account link
	 * 
	*/
	@Parameters("pageTitle")
	@Test (groups={"Home", "Smoke", "Regression"})
	public void home_001(@Optional ("Welcome to Gurukula!") String pageTitle){
		try{
			logger.info("TC execution started - home_001 Verify Home page having  Welcome to Gurukula!");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			HomePage homePage = 
					PageFactory.initElements(getDriver(), HomePage.class);	
			loginPage.openGurukula();	
			Assert.assertTrue(homePage.labelWelcomeGurukulaExists(pageTitle));
			Assert.assertTrue(homePage.linkLoginExists());
			Assert.assertTrue(homePage.linkRegisterExists());	
			logger.info("TC execution completed - home_001 Verify Home page having  Welcome to Gurukula!");
		} catch (Exception e){
			logger.error("TC failed - home_001 Verify Home page having  Welcome to Gurukula!"+e.toString());
		}
				
	}
	
	/**
	 * TC - home_002
	 * Description: Verify Copyright, Home & Account header links	
	 * 
	*/
	@Test (groups={"Home", "Smoke", "Regression"})
	public void home_002 (){
		try{
			logger.info("TC execution started - home_002 Verify Copyright, Home & Account header links");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			HomePage homePage = 
					PageFactory.initElements(getDriver(), HomePage.class);	
			loginPage.openGurukula();			
			Assert.assertTrue(homePage.verifyCopyRight());
			Assert.assertTrue(homePage.verifyPageHeaderLinks());	
			logger.info("TC execution completed - home_002 Verify Copyright, Home & Account header links");
		} catch (Exception e){
			logger.error("TC failed - home_002 Verify Copyright, Home & Account header links "+e.toString());
		}				
	}
}

