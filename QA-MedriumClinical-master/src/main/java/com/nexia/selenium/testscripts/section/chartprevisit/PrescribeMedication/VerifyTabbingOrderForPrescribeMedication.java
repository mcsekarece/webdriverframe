package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForPrescribeMedication extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify tabbing order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForSearchMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_083";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify tabbing order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_084";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyTabbingOrder
	 * Function to verify tabbing order
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 17, 2012
	 */	
	public boolean verifyTabbingOrder(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium = null;
		try{
			String csspaths[]={"css=#providerListSuggestBoxsuggestBox", "css=#locationListSuggestBoxsuggestBox", "css=#drugsQuicklistBox", "xpath=(//button[@type='button'])[8]", "xpath=(//button[@type='button'])[9]"};
			String csspaths1[] = {"css=#providerListSuggestBoxsuggestBox", "css=#locationListSuggestBoxsuggestBox", "css=#oneTimeOnlyIDcheckbox", "css=#freeTextIDcheckbox", "css=#refillMethodSuggestBoxsuggestBox", "css=#refillQuantitySuggestBoxsuggestBox", "css=#refillUnitSuggestBoxsuggestBox", "css=#refillRouteSuggestBoxsuggestBox", "css=#refillFrequencySuggestBoxsuggestBox", "css=#refillDurationSuggestBoxsuggestBox", "css=#refillUsageSuggestBoxsuggestBox", "css=#directionsNotesTextBoxId", "css=#dispenseID", "css=#unitListSuggestBoxsuggestBox", "css=#fillOnID", "css=#ofRefillsid", "css=#notesToPharmacyTextBoxId", "css=#subPermittedcheckbox", "css=#comPackingcheckbox", "css=#internalNotesTextBoxId", "css=#previousPharmacy", "css=#searchDatabase"};
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);;
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-4:Tab order                                        //
			//--------------------------------------------------------------------//
			if(prescribeData.testCaseId.equals("TC_PM_001")){
				
				for(int i =0;i<csspaths.length;i++){
					assertTrue(isElementPresent(selenium,csspaths[i]),"Not found",selenium,ClassName,MethodName);
					selenium.focus(csspaths[i]);
					waitForElementToEnable(selenium,csspaths[i]);
					selenium.keyPress(csspaths[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				}
				return true;
			}
			else if(prescribeData.testCaseId.equals("TC_PM_002")){
				String providerNameTemp= getText(selenium, lnkTopMenu);
				String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
				String tempArray[]=providerName.split(" ");
				String pName=tempArray[1]+", "+tempArray[0];
				System.out.println(pName);
				prescribeData.provider = pName;
				
				selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
				selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
				//--------------------------------------------------------------------//
				//  Step-4: Search  Prescribe Medication //
				//--------------------------------------------------------------------//
				assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,btnSave)){
					assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
					assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				//---------------------------------------------------------- ---------//
				//  Step-4:Tab order                                        //
				//--------------------------------------------------------------------//
				for(int i =0;i<csspaths1.length;i++){
					assertTrue(isElementPresent(selenium,csspaths1[i]),"Not found",selenium,ClassName,MethodName);
					selenium.focus(csspaths1[i]);
					waitForElementToEnable(selenium,csspaths1[i]);
					selenium.keyPress(csspaths1[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths1[i]));
				}
				return true;
			}else
				return false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)",selenium,ClassName,MethodName);
			return false;
		}
	}
}
