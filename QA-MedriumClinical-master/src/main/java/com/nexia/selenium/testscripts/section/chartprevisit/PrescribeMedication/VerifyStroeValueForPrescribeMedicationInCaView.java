package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStroeValueForPrescribeMedicationInCaView extends AbstractChartPreVisit{
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescripeData = new ChartPreVisitLib();
		prescripeData.workSheetName = "PrescribeMedi";
		prescripeData.testCaseId = "TC_PM_036";
		prescripeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescripeData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescripeData = new ChartPreVisitLib();
		prescripeData.workSheetName = "PrescribeMedi";
		prescripeData.testCaseId = "TC_PM_037";
		prescripeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoredValuesForMandatoryFields(seleniumHost, seleniumPort, browser, webSite, userAccount, prescripeData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForFreeText(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_038";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Increasing/Decreasing dose")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForIncreasingDecreasingDose(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_039";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with multiple directions")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForMultipleDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_040";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	  @Test  (enabled = false)
	//@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Values of Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForRefills(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_041";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	  @Test(enabled=false)
	//@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Values of Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyStoredValuesForFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount ) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_042";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount,prescribeData);
	}
	  @Test(enabled=false)
	 //@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Values of Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyStoredValuesForFreeFormDirections(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount ) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_043";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite,userAccount, prescribeData);
	}

	/**
	 * verifyStoreValueForPrescribeMedication
	 * function to verify Store Value For Prescribe Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Sep 12, 2012
	 */
	public boolean verifyStoreValueForPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescripeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescripeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescripeData.userName, prescripeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescripeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
		
			if(prescripeData.testCaseId.equals("TC_PM_042")||prescripeData.testCaseId.equals("TC_PM_043")){
				assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
			}
			else
		    assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescripeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
 			assertTrue(addPrescribeMedication(selenium,prescripeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Stored Value in Summary page //
			//--------------------------------------------------------------------//
			if(prescripeData.testCaseId.equals("TC_PM_036")||prescripeData.testCaseId.equals("TC_PM_043")){
			
				if(!verifyStoredValuesInSummaryPage(selenium,prescripeData)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			}
			if(prescripeData.testCaseId.equals("TC_PM_038")||prescripeData.testCaseId.equals("TC_PM_042")){
			if(!verifyStoredValuesInSummaryPageForFreeText(selenium,prescripeData)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			}
			if(prescripeData.testCaseId.equals("TC_PM_039")){
			if(!verifyStoredValuesInSummaryPageForIncreasingDecreasingDose(selenium,prescripeData)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			}
			if(prescripeData.testCaseId.equals("TC_PM_040")){
			if(!verifyStoredValuesInSummaryPageForMultipleDirections(selenium,prescripeData)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			}
		/*	if(prescripeData.testCaseId.equals("TC_PM_041")){
			if(!verifyStoredValuesInSummaryPageForRefill(selenium,prescripeData)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			}*/
					
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescripeData.toString(),selenium,ClassName,MethodName);
		}
		return false;
	}
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium,ChartPreVisitLib prescripeData){
		
		/*Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
		String date=DateFormat1.format(cal.getTime());
		

		waitForPageLoad(selenium);
	*/
		
		
		//if(!getText(selenium,prescriptionPageData).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			//return false;
		//}
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		System.out.println(prescripeData.provider);
		//if(!getText(selenium,"name").trim().contains(getText(selenium,lblprescribeProviderName1))){
		//	return false;
		//}
		
	   if(!getText(selenium,prescriptionPageData).trim().contains(providerName.toUpperCase().trim())){
			return false;
	     }
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillMethodCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.qualityCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.routeCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.frequencyCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.dispense.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitList.trim())){
			return false;
		}
		if(getText(selenium,prescriptionPageData).trim().contains("null")){
			return false;
		}
		if(prescripeData.testCaseId.equals("TC_PM_036")){
			if(!selenium.isTextPresent("No substitutions permitted")){
				return false;
			}
		}
		else{
			if(!getText(selenium,lblSummaryPrescribeMed).trim().contains("Substitutions permitted")){
				return false;
			}
		}
		
		click(selenium,btnEdit);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,yesLink))
		   {
			  click(selenium,yesLink);
		   }
		 String firstName="";
		 String lastName="";
		 int i=0;
		 char[] processFirstName=providerName.toCharArray();
		
		 while(processFirstName[i]!=' ')
		 {
			 firstName=firstName+processFirstName[i];
			 i++;
		 }
		 char[] processLastName=providerName.toCharArray();
		 i=providerName.length();
		 i=i-1;
		 while(processLastName[i]!=' ')
		 {
			 lastName=lastName+processLastName[i];
			 i--;
		 }
		 int length = lastName.length();
		 String lastname="";
	      for ( i = length - 1 ; i >= 0 ; i-- )
	    	  lastname = lastname + lastName.charAt(i);
		if(!getValue(selenium,ajxProvider).trim().contains(firstName.toUpperCase())){
			return false;
		}
		if(!getValue(selenium,ajxProvider).trim().contains(lastname.toUpperCase())){
			return false;
		}
		if(!getValue(selenium,ajxLoaction).trim().contains(prescripeData.loaction.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMethod).trim().contains(prescripeData.refillMethodCa.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxQuantity).trim().contains(prescripeData.qualityCa.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxUnit).trim().contains(prescripeData.unitCa.trim())){
			return false;
		}
		if(!getValue(selenium,ajxRoute).trim().contains(prescripeData.routeCa.trim())){
			return false;
		}
		if(!getValue(selenium,ajxFrequency).trim().contains(prescripeData.frequencyCa.trim())){
			return false;
		}
		//EMR-1272
		/*if(!getValue(selenium,ajxDuration).trim().contains(prescripeData.duration.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxUsage).trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getValue(selenium,txtDirectionNotes).trim().contains(prescripeData.direction.trim())){
			return false;
		}
		/*if(!getValue(selenium,txtDispense).trim().contains(prescripeData.dispense.trim())){
			return false;
		}*/
		/*if(!getValue(selenium,ajxUnitList).trim().contains(prescripeData.unitListCA.trim())){
			return false;
		}*/
		if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim())){
			return false;
		}
		
		return true;
	}
	public boolean verifyStoredValuesInSummaryPageForIncreasingDecreasingDose(Selenium selenium,ChartPreVisitLib prescripeData) throws IOException{			
		System.out.println();
		System.out.println(prescripeData.provider.trim().toUpperCase(new java.util.Locale("en","Us")));
		String providerNameTemp= getText(selenium, lnkTopMenu);
		
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		
		String tempArray[]=providerName.split(" ");
		String pName=tempArray[1]+", "+tempArray[0];
		System.out.println(pName);
		prescripeData.providerName = pName;
		prescripeData.provider = "Dr."+providerName;
		System.out.println(prescripeData.provider);
		assertTrue(selenium.isTextPresent(prescripeData.patientName.trim()),"Could not find the text",selenium,ClassName,MethodName);
		assertTrue(selenium.isTextPresent(providerName),"Could not find the text",selenium,ClassName,MethodName);
		
	/*	if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientAddress.trim())){
		return false;
	}*/
	/*if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerAddress.trim())){
		return false;
	}*/		
	/*if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientPhone.trim())){
		return false;
	}
	if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerPhone.trim())){
		return false;
	}		*/
	/*if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.licenseNo.trim())){
		return false;
	}*/
//		if(!getText(selenium,"medicationListPanel").trim().contains(prescripeData.prescribeNameCa.trim())){
//			return false;
//		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillMethodCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.routeCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.usageCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains("**"+prescripeData.dispense.trim()+"** ".trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitListCA.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.notesToPharmacy.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnEdit),"Could not click the Edit ",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,yesLink))
		{
			click(selenium,yesLink);
		}
		 String firstName="";
		 String lastName="";
		 int i=0;
		 char[] processFirstName=providerName.toCharArray();
		
		 while(processFirstName[i]!=' ')
		 {
			 firstName=firstName+processFirstName[i];
			 i++;
		 }
		 char[] processLastName=providerName.toCharArray();
		 i=providerName.length();
		 i=i-1;
		 while(processLastName[i]!=' ')
		 {
			 lastName=lastName+processLastName[i];
			 i--;
		 }
		 int length = lastName.length();
		 String lastname="";
	      for ( i = length - 1 ; i >= 0 ; i-- )
	    	  lastname = lastname + lastName.charAt(i);
		if(!getValue(selenium,ajxProvider).trim().contains(firstName.toUpperCase())){
			return false;
		}
		if(!getValue(selenium,ajxProvider).trim().contains(lastname.toUpperCase())){
			return false;
		}
		assertTrue(getValue(selenium,ajxLoaction).trim().contains(prescripeData.loaction.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxInRefillMethod).trim().contains(prescripeData.refillMethod.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxInRefillQuantity).trim().contains(prescripeData.refillQuantity.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxInRefilUnit).trim().contains(prescripeData.refillUnitCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxInRefillRoute).trim().contains(prescripeData.refillRouteCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxInRefillFrequency).trim().contains(prescripeData.refillFrequencyCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxRefilUsage).trim().contains(prescripeData.refillUsage.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		
		assertTrue(getValue(selenium,ajaxInRefillUsage3).trim().contains(prescripeData.refillUsage3Ca.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxUnitList).trim().contains(prescripeData.unitListCA.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim()),"Could not find the text",selenium,ClassName,MethodName);

		
		return true;
	}
	public boolean verifyStoredValuesInSummaryPageForMultipleDirections(Selenium selenium,ChartPreVisitLib prescripeData) throws IOException{			
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(prescripeData.patientName.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
//		if(!selenium.isTextPresent(prescripeData.providerName.trim())){
//			return false;
//		}
		/*if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientAddress.trim())){
			return false;
		}
		if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerAddress.trim())){
			return false;
		}*/
		/*if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientPhone.trim())){
			return false;
		}*/
	
		/*if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerPhone.trim())){
			return false;
		}*/	
//		if(!selenium.isTextPresent(prescripeData.prescribeNameCa.toUpperCase().trim())){
//			return false;
//		}
		
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillMethodCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillQuantityCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillUnitCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillRouteCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillFrequencyCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillUsage1Ca.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.methodCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim())){
			return false;
		}
		assertTrue(	click(selenium,btnEdit),"Could not find the text",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,yesLink))
		{
			click(selenium,yesLink);
		}
		assertTrue(getValue(selenium,ajxLoaction).trim().contains(prescripeData.loaction.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDRefilMethod).trim().contains(prescripeData.refillMethod.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDRefillQuantity).trim().contains(prescripeData.refillQuantityCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDRefillRoute).trim().contains(prescripeData.refillRouteCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDRefillFrequency).trim().contains(prescripeData.refillFrequencyCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDRefillUsage).trim().contains(prescripeData.refillUsage1.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDMethod).trim().contains(prescripeData.methodCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDQuantity).trim().contains(prescripeData.qualityCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		//assertTrue(getValue(selenium,ajxMDUnit).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.unitCa.trim().toLowerCase(new java.util.Locale("en","Us"))),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDRoute).trim().contains(prescripeData.routeCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDFrequency).trim().contains(prescripeData.frequencyCa.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,ajxMDUsage).trim().contains(prescripeData.refillUsage4Ca.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,txtDispense).trim().contains(prescripeData.dispense.trim()),"Could not find the text",selenium,ClassName,MethodName);

		//assertTrue(getValue(selenium,ajxMDRefillUnit).trim().contains(prescripeData.unitListCA.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim()),"Could not find the text",selenium,ClassName,MethodName);

		return true;
	}
	/*public boolean verifyStoredValuesInSummaryPageForRefill(Selenium selenium,ChartPreVisitLib prescripeData){			
		waitForPageLoad(selenium);
		if(!getText(selenium,"//div[4]/div[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.patientAddress.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.providerAddress.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.patientPhone.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.providerPhone.trim())){
			return false;
		}		
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.prescribeName.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.direction.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.direction.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.ofRefill.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillUsage1.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillMethod.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillQuantity.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillUnit.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillRoute.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillFrequency.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.refillduration.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains("**"+prescripeData.ofRefill.trim()+"** "+prescripeData.dispenseWord.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.unitList.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[2]").trim().contains(prescripeData.notesToPharmacy.trim())){
			return false;
		}	
		assertTrue(click(selenium,btnEdit));
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxProvider).trim().contains(prescripeData.provider.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLoaction).trim().contains(prescripeData.loaction.trim())){
			return false;
		}
		if(!getValue(selenium,"ofRefillsid").trim().contains(prescripeData.ofRefill.trim())){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='durationNumberID'])[2]").trim().contains(prescripeData.ofRefill.trim())){
			return false;
		}
		if(!getValue(selenium,"durationListSuggestBoxsuggestBox").trim().contains(prescripeData.refillUsage1.trim())){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[4]").trim().contains(prescripeData.refillMethod.trim())){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[4]").trim().contains(prescripeData.refillQuantity.trim())){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[4]").trim().contains(prescripeData.refillUnit)){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[4]").trim().contains(prescripeData.refillFrequency.trim())){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='refillDurationSuggestBoxsuggestBox'])[3]").trim().contains(prescripeData.refillduration.trim())){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[8]").trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getValue(selenium,"dispenseID").trim().contains(prescripeData.dispense.trim())){
			return false;
		}
		if(!getValue(selenium,ajxUnitList).trim().contains(prescripeData.unitList.trim())){
			return false;
		}
		if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim())){
			return false;
		}
		return true;
	}*/
	public boolean verifyStoredValuesInSummaryPageForFreeText(Selenium selenium,ChartPreVisitLib prescripeData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,prescriptionPageData).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us"))),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,prescriptionPageData).trim().contains(prescripeData.prescribeNameCa.trim().toUpperCase()),"Could not find the text",selenium,ClassName,MethodName);
		
		
		assertTrue(getText(selenium,prescriptionPageData).trim().contains(prescripeData.direction.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,prescriptionPageData).trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim()),"Could not find the text",selenium,ClassName,MethodName);
		
		assertTrue(getText(selenium,prescriptionPageData).trim().contains(prescripeData.notesToPharmacy.trim()),"Could not find the text",selenium,ClassName,MethodName);
		String providerNameTemp= getText(selenium, lnkTopMenu);		
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		assertTrue(click(selenium,btnEdit),"Could not Click the Edit",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,yesLink))
		{
			click(selenium,yesLink);
		}
		 String firstName="";
		 String lastName="";
		 int i=0;
		 char[] processFirstName=providerName.toCharArray();
		
		 while(processFirstName[i]!=' ')
		 {
			 firstName=firstName+processFirstName[i];
			 i++;
		 }
		 char[] processLastName=providerName.toCharArray();
		 i=providerName.length();
		 i=i-1;
		 while(processLastName[i]!=' ')
		 {
			 lastName=lastName+processLastName[i];
			 i--;
		 }
		 int length = lastName.length();
		 String lastname="";
	      for ( i = length - 1 ; i >= 0 ; i-- )
	    	  lastname = lastname + lastName.charAt(i);
		if(!getValue(selenium,ajxProvider).trim().contains(firstName.toUpperCase())){
			return false;
		}
		if(!getValue(selenium,ajxProvider).trim().contains(lastname.toUpperCase())){
			return false;
		}
		
		assertTrue(getValue(selenium,ajxProvider).trim().contains(firstName.toUpperCase().trim()),"Could not find the text",selenium,ClassName,MethodName);
		assertTrue(getValue(selenium,ajxProvider).trim().contains(lastname.toUpperCase().trim()),"Could not find the text",selenium,ClassName,MethodName);
		assertTrue(getValue(selenium,ajxLoaction).trim().contains(prescripeData.loaction.trim()),"Could not find the text",selenium,ClassName,MethodName);
		assertTrue(getValue(selenium,txtDirectionNotes).trim().contains(prescripeData.direction.trim()),"Could not find the text",selenium,ClassName,MethodName);
		assertTrue(getValue(selenium,txtDispense).trim().contains(prescripeData.dispense.trim()),"Could not find the text",selenium,ClassName,MethodName);
		return true;
	}
	/**
	 * verifyStoredValuesForMandatoryFields
	 * function to verify Stored Values For Mandatory Fields
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Sep 12, 2012
	 */
	
	public boolean verifyStoredValuesForMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescripeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescripeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescripeData.userName, prescripeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescripeData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
			
//			String tempArray[]=providerName.split(" ");
//			String pName=tempArray[1]+", "+tempArray[0];
//			System.out.println(pName);
//			prescripeData.providerName = pName;
//			prescripeData.provider = providerName;

			assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescripeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescripeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verify Stored Value in Summary page //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForMandatoryFields(selenium,prescripeData)){
				Assert.fail("Cases details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescripeData.toString(),selenium,ClassName,MethodName);
		}
		return false;
	}
	public boolean verifyStoredValuesForMandatoryFields(Selenium selenium,ChartPreVisitLib prescripeData){
		waitForPageLoad(selenium);
		/*if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!prescripeData.provider.trim().toUpperCase(new java.util.Locale("en","Us")).contains(getText(selenium,lblprescribeProviderName1).toLowerCase(new java.util.Locale("en","Us")).trim())){
			return false;
		}*/
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.refillMethodCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.qualityCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitCa.trim())){
			return false;
		}
		
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.routeCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.frequencyCa.trim())){
			return false;
		}
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.usage.trim())){
			return false;
		}
		System.out.println("**"+prescripeData.dispense+"**");
		System.out.println(getText(selenium,"css=div.prescription-preview-wrapper"));
		if(!(getText(selenium,prescriptionPageData).trim().contains("**"+prescripeData.dispense+"**".trim()))){
			return false;
		}
		
		
		
		if(!getText(selenium,prescriptionPageData).trim().contains(prescripeData.unitList.trim())){
			return false;
		}
		click(selenium,btnEdit);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,yesLink))
		{
			click(selenium,yesLink);
		}
		System.out.println(getValue(selenium,ajxProvider));
		System.out.println();
		System.out.println(prescripeData.provider.trim().toUpperCase(new java.util.Locale("en","Us")));
		String providerNameTemp= getText(selenium, lnkTopMenu);
		
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		
		 String firstName="";
		 String lastName="";
		 int i=0;
		 char[] processFirstName=providerName.toCharArray();
		
		 while(processFirstName[i]!=' ')
		 {
			 firstName=firstName+processFirstName[i];
			 i++;
		 }
		 char[] processLastName=providerName.toCharArray();
		 i=providerName.length();
		 i=i-1;
		 while(processLastName[i]!=' ')
		 {
			 lastName=lastName+processLastName[i];
			 i--;
		 }
		 int length = lastName.length();
		 String lastname="";
	      for ( i = length - 1 ; i >= 0 ; i-- )
	    	  lastname = lastname + lastName.charAt(i);
		if(!getValue(selenium,ajxProvider).trim().contains(firstName.toUpperCase())){
			return false;
		}
		if(!getValue(selenium,ajxProvider).trim().contains(lastname.toUpperCase())){
			return false;
		}
		if(!getValue(selenium,ajxLoaction).trim().contains(prescripeData.loaction.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMethod).trim().contains(prescripeData.refillMethodCa.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxQuantity).trim().contains(prescripeData.qualityCa.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxUnit).trim().contains(prescripeData.unit.trim())){
			return false;
		}
		if(!getValue(selenium,ajxRoute).trim().contains(prescripeData.routeCa.trim())){
			return false;
		}
		if(!getValue(selenium,ajxFrequency).trim().contains(prescripeData.frequencyCa.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxDuration).trim().contains(prescripeData.duration.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxUsage).trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getValue(selenium,txtDirectionNotes).trim().contains(prescripeData.direction.trim())){
			return false;
		}
		/*if(!getValue(selenium,txtDispense).trim().contains(prescripeData.dispense.trim())){
			return false;
		}*/
		return true;
	}

}
