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

public class VerifyUserNameForLabReport extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify abnormal lab report in lab report queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserNameInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_023";
		labData.fetchChartPreVisitTestData();
		verifyUserName(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * verifyUserName
	 * function to verifyUserName
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 27, 2012
	 */
	
	public boolean verifyUserName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,labData.switchRole));
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
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
			//  Step-6: Navigate to Labs tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabReport),"Could not click the Lab tag", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"suggestBox",labData.show);
			
			//--------------------------------------------------------------------//
			//  Step-7:Add comments //
			//--------------------------------------------------------------------//
			assertTrue(focus(selenium,lblSumInjection1),"Could not Find the text", selenium, ClassName, MethodName);
			assertTrue(clickAt(selenium,lblSumInjection1, ""),"Could not find the text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// assertTrue(click(selenium,"//tr[1]/td/div/table/tbody/tr/td[2]/span"),"Could not click the link");
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,elementReportCommentsIcon),"Could not click the Addd comment link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,"//blockquote/div/textarea",labData.comments),"Could not type comment", selenium, ClassName, MethodName);
			assertTrue(click(selenium,"link=Save"),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"sign"),"Could not click the sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify the Sign Lab //
			//--------------------------------------------------------------------//
//			assertTrue(click(selenium,"//td[2]/span"),"Could not click the data", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
			if(!verifyStoredValue(selenium,labData,userAccount)){
				returnValue=false;
				Assert.fail("User details not saved properly in Expand view :"+ labData.toString());
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib labData,String account){
		String date=null;
		waitForPageLoad(selenium);
		
		/*if(!getText(selenium,"//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div[2]/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.provider.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM d, yyyy");
			 date=DateFormat.format(cal.getTime());
			 click(selenium,"labReportDetailsText");
			// System.out.println(getText(selenium,"//div[@id='labReportDisclosurePanelDiv']/div[10]/div/div[4]"));			 
			 if(!selenium.isTextPresent(date.trim())){
					return false;
				}
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				if(!getText(selenium,"css=td.centerNoSidePadding").trim().contains(date.trim())){
					return false;
				}
		}
		return true;
	}
}
