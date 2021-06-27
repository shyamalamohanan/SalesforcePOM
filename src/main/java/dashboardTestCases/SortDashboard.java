package dashboardTestCases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseMethods;
import pagesPackage.LoginPage;


public class SortDashboard extends BaseMethods{

	@Test()
	public void verifySortDashboard() throws InterruptedException {

		String selectApp = "Dashboards";
		new LoginPage(driver)
		.enterLoginName().enterLoginPassword()
		.clickLoginButton()
		.clickToggleButton()
		.clickViewAllOption()
		.enterMenuOptionDashboards(selectApp)
		.clickOnMenuOptionDashboards()
		.clickDashboardsTab()
		.readDashboardItemsAsDisplayed()
		.clickOnSortArrow()
		.verifyDashboardItemsAsDisplayed();
	}
}
