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

public class VerifyUnfinishedItemsForProgramGroups extends AbstractSchedulingTest{

	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Unfinished Items For Program Groups")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyUnfinishedItemsForProgramGroups(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_013";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Delete Unfinished Items For Program Groups")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyDeleteUnfinishedItemsForProgramGroups(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_014";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}

	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Cancel Unfinished Items For Program Groups")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyCancelUnfinishedItemsForProgramGroups(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_015";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify No Unfinished Items For Program Groups")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void verifyNoUnfinishedItemsForProgramGroups(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_017";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}

	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Delete No Unfinished Items For Program Groups")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteNoUnfinishedItemsForProgramGroups(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_018";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        Verify Unfinished Items For Program Groups
	* @action 		  Verify Unfinished Items For Program Groups
	* @expected       To Ensure that the UnfinishedItems For Program Groups fine
 	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 30, 2013
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
			
			if(pDGData.testCaseId.equals("TC_PDG_013")){
			
				assertTrue(click(selenium,btnYesUnfinishedItem1),"Could not click Yes button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ pDGData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
			}else if(pDGData.testCaseId.equals("TC_PDG_014")) {
				
				assertTrue(click(selenium,btnYesUnfinishedItem1),"Could not click Yes button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkUnfinishedItem),"Could not click link  Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click1(selenium,lnkDeleteUnfinishedItem),"Could not click delete button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYesUnfinishedItem),"Could not click Yes button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);

				if(isElementPresent(selenium,popUPDeleteUnfinishedItem)){
				      Assert.fail("verify Delete link for UnfinishedItems popup for Program Groups failed");
				 }else{
					   return true;
				  }

			}else if(pDGData.testCaseId.equals("TC_PDG_015")){
			
			  assertTrue(click(selenium,"Cancel"),"Could not click Yes button for Unfinished Item",selenium,ClassName,MethodName);
			  waitForPageLoad(selenium);
				
			  if(isElementPresent(selenium,popUPUnfinishedItem)){
				   Assert.fail("verify Cancel UnfinishedItems For Program Groups failed");
			   }else{
				     return true;
			   }
			}else if(pDGData.testCaseId.equals("TC_PDG_017")){

			assertTrue(click(selenium,"No"),"Could not click No button for Unfinished Item",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			if(isElementPresent(selenium,btnAdd)){
				  return true;
			    }else{
			    	 Assert.fail("verify No link for UnfinishedItems popup for Program Groups failed"); 
			  }
		  }else if(pDGData.testCaseId.equals("TC_PDG_018")) {
				
				assertTrue(click(selenium,btnYesUnfinishedItem1),"Could not click Yes button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkUnfinishedItem),"Could not click link  Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click1(selenium,lnkDeleteUnfinishedItem),"Could not click delete button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnDeleteNoUnfinishedItem),"Could not click No button for Unfinished Item",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);

				if(isElementPresent(selenium,popUPDeleteUnfinishedItem)){
				      Assert.fail("verify delete  No link for UnfinishedItems popup for Program Groups failed");
				 }else{
					   return true;
				 }

			}
				
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
		
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
		 
			assertTrue(getValue(selenium,txtgroupName).contains(pDGData.groupName),"Could not click Find the entered details",selenium,ClassName,MethodName);
		 
			assertTrue(getValue(selenium,txtDescription).contains(pDGData.description),"Could not click Find the entered details",selenium,ClassName,MethodName);
			
			assertTrue(getValue(selenium,txtprogramPlan).contains(pDGData.plan),"Could not click Find the entered details",selenium,ClassName,MethodName);
			
			assertTrue(getText(selenium,lnkgroupObjective).trim().contains("Change in behavior"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkplannedActivite).trim().contains("Created forums to introduce or bring"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkageGroup).trim().contains("adults (35-49 years)"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkGender).trim().contains("both sexes"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkPrimary).trim().contains("Abenaki"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkCulture).trim().contains("Aboriginal"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,inkRole).trim().contains("business people"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkphysical).trim().contains("acquired immunodeficiency syndrome"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkSocial).trim().contains("environmental polution;"),"Could not click Find the entered details",selenium,ClassName,MethodName);
			
	      	}
      	catch(RuntimeException e){
      		
      		e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
      	}

	  	return true;
		}
}

