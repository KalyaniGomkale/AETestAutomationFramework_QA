package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ae.qa.Listeners.ITestListenerImplementation;
import com.ae.qa.base.TestBase;
import com.ae.qa.pages.IntegrationServicesPage;
import com.ae.qa.pages.PluginAssignmentsPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.pagesTenantAdmin.ArchivedPageTA;
import com.ae.qa.pagesTenantAdmin.IntegrationServicesPageTA;
import com.ae.qa.util.ExcelHandler;
@Listeners({ITestListenerImplementation.class})
public class IntegrationServicePageTestTA extends TestBase {
	IntegrationServicesPageTA integrationservicespageta;

	public IntegrationServicePageTestTA() {
		super();
	}

	@Test(priority=146,alwaysRun=true)
	public void validateAddIntegrationServicesTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddIntegrationServicesTestTA", "TC_463: Verify adding integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationservicespageta = new IntegrationServicesPageTA();
		System.out.println(TestDataInMap.get("IntName")+TestDataInMap.get("ConfLowerLimit")+TestDataInMap.get("ResponseLowerLimit")+TestDataInMap.get("MachineName")+TestDataInMap.get("IntUserName")+TestDataInMap.get("ClusterIP")+TestDataInMap.get("ClusterPort"));
		integrationservicespageta.validateAddIntegrationServices(TestDataInMap.get("IntName"), TestDataInMap.get("ConfLowerLimit"),TestDataInMap.get("ResponseLowerLimit"),TestDataInMap.get("MachineName"),TestDataInMap.get("IntUserName"),TestDataInMap.get("ClusterIP"),TestDataInMap.get("ClusterPort"));
		extentTest.log(extentTest.getStatus(), "Added Integration services successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=147,dependsOnMethods="validateAddIntegrationServicesTATest",alwaysRun=true)
	public void validateEditIntegrationServicesTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditIntegrationServicesTATest", "TC_467: Verify editing machine name in integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationservicespageta = new IntegrationServicesPageTA();
		integrationservicespageta.validateEditIntegrationServicesTA(TestDataInMap.get("IntName"),TestDataInMap.get("MachineName"));
		extentTest.log(extentTest.getStatus(), "It edited machine details of integration services successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=148,dependsOnMethods="validateAddIntegrationServicesTATest",alwaysRun=true)
	public void validateDownloadIntegrationServicesTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadIntegrationServicesTATest", "TC_468: Verify downloading integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationservicespageta = new IntegrationServicesPageTA();
		integrationservicespageta.validateDownloadIntegrationServicesTA(TestDataInMap.get("IntName"));
		extentTest.log(extentTest.getStatus(), "Integration services downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=1029,alwaysRun=true)
	public void validateEditConfJobLowerLimitIntegrationServicesTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditConfJobLowerLimitIntegrationServicesTATest", "TC_493:Verify Edit  conf job Lower limit Minutes");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationservicespageta = new IntegrationServicesPageTA();
		integrationservicespageta.validateEditConfJobLowerLimitTA(TestDataInMap.get("IntName"),TestDataInMap.get("ConfLowerLimit"));
		extentTest.log(extentTest.getStatus(), "Conf job lower limit is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=1030,alwaysRun=true)
	public void validateEditUpdateResponseJobLowerLimitIntegrationServicesTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditUpdateResponseJobLowerLimitIntegrationServicesTest", "TC_494:Verify Edit Update Response Job Lower Limit (in seconds");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationservicespageta = new IntegrationServicesPageTA();
		integrationservicespageta.validateEditUpdateResponseJobLowerLimitTA(TestDataInMap.get("IntName"),TestDataInMap.get("ResponseLowerLimit"));
		extentTest.log(extentTest.getStatus(), "Update Response lower limit is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=195,alwaysRun=true)
	public void validateIntegrationServicesPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateIntegrationServicesPageTATest", "TC_Additional:Verify Clicking Integration Services tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationservicespageta = new IntegrationServicesPageTA();;
		integrationservicespageta.validateIntegrationServicesPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Integration Services Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}

