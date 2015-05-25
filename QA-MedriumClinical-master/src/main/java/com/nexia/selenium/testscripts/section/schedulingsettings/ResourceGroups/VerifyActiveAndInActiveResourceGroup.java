package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActiveAndInActiveResourceGroup extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Active and In Active Resource Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void activeAndInActiveResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "ResourceGroup";
		resourceGroup.testCaseId = "TC_RG_001";
		resourceGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		activeAndInActiveResourceGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Active and InActive  Resource Group
	* @action 		  verify Active and InActive Resource Group
	* @expected       To Ensure that Active and InActive Resource Group works fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 16, 2013
	***************************************************************************************************/
	
	public boolean activeAndInActiveResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + resourceGroup.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, resourceGroup.userName, resourceGroup.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,resourceGroup.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Navigate to  Resource Group						          //
			//--------------------------------------------------------------------//
				
			assertTrue(click(selenium, lnkResourceGroup), "could not able to click the Ressource Group Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-5:Delete All Resource	Group								  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Create New Resource	Group								  //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Values For Resource Group					  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesForResourceGroup(selenium,resourceGroup),"Resource Group not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Delete Created Resource Group					  //
			//--------------------------------------------------------------------//
			String resourceGroupName = resourceGroup.resourceGroupName+uniqueName;
			assertTrue(selectValueFromAjaxList(selenium,txtSearchResourceGroup,resourceGroup.searchResourceName),"Group name is not getting displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.focus(txtSearchResourceGroup);
			
			selenium.fireEvent(txtSearchResourceGroup, "\\13");
			selenium.typeKeys(txtSearchResourceGroup, "a");
			
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
				if(getText(selenium, lblResourceGroup).contains(resourceGroupName)){
					Assert.fail("Record is not deleted Properly");
			     }
			//--------------------------------------------------------------------//
			//  Step-8:Verify InActive Resource Group					  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, chkIncludeInactiveCheckbox), "could not able to click  for Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			int checkClick=0,incrementForCheck=1;;
				do
				{
					waitForPageLoad(selenium);
				if(!getText(selenium, lblSummaryPageResourceGroup).contains(resourceGroupName)){
					assertTrue(click(selenium, showMore), "could not able to click  for More Resource Group", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			     }
				else if(getText(selenium, lblSummaryPageResourceGroup).contains(resourceGroupName))
				{
					checkClick++;
					break;
				}
				
			
				}while(isElementPresent(selenium,showMore));
				
				
				if(checkClick==0)
				{
					Assert.fail("Record is not deleted Properly");
				}
				
			//--------------------------------------------------------------------//
			//  Step-9:Active Resource Group					  //
			//--------------------------------------------------------------------//		
			selectValueFromAjaxList(selenium,txtSearchResourceGroup,resourceGroup.searchResourceName);
			waitForPageLoad(selenium);
			
			selenium.focus(txtSearchResourceGroup);
			
			selenium.fireEvent(txtSearchResourceGroup, "\\13");
			selenium.typeKeys(txtSearchResourceGroup, "a");
			
			while(selenium.isVisible(showMore))
			{
				waitForPageLoad(selenium);
				assertTrue(click(selenium, showMore), "could not able to click  for More Resource Group", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				
			}
			
			boolean elementFind= false;
			
			
			do
			{
			if(!getText(selenium,"xpath=(//span[@id='resourceGroupName'])["+incrementForCheck+"]").contains(resourceGroupName))
			{
				incrementForCheck++;
				continue;
			}
			else if(getText(selenium,"xpath=(//span[@id='resourceGroupName'])["+incrementForCheck+"]").contains(resourceGroupName))
			{
				String buttonClickId="xpath=(//a[contains(text(),'Activate')])["+incrementForCheck+"]";
			
				assertTrue(click(selenium, buttonClickId), "could not able to click  for More Resource Group", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYesButton) , "could not able to click the yes in the activate Resource Group", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				elementFind=true;
			}
				
			} while(elementFind==false);	
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, chkIncludeInactiveCheckbox), "could not able to click  for Inactive checkbox", selenium, ClassName, MethodName);	
			
			waitForPageLoad(selenium);
			
			
			
			//assertTrue(click(selenium, btnActivate) ,"could not able to click the Activate Resource Group", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnYesButton) , "could not able to click the yes in the activate Resource Group", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);	
			
			assertTrue(getText(selenium,lblSummaryPageResourceGroup).trim().contains(resourceGroupName),"The Include inactive check box not working properly",selenium, ClassName, MethodName);
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
