package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForResourceCalender extends AbstractSchedulingTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyTabbingOrderForResourceCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForResourceCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_004";
		createResourceCalData.fetchSchedulingTestData();	
		tabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
		/**     
		* @purpose       VerifyTabbingOrderForResourceCalender
	    * @action       VerifyTabbingOrderForResourceCalender 
	    * @expected     Verify TabbingOrder For ResourceCalender
	    * @author       Aspire QA
		* @throws        IOException 
	    * @state        Developing
	    * @useraccount  Both
		* @since  	     Jun 13, 2013
		* 
		*/
		public boolean tabbingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib createResourceCalData) throws IOException{
			Selenium selenium = null;
			boolean returnValue= true;
			try{
				String csspaths[]={tabResCalOwnerBoxsuggestBox,tabRunningMonthsBoxsuggestBox, tabResCalEffectiveDate};
				String csspaths1[]={tabResCalEndDate};
				//--------------------------------------------------------------------//
				// Step 1:Login to the application//
				//--------------------------------------------------------------------//
				
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createResourceCalData.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, createResourceCalData.userName, createResourceCalData.userPassword),"Login Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-2: Navigate to SchedulingSettings //
				//--------------------------------------------------------------------//
				
				assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Add New ResourceCalender //
				//--------------------------------------------------------------------//

				assertTrue(click(selenium,lnkResourceAddNew),"Could not click add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
							
				//---------------------------------------------------------- ---------//
				//  Step-4:verify Tab order                                        //
				//--------------------------------------------------------------------//
				for(int i =0;i<csspaths.length;i++){
					assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspaths[i]);
					waitForElementToEnable(selenium,csspaths[i]);
					selenium.keyPress(csspaths[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				}
				 
			    if(isChecked(selenium,chkNoEndDatecheckbox)){
		           assertTrue(click(selenium,chkNoEndDatecheckbox),"Could not click EndDate Checkbox", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					}
				for(int i =0;i<csspaths1.length;i++){
					assertTrue(isElementPresent(selenium,csspaths1[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspaths1[i]);
					waitForElementToEnable(selenium,csspaths1[i]);
					selenium.keyPress(csspaths1[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths1[i]));
				}
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + createResourceCalData.toString(), selenium, ClassName, MethodName);
			}return returnValue;
		}
}
