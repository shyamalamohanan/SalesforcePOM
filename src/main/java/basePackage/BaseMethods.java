package basePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {
	public WebDriver driver;
	public String fileName;
	public String sheetName;
	
	@Parameters("browser")
	@BeforeMethod
	public void startApplication(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("disable-notifications");
			options.addArguments("start-maximized");
			driver = new EdgeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
	}

	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

	
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		return utils.ReadExcel.readExcelData(fileName,sheetName);
	}
}
