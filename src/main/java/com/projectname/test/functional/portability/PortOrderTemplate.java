package com.projectname.test.functional.portability;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.OrderTemplatePage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class PortOrderTemplate extends TestBaseClass{
	
	private ClinicalSettingPage clinicalSettingPage;
	private HomePage homePage;
	private SharedPage sharedPage;
	private OrderTemplatePage orderTemplatePage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Portability function for Create the Order Template, VEL-2209" )
	@Parameters({"userAccount","webSite","browser"})
	
	public void createNewOrderTemplate(String userAccount,String webSite, String browser) 
	 {
			className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ChartPreVisitLib diData = new ChartPreVisitLib();
			diData.workSheetName = "PortOrderTemplate_CA";
			diData.testCaseId = "TC_OT_001";
			diData.fetchChartPreVisitTestData();
			createNewOrderTemplate(diData,userAccount);
	 }
	
	
	/** 
	 *  Portability function for Create the Order Template
     *  To  Create Portability function for Order Template
     *  @param dIData(Order template details to be added )
     *  @param userAccount(Application Environment)
     *  @since Jan 27, 2015
     */
	
	
	public boolean createNewOrderTemplate(ChartPreVisitLib diData,String userAccount){
		boolean returnValue=true;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, diData.userName, diData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to FULL Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL  Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, diData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfully");
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Clinical settings Page                        // 
			//--------------------------------------------------------------------// 
			
			logTitleMessage("Navigate to Clinical settings Page");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
			logTitleMessage("Successfuly Navigated to Clinical settings Page");
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Order Template  Page                        // 
			//--------------------------------------------------------------------// 
			
			logTitleMessage("Navigate to Order Template  Page");
			orderTemplatePage = clinicalSettingPage.navigateToOrderTemplate(driver);
			logTitleMessage("Successfuly Navigated to Order Template  Page");
			
			//--------------------------------------------------------------------//
			//  Step-5: Create the Order Template                                 //  
			//--------------------------------------------------------------------// 
			
			logTitleMessage("Create the Order Template ");
			clinicalSettingPage.createOrderTemplate(driver,diData,orderTemplatePage);
			logTitleMessage("Successfully Created the Order Template ");
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		catch(Exception e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		
	return returnValue;
}
}
