package com.org.gurukula.pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.gurukula.common.ConfigValues;

public class StaffPage extends BasePage {
	
	final static Logger logger = LoggerFactory.getLogger(StaffPage.class);

	public StaffPage(WebDriver driver) {
		super(driver);	
		logger.info("On Staff Page");				
	}
	
	
	// Below are Staff page locators
	@FindBy (how = How.XPATH, using = "//class/class[text() = 'Staffs']")
	private WebElement title_StaffPage;
	
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Create a new Staff']")
	private WebElement btn_CreateNewStaff;
	
	@FindBy (how = How.ID, using = "searchQuery")
	private WebElement editbx_StaffSearch;
	
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Search a Staff']")
	private WebElement btn_SearchStaff;
	
	@FindBy (how =  How.LINK_TEXT, using = "<<")
	private WebElement lnk_LeftNavigation;
	
	@FindBy (how =  How.LINK_TEXT, using = "<<")
	private WebElement lnk_RightNavigation;
	
	// To find ID, Name, Branch columns
	@FindBy (how = How.CLASS_NAME, using = "table table-striped")
	private WebElement tbl_Staff;
	
	@FindBy (how = How.XPATH, using = "//input[@name = 'name' and @ng-model = 'staff.name']")
	private WebElement editbx_StaffName;
	
	@FindBy (how = How.XPATH, using = "//select[@name = 'related_staffbranch' and @ng-model = 'staff.related_branchId']")
	private WebElement sel_StaffBranch;
			
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Save']")
	private WebElement btn_Save;
	
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Cancel']")
	private WebElement btn_Cancel;
	
	
	
	@FindBy (how = How.XPATH, using =  "//span[text() = 'Entities']")
	private WebElement menu_Entities;
	
	@FindBy (how = How.XPATH, using =  "//ul/li/a/span[text() = 'Staff']")
	private WebElement sel_Staff;
	
	@FindBy (how = How.XPATH, using =  "//button/span[text() = 'View']")
	private WebElement view_Staff;
	
	@FindBy (how = How.XPATH, using =  "//button/span[text() = 'Edit']")
	private WebElement edit_Staff;
	
	@FindBy (how = How.XPATH, using =  "//button/span[text() = 'Delete']")
	private WebElement delete_Staff;
	
	@FindBy (how = How.XPATH, using =  "//button/span[text() = 'Back']")
	private WebElement BackButton_ViewStaff;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'entity.validation.minlength' and @translate-value-min='5']")
	private WebElement errMsg_Atleast5Chars;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'entity.validation.pattern']")
	private WebElement errMsg_AlphNumeric;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'entity.validation.minlength' and @translate-value-min='2']")
	private WebElement errMsg_Atleast2Chars;
	
	@FindBy (how = How.XPATH, using =  "//a/span/span[text()='Home']")
	private WebElement lnk_Home;
	
	@FindBy (how = How.XPATH, using =  "//div/select[@ng-options='branch.id as branch.name for branch in branchs']")
	private WebElement sel_Branch;
	

	
	// Below are Branch page methods
		public boolean verifyStaffTitle (String title_StaffPage){
			try
			{
				return title_StaffPage.equals(title_StaffPage);
				
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );	
				return false;
			}	
		}
		
		public StaffPage clickOnCreateNewStaffButton (){
			try{
				click (btn_CreateNewStaff);		
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}					
			return this;
		}
		
		public StaffPage enterStaffName (String staffName){
			try{
				waitForIsDisplayed (editbx_StaffName, ConfigValues.waitMin);
				clear (editbx_StaffName);
				type (staffName, editbx_StaffName);	
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}					
			return this;
		}
		
		
		
		public StaffPage clickOnSave (){
			try{
				click (btn_Save);	
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}					
			return this;			
		}
		
		public StaffPage clickOnCancel (){
			try{
				logger.info("Clicked on Cancel button");
				click (btn_Cancel);	
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}					
			return this;
		}
		
		
		
		public StaffPage selectStaffPage(){
			try{
				logger.info("Selecting Branch page");
				click (menu_Entities);
				click (sel_Staff);	
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}					
			return this;
		}
		
		public StaffPage selectBranchName(String branchName){
			try{
				logger.info("Select Branch Name");
				click (sel_Branch);
				click (sel_StaffBranch);
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );					
			}				
			return this;			
		}
		
		public boolean createNewStaff(String staffName, String branchName){
				
				try{
					logger.info("Creating new Branch");
					clickOnCreateNewStaffButton();
					enterStaffName(staffName);
					selectBranchName(branchName);					
					clickOnSave ();
					return true;			
				}
				catch(NoSuchElementException nse)
				{
					logger.error("Branch not created");
					return false;
				}				
			}
			
			
			public boolean searchStaff(String staffName){				
				try {
					clear (editbx_StaffSearch);
					type(staffName, editbx_StaffSearch);				
					click (btn_SearchStaff);
					//return isLocatorEnabled (driver.findElement(By.xpath("//class/class[text()="+staffName+"]")));
					return true;
				}
				catch(NoSuchElementException exception){
					logger.error("Branch not exists"+exception.toString());
					return false;
				}
				
				
			}
			
			// View Branch
			public StaffPage viewStaffButton (){
				try{
					logger.info("Clicked on Branch view button");
					waitForIsDisplayed (view_Staff, ConfigValues.waitMin);
					click (view_Staff);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );					
				}					
				return this;
			}
			
			//editBranch - searches a branch with name and edits
			public boolean editStaffName(){
				try{
					logger.info("Clicked on edit button");
					click (edit_Staff);
					return true;
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );	
					return false;
				}
				
			}
			
			
			
			public boolean deleteStaff(){
				try{
					logger.info("Clicked on Branch deleted button");
					click (delete_Staff);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );	
					return false;
				}						
				return true;				
			}
			
			public StaffPage clickOnViewStaffBackButton (){
				try{
					click (BackButton_ViewStaff);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );						
				}					
				return this;
			}
			
			public boolean verifyAtLeast5CharsErrMsg(String errMsg){
				try{
					return errMsg_Atleast5Chars.equals(errMsg);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );		
					return false;
				}	
				
			}
			
			public boolean verifyAtLeast2CharsErrMsg(String errMsg){
				try{
					return errMsg_Atleast2Chars.equals(errMsg);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );		
					return false;
				}	
				
			}
			
			public boolean verifyValidationPatternErrMsg(String errMsg){
				try{
					return errMsg_AlphNumeric.equals(errMsg);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );		
					return false;
				}				
			}
			
			public StaffPage verifyLeftAndRightNavigations(){
				try{
					click(lnk_LeftNavigation);
					click (lnk_RightNavigation);
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );					
				}					
				return this;
			}
			
			
			public HomePage clickOnHome (){
				try{
					click (lnk_Home);	
				}catch(NoSuchElementException exception){
					logger.error("Element not found" + exception.toString() );					
				}								
				return new HomePage(driver);				
			}
		
		

	

	
	

	

}
