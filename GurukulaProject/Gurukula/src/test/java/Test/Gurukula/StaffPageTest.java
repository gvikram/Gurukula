package Test.Gurukula;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.gurukula.common.ConfigValues;
import com.org.gurukula.common.DriverConfig;
import com.org.gurukula.pages.LoginPage;
import com.org.gurukula.pages.StaffPage;

public class StaffPageTest extends DriverConfig{
	
	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	
	/**
	 * TC - staff_001	Verify Staff page title
	 */
	@Parameters("staffPageTitle")
	@Test (groups={"Staff", "Regression"})
	public void staff_001 (@Optional ("Staffs") String staffPageTitle){
		try{
			logger.info("TC execution started - staff_001	Verify Staff page title");
			LoginPage loginpage = 
					PageFactory.initElements(getDriver(), LoginPage.class);
			StaffPage staffpage = 
					PageFactory.initElements(getDriver(), StaffPage.class);	
			loginpage.openGurukula();
			loginpage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);		
			staffpage.verifyStaffTitle(staffPageTitle);
			logger.info("TC execution completed - staff_001	Verify Staff page title");
		} catch (Exception e) {
			logger.error("TC failed - staff_001	Verify Staff page title"+e.toString());
		}		
	}
		
	
	/**
	 * TC - staff_002	Verify create new Staff
	 */
	@Parameters ({"staffName", "staffBranch", "branchName", "branchCode"})
	@Test (groups={"Staff", "Smoke", "Regression"})
	public void staff_002 (@Optional ("StaffOne") String staffName, @Optional ("BranchOne") String staffBranch, @Optional ("BranchOne") String branchName, @Optional ("12") String branchCode) {
		try{
			logger.info("TC execution started - Staff_002	Verify create new Staff");
			LoginPage loginpage = 
					PageFactory.initElements(getDriver(), LoginPage.class);			
			StaffPage staffpage = 
					PageFactory.initElements(getDriver(), StaffPage.class);				
			loginpage.openGurukula();
			loginpage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);			
			staffpage.selectStaffPage();
			staffpage.createNewStaff(staffName, staffBranch);
			logger.info("TC execution completed - Staff_002	Verify create new Staff");
		} catch (Exception e) {
			logger.error("TC failed - Staff_002	Verify create new Staff"+e.toString());
		}		
	}
	
		
	/**
	 * TC - staff_003	Verify Staff View
	 */
	@Parameters ({"staffName", "staffBranch", "branchName", "branchCode"})
	@Test (groups={"Staff", "Regression"})
	public void staff_003 (@Optional ("StaffOne") String staffName, @Optional ("BranchOne") String staffBranch, @Optional ("BranchOne") String branchName, @Optional ("12") String branchCode) {
		try{
			logger.info("TC execution started - staff_004	Verify Staff View");
			LoginPage loginpage = 
					PageFactory.initElements(getDriver(), LoginPage.class);			
			StaffPage staffpage = 
					PageFactory.initElements(getDriver(), StaffPage.class);				
			loginpage.openGurukula();
			loginpage.login(ConfigValues.adminUsername, ConfigValues.adminPassword);			
			staffpage.selectStaffPage();
			staffpage.createNewStaff(staffName, staffBranch);
			staffpage.viewStaffButton();
			logger.info("TC execution completed - staff_004	Verify Staff View");
		} catch (Exception e) {
			logger.error("TC failed - staff_004	Verify Staff View"+e.toString());
		}	
	}
	
	
}
