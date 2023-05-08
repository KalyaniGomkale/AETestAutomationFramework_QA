package com.ae.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class ServerLogsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage = new InformationPage();
	public SystemSettingsPage systemsettingspage = new SystemSettingsPage();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[contains(text(),'Logs')]")
	@CacheLookup
	WebElement logsTab;
	@FindBy(xpath="//a[text()='Server Logs']")
	WebElement serverLogsTab; 
	@FindBy(xpath="//select[@id='type']")
	WebElement durationDrpdown;
	@FindBy(id="edit")
	WebElement downloadBtn;
	@FindBy(id="startDate-datepicker")
	WebElement startDate;
	@FindBy(id="toDate-datepicker")
	WebElement endDate;
	@FindBy(xpath="//*[@class='ui-datepicker-year']")
	WebElement endYear;
	@FindBy(xpath="//*[@class='ui-datepicker-month']")
	WebElement endMonth;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//div[@class='error']")
	WebElement errorMessage;


	public ServerLogsPage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToServerLogs() throws Exception {
		// Click Logs Tab
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Reporter.log("Clicked on logs tab",true);
		Thread.sleep(2000);
		serverLogsTab.click();
		Reporter.log("Clicked on server logs tab", true);
		Thread.sleep(2000);
	}

	public void presenceOfDownloadBtn() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(2000);
		navigateToServerLogs();
		Boolean isPresent = downloadBtn.isDisplayed();
		System.out.println("Is present for sysadmin: "+isPresent);
		if(isPresent.equals(true)) {
			System.out.println("Download server log is available in sysadmin");
		} else {
			System.out.println("Download server log is not available in sysadmin");
		}

	}
	public void downloadServerLogs(String duration) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(2000);
		navigateToServerLogs();
		Select duration_dropdown= new Select(durationDrpdown);
		duration_dropdown.selectByValue(duration);
		downloadBtn.click();
		Reporter.log("Clicked on download btn", true);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg =Messages.downloadServerLogsSuccessMsg;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Download does not started.");
		Reporter.log("Server logs download started Successfully",true);
		informationpage.validateSignOut();
	}

	//BYDATE
	public void selectOnlyEndDate(String duration,String endyear,String endmonth,String endday) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(2000);
		navigateToServerLogs();
		Select duration_dropdown= new Select(durationDrpdown);
		duration_dropdown.selectByValue(duration);
		//downloadServerLogs(duration);
		Reporter.log("Selected Custom duration from dropdown", true);
		endDate.click();
		Select endYear_dropdown= new Select(endYear);
		endYear_dropdown.selectByVisibleText(endyear);
		Select endMonth_dropdown= new Select(endMonth);
		endMonth_dropdown.selectByVisibleText(endmonth);
		WebElement endDay= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@data-date='"+endday+"']"));
		endDay.click();
		Thread.sleep(2000);
		downloadBtn.click();
		Reporter.log("Clicked on download btn", true);
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String actual_successMsg = errorMessage.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg =Messages.dateRangeFailureMsg;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Correct error message is not displaying");
		informationpage.validateSignOut();

	}
	public void selectOnlyStartDate(String duration,String startyear,String startmonth,String startday) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(2000);
		navigateToServerLogs();
		Select duration_dropdown= new Select(durationDrpdown);
		duration_dropdown.selectByValue(duration);
		//downloadServerLogs(duration);
		Reporter.log("Selected Custom duration from dropdown", true);
		startDate.click();
		Select endYear_dropdown= new Select(endYear);
		endYear_dropdown.selectByVisibleText(startyear);
		Select endMonth_dropdown= new Select(endMonth);
		endMonth_dropdown.selectByVisibleText(startmonth);
		WebElement endDay= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@data-date='"+startday+"']"));
		endDay.click();
		Thread.sleep(2000);
		downloadBtn.click();
		Reporter.log("Clicked on download btn", true);
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String actual_successMsg = errorMessage.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg =Messages.dateRangeFailureMsg;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Correct error message is not displaying");
		informationpage.validateSignOut();
	}
	public void selectStartDateYesterdayAndNoEndDate(String duration,String startyear,String startmonth,String startday) throws Exception {
		selectOnlyStartDate(duration,startyear,startmonth,startday);
	}
	public void selectBothStartDateAndEndDate(String duration,String startyear,String startmonth,String startday,
			String endyear,String endmonth,String endday) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(2000);
		navigateToServerLogs();
		Select duration_dropdown= new Select(durationDrpdown);
		duration_dropdown.selectByValue(duration);
		//downloadServerLogs(duration);
		Reporter.log("Selected Custom duration from dropdown", true);
		startDate.click();
		Select endYear_dropdown= new Select(endYear);
		endYear_dropdown.selectByVisibleText(startyear);
		Select endMonth_dropdown= new Select(endMonth);
		endMonth_dropdown.selectByVisibleText(startmonth);
		WebElement endDay= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@data-date='"+startday+"']"));
		endDay.click();
		Thread.sleep(2000);
		endDate.click();
		Select endYear_Dropdown= new Select(endYear);
		endYear_Dropdown.selectByVisibleText(endyear);
		Select endMonth_Dropdown= new Select(endMonth);
		endMonth_Dropdown.selectByVisibleText(endmonth);
		WebElement end_Day= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@data-date='"+endday+"']"));
		end_Day.click();
		Thread.sleep(2000);
		downloadBtn.click();
		Reporter.log("Clicked on download btn", true);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg =Messages.downloadServerLogsSuccessMsg;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Download does not started.");
		Reporter.log("Server logs download started Successfully",true);
		informationpage.validateSignOut();
	}
	
}