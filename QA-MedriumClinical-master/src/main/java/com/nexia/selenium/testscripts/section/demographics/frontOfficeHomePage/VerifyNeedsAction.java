package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNeedsAction extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Queues under Needs Action Menu")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNeedsActionOnFoHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	    	HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_003";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyNeedsAction(seleniumHost, seleniumPort, browser, webSite, userAccount,PatientData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify queues under Needs Actions queue
	* @action 		  verifying Urgent General Task For same user
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 30, 2013
	***************************************************************************************************/
	
	public boolean verifyNeedsAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib CreateGeneralTask ) throws IOException{
		
	    Selenium selenium=null;
		boolean returnValue=false;
		String urgentResult1= "";
		String urgentResult= "";
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CreateGeneralTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, CreateGeneralTask.userName, CreateGeneralTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
						assertTrue(switchRole(selenium,CreateGeneralTask.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Check Count on queues under Needs action menu  	//
			//--------------------------------------------------------------------//
			
			String resultList=getText(selenium,lblBumpList);
			String[] splitS = resultList.split(" ");
			int metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			
			if(metricResult1>=0){
				returnValue=true;
			}
			else{
				Assert.fail("Could not find count of bump list queue");;
			}
			
			resultList=getText(selenium,lblWaitList);
			splitS = resultList.split(" ");
		    metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			
			if(metricResult1>=0){
				returnValue=true;
			}
			else{
				Assert.fail("Could not find count of wait list queue");;
			}
			
			resultList=getText(selenium,lblUnconfirmedvisits);
			splitS = resultList.split(" ");
		    metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			
			if(metricResult1>=0){
				returnValue=true;
			}
			else{
				Assert.fail("Could not find count of Unconfirmedvisits queue");;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Access of queue under Needs Action Menu
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,lblBumpList),"Could not find bumplist queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblBumpList),"Could not click bumplist queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(isElementPresent(selenium,lnkHide),"Could not find link hide",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkHide),"Could not link hide",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("Hide")){
				Assert.fail("Access failed for bumplist");
			}
			
			assertTrue(isElementPresent(selenium,lblWaitList),"Could not find waitlist queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblWaitList),"Could not click waitlist queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(isElementPresent(selenium,lnkHide),"Could not find link hide",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkHide),"Could not link hide",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("Hide")){
				Assert.fail("Access failed for bumplist");
			}
			
			assertTrue(isElementPresent(selenium,lblUnconfirmedvisits),"Could not find Unconfirmedvisits queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblUnconfirmedvisits),"Could not click Unconfirmedvisits queue",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(isElementPresent(selenium,lnkHide),"Could not find link hide",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkHide),"Could not link hide",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("Hide")){
				Assert.fail("Access failed for bumplist");
			}
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
