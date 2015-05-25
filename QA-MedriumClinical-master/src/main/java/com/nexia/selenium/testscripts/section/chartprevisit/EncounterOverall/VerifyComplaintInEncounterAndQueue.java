package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyComplaintInEncounterAndQueue extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Verifing whether Complaint Present in Encounter and Queue After Save it ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyComplaintInEncounterAndQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_004";
		encounterData.fetchChartPreVisitTestData();
		verifyComplaint(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
 
	
	/*************************************************************************************************** 
	* @purpose        To verify the values of the chief complaint in  Encounter and Queue
	* @DefectId		  #3488
	* @action 		  Select the stored encounter with chief complaint
	* @expected       The values of the chief complaint should be visible
	* @author         Aspire QA
	* @state          Completed
	* @useraccount    Both
	* @since  	     April 19, 2013
	***************************************************************************************************/
	public boolean verifyComplaint(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData)throws Exception{
		Selenium selenium=null;
		
		try{
		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2: Advanced search with Patient ID//
		//--------------------------------------------------------------------//

		searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
		waitForPageLoad(selenium);

		//--------------------------------------------------------------------//
		//  Step-3: Delete Encounter in Encounter tab//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSaveProblemList),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
	//	assertTrue(deleteAllEncounters(selenium,encounterData),"Could nor delete", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
		assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);

		//--------------------------------------------------------------------//
		//  Step-4: Begin an encounter//
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);
/*		String str = getText(selenium, lnkTopMenu);
		String Rprovider = str.replaceAll(", " + encounterData.switchRole, "");

		String tempArray[] = Rprovider.split(" ");
		String providerName = tempArray[1] + ", " + tempArray[0];
		assertTrue(click(selenium,"link="+providerName),"could not click link", selenium, ClassName, MethodName);

		selectValueFromAjaxList(selenium,ajxProviderSugBox,encounterData.provider);
		waitForPageLoad(selenium);
*/
		//--------------------------------------------------------------------//
		//  Step-6:Enter chief complaint//
		//--------------------------------------------------------------------//
		assertTrue(type(selenium,chiefComplaint,encounterData.chiefComplaint),"Could not Enter the chief", selenium, ClassName, MethodName);
		selenium.fireEvent(chiefComplaint, "blur");
		assertTrue(type(selenium,chiefComplaintText,encounterData.chief),"Could not Enter the chief", selenium, ClassName, MethodName);
        
		//--------------------------------------------------------------------//
		//  Step-7:Enter Assesment//
		//--------------------------------------------------------------------//
	
		selenium.type(ajxAssessmentSearch,encounterData.medicalCondition);
		selenium.fireEvent(ajxAssessmentSearch,"keydown");
		selenium.fireEvent(ajxAssessmentSearch,"keypress");                           
		selenium.fireEvent(ajxAssessmentSearch,"keyup");
		selenium.keyPress(ajxAssessmentSearch, "\\13");
		selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
		if(isElementPresent(selenium, "//body/div[5]/div/div/div/div/div")){
			click(selenium,"//body/div[5]/div/div/div/div/div");
		}else{
			selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);	
		}
		selenium.keyPress(ajxAssessmentSearch, "\\13");
		String date = null;
		if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			assertTrue(enterDate(selenium,txtOnset,date),"Could not enter the Admin on ;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal1.getTime());
			assertTrue(enterDate(selenium,txtOnset,date),"Could not enter the Admin on ;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
		}
		
		selectValueFromAjaxList(selenium,ajxItem,encounterData.itemStatus);
		//click(selenium,"//div[5]/div/div/div/div/div");
			
		assertTrue(click(selenium,btnAdd),"Could not click save button;More details:" +encounterData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
	    
		//--------------------------------------------------------------------//
		//  Step-8: Save Complaint//
		//--------------------------------------------------------------------//
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();
		}
		
		assertTrue(click(selenium,lnkBeginEncounterAction ),"Could not click the Action button;More details:" +encounterData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lblEncounterSave),"Could not click the Save button;More details:" +encounterData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-9: Verify Store values in Encounter tab//
		//--------------------------------------------------------------------//

		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);	waitForPageLoad(selenium);
		while(selenium.isVisible(lnkShowMore))
		{
			assertTrue(click(selenium,lnkShowMore),"Could not click the encounter tab", selenium, ClassName, MethodName);	waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		}
		if(!verifyStoreInEncounter(selenium,encounterData)){
			fail("The values are not stored properly in Encounter");
		}
		

		//--------------------------------------------------------------------//
		//  Step-10: Navigate to Encounters Queue//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo;More Deatils:"+encounterData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
        
		assertTrue(click(selenium,lnkUnSigned),"Could not click the Meds queue button;More Deatils:"+encounterData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtMedsSearchTextBox,encounterData.chiefComplaint),"Could not enter the search text;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
		selenium.keyPress("searchTextBox", "\\13");
		selenium.keyPress("searchTextBox", "\\13");
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,showPickList,encounterData.show);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblUnEncounterQueue),"Could not click the lblUnEncounterQueue;More Deatils:"+encounterData.toString(), selenium, ClassName, MethodName);
		
	//	if(!verifyStoreInEncounterQueue(selenium,encounterData)){
	//		Assert.fail("The values are not stored properly in EncounterQueue");
	//	}
		
	}
	catch (RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return true;
		
	}
	public boolean verifyStoreInEncounter(Selenium selenium, ChartPreVisitLib orderData) throws IOException{
		//waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(orderData.chiefComplaint.trim()),"no chief complaint", selenium, ClassName, MethodName);
			
		/*if(!getText(selenium,lblComplaintEncounter).toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.provider1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		assertTrue(selenium.isTextPresent(orderData.offEncounter.trim()),"no off encounter", selenium, ClassName, MethodName);
			
		assertTrue(selenium.isTextPresent(orderData.medicalCondition.trim()),"no medical", selenium, ClassName, MethodName);
			
		
		return true;
	}	
	public boolean verifyStoreInEncounterQueue(Selenium selenium, ChartPreVisitLib orderData){
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent(orderData.chiefComplaint.trim())){
			return false;
		}
		if(!selenium.isTextPresent(orderData.medicalCondition1.trim())){
			return false;
		}
		
		return true;
	}	
	
	
	
}
