package Test.Gurukula;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.gurukula.common.ConfigValues;
import com.org.gurukula.common.DriverConfig;
import com.org.gurukula.pages.LoginPage;
import com.org.gurukula.pages.Registration;
import com.org.gurukula.pages.ResetPassword;

public class LoginPageTest extends DriverConfig{
	
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
		
	
	/**
	 * TC - login_001	
	 * Verify login successful when entered valid username/password and verify "Welcome to Gurukula!" message.
	 * @param pageTitle 
	 *
	 */
	@Parameters ("pageTitle")
	@Test (groups={"Login", "Smoke", "Regression"})
	public void login_001 (@Optional("Welcome to Gurukula!") String pageTitle) {
		try{
			logger.info("TC execution started - login_001 Verify login successful when entered valid username/password");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);		
			Assert.assertTrue(loginPage.verifyLoginPageTitle( pageTitle));	
			logger.info("TC execution completed - login_001 Verify login successful when entered valid username/password");
		} catch (Exception e){
			logger.error("TC failed - login_001 Verify login successful when entered valid username/password"+e.toString());
		}				
	}
	
	/**
	 * TC - login_002	
	 * Verify Login fail when invalid username/password 
	 * and it throw error message as "Authentication failed! Please check your credentials and try again."
	 */
	@Parameters("authErrMsg")
	@Test (groups={"Login", "Regression"})
	public void login_002 (@Optional ("Authentication failed!") String authErrMsg){
		try{
			logger.info("TC execution started - login_002  Verify Login fail when invalid username/password");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.invalidAdminUserName, ConfigValues.invalidPassword);	
			Assert.assertFalse(loginPage.isLoginAuthenticationFailed(authErrMsg));	
			logger.info("TC execution completed - login_002  Verify Login fail when invalid username/password");
		} catch (Exception e){
			logger.error("TC failed - login_002  Verify Login fail when invalid username/password "+e.toString());
		}			
	}
	
	/**
	 * 
	 * TC - login_003	
	 * Verify click on "Did you forgot your password?" link then it will navigate 
	 * to "Reset your Password" page 

	 */
	@Parameters("resetPageTitle")
	@Test (groups={"Login", "Regression"})
	public void login_003(@Optional ("Reset your password") String resetPageTitle){
		try{
			logger.info("TC execution started - login_003 Verify click on Did you forgot your password?");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			ResetPassword resetpwd = 
					PageFactory.initElements(getDriver(), ResetPassword.class);	
			loginPage.openGurukula();	
			loginPage.clickOnLoginLink();	
			loginPage.clickOnResetLink();
			Assert.assertTrue(resetpwd.verifyRestPageTitle(resetPageTitle));
			logger.info("TC execution completed - login_003 Verify click on Did you forgot your password?");
		} catch (Exception e){
			logger.error("TC failed - login_003 Verify click on Did you forgot your password?"+e.toString());
		}			
	}
	
	
	/**
	 * 
	 * TC - login_004	
	 * Verify enter valid E-mail and click on Reset Password button

	 */
	@Parameters({"resetValidEmailAddress", "emailErrMsg"})
	@Test (groups={"Login", "Regression"} )
	public void login_004(@Optional ("Vikram.Gudidevuni@gmail.com") String resetValidEmailAddress, @Optional ("E-Mail address isn't registered!") String emailErrMsg){
		try{
			logger.info("TC execution started - login_004 Verify enter valid E-mail and click on Reset Password button");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			ResetPassword resetpwd = 
					PageFactory.initElements(getDriver(), ResetPassword.class);	
			loginPage.openGurukula();
			loginPage.clickOnLoginLink();
			loginPage.clickOnResetLink();
			resetpwd.enterEmailAddress(resetValidEmailAddress);
			resetpwd.clickOnResetPasswordButton();
			Assert.assertTrue(resetpwd.verifyEmailInfoMessage(emailErrMsg));	
			logger.info("TC execution completed - login_004 Verify enter valid E-mail and click on Reset Password button");
		} catch (Exception e){
			logger.error("TC failed - login_004 Verify enter valid E-mail and click on Reset Password button"+e.toString());
		}		
	}
	
	
	/**
	 * TC - login_005	
	 * Verify enter in-valid E-mail as "test" and click on Reset Password button, 
	 * it should throw error message as "Your e-mail is invalid." 
	 * and "Your e-mail is required to be at least 5 characters."
	 */
	@Parameters ({"resetInvalidEmailAddress", "resetInvalidEmailErrMsg"})
	@Test (groups={"Login", "Regression"})
	public void login_005(@Optional ("Test") String resetInvalidEmailAddress, @Optional ("Your e-mail is invalid.") String resetInvalidEmailErrMsg){
		try{
			logger.info("TC execution started - login_005 Verify enter in-valid E-mail as test and click on Reset Password button");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			ResetPassword resetpwd = 
					PageFactory.initElements(getDriver(), ResetPassword.class);	
			loginPage.openGurukula();
			loginPage.clickOnLoginLink();
			loginPage.clickOnResetLink();
			resetpwd.enterEmailAddress(resetInvalidEmailAddress);		
			Assert.assertTrue(resetpwd.verifyEmailInvalid(resetInvalidEmailErrMsg));
			logger.info("TC execution completed - login_005 Verify enter in-valid E-mail as test and click on Reset Password button");
		} catch (Exception e){
			logger.error("TC failed - login_005 Verify enter in-valid E-mail as test and click on Reset Password button"+e.toString());
		}
		
	}
	
	/**
	 * TC - login_006	
	 * Verify click on Register a new account link, 
	 * it navigate to Registration page
	 */
	@Parameters("regstrPageTitle")
	@Test (groups={"Login", "Regression"})
	public void login_006(@Optional ("Registration") String regstrPageTitle){
		try{
			logger.info("TC execution started - login_006 Verify click on Register a new account link");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			Registration registration = 
					PageFactory.initElements(getDriver(), Registration.class);	
			loginPage.openGurukula();	
			loginPage.clickOnLoginLink();	
			loginPage.clickOnRegisterLink();
			Assert.assertTrue(registration.verifyRegistrationTitle(regstrPageTitle));
			logger.info("TC execution completed - login_006 Verify click on Register a new account link");
		} catch (Exception e) {
			logger.error("TC failed - login_006 Verify click on Register a new account link"+e.toString());
		}		
	}
	
	/**
	 * 
	 * TC - login_007	
	 * Verify Registration page having Login, E-mail, New Password, 
	 * New password confirmation lables, Login, E-mail, New password, 
	 * New Password confirmation text boxes, Register button, login link and copyright 2015 label.
	 */
	@Test (groups={"Login", "Regression"})
	public void login_007(){
		try{
			logger.info("TC execution started - login_007  Verify Registration page having Login, E-mail, New Password");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			Registration registration = 
					PageFactory.initElements(getDriver(), Registration.class);	
			loginPage.openGurukula();	
			loginPage.clickOnLoginLink();	
			loginPage.clickOnRegisterLink();		
			Assert.assertTrue(registration.verifyRegistrationFields());
			logger.info("TC execution completed - login_007  Verify Registration page having Login, E-mail, New Password");
		} catch (Exception e) {
			logger.error("TC failed - login_007  Verify Registration page having Login, E-mail, New Password"+e.toString());
		}		
	}
	
	/**
	 * TC - login_008	
	 * Verify Registration with valid input data and it should successful
	 */
	@Parameters ({"regstrLoginName", "regstrEmail", "regstrPassword"} )
	@Test (groups={"Login", "Regression"})
	public void login_008(@Optional ("Vikram") String regstrLoginName, @Optional ("Vikram_1258@yhoo.com") String regstrEmail, @Optional ("Vikram!1234") String regstrPassword){
		try{
			logger.info("TC execution started - login_008 Verify Registration with valid input data and it should successful");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			Registration registration = 
					PageFactory.initElements(getDriver(), Registration.class);	
			loginPage.openGurukula();	
			loginPage.clickOnLoginLink();	
			loginPage.clickOnRegisterLink();			
			registration.RegisterUser(regstrLoginName, regstrEmail, regstrPassword, regstrPassword);
			logger.info("TC execution completed - login_008 Verify Registration with valid input data and it should successful");
		} catch (Exception e) {
			logger.error("TC failed - login_008 Verify Registration with valid input data and it should successful"+e.toString());
		}		
	}

}
