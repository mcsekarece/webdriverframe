package com.nexia.selenium.testscripts.section.chartprevisit.LabReportElectronic;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;


public class VerifyELabHistoryNewReportForLabSoft extends AbstractChartPreVisit {
	@Test(groups = {"DeferredUS","Approved", "Production","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report thru Electronic Means" )
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void electronicLabReportWithMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib ElabData = new ChartPreVisitLib();
		ElabData.workSheetName = "ElectronicFileLabReport";
		ElabData.testCaseId = "TC_ELR_004";
		ElabData.fetchChartPreVisitTestData();
		electronicLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, ElabData);
	}
	
	/**
	 * electronicfileNewReport
	 * function to electronic file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    August 15, 2013
	 */
	public boolean electronicLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ElabData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
								
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ElabData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, ElabData.userAccount, ElabData.userName, ElabData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			searchPatientNexiaForProviderHomePage(selenium,ElabData.patientId);
			waitForPageLoad(selenium);			
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			assertTrue(deletelabReport(selenium,ElabData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Perform the FTP Upload of the Electronic labs (2 times)   //
			//--------------------------------------------------------------------//						
			ftpFileUpload(selenium, webSite, ElabData);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);
			
			
			ChartPreVisitLib ElabData1 = new ChartPreVisitLib();
			ElabData1.workSheetName = "ElectronicFileLabReport";
			ElabData1.testCaseId = "TC_ELR_006";
			ElabData1.fetchChartPreVisitTestData();
			
			
			ftpFileUpload(selenium, webSite, ElabData1);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);
			ftpFileUpload(selenium, webSite, ElabData1);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);
															
			//--------------------------------------------------------------------//
			//  Step-5: Verify History for the Labs								  //
			//--------------------------------------------------------------------//			
			if(!verifyLabHistory(selenium,ElabData1)){
				fail("Lab History are not displayed correctly; More Details :"+ ElabData.toString());
				returnValue=false;
			}else
				return returnValue;					
			
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}