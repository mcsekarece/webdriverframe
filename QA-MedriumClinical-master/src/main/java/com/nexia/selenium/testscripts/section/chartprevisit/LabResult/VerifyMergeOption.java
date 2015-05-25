package com.nexia.selenium.testscripts.section.chartprevisit.LabResult;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMergeOption 	extends AbstractChartPreVisit {
		@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Merge Option, #7925")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void verifyMergeOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			ChartPreVisitLib labData = new ChartPreVisitLib();
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_001";
			labData.fetchChartPreVisitTestData();
			fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
		}
		
		
		/**
		 *  Merge Option for lab report 
		 * function to  Verify Merge Option for lab report
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws      IOException 
		 * @since  	    Dec 18, 2013
		 */
		public boolean fileNewReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Create New Patient//
				//--------------------------------------------------------------------//
				
				assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
				HomeLib patientData = new HomeLib();
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NPC_002";
				patientData.fetchHomeTestData();
				createNewPatientWithMandatory(selenium,patientData);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3:Navigation to File new lab report//
				//--------------------------------------------------------------------//
				
				assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: File new lab report//
				//--------------------------------------------------------------------//
			
				assertTrue(fileReportWithMandatory(selenium,labData,userAccount),"Creation of lab report  Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				//--------------------------------------------------------------------//
				//  Step-5: File  another  lab report//
				//--------------------------------------------------------------------//
				
				ChartPreVisitLib labData2 = new ChartPreVisitLib();
				labData2.workSheetName = "FileLabReport";
				labData2.testCaseId = "TC_LR_026";
				labData2.fetchChartPreVisitTestData();
				
				assertTrue(fileReportWithMandatory(selenium,labData2,userAccount),"Creation of another lab report  Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Merge the lab reports //
				//--------------------------------------------------------------------//
				assertTrue(selenium.isVisible(lnkLabReport),"Injection Link Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);

				assertTrue(click(selenium, lnkLabReport),"Could not click link Lab Report",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnOption),"Could not click link Option",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				if(!isChecked(selenium, chkbxFstLabReport)){
					assertTrue(click(selenium, chkbxFstLabReport),"Could not click check box First Lab Report",selenium, ClassName, MethodName);
				}
				if(isElementPresent(selenium,chkbxSecLabReport)&&!isChecked(selenium, chkbxSecLabReport)){
					assertTrue(click(selenium, chkbxSecLabReport),"Could not click check box second Lab Report",selenium, ClassName, MethodName);
				}
				
				assertTrue(selenium.isVisible(btnMergeLabReport),"Merge lab report Link Not Visible;More Details",selenium,ClassName,MethodName);
				
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnMergeLabReport),"Could not click Merge option  Lab Report",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!selenium.isElementPresent(lnkContinue)){
					Assert.fail("Merge  Target Popup is not displayed");				
				}
				
				assertTrue(selenium.isVisible(rdoTargetMergeLabReport),"" +"Merge Lab report Link Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, rdoTargetMergeLabReport),"Could not click  Target  option for  Lab Report",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkContinue),"Could  not click  Target Continue button Lab Report",selenium, ClassName, MethodName);
										
				//--------------------------------------------------------------------//
				//  Step-7:  Verify Merge Option for lab report //
				//--------------------------------------------------------------------//
				
				if(! verifyMergeOptionforLabreport(selenium,labData,labData2,userAccount)){
					Assert.fail("Verify Merge Option for lab report failed");
				}
				return returnValue;
				
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
		  }
		
  public boolean verifyMergeOptionforLabreport(Selenium selenium,ChartPreVisitLib labData,ChartPreVisitLib labData2,String userAccount) throws IOException{
		boolean returnValue=true;
		
		// Verify the First Report 
		
		assertTrue(click(selenium, lnkMergedReportOne),"Could not click lnk Merged Lab Report One ",selenium, ClassName, MethodName);
	//	assertTrue(click(selenium, lnkLabRepInfo),"Could not click link  Lab Report information",selenium, ClassName, MethodName);
		
		System.out.println(getText(selenium,vfyFstReportDetails));
		
		if(!getText(selenium,vfyFstReportDetails).contains(labData.accNumber)){
			Assert.fail("Verify Merge Option for lab report one failed");
		}
		
      // Verify the Second Report 
		
		assertTrue(click(selenium, lnkMergedReportTwo),"Could not click lnk Merged Lab Report Two ",selenium, ClassName, MethodName);
		//assertTrue(click(selenium, lnkLabRepInfo),"Could not click link  Lab Report information",selenium, ClassName, MethodName);
		
		if(!getText(selenium,vfyFstReportDetails).contains(labData2.accNumber)){
			Assert.fail("Verify Merge Option for lab report two failed");
		}
		
		return returnValue;
		
		}
}
	

