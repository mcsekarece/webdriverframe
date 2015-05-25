package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLogoutFunctionsforUnfinishedItems extends AbstractSchedulingTest{

	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Logout Functions for Unfinished Items")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyLogoutFunctionsforUnfinishedItems(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_019";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Logout Cancel for Unfinished Items")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyLogoutCancelforUnfinishedItems(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_020";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Logout No for Unfinished Items")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyLogoutNoforUnfinishedItems(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_021";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
		
	/*************************************************************************************************** 
	* @purpose        Verify Logout Functions Unfinished Items For Program Groups
	* @action 		  Verify Logout Functions Unfinished Items For Program Groups
	* @expected       To Ensure that the Logout Functions UnfinishedItems For Program Groups fine
 	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Nov 05, 2013
	***************************************************************************************************/
	
	public boolean createProgramAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Add Program Groups for";
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,pDGData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ pDGData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			  
			//--------------------------------------------------------------------//
			//  Step-4:Navigate To Progarm Group						  //
			//--------------------------------------------------------------------//
		
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Program Group					  //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Create Program					  //
			//--------------------------------------------------------------------//
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			
			if(pDGData.testCaseId.equals("TC_PDG_019")){
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSignout),"Could not click the sign out link;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,btnlogoutUnfinishedItem)){
					   Assert.fail("verify Logout popup not present for UnfinishedItems");
				   }
				assertTrue(click(selenium,btnlogoutUnfinishedItem),"Could not click the logout Unfinished Itemlink;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnYesUnfinishedItem1)){
					/*if(!getText(selenium,popUPlogoutYes).trim().contains("You have "+unfinishedItem+" unfinished items saved")){
						return false;
					}*/
					assertTrue(click(selenium,btnYesUnfinishedItem1),"Could not click the Yes button for Unfinished Itemlink;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				 }
				
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnYesButton)){
					assertTrue(click(selenium,btnYesButton),"Could not click the Yes button for logout Itemlink;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				 }
				
				
			}else if (pDGData.testCaseId.equals("TC_PDG_020")){

				assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSignout),"Could not click the sign out link;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnlogoutUnfinishedItem)){
					assertTrue(click(selenium,btnCancelUnfinishedItem),"Could not click the logout cancel button Unfinished Itemlink;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
								
				if(isElementPresent(selenium,btnlogoutUnfinishedItem)){
					 Assert.fail("verify Logout warning message not closed for UnfinishedItems");
				}
				return true;
				}
			}else if (pDGData.testCaseId.equals("TC_PDG_021")){
				assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSignout),"Could not click the sign out link;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnlogoutUnfinishedItem)){
					assertTrue(click(selenium,btnlogoutUnfinishedItem),"Could not click the logout button Unfinished Itemlink;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				   }
				if(isElementPresent(selenium,btnNoUnfinishedItem)){
					assertTrue(click(selenium,btnNoUnfinishedItem),"Could not click the NO  button for Unfinished Itemlink;More Details:"+pDGData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				 }
			
				
				if(isElementPresent(selenium,btnYesUnfinishedItem1)){
					Assert.fail("verify Logout Yes or No warning message not closed for UnfinishedItems");
				 }
				
				return true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-10: login again//
			//--------------------------------------------------------------------//
						assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Again Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11:Change Switch Role Again  										  //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,pDGData.switchRole1),"Switch Role Agian Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-12: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
		
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ pDGData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValuesAddProgram(selenium,pDGData,uniqueName)){
				Assert.fail("Program Group  details not saved properly in contacts page :"+ pDGData.toString());
			}
					
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
		
 public boolean verifyStoredValuesAddProgram(Selenium selenium, SchedulingTestLib pDGData,String uniqueName) throws IOException{
      
	 try{		
		assertTrue(getValue(selenium,txtgroupName).contains(pDGData.groupName),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtDescription).contains(pDGData.description),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtprogramPlan).contains(pDGData.plan),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkgroupObjective).trim().contains("Change in behavior"),"Verification failed",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lnkplannedActivite).trim().contains("Created forums to introduce or bring"),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkageGroup).trim().contains("adults (35-49 years)"),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkGender).trim().contains("both sexes"),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkPrimary).trim().contains("Abenaki"),"Verification failed",selenium, ClassName, MethodName);
	 
		assertTrue(getText(selenium,lnkCulture).trim().contains("Aboriginal"),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,inkRole).trim().contains("business people"),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkphysical).trim().contains("acquired immunodeficiency syndrome"),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkSocial).trim().contains("environmental polution"),"Verification failed",selenium, ClassName, MethodName);
      	}
      	catch(RuntimeException e){
      		
      		e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
      	}

	  	return true;
		}
}
