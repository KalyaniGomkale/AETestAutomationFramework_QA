package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.FileManagementPage;
import com.ae.qa.pagesTenantAdmin.FileManagementPageTA;
import com.ae.qa.util.ExcelHandler;

public class FileManagementPageTestTA extends TestBase {
	FileManagementPageTA filemanagementpageta;

	public FileManagementPageTestTA() {
		super();
	}
	@Test(priority=198,alwaysRun=true)
	public void validateFileManagementPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateFileManagementPageTATest", "TC_Additional:Verify Clicking File Management tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		filemanagementpageta = new FileManagementPageTA();
		filemanagementpageta.validateFileManagementPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "File Management Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=1026,alwaysRun=true)
	public void validateUploadWFFileManagementTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadWFFileManagementTest", "TC_257: Verify respective file get copy when upload file for more than one workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		filemanagementpageta = new FileManagementPageTA();
		filemanagementpageta.validateUploadWorkflowFiles(TestDataInMap.get("wfName"),TestDataInMap.get("fName"));
		extentTest.log(extentTest.getStatus(), "Workflow file is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=1027,alwaysRun=true)
	public void validateEditWFFileManagementTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditWFFileManagementTest", "TC_258: Verify edit with same file name with edited data");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		filemanagementpageta = new FileManagementPageTA();
		filemanagementpageta.validateEditWorkflowFiles();
		extentTest.log(extentTest.getStatus(), "Workflow file is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=1028,alwaysRun=true)
	public void validateDeleteUploadWFFileManagementTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteUploadWFFileManagementTest", "TC_259: Verify delete file");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		filemanagementpageta = new FileManagementPageTA();
		filemanagementpageta.validateDeleteUploadWorkflowFiles();
		extentTest.log(extentTest.getStatus(), "Workflow file is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
