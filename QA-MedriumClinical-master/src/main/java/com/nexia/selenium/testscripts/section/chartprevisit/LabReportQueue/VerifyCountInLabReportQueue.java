package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCountInLabReportQueue extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify count of lab reports in lab report queue With same receiving provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCountInLabReportQueueWithSameRProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_031";
		labData.fetchChartPreVisitTestData();
		verifyCount(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/**
	 * verifyCount
	 * function to verify count of the lab report queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 26, 2012
	 */
	public boolean verifyCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  	//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		

			//--------------------------------------------------------------------//
			//  Step-5: Get the count of the lab reports//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			String resultList=getText(selenium,labReportQueue);
			System.out.println(resultList);
			String[] splitS = resultList.split(" ");
			int metricResult = Integer.parseInt(splitS[0]);
			System.out.println(metricResult);
			waitForPageLoad(selenium);
			String metricResult1="";
			if(resultList.contains("abnormal")){
			String strin=splitS[3];
			System.out.println(strin);
				for(int i=1;i<strin.length();i++){
					metricResult1=metricResult1+strin.charAt(i);
				}
				System.out.println(metricResult1);
			}else 
				metricResult1="0";
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
 			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: File new lab report//
			//--------------------------------------------------------------------//
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			
			if(labData.testCaseId.equalsIgnoreCase("TC_LR_031")){
				
				String providerNameTemp= getText(selenium, lnkTopMenu);
				
				String providerName= providerNameTemp.replaceAll(", FULL", "");
				
				String tempArray[]=providerName.split(" ");
				
				String pName=tempArray[1]+", "+tempArray[0];
				
				System.out.println(pName);
				//selectValueFromAjaxList(selenium,ajxRProvider, pName);
				
				waitForPageLoad(selenium);
				
				selectValueFromAjaxList(selenium,ajxRProvider,pName);
				
				selectValueFromAjaxList(selenium,ajxOProvider,pName);
				
				assertTrue(click(selenium,btnSave2),"Could not find save button", selenium, ClassName, MethodName);
			}
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Get the count of lab report queue after creating a new report//
			//--------------------------------------------------------------------//;
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String resultList1=getText(selenium,labReportQueue);
			String[] split = resultList1.split(" ");
			int metricResult2 = Integer.parseInt(split[0]);
			
			String stri=split[3];
			String metricResult3="";
			for(int i=1;i<stri.length();i++){
				metricResult3=metricResult3+stri.charAt(i);
			}
			
			int metricResult5=Integer.parseInt(metricResult3);
			int metricResult4=Integer.parseInt(metricResult1);
			if(metricResult5>metricResult4)
				//if(metricResult2>metricResult)
				returnValue=true;
			else
				Assert.fail("Count not increasing properly");
		
			//--------------------------------------------------------------------//
			//  Step-10: compare the count before and after creating the lab report//
			//--------------------------------------------------------------------//
			if(labData.testCaseId.equalsIgnoreCase("TC_LR_031")){
				if(metricResult2>metricResult)
					returnValue=true;
				else
					Assert.fail("Count not increasing properly");
			}
			else{
				if(metricResult2==metricResult)
					returnValue=true;
				else
					Assert.fail("Count increased");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
