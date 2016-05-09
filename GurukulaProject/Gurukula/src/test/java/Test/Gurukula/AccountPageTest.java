package Test.Gurukula;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.gurukula.common.ConfigValues;
import com.org.gurukula.common.DriverConfig;
import com.org.gurukula.pages.AccountPage;
import com.org.gurukula.pages.LoginPage;


public class AccountPageTest extends DriverConfig{
	
	
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	/**
	 * TC - account_001	Verify User Settings page title 
	 */
	@Parameters("userSettingsPageTitle")
	@Test(groups={"Account", "Regression"})
	public void account_001(@Optional ("User settings for") String userSettingsPageTitle){
		try{
			logger.info("TC execution started - account_001	Verify User Settings page title");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.verifyUserSettingsPageTitle(userSettingsPageTitle);
			logger.info("TC execution completed - account_001	Verify User Settings page title");
		} catch (Exception e){
			logger.error("TC failed - account_001	Verify User Settings page title" +e.toString());
		}				
	}
	
	
		
	/**
	 * TC - account_002	Verify update User settings 
	 */
	@Parameters({"userSettingsFirstName", "userSettingsLastName", "userSettingsEmail", "userSettingsSavedMsg"})
	@Test(groups={"Account", "Smoke", "Regression"})
	public void account_002	(@Optional ("vikram") String userSettingsFirstName, @Optional ("gudidevuni") String userSettingsLastName, @Optional ("Vikram.Gudidevuni@gmail.com") String userSettingsEmail, @Optional ("Settings saved.") String userSettingsSavedMsg){
		try 
		{
			logger.info("TC execution started - account_002	Verify update User settings ");
			LoginPage loginPage = 
				PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
				PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.goToUserSettingsPage();
			accountpage.enterFirstName(userSettingsFirstName);
			accountpage.enterLastName(userSettingsLastName);
			accountpage.enterEmail(userSettingsEmail);
			accountpage.ClickOnUserSettingsSave();		
			Assert.assertTrue(accountpage.verifySettingsSaved(userSettingsSavedMsg));	
			logger.info("TC execution completed - account_002	Verify update User settings ");
		}
		catch(Exception e)
		{
			logger.error("TC failed - account_002	Verify update User settings  " + e.toString());
		}
	}
	
	/**
	 * TC - account_003	Verify Password page title 
	 */
	@Parameters("passwordPageTitle")
	@Test(groups={"Account", "Regression"})
	public void account_003 (@Optional ("Password for") String passwordPageTitle) {
		try{
			logger.info("TC execution started - account_003	Verify Password page title ");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			logger.info("Password page title shown as Password for [ + logged in user name + ]");
			accountpage.verifyPasswordPageTitle(passwordPageTitle);
			logger.info("TC execution completed - account_003	Verify Password page title ");
		}catch (Exception e){
			logger.error("TC failed - account_003	Verify Password page title "+e.toString() );
		}	
	}
	
	/**
	 * TC - account_004	Verify enter 3 chars in Password 
	 */
	@Parameters({"password3Chars", "pwdMinCharsErrMsg"})
	@Test(groups={"Account", "Regression"})
	public void account_004	(@Optional ("Pas") String password3Chars, @Optional ("Your password is required to be at least 5 characters.") String pwdMinCharsErrMsg){
		try{
			logger.info("TC execution started - account_004	Verify enter 3 chars in Password ");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.goToPasswordPage();
			accountpage.enterNewPassword(password3Chars);		
			Assert.assertTrue(accountpage.verifyPwdMinCharsErrMsg(pwdMinCharsErrMsg));	
			logger.info("TC execution completed - account_004	Verify enter 3 chars in Password ");
		}catch(Exception e){
			logger.error("TC failed - account_004	Verify enter 3 chars in Password " + e.toString());
		}
		
			
	}
	
		
	/**
	 * TC - account_005	Verify Password strength after enter Vikky123 in New Password
	 */
	@Parameters({"accountPassword", "pwdStrengthRGBRange"})
	@Test(groups={"Account", "Regression"})
	public void account_005	(@Optional ("Vikky123") String accountPassword, @Optional ("(153, 255, 0)") String pwdStrengthRGBRange){
		try{
			logger.info("TC execution started - account_005	Verify Password strength after enter Vikky123 in New Password");
			LoginPage loginPage =
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.goToPasswordPage();
			accountpage.enterNewPassword(accountPassword);
			Assert.assertTrue(accountpage.verifyPwdStrength(pwdStrengthRGBRange));
			logger.info("TC execution completed - account_005	Verify Password strength after enter Vikky123 in New Password");
		}catch (Exception e){
			logger.error("TC failed - account_005	Verify Password strength after enter Vikky123 in New Password" +e.toString());
		}	
	}
	
	
	/**
	 * TC - account_006	Verify Session title
	 */
	@Parameters("sessionPageTitle")
	@Test(groups={"Account", "Regression"})
	public void account_006	(@Optional ("Active sessions for") String sessionPageTitle){
		try{
			logger.info("TC execution started - account_006	Verify Session title");
			LoginPage loginPage =
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.verifySessionPageTitle(sessionPageTitle);
			logger.info("TC execution completed - account_006	Verify Session title");
		}catch (Exception e){
			logger.error("TC failed - account_006	Verify Session title");
		}				
	}
	
	/**
	 * TC - account_007	Verify invalidate session 
	 */
	@Parameters("sessionValidateMsg")
	@Test(groups={"Account", "Regression"} )
	public void account_007	(@Optional ("Session invalidated!") String sessionValidateMsg){		
		try{
			logger.info("TC execution started - account_007	Verify invalidate session ");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.clickOnAccountMenu();
			accountpage.selectSessionsFromMenu();
			accountpage.clickOnInvalidateButton();
			Assert.assertTrue(accountpage.sessionValidateMsg(sessionValidateMsg));
			logger.info("TC execution completed - account_007	Verify invalidate session ");
		}catch(Exception e){
			logger.error("TC failed - account_007	Verify invalidate session "+e.toString());
		}
		
	}
	
	/**
	 * TC - account_008	Verify Logout 
	 */
	@Test(groups={"Account", "Regression"})
	public void account_008	(){
		try{
			logger.info("TC execution started - account_008	Verify Logout");
			LoginPage loginPage = 
					PageFactory.initElements(getDriver(), LoginPage.class);	
			AccountPage accountpage = 
					PageFactory.initElements(getDriver(), AccountPage.class);
			loginPage.openGurukula();		
			loginPage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			accountpage.clickOnAccountMenu();
			accountpage.selectSessionsFromMenu();
			accountpage.clickOnAccountMenu();
			accountpage.selectLogoutFromMenu();	
			logger.info("TC execution completed - account_008	Verify Logout");			
		}catch (Exception e){
			logger.error("TC failed - account_008	Verify Logout "+e.toString());
		}
		
	}
	
	
}
