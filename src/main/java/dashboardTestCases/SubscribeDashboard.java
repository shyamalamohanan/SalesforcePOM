package dashboardTestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseMethods;
import pagesPackage.LoginPage;

public class SubscribeDashboard extends BaseMethods{
	@Parameters("browser")
	@BeforeTest
	public void setSheetName(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
		fileName = "ChromeDashboard";
		sheetName = "Sheet3";
	}else if(browser.equalsIgnoreCase("Edge")) {
		fileName = "EdgeDashboard";
		sheetName = "Sheet3";
		}
	}
	
	@Test(dataProvider = "fetchData")
	public void verifySubscribeDasboard(String dashboardName,String selectApp, String menuOption) throws InterruptedException {

		String expectedSubscribeBanner = "You started a dashboard subscription.";

		new LoginPage(driver).enterLoginName().enterLoginPassword().clickLoginButton()
		.clickToggleButton().clickViewAllOption()
		.enterMenuOptionDashboards(selectApp).clickOnMenuOptionDashboards()
		.clickDashboardsTab().searchDashboard(dashboardName)
		.clickOnDashboardDropDown().selectDashboardDropDownOption(menuOption)
		.setFrequency().clickFrequencySaveButton()
		.verifySubscribeBanner(expectedSubscribeBanner);



	}

}
