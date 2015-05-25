package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActiveNPREquipment extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyIncludeinActivecheckbox ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeinActiveNPREquip(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "NonProviderResource";
		nonProviderEq.testCaseId = "TC_NP_004";
		nonProviderEq.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewNonProviderEquipment(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);
	}


	/**     
	* @purpose        VerifyIncludeinActiveNPREquipmnet
	*  @action         VerifyIncludeinActive checkbox
	*  @expected       VerifyIncludeinActive checkbox for NPR Equipment working properly
	*  @author         Jagmit
	*  @state          Developing
	*  @useraccount    Both
	* @since  	       Jun 24, 2013
	* 
	*/

	 public boolean createNewNonProviderEquipment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProviderEq) throws Exception{
			Selenium selenium=null;
			boolean returnValue=true;
		
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProviderEq.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProviderEq.userName, nonProviderEq.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
		
				//--------------------------------------------------------------------//
				//  Step-2:Change Switch Role  										  //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,nonProviderEq.switchRole),"Switch Role Failed",  selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3:Navigate To Non Provider Resource Equipment						  //
				//--------------------------------------------------------------------//
				assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Equipment", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkNonProviderResourceEquipment), "could not able to click the Non Provider Resource Equipment link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4:Delete All Non Provider Resource	Equipment					  //	
				//--------------------------------------------------------------------//
				assertTrue(deleteAllNonProviderResource(selenium,nonProviderEq),"Could not delete All Non Provider Resource Equipment", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5:Create New Non Provider Resource	Equipment					  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String uniqueName=DateFormat.format(cal.getTime());
				
				assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource room", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Delete  Created Non Provider Resource Equip				  //
				//--------------------------------------------------------------------//
				
				String[] tempArray = getText(selenium, lnkNonProviderResourceEquipment).split(" ");
				
				int resourceNPREquipCount=Integer.parseInt(tempArray[1].replace("(", "").replace(")", ""));

				for(int count=1;count<=resourceNPREquipCount;count++){		
					   if(getText(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(nonProviderEq.equipmentName.trim().toLowerCase(new java.util.Locale("en","US")))){
							   
						assertTrue(click(selenium,btnDeleteNPR), "Could not click the delete button", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up", selenium, ClassName, MethodName);
						 waitForPageLoad(selenium);
						 break;
					}
						
				 }
								 
				 if(getText(selenium, lblSummaryPageNonProviderResourceRoom).contains(nonProviderEq.equipmentName)){
					 Assert.fail("The Equipment staff deletion failed");
				 }
							 
		          assertTrue(click(selenium,chkIncludeInactiveCheckboxNPR),"Could not click IncludeInactiveCheckbox for NPR", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-7: Active the In Active Equipment			  //
				//--------------------------------------------------------------------//	 
				 selectValueFromAjaxList(selenium,txtSearchNonProviderResource, nonProviderEq.equipmentName+uniqueName);
					 
				 assertTrue(click(selenium,btnActivateNonProvider+nonProviderEq.equipmentName+uniqueName),"Could not click the active user",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
				 assertTrue(click(selenium,btnYesButton),"Could not click the yes button",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
				 
				 assertTrue(selenium.isVisible(lblNonProvider),"The Equipment staff deletion failed",selenium, ClassName, MethodName);
				 return true;
			}
			catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
