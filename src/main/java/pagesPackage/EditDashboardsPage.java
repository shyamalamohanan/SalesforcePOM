package pagesPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.BaseMethods;

public class EditDashboardsPage extends BaseMethods{
	public EditDashboardsPage(WebDriver driver) {
		this.driver = driver;
	}



	public EditDashboardsPage switchToFrameOfWindow() {
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

	public EditDashboardsPage clickOnEditDashboardIcon() {
		try {
			Thread.sleep(3000);
			Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver);
			((FluentWait<WebDriver>) waitFluent).withTimeout(Duration.ofSeconds(30));
			((FluentWait<WebDriver>) waitFluent).pollingEvery(Duration.ofSeconds(5));
			((FluentWait<WebDriver>) waitFluent).ignoring(Exception.class);
			WebElement eleEditIcon =driver.findElement(By.xpath("(//button[@title='Edit Dashboard Properties'])"));
			waitFluent.until(ExpectedConditions.visibilityOf(eleEditIcon));
			eleEditIcon.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return this;
	} 

	public EditDashboardsPage clearAndEnterDashboardDescriptionInput(String description) {
		try {
			WebElement eleDescription = driver.findElement(By.xpath("(//input[@id='dashboardDescriptionInput'])"));
			eleDescription.clear();	
			eleDescription.sendKeys(description);}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return this;
	} 

	public EditDashboardsPage clickSubmitButton() {
		try {
			WebElement eleSubmit = driver.findElement(By.xpath("//button[@id='submitBtn']"));
			eleSubmit.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return this;
	} 

	public EditDashboardsPage switchOutOffFrame() {
		try {
			driver.switchTo().defaultContent();
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return this;
	}

	public EditDashboardsPage clickSaveButton() {
		try {
			WebElement eleSaveButton = driver.findElement(By.xpath("//button[text()='Save']"));
			eleSaveButton.click();}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return this;
	} 

	public EditDashboardsPage clickDoneButton() {
		WebElement eleDoneButton = driver.findElement(By.xpath("//button[text()='Done']"));
		eleDoneButton.click();
		return this;
	} 

	public EditDashboardsPage clickSaveOfDoneButton() {
		try {
			WebElement eleSaveOfDone = driver.findElement(By.xpath("//button[@id='modalBtn2']"));
			eleSaveOfDone.click();}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return this;
	} 

	public EditDashboardsPage verifySavedDashboardDescripition(String expectedDescription) {
		String actualDescription="";
		try {
			WebElement eleDashboardEdited = driver.findElement(By.xpath("//div[@class='info']//p"));
			actualDescription = eleDashboardEdited.getText();
			System.out.println(actualDescription);
		}
		catch(Exception e) {
			e.printStackTrace();
		} 

		Assert.assertEquals(actualDescription,expectedDescription,"The description do not macth");
		return this;
	}

	public EditDashboardsPage setFrequency() {
		try {
			WebElement eleFrequency = driver.findElement(By.xpath("//span[text()='Daily']"));
			eleFrequency.click();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	}

	public EditDashboardsPage clickFrequencySaveButton() {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;	
			WebElement eleFrequencySave = driver.findElement(By.xpath("//button[@title='Save']"));
			js.executeScript("arguments[0].click();", eleFrequencySave);
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;	
	}

	public EditDashboardsPage verifySubscribeBanner(String expectedSubscribeBanner) {
		String actualSubscribeBanner="";
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver,60);
			WebElement eleSubscribeBanner = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
			actualSubscribeBanner = wait.until(ExpectedConditions.visibilityOf(eleSubscribeBanner)).getText();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		Assert.assertEquals(actualSubscribeBanner, expectedSubscribeBanner, "The subcription was unsuccessful");
		return this;
	}

	public EditDashboardsPage clickConfirmDeleteButton() {
		try {
			WebElement eleConfirmDelete = driver.findElement(By.xpath("//button[@title='Delete']"));
			eleConfirmDelete.click();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		return this;
	} 

	public EditDashboardsPage verifyDeleteBannerMessage(String expctedMessage) {
		String actualMessage = "";
		try {
			WebElement eleDashboardMsg = driver.findElement(By.xpath("//span[@class='emptyMessageTitle']"));
			actualMessage = eleDashboardMsg.getText();
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		Assert.assertEquals(actualMessage, expctedMessage, "The Dashboard was not deleted successfully");
		return this;
	} 



}
