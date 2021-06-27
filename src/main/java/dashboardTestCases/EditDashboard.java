package dashboardTestCases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseMethods;
import pagesPackage.LoginPage;

public class EditDashboard extends BaseMethods {
	@Parameters("browser")
	@BeforeTest
	public void setSheetName(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
		fileName = "ChromeDashboard";
		sheetName = "Sheet2";
	}else if(browser.equalsIgnoreCase("Edge")) {
		fileName = "EdgeDashboard";
		sheetName = "Sheet2";
		}
	}

	@Test(dataProvider = "fetchData")
	public void verifyEditDashoard(String dashboardName,String description, String selectApp, String menuOption) throws InterruptedException {

		String expectedDescription = "SalesForce";
	
		new LoginPage(driver)
		.enterLoginName().enterLoginPassword().clickLoginButton()
		.clickToggleButton().clickViewAllOption()
		.enterMenuOptionDashboards(selectApp).clickOnMenuOptionDashboards()
		.clickDashboardsTab()
		.searchDashboard(dashboardName)
		.clickOnDashboardDropDown()
		.selectDashboardDropDownOption(menuOption)
		.switchToFrameOfWindow()
		.clickOnEditDashboardIcon()
		.clearAndEnterDashboardDescriptionInput(description)
		.clickSubmitButton()
		.switchOutOffFrame()
		.switchToFrameOfWindow()
		.clickSaveButton()
		.clickDoneButton()
		.clickSaveOfDoneButton()
		.verifySavedDashboardDescripition(expectedDescription);

	}

}
