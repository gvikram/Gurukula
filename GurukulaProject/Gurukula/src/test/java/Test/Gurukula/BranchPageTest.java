package Test.Gurukula;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.org.gurukula.common.ConfigValues;
import com.org.gurukula.common.DriverConfig;
import com.org.gurukula.pages.BranchPage;
import com.org.gurukula.pages.LoginPage;




public class BranchPageTest extends DriverConfig{
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	
	/**
	 *  TC - branch_001	Verify Branch title
	 *  
	 */
	@Parameters ("branchTitle")
	@Test (groups={"Branch", "Regression"})
	public void branch_001 (@Optional ("Branches") String branchTitle){
		try{
			logger.info("TC execution started - branch_001	Verify Branch title");
			LoginPage loginpage = 
				PageFactory.initElements(getDriver(), LoginPage.class);
			BranchPage branchpage = 
				PageFactory.initElements(getDriver(), BranchPage.class);		
			loginpage.openGurukula();
			loginpage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			branchpage.selectBranchPage();
			Assert.assertTrue(branchpage.verifyBranchTitle(branchTitle));
			logger.info("TC execution completed - branch_001	Verify Branch title");
		}catch (Exception e) {
			logger.error("TC failed - branch_001	Verify Branch title" + e.toString());
		}	
	}

	
	/**
	 * TC - branch_002	Verify create new branch
	 * @param branchName 
	 * @param branchCode 
	 */
	@Parameters ({"branchName", "branchCode"})
	@Test (groups={"Branch", "Smoke", "Regression"})
	public void branch_002 (@Optional ("BranchOne") String branchName, @Optional ("12") String branchCode) {
		try{
			logger.info("TC execution started - branch_002	Verify create new branch");
			LoginPage loginpage = 
					PageFactory.initElements(getDriver(), LoginPage.class);
			BranchPage branchpage = 
					PageFactory.initElements(getDriver(), BranchPage.class);		
			loginpage.openGurukula();
			loginpage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			branchpage.selectBranchPage();
			branchpage.createNewBranch (branchName, branchCode);
			Assert.assertTrue(branchpage.verifyNewBranchCreated (branchName));				
			logger.info("TC execution completed - branch_002	Verify create new branch");
		} catch (Exception e) {
			logger.error("TC failed - branch_002	Verify create new branch" + e.toString());
		}		
	}
	
	
	/**
	 * TC - branch_003	Verify Branch Search 
	 * @param branchName 
	 */
	@Parameters({"branchName", "branchCode"})
	@Test (groups={"Branch", "Regression"})
	public void branch_003 (@Optional ("BranchOne") String branchName, @Optional ("12") String branchCode) {
		try {
			logger.info("TC execution started - branch_003	Verify Branch Search ");
			LoginPage loginpage = 
					PageFactory.initElements(getDriver(), LoginPage.class);
			BranchPage branchpage = 
					PageFactory.initElements(getDriver(), BranchPage.class);		
			loginpage.openGurukula();
			loginpage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);
			branchpage.selectBranchPage();
			branchpage.createNewBranch (branchName, branchCode);
			Assert.assertTrue(branchpage.verifyNewBranchCreated (branchName));		
			branchpage.searchBranch(branchName);			
			logger.info("TC execution completed - branch_003	Verify Branch Search ");
		} catch (Exception e) {
			logger.error("TC failed - branch_003	Verify Branch Search "+e.toString());
		}	
	}
	
		
	
	
	
			
	}
