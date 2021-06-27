package pagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.BaseMethods;

public class HomePage extends BaseMethods{
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage clickToggleButton() {
		WebElement eleToggleButton = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		eleToggleButton.click();
		return this;
	}

	public HomePage clickViewAllOption() {
		WebElement eleViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		eleViewAll.click();
		return this;
	}

	public HomePage enterMenuOptionDashboards(String selectApp) {
		WebElement eleSearchApps = driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']"));
		eleSearchApps.sendKeys(selectApp);
		return this;
	}

	public CreateDashboardsPage clickOnMenuOptionDashboards() {
		WebElement eleDashboardsLink = driver.findElement(By.xpath("//p[@class='slds-truncate']"));
		eleDashboardsLink.click();
		return new CreateDashboardsPage(driver);
	}
}
