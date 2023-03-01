package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.util.ExcelHandler;

public class ExternalAppsTestTA extends TestBase {
	ExternalAppsPageTA externalappspageta;

	public ExternalAppsTestTA() {
		super();
	}

	@Test(priority=900)
	public void validateRegisterExternalAppTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateRegisterExternalAppTATest", "TC_653:Verify can register External app");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		externalappspageta = new ExternalAppsPageTA();
		externalappspageta.validateRegisterExternalApp("Google Chart","https://chart.apis.google.com/chart?chs=500x500&chma=0,0,100,100&cht=p&chco=FF0000%2CFFFF00%7CFF8000%2C00FF00%7C00FF00%2C0000FF&chd=t%3A122%2C42%2C17%2C10%2C8%2C7%2C7%2C7%2C7%2C6%2C6%2C6%2C6%2C5%2C5&chl=122%7C42%7C17%7C10%7C8%7C7%7C7%7C7%7C7%7C6%7C6%7C6%7C6%7C5%7C5&chdl=android%7Cjava%7Cstack-trace%7Cbroadcastreceiver%7Candroid-ndk%7Cuser-agent%7Candroid-webview%7Cwebview%7Cbackground%7Cmultithreading%7Candroid-source%7Csms%7Cadb%7Csollections%7Cactivity|Chart");
		extentTest.log(extentTest.getStatus(), "External Apps is registred successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=901)
	public void validateOpenExternalAppTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateOpenExternalAppTATest", "TC_654:Verify can open External app");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		externalappspageta = new ExternalAppsPageTA();
		externalappspageta.validateOpenExternalApp("Google Chart");
		extentTest.log(extentTest.getStatus(), "External Apps is opened successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=902)
	public void validateOpenExternalAppNewTabTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateOpenExternalAppNewTabTATest", "TC_Additional:Verify can open External app in new tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		externalappspageta = new ExternalAppsPageTA();
		externalappspageta.validateOpenExternalAppNewTab("Google Chart");
		extentTest.log(extentTest.getStatus(), "External Apps is opened successfully in new tab");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=182)
	public void validateExternalAppsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateExternalAppsPageTATest", "TC_Additional:Verify Clicking External Apps tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		externalappspageta = new ExternalAppsPageTA();
		externalappspageta.validateExternalAppsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "External Apps Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
