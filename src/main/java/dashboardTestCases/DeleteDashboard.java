package dashboardTestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseMethods;
import pagesPackage.LoginPage;

public class DeleteDashboard extends BaseMethods{

	@Parameters("browser")
	@BeforeTest
	public void setSheetName(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
		fileName = "ChromeDashboard";
		sheetName = "Sheet4";
	}else if(browser.equalsIgnoreCase("Edge")) {
		fileName = "EdgeDashboard";
		sheetName = "Sheet4";
		}
	}
	
	@Test(dataProvider = "fetchData")
	public void verifyDeleteDashboard(String dashboardName, String selectApp, String menuOption) throws InterruptedException {
		String expctedMessage = "No results found";
		
		new LoginPage(driver)
		.enterLoginName().enterLoginPassword().clickLoginButton()
		.clickToggleButton().clickViewAllOption()
		.enterMenuOptionDashboards(selectApp)
		.clickOnMenuOptionDashboards()
		.clickDashboardsTab()
		.searchDashboard(dashboardName)
		.clickOnDashboardDropDown()
		.selectDashboardDropDownOption(menuOption)
		.clickConfirmDeleteButton()
		.verifyDeleteBannerMessage(expctedMessage);
		
	}	
		
}
