package com.nexia.selenium.testscripts.section.operations.BookingAssistant;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;



public class VerifyTabbingForBookingAssistant  extends AbstractOperationsTest {

	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "VerifyTabbingOrderForResourceCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForBookingAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		tabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
		/**     
		  * @purpose       VerifyTabbingForBookingAssistant
	    *  @action         VerifyTabbingForBookingAssistant
	    *  @expected       VerifyTabbingForBookingAssistant
	    *  @author         Aspire QA
	    *  @state          Developing
	    *  @useraccount    Both
		  * @since  	    Jun 25, 2013
		  * 
		  */
	
	
	public boolean tabbingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData)throws Exception{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			String csspaths[]={tabVisitType,tabResource, tabBassDuration,tabShowOnly,tabShowTime,tabStartDate};
			String csspaths1[]={tabEndDate,tabSelectAll};
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + bookingAssistTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to BookingAssistant //
			//--------------------------------------------------------------------//
			
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBookingAssistant),"Could not click Resource Calender link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//---------------------------------------------------------- ---------//
			//  Step-3:verify Tab order                                        //
			//--------------------------------------------------------------------//
			
			
			assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnShowMoreDetails),"Could not click Show more details button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName,MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
			assertTrue(selectValueFromAjaxList(selenium,ajxShowTime2,bookingAssistTestData.showTime),"Could not select show time period"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			for(int i =0;i<csspaths1.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName,MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
		}			
			catch (RuntimeException e){
				
				e.printStackTrace();
				assertTrue(false ,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
				
			}
			return returnValue;
		}
}
