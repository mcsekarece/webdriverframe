package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyForwardedLabReport extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Forwarded Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForwardedLabReportInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_042";
		labData.fetchChartPreVisitTestData();
		verifyLabReportQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Forwarded Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInForwardedLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_043";
		labData.fetchChartPreVisitTestData();
		verifyLabReportQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}*/
	/**
	 * verifyLabReportQueue
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 12, 2012
	 */
	public boolean verifyLabReportQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "
					+ labData.switchRole, "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			labData.rProvider = providerName;
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
			if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
				click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,firstLabReport)){
				
			assertTrue(click(selenium,firstLabReport),"Cold not click the report", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        
			assertTrue(click(selenium, lnkMore),
					"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabs),
					"Could not click on Lab Report link link", selenium, ClassName, MethodName);
					assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,"//a[@id='ListItemActionAnchor1']/div")){
				//assertTrue(click(selenium,labReportCheckBox),"Cold not click the check box");
				if(selenium.isConfirmationPresent()){
                    System.out.println(selenium.getConfirmation());
                    selenium.chooseOkOnNextConfirmation();
            }			
				selenium.clickAt(lnkBeginEncounterAction, "");
				selenium.focus(lnkBeginEncounterAction);
				selenium.fireEvent(lnkBeginEncounterAction,"keyPress");
				assertTrue(click(selenium,lnkLabReportDelete),"Cold not click the check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDeleteReason),"Cold not click the check box", selenium, ClassName, MethodName);
				if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"", selenium, ClassName, MethodName);
				if(isElementPresent(selenium,lnkVitals))
					break;
				}
			}
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: File new lab report//
			//--------------------------------------------------------------------// 
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			
		if(isElementPresent(selenium,lnkEnterData)){
				 returnValue=true;
			}else
				return false;
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Lab report queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);			
			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();     
            	waitForPageLoad(selenium);
            	}
			assertTrue(click(selenium,firstLabReport),"Could not click Lab report queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,labReportCheckBox),"Cold not click the check box", selenium, ClassName, MethodName);
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose)," ", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabReportForward),"Cold not click the forward button", selenium, ClassName, MethodName);
			//selenium.clickAt("css=#forwardLabReports > span.topMenuItemSpan.light", "");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,forwardTo,labData.oProvider);
			assertTrue(type(selenium,notes,labData.patientId),"Cold not click the forward button", selenium, ClassName, MethodName);
			if(getText(selenium,labData.testCaseId).contains("TC_LR_014")){
				assertTrue(click(selenium,btnCancel),"Cold not click the send button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnNexiaLogo),"Cold not click the back button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,showPickList,labData.show);
				if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
					click(selenium,"//div[5]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,forPickList,labData.oProvider);
				if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
					click(selenium,"//div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,firstLabReport))
					return false;
				else 
					return true;
			}
			else{
			assertTrue(click(selenium,send),"Cold not click the send button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNexiaLogo),"Cold not click the Nexia Logo", selenium, ClassName, MethodName);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,showPickList,labData.show);
				if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
				click(selenium,"//div[5]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,forPickList,labData.oProvider);
			if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
			click(selenium,"//div[5]/div/div/div/div/div");       
			
			
			if(!verifyStoredValues(selenium,labData,userAccount))
				returnValue=	 false;
			else
				returnValue=true;
		}	
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib labData,String account){
		String date=null;		
						if(!selenium.isTextPresent(labData.patientId)){
			return false;
		}	
//		if(!selenium.isTextPresent(labData.reportStatus)){
//			return false;
//		}
		if(!selenium.isTextPresent("Forwarded by")){
			return false;
		}
		String OrderPro=labData.oProvider.split(",")[0];
		String ProInLabel=getText(selenium,ForwardedLabReport).toLowerCase();
		if(!ProInLabel.contains(OrderPro.toLowerCase())){
			return false;
		}
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMMM dd, yyyy");
			 date=DateFormat.format(cal.getTime());
			
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				
		}
		 if(!selenium.isTextPresent(date)){
				return false;
			}
		return true;
	}	
}
