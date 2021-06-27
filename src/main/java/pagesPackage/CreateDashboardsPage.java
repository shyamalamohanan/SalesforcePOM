package pagesPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import basePackage.BaseMethods;

public class CreateDashboardsPage extends BaseMethods{
	String sortValue;
	String name;
	int count ;
	List<String> sortList = new ArrayList<String>() ;
	List<String> manuallySortedData = new ArrayList<String>();
	List<String> afterSortList = new ArrayList<String>(); 

	public CreateDashboardsPage(WebDriver driver) {
		this.driver = driver;
	}

	public CreateDashboardsPage clickNewDashboards() {
		try {
			WebElement eleNewDasboardButton = driver.findElement(By.xpath("//div[@title='New Dashboard']"));
			eleNewDasboardButton.click();	
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage switchToFrameOfPopUp() {
		try {
			
			Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver);
			((FluentWait<WebDriver>) waitFluent).withTimeout(Duration.ofSeconds(30));
			((FluentWait<WebDriver>) waitFluent).pollingEvery(Duration.ofSeconds(5));
			((FluentWait<WebDriver>) waitFluent).ignoring(Exception.class);
			Thread.sleep(7000);
			WebElement eleFramePopUp = driver.findElement(By.xpath("//iframe[@title='dashboard']")); 
			waitFluent.until(ExpectedConditions.visibilityOf(eleFramePopUp));
			driver.switchTo().frame(eleFramePopUp);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage enterNewDashboardName(String dashboardName) {
		try {
			//Thread.sleep(3000);
			WebElement eleDasboardName = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
			eleDasboardName.sendKeys(dashboardName);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage clickCreateButton() {
		try {
			WebElement eleCreateButton = driver.findElement(By.xpath("//button[@id='submitBtn']"));
			eleCreateButton.click();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage switchOutOffFrame() {
		try {
			driver.switchTo().defaultContent();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage switchToFrameOfWindow() {
		try {
			Thread.sleep(4000);
			WebElement elframeWindow = driver.findElement(By.xpath("//iframe[@title='dashboard']")); 
			driver.switchTo().frame(elframeWindow);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	} 

	public CreateDashboardsPage clickSaveButton() {
		try {
			WebElement eleSaveButton = driver.findElement(By.xpath("//button[text()='Save']"));
			eleSaveButton.click();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	} 

	public CreateDashboardsPage clickDoneButton() {
		try {
			WebElement eleDoneButton = driver.findElement(By.xpath("//button[text()='Done']"));
			eleDoneButton.click();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	} 

	public CreateDashboardsPage verifyDashboardMessage(String newDashboardCreated) {
		String actualDasboardCreated = "";
		try {
			WebElement eleViewDashboardMessage = driver.findElement(By.xpath("(//div[@class=\"slds-media\"]//child::span)[3]"));
			actualDasboardCreated = eleViewDashboardMessage.getText();
			System.out.println(actualDasboardCreated);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}

		Assert.assertEquals(actualDasboardCreated, newDashboardCreated, "The dashborad was not created successfully");
		return this;
	} 

	public CreateDashboardsPage clickDashboardsTab() {
		try {
			JavascriptExecutor Js = (JavascriptExecutor)driver;
			WebElement eleDashboardsTab = driver.findElement(By.xpath("//span[@class='slds-truncate'][text()='Dashboards']"));
			Js.executeScript("arguments[0].click();", eleDashboardsTab);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage searchDashboard(String dashboardName) {
		try {
			WebElement eleSearchDasboard = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
			eleSearchDasboard.sendKeys(dashboardName);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage clickOnDashboardDropDown() {
		try {
			Thread.sleep(4000);
			JavascriptExecutor Js = (JavascriptExecutor)driver;
			WebElement eleDashboardDropDown = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr//child::span[text()='Show actions']"));
			Js.executeScript("arguments[0].click();", eleDashboardDropDown);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public CreateDashboardsPage readDashboardItemsAsDisplayed() {
		try {
			Thread.sleep(4000);
			WebElement eleDasboradItems = driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputText'])[2]"));
			String items=eleDasboradItems.getText();
			count = Integer.parseInt(items.replaceAll("[^0-9]", ""));	
			WebElement eleDNameUnSorted = driver.findElement(By.xpath("(//table[@role='grid']//thead//tr//th//child::span[@aria-live='assertive'])[1]"));
			sortValue = eleDNameUnSorted.getText();
			System.out.println("The value of sort in Dom before applying sort is - "+sortValue);
			for(int i=1; i<=count;i++){
				name = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//th[1]")).getText();
				sortList.add(name);
				driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//th[1]")).sendKeys(Keys.ARROW_DOWN);
			}
			Collections.sort(sortList,String.CASE_INSENSITIVE_ORDER);
			for(String sort : sortList){
				manuallySortedData.add(sort);
			}
			System.out.println(manuallySortedData);
			sortList.clear();			
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	} 

	public CreateDashboardsPage clickOnSortArrow() throws InterruptedException {
		try{

			Thread.sleep(4000);	
			JavascriptExecutor Js = (JavascriptExecutor)driver;
			WebElement eleSortArrow = driver.findElement(By.xpath("(//table[@role='grid']//thead//tr//th//child::lightning-primitive-icon[@class='slds-icon_container'])[1]"));
			Js.executeScript("arguments[0].click();", eleSortArrow);

		}
		catch(Exception e){ 
			e.printStackTrace();
		}

		return this;
	} 

	public CreateDashboardsPage verifyDashboardItemsAsDisplayed() {
		try {
			Thread.sleep(4000);
			WebElement eleDasboradItems = driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputText'])[2]"));
			String items=eleDasboradItems.getText();
			count = Integer.parseInt(items.replaceAll("[^0-9]", ""));	
			WebElement eleDNameUnSorted = driver.findElement(By.xpath("(//table[@role='grid']//thead//tr//th//child::span[@aria-live='assertive'])[1]"));
			sortValue = eleDNameUnSorted.getText();
			System.out.println("The value of sort in Dom after applying sort is - "+sortValue);
			for(int i=1; i<=count;i++){
				name = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//th[1]")).getText();
				sortList.add(name);
				driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//th[1]")).sendKeys(Keys.ARROW_DOWN);
			}			
			System.out.println(sortList);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		Assert.assertEquals(manuallySortedData, sortList, "There is a mismatch in the sorting order");
		return this;
	} 

	public EditDashboardsPage selectDashboardDropDownOption(String menuOption) {
		try {
			Thread.sleep(3000);
			List<WebElement> eleDashboradMenu = driver.findElements(By.xpath("//lightning-menu-item[@role='presentation']//child::span[@class='slds-truncate']"));
			for(int i = 1;i<=eleDashboradMenu.size();i++)
			{
				String currentOption = driver.findElement(By.xpath("(//lightning-menu-item[@role='presentation']//child::span[@class='slds-truncate'])"+"["+i+"]")).getText();
				if(currentOption.equals(menuOption))
				{
					driver.findElement(By.xpath("(//lightning-menu-item[@role='presentation']//child::span[@class='slds-truncate'])"+"["+i+"]")).click();
					break;
				}
			}
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return new EditDashboardsPage(driver);
	}
}
