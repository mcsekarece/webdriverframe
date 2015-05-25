package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAssociatedProvidersinForwardedOptions extends AbstractChartPreVisit{
	
	 @Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Associated Providers in Forwarded Options")
	 @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyAssociatedProvidersList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_005";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	 
	 /**
		 * Verify Associated Providers in Forwarded Options
		 * function to Verify Associated Providers in Forwarded Options
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws      IOException 
		 * @since  	    Nov 07, 2014
		 */
		public boolean createDiagnosticTestReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib diData) throws IOException{
			Selenium selenium=null;	
			boolean returnvalue=true;
		try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + diData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName, diData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Get the count of  associated provider in current practice //  
				//--------------------------------------------------------------------//	
				assertTrue(click(selenium, lnkLocationHeader),
						"Could not click header", selenium, ClassName, MethodName);
				String currentPractice = selenium.getText(lnkPractice);
				waitForPageLoad(selenium);
				Integer practiceCount = (Integer) selenium.getXpathCount(lnkPracticeCount);
			
				for (int rowPos = 1; rowPos <= practiceCount; rowPos++) {
					System.out.println(String.format(lnkPracticeCount, rowPos));
					if (selenium.getText(String.format(lnkPracticeCount, rowPos))
							.equals(currentPractice)) {
						selenium.click(String.format(lnkPracticeCount, rowPos));
						break;
					}
				}
				waitForPageLoad(selenium);
				
				String lblCount=selenium.getText(lnkProvidersCount);
				lblCount=lblCount.replace('(', ' ');
				lblCount=lblCount.replace(')', ' ').trim();
				Integer associatedProvidresCount = Integer.parseInt(lblCount);
				
				//--------------------------------------------------------------------//
				//  Step-2: Verify Diagnostic Report Q count before adding Report
				//--------------------------------------------------------------------//			
		
				String dIQueue=getText(selenium,queDiagnosticReport);
				System.out.println(dIQueue);
				String[] splitS = dIQueue.split(" ");
				int  queueValue = Integer.parseInt(splitS[0]);
				System.out.println( queueValue);
				
				//--------------------------------------------------------------------//
				//  Step-3: Navigate to Diagnostic Report
				//--------------------------------------------------------------------//			
				
				assertTrue(navigateToCorresReport(selenium,diData),"Could not Navigate to File document",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				
				//--------------------------------------------------------------------//
				//  Step-4 :Diagnostic  Report for the  patient 
				//--------------------------------------------------------------------//
			
				assertTrue(CreateDiagnosticReport(selenium,diData,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
		        waitForPageLoad(selenium);	
				
		        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				
		        // Verify the DI Report created or not
				
				String dIQueue1=getText(selenium,queDiagnosticReport);
				System.out.println(dIQueue1);
				String[] splitS1 = dIQueue1.split(" ");
				int  queueValue1 = Integer.parseInt(splitS1[0]);
				System.out.println(" queueValue1 - " +  queueValue1);
				
				if( queueValue1 >  queueValue){
					returnvalue=true;
				}else{
					assertTrue(false,"After save the report  the Count in the Q not updated Before Count=+"+ queueValue+",After Count=="+ queueValue1+"", selenium, ClassName, MethodName);
				}

				//--------------------------------------------------------------------//
				//  Step-5: Navigate to the Corresponding Report
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6 :Forward the Diagnostic  Report 
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium, action),"Could not click  action button ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkForwardAction),"Could not click the link Forward", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
		        assertTrue(click(selenium,show), "Could not click forward TO  provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
		
				// -------------------------------------------------------------------//
				//  Step-7 : Verify Associated Providers in Forwarded Options     // 
				//--------------------------------------------------------------------//
			
				Integer forwardedProvidersCount = (Integer) selenium.getXpathCount(vfyForwardedProviders);
				
				if (forwardedProvidersCount.equals(associatedProvidresCount)){
					return true;
				}else {
					Assert.fail("Verify Associated Providers in Forwarded Options is failed");
				}
				
			
		}	catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnvalue;
	}	
		
}
