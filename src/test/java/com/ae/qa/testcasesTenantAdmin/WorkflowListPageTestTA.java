package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.ExcelHandler;

public class WorkflowListPageTestTA extends TestBase {
	WorkflowListPageTA workflowlistpageta;
	//public InformationPageTA informationpageta=new InformationPageTA();

	public WorkflowListPageTestTA() {
		super();
	}

	@Test(priority=54)
	public void validateImportWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowTest", "TC_082: Verify Import PS workflow w/o parameter & enable the workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		//workflowlistpageta.validateImportWorkflow("Sanity3","Sanity","Default","C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\Boolean.zip","High","20","60","3","30","Minutes");
		workflowlistpageta.validateImportWorkflow(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow without parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=55) 
	public void ValidateUploadInvalidIconTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateUploadIconTest","TC_152: Verify if user is able to upload wf icon more than 50KB");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateUploadInvalidIcon(TestDataInMap.get("wfName"),prop.getProperty("WFInavlidIcon"));
		extentTest.log(extentTest.getStatus(), "Workflow icon cant be updated as size is more than 50KB");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=56) 
	public void ValidateUploadIconTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateUploadIconTest","TC_151: Verify if user is able to upload wf icon upto 50KB");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateUploadIcon(TestDataInMap.get("wfName"),prop.getProperty("WFValidIcon"));
		extentTest.log(extentTest.getStatus(), "Workflow icon upto size 50KB uploaded successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=57) 
	public void ValidateEditManualExecutionTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateEditManualExecutionTest","TC_157: Verify if user can edit Manual execution time");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateEditManualExecution(TestDataInMap.get("wfName"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Manual execution time is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}  


	@Test(priority=58) 
	public void ValidateExportWorkflowTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateExportWorkflowTest","TC_157: Verify if user can export wf from development env.");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateExportWorkflow(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Workflow exported successfully from development environment");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=98)
	public void validateImportWorkflowWithConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigParamTest", "TC_083: Verify Import PS workflow with config parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with config parameter imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=99)
	public void validateImportWorkflowWithRuntimeParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithRuntimeParamTest", "TC_084: Verify Import PS workflow with runtime parameter without credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithRuntimeParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithRunTimeParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow with runtime parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=100)
	public void validateImportWorkflowWithConfigRuntimeParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigRuntimeParamTest", "TC_085: Verify Import PS workflow with configuration and runtime parameter without credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigRuntimeParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigRuntimeParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with configuration & runtime parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=101)
	public void validateImportWorkflowWithCredConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithCredConfigParamTest", "TC_086: Verify Import PS workflow with configuration with more than 1 credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithCredConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithCredAsConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),
				TestDataInMap.get("CrdentailParam1"), TestDataInMap.get("CrdentailParam2"));
		extentTest.log(extentTest.getStatus(), "Workflow with configuration param as credentials imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=102)
	public void ValidateShowFileStructureTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateShowFileStructureTest", "TC_095: Verify show file structure while importing workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ValidateShowFileStructure(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Show File structure validated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=103)
	public void ValidateUpdateWFWithConfigWFTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateUpdateWFWithConfigWFTest", "TC_100: Validate update workflow without config parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ValidateUpdateWFWithConfigWF(TestDataInMap.get("wfName"),
				prop.getProperty("updateWFWithoutConfigParam"));
		extentTest.log(extentTest.getStatus(), "Workflow without config parameter updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=173)
	public void validateWorkflowListPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowListPageTATest", "TC_Additional:Verify Clicking Workflows List tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA();
		workflowlistpageta.validateWorkflowListPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Workflows List Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Regression test case
	@Test(priority=305)
	public void validateImportWorkflowWithConfigParamCredAndCredpoolTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigParamCredAndCredpoolTATest", "TC_087: Verify ImportPS workflow with Config parameter which uses individual credentials + credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"),
				TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFWithCredAsConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("CrdentailParam1"),TestDataInMap.get("CrdentailParam2"));
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=2006)
	public void validateImportWFAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWFAssistedAgent", "TC_087: Verify Import workflow for registered assisted agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWFAssistedAgent(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow for assisted agent is imported successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	/*@Test(priority=315)
	public void validateImportWorkflowUnRegisteredAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowUnRegisteredAssistedAgent", "TC_087: Verify Import workflow for unregistered assisted agent");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowUnRegistredAssistedAgent("AssistedAgentWF06","For Assisted Agent","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\AssistedAgentWorkflow_v1.zip","Low","20","60","3","30","Minutes");
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	//Regression test case
	/*@Test(priority=306)
	public void ValidateExportMultipleWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowTest", "TC_138: To verify can export multiple workflow at a time as verified");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.vaildateExportMutlipleWorkflow();
		extentTest.log(extentTest.getStatus(), "Multiple workflow at a time are selected and verified");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}*/
	@Test(priority=318)
	public void ValidateShowFileStructureWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateShowFileStructureWorkflowTest", "TC_60: Verify show file structure on workflow list page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateShowFileStructureWorkflow(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Show file Strcture of workflow is displayed appropriately");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=318)
	public void validateImportWFRunParamCredTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWFRunParamCredTest", "TC_56: Verify Import PS workflow with Runtime parameter which uses credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWFRunParamCred(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFWithRuntimeCredParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("CrdentailParam1"));
		extentTest.log(extentTest.getStatus(), "Verify Import PS workflow with Runtime parameter which uses credentials is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=340)
	public void validateUpdateConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdateConfigParamTest", "TC_62: To verify update workflow which uses config parameters");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateUpdateConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),prop.getProperty("WFWithUpdatedConfigParam"),TestDataInMap.get("Param1"),TestDataInMap.get("Param2"),TestDataInMap.get("EncParam1"),TestDataInMap.get("EncParam2"));
		extentTest.log(extentTest.getStatus(), "update workflow with config parameter is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=341)
	public void validateUpdateWFCredAndCredpoolTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdateWFCredAndCredpoolTest", "TC_63: To verify update workflow uses config parameter as credentials and credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateUpdateWFCredAndCredpool(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),prop.getProperty("WFWithUpdatedCredAndCredPoolParam"),
				TestDataInMap.get("ParamValue"),TestDataInMap.get("CrdentailParam1"),TestDataInMap.get("CrdentailParam2"));
		//workflowlistpageta.validateUpdateWFCredAndCredpool("KG_Private3","For Private Purpose","KG3","Pune@1234","WFUpdateConfigCredParam","For update config cred parameter","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\WFWithConfigParam.zip","High","5",
				//"10","1","1","Hours","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\UpdateCredandCredPoolParam_v1.zip","KG_Private3", "AE1","KG_Private2");
		extentTest.log(extentTest.getStatus(), "update workflow uses config parameter as credentials and credential pool is updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Regression Test case need to add these in closure activites
	/*@Test(priority=600)
	public void validateDeleteCredentialWFTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteCredentialWFTest", "TC_113: To verify delete pool credentials used in worfklow");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateDeleteCredentialWF("WFConfigParamCred","KG_Private2");
		extentTest.log(extentTest.getStatus(), "To verify delete pool credentials used in worfklow is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Need to update the test case need a workflow for it.
	/*@Test(priority=342)
	public void validateImportWFConfigCredCredpoolandRunParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWFConfigCredCredpoolandRunParamTest", "TC_57: Verify Publish PS workflow with config (Credential pool and indivisual credentials)+Run time parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWFConfigCredCredpoolandRunParam("WFConfigRunParameter","For config cred parameter and runtime parameter","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\WFConfigCredRunParam_v1.zip","High","5",
				"10","1","1","Hours","KG_Private2", "AE1");
		extentTest.log(extentTest.getStatus(), "update workflow uses config parameter as credentials and credential pool is updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority=1051)
	public void validateEditWFtoSequentialTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditWFtoSequentialTest", "TC_163: To verify workflow get edited to Sequential");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateEditWFtoSequential(TestDataInMap.get("wfName"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Worflow is edited to sequential successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	///////////For UAT License////////////
	@Test(priority=1300)
	public void validateExportWFUATTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportWFUATTest", "TC_124: To Verify Export as Non Verified workflow from UAT enviournment");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateExportWFOtherCustomer(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),
				prop.getProperty("licenseUAT"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Export as non verified workflow from UAT environment is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1301,dependsOnMethods="validateExportWFUATTest")
	public void validateImportExportedWFUATTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportExportedWFUATTest", "TC_125: To Verify import as Non Verified workflow from UAT enviournment one cusotmer to UAT  enviournment of other customer");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportExportedWFOtherCustomer(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),
				TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("UATExportedImportWF"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Import as Non Verified workflow from UAT enviournment one cusotmer to UAT  enviournment of other customer is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	///////////For Subscription License////////////
	@Test(priority=1302)
	public void validateExportWFSubscriptionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportWFSubscriptionTest", "TC_126: To Verify Export workflow from Subscription  enviournment");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateExportWFOtherCustomer(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),
				prop.getProperty("licenseSubscription"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Export workflow from Subscription environment is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1303,dependsOnMethods="validateExportWFSubscriptionTest")
	public void validateImportExportedWFSubscriptionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportExportedWFSubscriptionTest", "TC_127: To Verify import as Non Verified workflow from Subscription enviournment one cusotmer to Subscription  enviournment of other customer");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportExportedWFOtherCustomer(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),
				TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("SubscriptionExportedImportWF"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Import as Non Verified workflow from UAT enviournment one cusotmer to Subscription  enviournment of other customer is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	///////For Enterprise License//////////////
	@Test(priority=1304)
	public void validateExportWFEnterpriseTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportWFEnterpriseTest", "TC_128: To Verify Export workflow from Enterprise  enviournment");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateExportWFOtherCustomer(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),
				prop.getProperty("licenseEnterprise"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Export workflow from Subscription environment is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1305,dependsOnMethods="validateExportWFEnterpriseTest")
	public void validateImportExportedWFEnterpriseTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportExportedWFEnterpriseTest", "TC_129: To Verify import as Non Verified workflow from Enterprise enviournment one cusotmer to Enterprise  enviournment of other customer");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportExportedWFOtherCustomer(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),
				TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("EnterpriseExportedImportWF"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Import as Non Verified workflow from UAT enviournment one cusotmer to Subscription  enviournment of other customer is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	////////////////For export as verified WF/////////////////////////////////////////////////////////////////////
	@Test(priority=1306)
    public void validateExportVerifiedWFUATTest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportVerifiedWFUATTest", "TC_141: To Verify Export as Verified workflow from UAT enviournment");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportVerifiedWFUAT(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"));
	extentTest.log(extentTest.getStatus(), "Workflow with export as verified is verified successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}

	////////////////For import export wf from one environment to other//////////////////////////////////
	@Test(priority=1308)
	public void validateExportUATWFAndImportInDevelopmentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportUATWFAndImportInDevelopmentTest", "TC_138: To Verify import workflow from UAT enviournment of one cusotmer to Development enviournment of other customer");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ImportWorkflow(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("UATExportedImportWF"),
				TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Import workflow from UAT enviournment of one cusotmer to Development enviournment of other customer is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1309)
	public void validateExportUATWFAndImportInSubscriptionTestTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportUATWFAndImportInSubscriptionTestTest", "TC_142: To Verify import workflow from Subcription enviournment of one cusotmer to UAT enviournment of other customer");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ImportWorkflow(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("UATExportedImportWF"),
				TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Import workflow from UAT enviournment of one cusotmer to Development enviournment of other customer is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1310)
	public void validateExportSubscriptionWFAndImportInDevelopmentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportSubscriptionWFAndImportInDevelopmentTest", "TC_122: To Verify Export workflow from Dev enviournment (Dev To Subs)");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ImportWorkflow(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("SubscriptionExportedImportWF"),
				TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Export workflow from Dev enviournment (Dev To Subs) is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1311)
	public void validateExportUATWFAndImportInEnterpriseTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportUATWFAndImportInEnterpriseTest", "TC_137: To Verify import workflow to Enterprise enviournment of one cusotmer from UAT enviournment of other customer");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ImportWorkflow(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("UATExportedImportWF"),
				TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Import workflow to Enterprise enviournment of one cusotmer from UAT enviournment of other customer is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	//Need to get the expected result
	/*@Test(priority=1312)
public void validateExportAsVerifiedUATWFAndImportInEnterpriseTest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportAsVerifiedUATWFAndImportInEnterpriseTest", "TC_139: To Verify Export as  Verified workflow from UAT enviournment(UAT To  Enterprise)");
	//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportAsVerifiedUATWFAndImportInEnterprise("EnterpriseUser10","Pune@1234","ExportVerifiedUATImportEnterprise","From UAT to Enterprise env","Default",prop.getProperty("UATExportAsVerifiedWF"),
			"High","20","60","3","30","Minutes");
	extentTest.log(extentTest.getStatus(), "To Verify Export as  Verified workflow from UAT enviournment(UAT To  Enterprise) is verified successfully");  
	//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}*/
////////////////WF import export for same customer[License ID should be same]///////////////////////////////////////////////////
@Test(priority=1313)
public void validateCreateDevelopmentSameCustomerTest(Method method) throws Exception {
	extentTest = extent.createTest("validateCreateDevelopmentSameCustomerTest", "TC_Additional: To Create new tenant with tenant user for same customer development license");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateCreateTenantAdminWithUploadLicense(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
			TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),prop.getProperty("SameIDDevelopmentLicense"));
	extentTest.log(extentTest.getStatus(), "Tenant user for same devlopment license ID is created successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
@Test(priority=1314)
public void validateCreateEnterpriseSameCustomerTest(Method method) throws Exception {
	extentTest = extent.createTest("validateCreateEnterpriseSameCustomerTest", "TC_Additional: To Create new tenant with tenant user for same customer Enterprise license");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateCreateTenantAdminWithUploadLicense(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
			TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),prop.getProperty("SameIDEnterpriseLicense"));
	extentTest.log(extentTest.getStatus(), "Tenant user for same enterprise license ID is created successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
@Test(priority=1315)
public void validateCreateUATSameCustomerTest(Method method) throws Exception {
	extentTest = extent.createTest("validateCreateUATSameCustomerTest", "TC_Additional: To Create new tenant with tenant user for same customer UAT license");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateCreateTenantAdminWithUploadLicense(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
			TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"),prop.getProperty("SameIDUATLicense"));
	extentTest.log(extentTest.getStatus(), "Tenant user for same UAT license ID is created successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
	//////////////////////////////For import export wf for same customer/////////////////////////////////////
	@Test(priority=1316)
public void validateExportWFDevelopmentAndImportInUATSATest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportWFDevelopmentAndImportInUATSATest", "TC_131: To Verify import workflow from Dev enviournment of one cusotmer to UAT enviournment of same customer");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportImportWFforSameCustomer(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
			prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),
			TestDataInMap.get("UserName1"),TestDataInMap.get("wfName1"),prop.getProperty("SameDevelopmentExportedUATWF"));
	extentTest.log(extentTest.getStatus(), "Import workflow from Dev enviournment of one customer to UAT enviournment of same customer is Verified successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
@Test(priority=1317)
public void validateExportWFDevelopmentAndImportInEnterpriseSATest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportWFDevelopmentAndImportInEnterpriseSATest", "TC_133: To Verify import workflow from Dev enviournment of one cusotmer to Enterprise enviournment of same customer");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportImportWFforSameCustomer(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
			prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),
			TestDataInMap.get("UserName1"),TestDataInMap.get("wfName1"),prop.getProperty("SameDevelopmentExportedEnterpriseWF"));
	extentTest.log(extentTest.getStatus(), "Import workflow from Dev enviournment of one customer to Enterprise enviournment of same customer is Verified successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
@Test(priority=1318)
public void validateExportWFUATAndImportInEnterpriseSATest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportWFUATAndImportInEnterpriseSATest", "TC_Additional: To Verify import workflow from UAT enviournment of one cusotmer to Enterprise enviournment of same customer ");
	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportImportWFforSameCustomer(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
			prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),
			TestDataInMap.get("UserName1"),TestDataInMap.get("wfName1"),prop.getProperty("SameUATExportedEnterpriseWF"));
	extentTest.log(extentTest.getStatus(), "Import workflow from UAT enviournment of one customer to Enterprise enviournment of same customer is Verified successfully");  
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
	//////////////Verified Workflow///////////////////////////////////////////////////////////////////////////////////////
	/*@Test(priority=1319)
public void validateVerfiedStatusWFAfterUpdateVerifiedWFTest(Method method) throws Exception {
	extentTest = extent.createTest("validateVerfiedStatusWFAfterUpdateVerifiedWFTest", "TC_143: Verify Verified status after Update of Verified workflow with verified workflow");
	//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateVerfiedStatusWFAfterUpdateVerifiedWF("Same_UATUser","Pune@1234","Same_EnterpriseUser","Pune@1234","SameDevelopmentUATWF","SameUATEnterpriseWF",prop.getProperty("ExportAsVerifedSameCustomerWF"),"Verified");
	extentTest.log(extentTest.getStatus(), "Verified status after Update of Verified workflow with verified workflow is verified successfully");  
	//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
@Test(priority=1320)
public void validateVerfiedStatusWFAfterUpdateNonVerifiedWFTest(Method method) throws Exception {
	extentTest = extent.createTest("validateVerfiedStatusWFAfterUpdateNonVerifiedWFTest", "TC_144: Verify Verified status after Update of Verified workflow with non verified workflow");
	//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateVerfiedStatusWFAfterUpdateNonVerifiedWF("Same_EnterpriseUser","Pune@1234","SameUATEnterpriseWF","SameUATEnterpriseWF ","Verified",prop.getProperty("WFToImportPath"));
	extentTest.log(extentTest.getStatus(), "Verified status after Update of Verified workflow with non verified workflow is verified successfully");  
	//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}*/
	////////////////////////////////////Export Multiple Workflow as Verified//////////////////////////////////////////
	/*@Test(priority=1321)
public void validateExportMultipleAsVerifiedTest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportMultipleAsVerifiedTest", "TC_145: To Verify can export multiple workflow at a time as verified");
	//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportMultipleAsVerified("Same_UATUser","Pune@1234");
	extentTest.log(extentTest.getStatus(), "Export multiple workflow as verified is verified successfully");  
	//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}
//Not getting the expected result
@Test(priority=1322)
public void validateImportExportedMultipleWorkflowTest(Method method) throws Exception {
	extentTest = extent.createTest("validateImportExportedMultipleWorkflowTest", "TC_146: To verify can import workflow exported with option multiple export");
	//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.ImportWorkflow("Same_EnterpriseUser","Pune@1234","ImportMultipleExportWF","From import multiple export workflow","Default",prop.getProperty("MultipleExportVerifiedWF"),
			"High","20","60","3","30","Minutes");
	extentTest.log(extentTest.getStatus(), "Import workflow exported with option multiple export is verified successfully");  
	//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}*/
	/*@Test(priority=1323)
public void validateExportMultipleAsNonVerifiedTest(Method method) throws Exception {
	extentTest = extent.createTest("validateExportMultipleAsNonVerifiedTest", "TC_147: To Verify can export multiple workflow at a time as non verified");
	//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	workflowlistpageta = new WorkflowListPageTA(); 
	workflowlistpageta.validateExportMultipleAsNonVerified("Same_UATUser","Pune@1234");
	extentTest.log(extentTest.getStatus(), "Export multiple workflow at a time as non verified is verified successfully");  
	//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
}*/


	//For Workflow Name
	@Test(priority = 3155)
	public void validateAdvSearchForWFNameEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEqualToWorkflowsPageTATest", "TC_009: To Verfiy Advance search for workflow name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3156)
	public void validateAdvSearchForWFNameNotEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameNotEqualToWorkflowsPageTATest", "TC_009: To Verfiy Advance search for workflow name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3157)
	public void validateAdvSearchForWFNameIsLikeWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameIsLikeWorkflowsPageTATest", "TC_009: To Verfiy Advance search for workflow name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3158)
	public void validateAdvSearchForWFNameBeginsWithWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameBeginsWithWorkflowsPageTATest", "TC_009: To Verfiy Advance search for workflow name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3159)
	public void validateAdvSearchForWFNameEndsWithWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEndsWithWorkflowsPageTATest", "TC_009: To Verfiy Advance search for workflow name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

	//For Workflow Category
	@Test(priority = 3160)
	public void validateAdvSearchForWFCategoryEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryEqualToWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Category with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3161)
	public void validateAdvSearchForWFCategoryNotEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryNotEqualToWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Category with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3162)
	public void validateAdvSearchForWFCategoryIsLikeWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryIsLikeWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Category with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3163)
	public void validateAdvSearchForWFCategoryBeginsWithWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryBeginsWithWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Category with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3164)
	public void validateAdvSearchForWFCategoryEndsWithWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryEndsWithWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Category with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

	//For Created [Calender]
	@Test(priority = 3165)
	public void validateCreatedEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToWorkflowsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3166)
	public void validateCreatedBeforeWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeWorkflowsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3167)
	public void validateCreatedAfterWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterWorkflowsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3168)
	public void validateCreatedInBetweenWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenWorkflowsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3169)
	public void validateCreatedNotInBetweenWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenWorkflowsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Workflow Status 
	@Test(priority = 3170)
	public void validateStatusDropdownEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateStatusDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3171)
	public void validateStatusDropdownNotEqualToWorkflowsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToWorkflowsPageTATest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateStatusDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
}



