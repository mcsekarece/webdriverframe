package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class PortVisitGroup extends AbstractSchedulingTest{
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" }, description = "Adding New Visit Group if Required", dependsOnGroups= "BeforePortVisitGroup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewGroup001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "PortVisitGroup";
		visitGroup.testCaseId = "TC_PVG_001";
		visitGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" }, description = "Adding New Visit Group if Required", dependsOnGroups= "BeforePortVisitGroup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewGroup002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "PortVisitGroup";
		visitGroup.testCaseId = "TC_PVG_002";
		visitGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" }, description = "Adding New Visit Group if Required", dependsOnGroups= "BeforePortVisitGroup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewGroup003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "PortVisitGroup";
		visitGroup.testCaseId = "TC_PVG_003";
		visitGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	/*************************************************************************************************** 
	* @purpose        To verify create New Visit Group
	* @action 		  verifying Create Function  for Visit Group 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 20, 2013
	***************************************************************************************************/
	public boolean checkVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib visitGroup) throws IOException{
		Selenium selenium = null;
		boolean returnValue=true;
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitGroup.toString());
		assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitGroup.userName, visitGroup.userPassword),"Login Failed", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2:Change Switch Role  										  //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,visitGroup.switchRole),"Could not change the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3:Change Switch Practice										  //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkTopPracticeMenu),"Could not click on practice menu",selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		 int count=1;
		 while(isElementPresent(selenium,"//tr["+count+"]/td/a/span")){
			 if(getText(selenium,"//tr["+count+"]/td/a/span").contains(visitGroup.practiceName)){
			 click(selenium,"//tr["+count+"]/td/a/span");
			 waitForPageLoad(selenium);
			 }
			 else{
				 count++;
			 }
			 
			 if(count>15){
				 break;
			 }
		 }
		
		//--------------------------------------------------------------------//
		//  Step-4:Navigate to Scheduling section							  //
		//--------------------------------------------------------------------//
		 assertTrue(goToScheduling(selenium),"Navigate to Scheduling section",selenium, ClassName, MethodName);
		 
		//--------------------------------------------------------------------//
		//  Step-5:Navigate to Visit Group							          //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkVisitGroup),"could not click the Visit Group Link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: Search Visit Group				                          //
		//--------------------------------------------------------------------//
		if(searchVisitType(selenium, visitGroup)){
			assertTrue(createVisitGroup(selenium,visitGroup),"Could not created the visit type", selenium, ClassName, MethodName);
		}else{
			
			if(!verifyStoreValue(selenium,visitGroup)){
				assertTrue(type(selenium,txtGroupName,visitGroup.groupName),"Could not enter the group name",selenium,ClassName,MethodName);
				 assertTrue(type(selenium,txtSearch,visitGroup.visitName),"Could not enter the visit type ",selenium,ClassName,MethodName);
				 assertTrue(click(selenium,btnSearch),"could not click on the search button",selenium,ClassName,MethodName);
				 assertTrue(click(selenium,chkViistType),"Cpuld not click on the check box",selenium,ClassName,MethodName);
				 
				 if(visitGroup.testCaseId.equals("TC_VG_001")){
					 assertTrue(click(selenium,chkGreenColor),"Could not click on the color",selenium,ClassName,MethodName);
				 }
				assertTrue(click(selenium,btnSave),"Could not click the save button",selenium,ClassName,MethodName);
				
				if(!verifyStoreValue(selenium,visitGroup)){
					Assert.fail("The Details are not saved Properly");
				}
			}else
			 returnValue=true;
		}
		return returnValue;
	}
	
	
	public boolean searchVisitType(Selenium selenium, SchedulingTestLib visitGroup) throws IOException{
		
		//--------------------------------------------------------------------//
		//   Search Visit Group				                              //
		//--------------------------------------------------------------------//
		assertTrue(type(selenium,txtSearchGroup,visitGroup.groupName),"Could not Type the visit name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selenium.keyPress(txtSearchGroup, "\\13");
		waitForPageLoad(selenium);
		if(getText(selenium,"//div[@id='VisitGroupsListWidget']/table/tbody/tr/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(visitGroup.groupName.toLowerCase(new java.util.Locale("en","US")).trim())){
			assertTrue(click(selenium,btnEdit),"Could not click on the edit button", selenium, ClassName, MethodName);
			return false;
				
		}else if(isElementPresent(selenium,chkGroupIncude)){
			assertTrue(click(selenium,chkGroupIncude),"Could not click the check box", selenium, ClassName, MethodName);
			int counter=(Integer) selenium.getXpathCount("//div[@id='VisitGroupsListWidget']/table/tbody/tr/td");
			while (isElementPresent(selenium,"//div[@id='VisitGroupsListWidget']/table/tbody/tr["+counter+"]/td")){
			if(getText(selenium,"//div[@id='VisitGroupsListWidget']/table/tbody/tr["+counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(visitGroup.groupName.toLowerCase(new java.util.Locale("en","US")).trim())){
				assertTrue(click(selenium,lnkActivate),"Could not click on the Activate button", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton),"could not click the yes button", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnEdit),"Could not click on the edit button", selenium, ClassName, MethodName);
				return false;
			}
			else
				counter++;
			}
			
		}
		return true;
	}
	
	public boolean createVisitGroup(Selenium selenium, SchedulingTestLib visitGroup) throws IOException{
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-5: Create Visit Type//
			//--------------------------------------------------------------------//
			try {
				assertTrue(createVisitGroupPortability(selenium,visitGroup),"Could not created the visit type",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-6: verify Store Value   -------------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click on the edit button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!verifyStoreValue(selenium,visitGroup)){
				Assert.fail("The Details are not saved Properly");
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,SchedulingTestLib visitGroup){
		
		if(!getValue(selenium,txtGroupName).trim().contains(visitGroup.groupName.trim())){
			return false;
		}
		if(!getText(selenium,lblVisitName).trim().contains(visitGroup.visitName.trim())){
			return false;
		}
		
		return true;
	}
	
}
