package pagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.BaseMethods;

public class LoginPage extends BaseMethods {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPage enterLoginName(){
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("cypress@testleaf.com");
		return this;
	}
	
	public LoginPage enterLoginPassword(){
		WebElement eleUserPassword = driver.findElement(By.xpath("//input[@id='password']"));
		eleUserPassword.sendKeys("Selbootcamp@123");
		return this;
	}
	
	public HomePage clickLoginButton() {
		WebElement eleLoginButton = driver.findElement(By.xpath("//input[@id='Login']"));	
		eleLoginButton.click();
		return new HomePage(driver);
	}

}
