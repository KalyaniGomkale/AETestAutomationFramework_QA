package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ArtifactsPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.ServerLogsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestDataHandler;

public class ServerLogsPageTest extends TestBase {

	LoginPage loginpage;
	ServerLogsPage serverlogspage;
	TestDataHandler testdata = new TestDataHandler();

	// constructor is used to initialize object of class and super to call
	// superclass objects and access the superclass methods and variables
	public ServerLogsPageTest() {
		super();
	}
	/*@Test(priority = 1)
	public void validatepresenceOfDownloadBtnTest(Method method) throws Exception {
		extentTest = extent.createTest("validatepresenceOfDownloadBtnTest","TC_xx: To Verfiy server log option for sysadmin");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		serverlogspage = new ServerLogsPage();
		serverlogspage.presenceOfDownloadBtn();
		//serverlogspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Download server logs option is present for sysadmin");
	//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 2)
	public void validatedownloadServerLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validatedownloadServerLogsTest","TC_xx: To Verfiy download server logs for today");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		serverlogspage = new ServerLogsPage();
		serverlogspage.downloadServerLogs("LATEST");
		//serverlogspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Server logs for today downloaded successfully");
	//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 3)
	public void validateselectOnlyEndDateTest(Method method) throws Exception {
		extentTest = extent.createTest("validateselectOnlyEndDateTest","TC_xx: Verify  select only endDate ( startDate not selected )");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		serverlogspage = new ServerLogsPage();
		serverlogspage.selectOnlyEndDate("BYDATE","2023","May","2");
		//serverlogspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Only end date is selected and error message displayed correctly");
	//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 4)
	public void selectOnlyStartDateTest(Method method) throws Exception {
		extentTest = extent.createTest("selectOnlyStartDateTest","TC_xx: Verify  select only startDate ( endDate not selected )");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		serverlogspage = new ServerLogsPage();
		serverlogspage.selectOnlyStartDate("BYDATE","2023","May","2");
		//serverlogspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Only start date is selected and error message displayed correctly");
	//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 5)
	public void selectStartDateYesterdayAndNoEndDateTest(Method method) throws Exception {
		extentTest = extent.createTest("selectStartDateYesterdayAndNoEndDateTest","TC_xx: Verify  select startDate as yesterday ( endDate not selected )");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		serverlogspage = new ServerLogsPage();
		serverlogspage.selectStartDateYesterdayAndNoEndDate("BYDATE","2023","May","7");
		//serverlogspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Yesterday start date is selected and error message displayed correctly");
//		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 6)
	public void selectBothStartDateAndEndDateTest(Method method) throws Exception {
		extentTest = extent.createTest("selectBothStartDateAndEndDateTest","TC_xx: Verify  select both startDate amd endDate");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		serverlogspage = new ServerLogsPage();
		serverlogspage.selectBothStartDateAndEndDate("BYDATE","2023","May","8","2023","May","8");
		//serverlogspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Start date and End date is selected and logs are downloaded successfully");
//		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}

