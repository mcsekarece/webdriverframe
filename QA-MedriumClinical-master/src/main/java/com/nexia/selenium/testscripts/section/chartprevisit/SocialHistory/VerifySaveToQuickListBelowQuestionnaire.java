package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveToQuickListBelowQuestionnaire extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifuing Save to Quick list Below Questionnaire")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void saveToQuickListBelowQuestionnaire(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_012";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySaveToQuickList(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Save to Quick list Below Questionnaire
	* @action 		  verifying added alcohol and Quick List Below Questionnaire is displyed
	* @expected       After Slected alochol and Quick List Below Questionnaire
	* @defectId       #3715
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 22, 2013
	***************************************************************************************************/
	
	public void verifySaveToQuickList(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib historyData) throws InterruptedException, IOException{
		Selenium selenium=null;
		try{
			String csspaths[]={"css=#saveListcheckbox","css=#answer1Moreradio"};
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-3: Navigate to FamilyHistory                                         //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSocialShowMore),"Could not click the Show more link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-4:Tab order                                        //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found",selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)");
		}
	}
}
