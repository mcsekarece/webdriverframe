package com.nexia.selenium.testscripts.section.chartprevisit.EncounterQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnsignedEncounterQueueCount extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing save functionality in Encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_019";
		encounterData.fetchChartPreVisitTestData();
		verifySaveEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/**
	 * verifySaveEncounter
	 * function to verify save functionality in Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @defect      #2007	
	 * @throws     IOException 
	 * @since  	    Nov 28, 2012
	 */
	public boolean verifySaveEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		String date=null;
		String time=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			assertTrue(switchRole(selenium,encounterData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId),"Could not select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			
			assertTrue(deleteAllEncounters(selenium,encounterData),"Could nor delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		

			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Save the encounter//
			//--------------------------------------------------------------------//
		
			
			
			assertTrue(clickAt(selenium,lnkBeginEncounterAction,""),"Could not click", selenium, ClassName, MethodName);
			assertTrue(focus(selenium,lnkBeginEncounterAction),"Could not Select", selenium, ClassName, MethodName);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
				
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Home page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Encounter Queue//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkUnSigned),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String resultList=getText(selenium,lnkUnSigned);
			System.out.println(resultList);
			String[] splitS = resultList.split(" ");
			int encounterResult = Integer.parseInt(splitS[0]);
			System.out.println(encounterResult);
			
			
			selectValueFromAjaxList(selenium,ajxShow,"My encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblUnEncounterQueue),"Could not click the First record", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			  if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName, MethodName);
			String UnsignedList=getText(selenium,"showListButton");
			System.out.println(UnsignedList);
			String[] split = UnsignedList.split(" ");
			String TempCount=split[3].replace("(", "");
			TempCount=TempCount.replace(")","");
			int unSignedResult =Integer.parseInt(TempCount);
			System.out.println(unSignedResult);
			waitForPageLoad(selenium);
			//Verify the count
			if(!(encounterResult == unSignedResult )){
				Assert.fail("The count is not equal");
			}
			
			//click the sign button
			selenium.focus(btnSign);
			selenium.clickAt(btnSign, "");
			/*assertTrue(click(selenium, btnEncounterNoteSign),"Could not click the Sign Button", selenium, ClassName, MethodName);*/
			waitForPageLoad(selenium);
			  if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			String resultList1=getText(selenium,lnkUnSigned);
			System.out.println(resultList);
			String[] splitS1 = resultList1.split(" ");
			int encounterResult1 = Integer.parseInt(splitS1[0]);
			System.out.println(encounterResult);
			//--------------------------------------------------------------------//
			//  Step-7: After the sign the encounter verify the count details//
			//--------------------------------------------------------------------//
			
			 
			 if(!(encounterResult1 <= encounterResult)){
				 Assert.fail("The unsigned result is not less then signedEncounter");
			 }
			

			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
