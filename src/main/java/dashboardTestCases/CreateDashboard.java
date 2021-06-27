package dashboardTestCases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseMethods;

import pagesPackage.LoginPage;

public class CreateDashboard extends BaseMethods {

	@Parameters("browser")
	@BeforeTest
	public void setSheetName(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			fileName = "ChromeDashboard";
			sheetName = "Sheet1";
		}else if(browser.equalsIgnoreCase("Edge")) {
			fileName = "EdgeDashboard";
			sheetName = "Sheet1";
		}
	}

	
	@Test(dataProvider = "fetchData")
	public void verifyCreateDashboard(String dashboardName, String selectApp) {

		new LoginPage(driver)
		.enterLoginName()
		.enterLoginPassword().clickLoginButton()
		.clickToggleButton().clickViewAllOption()
		.enterMenuOptionDashboards(selectApp).clickOnMenuOptionDashboards()
		.clickNewDashboards().switchToFrameOfPopUp()
		.enterNewDashboardName(dashboardName).clickCreateButton()
		.switchToFrameOfWindow().clickSaveButton()
		.clickDoneButton()
		.verifyDashboardMessage(dashboardName);	

	}
}