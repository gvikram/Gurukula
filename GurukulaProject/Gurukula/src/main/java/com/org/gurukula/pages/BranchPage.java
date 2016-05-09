package com.org.gurukula.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.testng.log4testng.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.gurukula.common.ConfigValues;

public class BranchPage extends BasePage {

	final static Logger logger = LoggerFactory.getLogger(BranchPage.class);
	
	public BranchPage(WebDriver driver) {
		super(driver);			
	}
		
	// Below are Branch page locators
	@FindBy (how = How.XPATH, using ="//h2[text() = 'Branches']")
	private WebElement title_Branch;
	
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Create a new Branch']")
	private WebElement btn_CreateNewBranch;
	
	@FindBy (how = How.XPATH, using = "//input[@ng-model = 'searchQuery']")
	private WebElement txtbx_BranchSearch;
	
	@FindBy (how = How.XPATH, using = "//span[text() = 'Search a Branch']")
	private WebElement btn_SearchBranch;
	
	@FindBy (how = How.XPATH, using = "//tr/td[2]")
	private WebElement tbl_Branch;
	
	@FindBy (how = How.XPATH, using = "//input[@ng-model='branch.name' and @name = 'name']")
	private WebElement editbxBranch_Name;
	
	
	@FindBy (how = How.XPATH, using = "//input[@ng-model='branch.code' and @name = 'code']")
	private WebElement editbxBranch_Code;
	
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Save']")
	private WebElement btn_Save;
	
	@FindBy (how = How.XPATH, using = "//button/span[text() = 'Cancel']")
	private WebElement btn_Cancel;
	

	@FindBy (how = How.XPATH, using =  "//span[text() = 'Entities']")
	private WebElement menu_Entities;
	
	@FindBy (how = How.XPATH, using =  "//ul/li/a/span[text() = 'Branch']")
	private WebElement sel_Branch;
	
	@FindBy (how = How.XPATH, using =  "//button[1]/span[1][text() = 'View']")
	private WebElement view_Branch;
	
	@FindBy (how = How.XPATH, using =  "//tr[1]/td[2]/input")
	private WebElement editbx_ViewBranchName;
	
	@FindBy (how = How.XPATH, using =  "//tr[2]/td[2]/input")
	private WebElement editbx_ViewBranchCode;
	
	@FindBy (how = How.XPATH, using =  "//button[1]/span[1][text() = 'Edit']")
	private WebElement edit_Branch;
	
	@FindBy (how = How.XPATH, using =  "//button[1]/span[1][text() = 'Delete']")
	private WebElement delete_Branch;
	
	@FindBy (how = How.XPATH, using =  "//button/span[text() = 'Back']")
	private WebElement backbutton_ViewBranch;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'entity.validation.minlength' and @translate-value-min='5']")
	private WebElement errMsg_Atleast5Chars;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'entity.validation.pattern']")
	private WebElement errMsg_AlphNumeric;
	
	@FindBy (how = How.XPATH, using =  "//div/p[@translate = 'entity.validation.minlength' and @translate-value-min='2']")
	private WebElement errMsg_Atleast2Chars;
	
		
	// Below are Branch page methods
	public boolean verifyBranchTitle (String titleBranch){
		try
		{
			return title_Branch.getText().equals(titleBranch);			
		}
		catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());
			return false;			
		}
	}
	
	public BranchPage clickOnCreateNewBranchButton (){
		try{
			click (btn_CreateNewBranch);		
			waitForIsDisplayed (editbxBranch_Name, 5);			
		} catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());						
		}
		return this;		
	}
	
	public BranchPage enterBranchName (String branchName){
		try{
			clear (editbxBranch_Name);			
			click (editbxBranch_Name);
			type (branchName, editbxBranch_Name);
		}catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());						
		}				
		return this;
	}
	
	public BranchPage enterBranchCode (String branchCode){
		try{
			clear (editbxBranch_Code);
			type (branchCode, editbxBranch_Code);
		} catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());						
		}				
		return this;
	}
	
	public BranchPage clickOnSave (){
		try{
			click (btn_Save);
		}catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());						
		}					
		return this;		
	}
	
	public BranchPage clickOnCancel (){
		try{
			logger.info("Clicked on Cancel button");
			click (btn_Cancel);	
		}catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());						
		}			
		return this;
	}
	
	
	
	public BranchPage selectBranchPage(){
		try{
			logger.info("Selecting Branch page");
			click (menu_Entities);
			click (sel_Branch);	
		}catch(NoSuchElementException exception){
			logger.error("Element not found"+exception.toString());						
		}			
		return this;
	}
	
	
	public boolean createNewBranch(String branchName, String branchCode){			
		try{
			logger.info("Creating new Branch");
			clickOnCreateNewBranchButton();
			enterBranchName(branchName);
			enterBranchCode(branchCode);
			clickOnSave ();				
			return true;	
		}catch(NoSuchElementException exception){
				logger.error("Element not found"+exception.toString());
				return false;
			}
		
		}
		
		public boolean verifyNewBranchCreated(String branchName) {	
			try{
				waitForIsDisplayed (tbl_Branch, ConfigValues.waitMin);
				return (tbl_Branch.getText().equals(branchName));	
			}catch(NoSuchElementException exception){
				logger.error("Element not found"+exception.toString());
				return false;
			}					
		}		
		
		public boolean searchBranch(String branchName){
			
			try {
				clear (txtbx_BranchSearch);
				waitForIsDisplayed (txtbx_BranchSearch, ConfigValues.waitMin);
				type(branchName, txtbx_BranchSearch);	
				waitForIsDisplayed (txtbx_BranchSearch, ConfigValues.waitMin);
				click (btn_SearchBranch);
				waitForIsDisplayed (tbl_Branch, ConfigValues.waitMin);
				return (tbl_Branch.getText().equals(branchName));
				
			}
			catch(NoSuchElementException exception){
				logger.error("Element not found"+exception.toString());
				return false;
			}			
		}
		
		
		public boolean verifyViewBranch (String branchName, String branchCode){
			
			try{
				logger.info("Clicked on Branch view button");				
				click (view_Branch);
				waitForIsDisplayed (editbx_ViewBranchName, ConfigValues.waitMin);
				editbx_ViewBranchName.getText().equals(branchName);
				editbx_ViewBranchCode.getText().equals(branchCode);
				waitForIsDisplayed (tbl_Branch, ConfigValues.waitMin);
				return (tbl_Branch.getText().equals(branchName));					
			} catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );
				return false;
			}
		}
		
		//editBranch - searches a branch with name and edits
		public boolean editBranchName(){
			try{
				logger.info("Clicked on edit button");
				waitForIsDisplayed (edit_Branch, ConfigValues.waitMin);
				click (edit_Branch);
				waitForIsDisplayed (edit_Branch, ConfigValues.waitMin);
				return true;
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );
				return false;
			}
		}	
		
		
		public boolean deleteBranch(){
			try{
				logger.info("Clicked on Branch deleted button");
				waitForIsDisplayed (edit_Branch, ConfigValues.waitMin);
				click (delete_Branch);	
				waitForIsDisplayed (delete_Branch, ConfigValues.waitMin);
				click (delete_Branch);	
				return true;
			}catch(NoSuchElementException exception){
				logger.error("Element not found" + exception.toString() );
				return false;
			}			
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
	
	
	

}
