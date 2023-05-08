package com.ae.qa.pagesTenantAdmin;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class ExternalAppsPageTA extends TestBase{
	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath="//span[text()='External Apps']")
	WebElement externalAppsTab;
	@FindBy(xpath="//button[@name='new-req']")
	WebElement registerBtn;
	@FindBy(id="appName")
	WebElement appName;
	@FindBy(id="appUrl")
	WebElement appUrl;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alert_Message;
	@FindBy(xpath = "//div/h2")
	WebElement appOpenTitle;
	@FindBy(id="newTab")
	WebElement newTab;
	@FindBy(xpath="//button[text()='Unregister']")
	WebElement UnregisterBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	

	public ExternalAppsPageTA()
	{
		PageFactory.initElements(driver, this);
	}

	public void validateRegisterExternalApp(String AppName,String AppUrl) throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(externalAppsTab));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", externalAppsTab);
		Thread.sleep(2000);
		registerBtn.click();
		Reporter.log("Register button is clicked successfully",true);
		appName.sendKeys(AppName);
		Reporter.log("App Name is entered successfully",true);
		appUrl.sendKeys(AppUrl);
		Reporter.log("App URL is entered successfully",true);
		Thread.sleep(2000);
		submitBtn.click();
		Reporter.log("Submit button is clicked successfully",true);
		wait.until(ExpectedConditions.visibilityOf(alert_Message));
		String actual_Message = alert_Message.getText();
		Reporter.log("Actual Success Message:-"+actual_Message);
		String expected_Message = Messages.externalAppsSuccessMsg;
		Reporter.log("Expected Success Message:-"+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"External apps is not registered successfully");
		Reporter.log("External apps is registered successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateOpenExternalApp(String AppName) throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(externalAppsTab));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", externalAppsTab);
		Thread.sleep(2000);
		WebElement openBtn = driver.findElement(By.xpath("//table[@class='ae-table table table-bordered table-striped fade-in animate mb-0']/tr/td/label[contains(text(),'"+AppName+"')]/../../td/span[@title='Open']"));
		openBtn.click();
		Thread.sleep(2000);
		String actual_Title = appOpenTitle.getText();
		Reporter.log("Actual Title:-"+actual_Title);
		String expected_Title = AppName;
		Reporter.log("Expected Title:-"+expected_Title);
		Assert.assertEquals(actual_Title, expected_Title,"External apps is not opened successfully");
		Reporter.log("External apps is opened successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateOpenExternalAppNewTab(String AppName) throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(externalAppsTab));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", externalAppsTab);
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("//table[@class='ae-table table table-bordered table-striped fade-in animate mb-0']/tr/td/label[contains(text(),'"+AppName+"')]/../../td/span[@title='Edit']"));
		editBtn.click();
		Thread.sleep(2000);
		if(!newTab.isSelected()){
			newTab.click();
			Reporter.log("Open is New Tab checkbox is selected successfully",true);
			}else {
				Reporter.log("Open is New Tab checkbox is already selected",true);
			}
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alert_Message));
		String actual_Message = alert_Message.getText();
		Reporter.log("Actual Success Message:-"+actual_Message);
		String expected_Message = Messages.externalAppsSuccessMsg;
		Reporter.log("Expected Success Message:-"+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"External apps is not registered successfully");
		Reporter.log("External apps is registered successfully",true);
		Thread.sleep(2000);
		WebElement externalAppLink = driver.findElement(By.xpath("(//table[@class='ae-table table table-bordered table-striped fade-in animate mb-0']/tr/td)[1]"));
		String actual_externalAppLink = externalAppLink.getAttribute("title");
		System.out.println("Actual:-"+actual_externalAppLink);
		WebElement openBtn = driver.findElement(By.xpath("//table[@class='ae-table table table-bordered table-striped fade-in animate mb-0']/tr/td/label[contains(text(),'"+AppName+"')]/../../td/span[@title='Open']"));
		openBtn.click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> I1 = windowHandles.iterator();
		while(I1.hasNext()) {
			String child_window=I1.next();
			driver.switchTo().window(child_window);
		}
		String expected_externalAppLink =driver.getCurrentUrl();
		System.out.println("Expected:-"+expected_externalAppLink);
		Assert.assertEquals(actual_externalAppLink, expected_externalAppLink,"External apps is not registered successfully");
		Reporter.log("External apps is opened successfully in new tab",true);
		//Thread.sleep(2000);
		//while(I1.hasNext()) {
		//String parent_window = I1.next();
		//driver.switchTo().window(parent_window);
		//}
		//informationpageta.validateSignOut();
	}
	public void validateUnRegisterExternalApp(String AppName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(externalAppsTab));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", externalAppsTab);
		Thread.sleep(2000);
		WebElement unRegisterBtn = driver.findElement(By.xpath("//table/tr/td/label[contains(text(),'"+AppName+"')]/../../td/span[@title='Unregister']"));
		unRegisterBtn.click();
		Thread.sleep(1000);
		UnregisterBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alert_Message));
		String actual_Message = alert_Message.getText();
		Reporter.log("Actual Success Message:-"+actual_Message);
		String expected_Message = Messages.externalAppDeRegisterMsg;
		Reporter.log("Expected Success Message:-"+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"External apps is not deregistered successfully");
		Reporter.log("External apps is deregistered successfully",true);
		informationpageta.validateSignOut();
	}
	
	public void validateExternalAppsPageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(externalAppsTab));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", externalAppsTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);	
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}

}
