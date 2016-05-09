package com.org.gurukula.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountPage extends BasePage {
	
	final static Logger logger = LoggerFactory.getLogger(AccountPage.class);
	
	public AccountPage(WebDriver driver) {
		super(driver);				
	}


		
	@FindBy (how = How.XPATH, using = "//span[text()='Account']")
	private WebElement lnk_Account;
	
	@FindBy (how = How.XPATH, using = "//span[text()='Settings']")
	private WebElement lnk_Settings;
	
	@FindBy (how = How.XPATH, using = "//span[text()='Password']")
	private WebElement lnk_Password;
	
	@FindBy (how = How.XPATH, using = "//span[text()='Sessions']")
	private WebElement lnk_Sessions;
	
	
		
	// Below are User settings locators	
	@FindBy (how = How.XPATH, using = "//h2[@translate='settings.title']")
	private WebElement title_UserSettingsPage;
	
	@FindBy (how = How.XPATH, using = "//div/input[@name='firstName']")
	private WebElement editbx_FirstName;
	
	@FindBy (how = How.NAME, using = "//label[text() = 'First Name']")
	private WebElement lbl_FirstName;
	
	@FindBy (how = How.XPATH, using = "//label[text() = 'Last Name']")
	private WebElement lbl_LastName;
	
	@FindBy (how = How.NAME, using = "lastName")
	private WebElement editbx_LastName;
	
	
	@FindBy (how = How.XPATH, using = "//label[text() = 'E-mail']")
	private WebElement lbl_Email;
	
	
	@FindBy (how = How.NAME, using = "email")
	private WebElement editbx_Email;
	
	
	@FindBy (how = How.XPATH, using = "//label[text() = 'Language']")
	private WebElement lbl_Language;
	
	
	@FindBy (how = How.NAME, using = "langKey")
	private WebElement sel_Language;
	
	@FindBy (how = How.XPATH, using = "//button[text() = 'Save']")
	private WebElement btn_UserSettings_Save;
	
	@FindBy (how = How.XPATH, using = "//div[text() = ' Settings could not be saved.']")
	private WebElement errMsg_SettingsNotSaved;
	
	
	// Below are Password settings locators
	@FindBy (how = How.XPATH, using = "//div/h2[@translate = 'password.title']")
	private WebElement title_PasswordPage;	
	
	
	@FindBy (how = How.XPATH, using = "//label[text() = 'New password']")
	private WebElement lbl_NewPassword;
	
	@FindBy (how = How.XPATH, using = "//input[@name = 'password' and @placeholder = 'New password']")
	private WebElement editbx_NewPassword;
	
	@FindBy (how = How.XPATH, using = "//div/p[@translate = 'global.messages.validate.newpassword.minlength']")
	private WebElement password_MinCharsErrMsg;
	
	
	@FindBy (how = How.XPATH, using = "//label[text() = 'New password confirmation' and @translate = 'global.form.confirmpassword'")
	private WebElement lbl_NewPasswordConfirmation;
	
	@FindBy (how = How.XPATH, using = "//input[@name = 'confirmPassword' and @placeholder = 'Confirm the new password']")
	private WebElement editbx_NewPasswordConfirmation;
	
	@FindBy (how = How.XPATH, using = "//*[@id='strengthBar']/li[4]")
	private WebElement password_Strength;
	
	@FindBy (how = How.XPATH, using = "//button[text() = 'Save' and @type = 'submit']")
	private WebElement btn_Password_Save;
	
	
	// Below are Session settings locators
	@FindBy (how = How.XPATH, using = "//h2[contains(text() , 'Active sessions for ')]")
	private WebElement title_SessionPage;
	
	@FindBy (how = How.CLASS_NAME, using = "table table-striped")
	private WebElement tbl_Session;
	
	@FindBy (how = How.XPATH, using = "//button[text() = 'Invalidate' and @type = 'submit']")
	private WebElement btn_Invalidate;
	
	@FindBy (how = How.XPATH, using = "//div/strong[text() = 'Session invalidated!']")
	private WebElement msg_SessionInvalidated;
	
	
	
	@FindBy (how = How.XPATH, using = "//span[text()='Account']")
	private WebElement menu_Account;
	
	@FindBy (how = How.XPATH, using = "//span[text()='Settings' and @translate = 'global.menu.account.settings']")
	private WebElement sel_Settings;
	
	@FindBy (how = How.XPATH, using = "//span[text()='Password' and @translate = 'global.menu.account.password']")
	private WebElement menu_Password;
	
	@FindBy (how = How.XPATH, using = "//a[@ui-sref = 'sessions']")
	private WebElement menu_Sessions;
	
	
	// Below are Logout locators
	@FindBy (how = How.XPATH, using = "//span[text() = 'Log out' and @translate = 'global.menu.account.logout']")
	private WebElement lnk_Logout;
	
	// Below are User settings methods
	
	public boolean verifyUserSettingsPageTitle (String userSettingsPageTitle){
		try{
			click(lnk_Account);
			click(lnk_Settings);
			return title_UserSettingsPage.getText().contains(userSettingsPageTitle);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());
			return false;
		}
	}
	
	public AccountPage goToUserSettingsPage(){
		try{
			click(lnk_Account);
			click(lnk_Settings);			
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}
		return this;
	}
	
	public AccountPage enterFirstName (String firstName){
		try{
			clear(editbx_FirstName);
			type(firstName, editbx_FirstName);			
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}
		return this;
		
	}

	public AccountPage enterLastName (String lastName){
		try{
			clear(editbx_LastName);
			type(lastName, editbx_LastName);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public AccountPage enterEmail (String email) {
		try{
			clear(editbx_Email);
			type(email, editbx_Email);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	/*public AccountPage selectLanguage (String language) {
		selectItemFromList(sel_Language);
		return this;
	}*/
	
	public AccountPage ClickOnUserSettingsSave (){
		try{
			click (btn_UserSettings_Save);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public boolean verifySettingsSaved (String errMsgUserSettingsSaved){
		try{
			return errMsg_SettingsNotSaved.getText().contains(errMsgUserSettingsSaved);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());
			return false;
		}		
	}
	
	// Below are Password settings methods	
	public boolean verifyPasswordPageTitle(String passwordPageTitle) {
		try{
			click (lnk_Account);
			click (lnk_Password);
			return title_PasswordPage.getText().contains(passwordPageTitle);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());
			return false;
		}				
	}
	
	public AccountPage enterNewPassword(String newPassword) {
		try{
			clear(editbx_NewPassword);
			type(newPassword, editbx_NewPassword);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public AccountPage goToPasswordPage(){
		try{
			click (lnk_Account);
			click (lnk_Password);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public boolean verifyPwdMinCharsErrMsg(String pwdMinCharsErrMsg){
		try{
			return password_MinCharsErrMsg.getText().equals(pwdMinCharsErrMsg);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());	
			return false;
		}			
	}
	
	public boolean verifyPwdStrength(String styleRGB){
		try{
			return password_Strength.getAttribute("style").contains(styleRGB);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());	
			return false;
		}			
	}
	
	
	
	public AccountPage enterNewPasswordConfirmation(String newPasswordConfirmation){
		try{
			clear (editbx_NewPasswordConfirmation);
			type(newPasswordConfirmation, editbx_NewPasswordConfirmation);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());				
		}		
		return this;
	}
	
	public AccountPage clickOnNewPasswordPageSave(){
		try{
			click (btn_Password_Save);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());				
		}
		
		return this;
	}

	// Below are Session settings methods
	public boolean verifySessionPageTitle (String sessionPageTitle){
		try{
			click (lnk_Account);
			click (lnk_Sessions);
			return title_SessionPage.getText().contains(sessionPageTitle);	
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());	
			return false;
		}					
	}
	
	
	
	public AccountPage clickOnInvalidateButton(){
		try{
			click (btn_Invalidate);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public AccountPage clickOnAccountMenu(){
		try{
			click (menu_Account);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public AccountPage selectSettingsFromMenu (){
		try{
			click (sel_Settings);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}			
		return this;
	}
	
	public AccountPage selectPasswordFromMenu(){
		try{
			click (menu_Password);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public AccountPage selectSessionsFromMenu (){
		try{
			click (menu_Sessions);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}		
		return this;
	}
	
	public boolean sessionValidateMsg(String sessionValidateMsg){
		try{
			return msg_SessionInvalidated.getText().contains(sessionValidateMsg);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());
			return false;
		}		
	}
	
	public HomePage selectLogoutFromMenu (){
		try{
			click (lnk_Logout);
		}catch (NoSuchElementException exception){
			logger.error("Element not found"+ exception.toString());			
		}			
		return new HomePage(driver);
	}
	
}
