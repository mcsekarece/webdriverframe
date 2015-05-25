package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoreValueForPrescripeMedication extends AbstractChartPreVisit{
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescripeData = new ChartPreVisitLib();
		prescripeData.workSheetName = "PrescribeMedi";
		prescripeData.testCaseId = "TC_PM_004";
		prescripeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescripeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescripeData = new ChartPreVisitLib();
		prescripeData.workSheetName = "PrescribeMedi";
		prescripeData.testCaseId = "TC_PM_035";
		prescripeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoredValuesForMandatoryFields(seleniumHost, seleniumPort, browser, webSite, userAccount, prescripeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForFreeText(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_009";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Increasing/Decreasing dose")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForIncreasingDecreasingDose(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_003";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with multiple directions")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForMultipleDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_002";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Values of Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForRefills(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_010";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(enabled=false)
	//This Test for checking "free form". It removed from UI. So, Disable the script from execution
	//@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyStoredValuesForFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount ) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_023";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount,prescribeData);
	}
	@Test(enabled=false)
	//This Test for checking "free form". It removed from UI. So, Disable the script from execution
	//@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyStoredValuesForFreeFormDirections(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount ) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_029";
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
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,prescripeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescripeData), "Pending medication deleteion failed",selenium,ClassName,MethodName);
			
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
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescripeData.provider = pName;
			
			if(prescripeData.testCaseId.equals("TC_PM_023")||prescripeData.testCaseId.equals("TC_PM_029")){
				assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			else
				assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescripeData.toString(),selenium,ClassName,MethodName);
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
			if(prescripeData.testCaseId.equals("TC_PM_004")||prescripeData.testCaseId.equals("TC_PM_029")){
				if(!verifyStoredValuesInSummaryPage(selenium,prescripeData, userAccount)){
					Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
					return false;
				}else 
					return returnValue;
			}
			if(prescripeData.testCaseId.equals("TC_PM_009")||prescripeData.testCaseId.equals("TC_PM_023")){
				if(!verifyStoredValuesInSummaryPageForFreeText(selenium,prescripeData, userAccount)){
					Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
					return false;
				}else 
					return returnValue;
			}
			if(prescripeData.testCaseId.equals("TC_PM_003")){
				if(!verifyStoredValuesInSummaryPageForIncreasingDecreasingDose(selenium,prescripeData, userAccount)){
					Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
					return false;
				}else 
					return returnValue;
			}
			if(prescripeData.testCaseId.equals("TC_PM_002")){
				if(!verifyStoredValuesInSummaryPageForMultipleDirections(selenium,prescripeData, userAccount)){
					Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
					return false;
				}else 
					return returnValue;
			}
		/*	if(prescripeData.testCaseId.equals("TC_PM_010")){
			if(!verifyStoredValuesInSummaryPageForRefill(selenium,prescripeData)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			}*/
					
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescripeData.toString());
		}
		return false;
	}
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium,ChartPreVisitLib prescripeData, String account) throws Exception{
	
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		try{
		assertTrue(selenium.isTextPresent(prescripeData.patientId), ""+ "Patient Name Not Present", selenium, ClassName,	MethodName);
	
		
		assertTrue(selenium.isTextPresent(providerName.toUpperCase()), ""+ "Provider Name Not Present", selenium, ClassName,	MethodName);
	
		
		assertTrue(selenium.isTextPresent(prescripeData.refillMethod), ""+ "Refill Method Not Present", selenium, ClassName,	MethodName);
		
		
		assertTrue(selenium.isTextPresent(prescripeData.unit), ""+ "Unit Not Present", selenium, ClassName,	MethodName);
		
		
		assertTrue(selenium.isTextPresent(prescripeData.refillQuantity), ""+ "Refill Quantity Not Present", selenium, ClassName,	MethodName);
		
		
		if(account.equalsIgnoreCase(CAAccount)){
			assertTrue(selenium.isTextPresent(prescripeData.routeCa), ""+ "Route Not Present", selenium, ClassName,	MethodName);
		
		
			assertTrue(selenium.isTextPresent(prescripeData.frequencyCa), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);
			
			
			
		}
		else{
			assertTrue(selenium.isTextPresent(prescripeData.route), ""+ "Route Not Present", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(selenium.isTextPresent(prescripeData.frequency), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			
			
			
		}
	
		assertTrue(selenium.isTextPresent(prescripeData.usage), ""+ "Usage Not Present", selenium, ClassName,	MethodName);
		
		
		assertTrue(selenium.isTextPresent(prescripeData.dispense), ""+ "Dispense Not Present", selenium, ClassName,	MethodName);
		
		
		assertTrue(selenium.isTextPresent(prescripeData.unitList), ""+ "Unit List Not Present", selenium, ClassName,	MethodName);
		
		
		
		assertTrue(click(selenium,btnEdit),"could not click Edit",selenium,ClassName,MethodName);
	System.out.println(getValue(selenium,ajxProvider).toString());
	
	System.out.println(prescripeData.provider);
	
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
		if(!getValue(selenium,ajxMethod).trim().contains(prescripeData.refillMethod.trim())){
			return false;
		}
		
		if(!getValue(selenium,ajxUnit).trim().contains(prescripeData.unit.trim())){
			return false;
		}
		/*
		if(!getValue(selenium,ajxQuantity).trim().contains(prescripeData.refillQuantity.trim())){
			return false;
		}*/
		
		
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,ajxRoute).trim().contains(prescripeData.routeCa.trim())){
				return false;
			}
			if(!getValue(selenium,ajxFrequency).trim().contains(prescripeData.frequencyCa.trim())){
				return false;
			}
			
		}
		else{
			if(!getValue(selenium,ajxRoute).trim().contains(prescripeData.route.trim())){
				return false;
			}
			if(!getValue(selenium,ajxFrequency).trim().contains(prescripeData.frequency.trim())){
				return false;
			}
			
		}
	
	
		if(!getValue(selenium,ajxUsage).trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getValue(selenium,txtDirectionNotes).trim().contains(prescripeData.direction.trim())){
			return false;
		}
		//waitForPageLoad(selenium);
		if(!getValue(selenium,txtDispense).trim().contains(prescripeData.dispense.trim())){
			return false;
		}
		if(!getValue(selenium,ajxUnitList).trim().contains(prescripeData.unitList.trim())){
			return false;
		}
		if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim())){
			return false;
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		return true;
		
	}
	public boolean verifyStoredValuesInSummaryPageForIncreasingDecreasingDose(Selenium selenium,ChartPreVisitLib prescripeData, String account) throws IOException{			
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
			assertTrue(selenium.isTextPresent(prescripeData.patientName), ""+ "Patient Name Not Present", selenium, ClassName,	MethodName);

			
			assertTrue(selenium.isTextPresent(providerName.toUpperCase()), ""+ "ProviderName Not Present", selenium, ClassName,	MethodName);

					
			assertTrue(selenium.isTextPresent(prescripeData.prescribeNameCa), ""+ "prescribe Name Not Present", selenium, ClassName,	MethodName);



			assertTrue(selenium.isTextPresent(prescripeData.refillMethod), ""+ "Refill Method Not Present", selenium, ClassName,	MethodName);

			
		
			assertTrue(selenium.isTextPresent(prescripeData.unit), ""+ "Unit Not Present", selenium, ClassName,	MethodName);

			
			assertTrue(selenium.isTextPresent(prescripeData.refillQuantity), ""+ "Refill Quantity Not Present", selenium, ClassName,	MethodName);

			
			if(account.equalsIgnoreCase(CAAccount)){
				assertTrue(selenium.isTextPresent(prescripeData.routeCa), ""+ "Route Not Present", selenium, ClassName,	MethodName);
	
			
				assertTrue(selenium.isTextPresent(prescripeData.frequencyCa), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);
	
				
			}
			else{
				assertTrue(selenium.isTextPresent(prescripeData.route), ""+ "Route Not Present", selenium, ClassName,	MethodName);

			
				assertTrue(selenium.isTextPresent(prescripeData.frequency), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);

				
			}
		
			assertTrue(selenium.isTextPresent(prescripeData.usage), ""+ "Usage Not Present", selenium, ClassName,	MethodName);
		
			assertTrue(selenium.isTextPresent(prescripeData.dispense), ""+ "Dispense Not Present", selenium, ClassName,	MethodName);

			
			assertTrue(selenium.isTextPresent(prescripeData.unitListCA), ""+ "Unit List Not Present", selenium, ClassName,	MethodName);

			
			assertTrue(selenium.isTextPresent(prescripeData.durationIn), ""+ "Duration In Not Present", selenium, ClassName,	MethodName);
		
			assertTrue(selenium.isTextPresent(prescripeData.notesToPharmacy), ""+ "notesToPharmacy Not Present", selenium, ClassName,	MethodName);

			
			click(selenium,btnEdit);
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
			if(!getValue(selenium,ajxInRefillMethod).trim().contains(prescripeData.refillMethod.trim())){
				return false;
			}
			if(!getValue(selenium,ajxInRefilUnit).trim().contains(prescripeData.refillUnit.trim())){
				return false;
			}
			if(!getValue(selenium,ajxInRefillQuantity).trim().contains(prescripeData.refillQuantity.trim())){
				return false;
			}
			
			if(account.equalsIgnoreCase(CAAccount)){
				if(!getValue(selenium,ajxInRefillRoute).trim().contains(prescripeData.refillRouteCa.trim())){
					return false;
				}
				if(!getValue(selenium,ajxInRefillFrequency).trim().contains(prescripeData.refillFrequencyCa.trim())){
					return false;
				}
				
			}
			else{
				if(!getValue(selenium,ajxInRefillRoute).trim().contains(prescripeData.refillRoute.trim())){
					return false;
				}
				if(!getValue(selenium,ajxInRefillFrequency).trim().contains(prescripeData.refillFrequency.trim())){
					return false;
				}
				
			}
			if(!getValue(selenium,ajxRefilUsage).trim().contains(prescripeData.refillUsage.trim())){
				return false;
			}
	
			if(!getValue(selenium,ajxInRefillUsage2).trim().contains(prescripeData.refillUsage2.trim())){
				return false;
			}
			if(!getValue(selenium,ajaxInRefillUsage3).trim().contains(prescripeData.refillUsage3.trim())){
				return false;
			}
			if(!getValue(selenium,txtDuration).trim().contains(prescripeData.durationIn.trim())){
				return false;
			}
			
			if(!getValue(selenium,ajxUnitList).trim().contains(prescripeData.unitList.trim())){
				return false;
			}
			if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim())){
				return false;
			}
			
			return true;
		}
	public boolean verifyStoredValuesInSummaryPageForMultipleDirections(Selenium selenium,ChartPreVisitLib prescripeData, String account) throws IOException{			
		waitForPageLoad(selenium);
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		
		assertTrue(selenium.isTextPresent(prescripeData.patientName), ""+ "Patient Name Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(providerName.toUpperCase()), ""+ "Provider Name Not Present", selenium, ClassName,	MethodName);

					
				
		assertTrue(selenium.isTextPresent(prescripeData.prescribeNameCa), ""+ "prescribe Name Not Present", selenium, ClassName,	MethodName);
	


		assertTrue(selenium.isTextPresent(prescripeData.refillMethod), ""+ "Refill Method Not Present", selenium, ClassName,	MethodName);

		
	
		assertTrue(selenium.isTextPresent(prescripeData.refillUnit), ""+ "Refill Unit Not Present", selenium, ClassName,	MethodName);


		assertTrue(selenium.isTextPresent(prescripeData.refillQuantity), ""+ "Refill Quantity Not Present", selenium, ClassName,	MethodName);

		
		if(account.equalsIgnoreCase(CAAccount)){
			assertTrue(selenium.isTextPresent(prescripeData.routeCa), ""+ "Route Not Present", selenium, ClassName,	MethodName);

		
			assertTrue(selenium.isTextPresent(prescripeData.frequencyCa), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);

			
		}
		else{
			assertTrue(selenium.isTextPresent(prescripeData.route), ""+ "Route Not Present", selenium, ClassName,	MethodName);

		
			assertTrue(selenium.isTextPresent(prescripeData.frequency), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);

			
		}
		assertTrue(selenium.isTextPresent(prescripeData.refillduration), ""+ "Refill Duration Not Present", selenium, ClassName,	MethodName);

		assertTrue(selenium.isTextPresent(prescripeData.refillUsage1), ""+ "Refill Usage Not Present", selenium, ClassName,	MethodName);

			
		
		assertTrue(selenium.isTextPresent(prescripeData.route), ""+ "Route Not Present", selenium, ClassName,	MethodName);

	
		assertTrue(selenium.isTextPresent(prescripeData.frequencyCa), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);

		
		//assertTrue(selenium.isTextPresent(prescripeData.usage), ""+ "Usage Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(prescripeData.dispense), ""+ "Dispense Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(prescripeData.unitListCA), ""+ "Unit List Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(prescripeData.durationIn), ""+ "Duration Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(prescripeData.notesToPharmacy), ""+ "notesToPharmacy Not Present", selenium, ClassName,	MethodName);


						
			
		click(selenium,btnEdit);
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
			 i++;
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
		if(!getValue(selenium,ajxMDRefilMethod).trim().contains(prescripeData.refillMethod.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDRefillQuantity).trim().contains(prescripeData.refillQuantity.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDRefillUnit).trim().contains(prescripeData.refillUnit.trim())){
			return false;
		}
		
		if(!getValue(selenium,ajxMDRefillFrequency).trim().contains(prescripeData.refillFrequency.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDRefillDuration).trim().contains(prescripeData.refillduration.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDRefillUsage).trim().contains(prescripeData.refillUsage1.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDQuantity).trim().contains(prescripeData.quality.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDUnit).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.unit.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,ajxMDFrequency).trim().contains(prescripeData.frequencyCa.trim())){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxMDFrequency).trim().contains(prescripeData.frequency.trim())){
				return false;
			}
		}
		
		if(!getValue(selenium,ajxMDDuration).trim().contains(prescripeData.duration.trim())){
			return false;
		}
		if(!getValue(selenium,ajxMDUsage).trim().contains(prescripeData.usage.trim())){
			return false;
		}
		if(!getValue(selenium,ajxUnitList).trim().contains(prescripeData.unitList.trim())){
			return false;
		}
		if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescripeData.notesToPharmacy.trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesInSummaryPageForFreeText(Selenium selenium,ChartPreVisitLib prescripeData, String account) throws Exception{
			
			waitForPageLoad(selenium);
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
			
			assertTrue(selenium.isTextPresent(prescripeData.patientId), ""+ "Patient Name Not Present", selenium, ClassName,	MethodName);

			
			System.out.println(getText(selenium,lblprescribeProviderName));
			System.out.println(prescripeData.providerName);
			
			assertTrue(selenium.isTextPresent(providerName.toUpperCase()), ""+ "Provider Name Not Present", selenium, ClassName,	MethodName);
	
			
			System.out.println(getText(selenium,lblPrescribeData));
			System.out.println(prescripeData.providerAddress);
			
			if(account.equalsIgnoreCase(CAAccount)){
				assertTrue(selenium.isTextPresent(prescripeData.prescribeNameCa), ""+ "prescribe Name Not Present", selenium, ClassName,	MethodName);
	
			}
			else{
				assertTrue(selenium.isTextPresent(prescripeData.prescribeName), ""+ "prescribe Name Not Present", selenium, ClassName,	MethodName);
		
			}
			
			
			assertTrue(selenium.isTextPresent(prescripeData.direction), ""+ "Direction Not Present", selenium, ClassName,	MethodName);

		
			assertTrue(selenium.isTextPresent(prescripeData.dispense), ""+ "Dispense Not Present", selenium, ClassName,	MethodName);

			
			
			if(prescripeData.testCaseId.equals("TC_PM_009")){
				
				assertTrue(selenium.isTextPresent("No substitutions permitted"), ""+ "No substitutions permitted Text Not Present", selenium, ClassName,	MethodName);

				
			}
			else{
				
				assertTrue(selenium.isTextPresent("Substitutions permitted"), ""+ "Substitutions permitted Text Not Present", selenium, ClassName,	MethodName);
		
			
			}
			assertTrue(click(selenium,btnEdit),"Edit failed",selenium,ClassName,MethodName);
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
			if(!getValue(selenium,txtDirectionNotes).trim().contains(prescripeData.direction.trim())){
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
			//  Step-3: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescripeData), "Pending medication deleteion failed",selenium,ClassName,MethodName);
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
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescripeData.providerName = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescripeData.toString(), selenium, ClassName, MethodName);
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
			if(!verifyStoredValuesForMandatoryFields(selenium,prescripeData, userAccount)){
				Assert.fail("Cases details not saved properly; More Details :"+ prescripeData.toString());
				return false;
			}else 
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescripeData.toString());
		}
		return false;
	}
	public boolean verifyStoredValuesForMandatoryFields(Selenium selenium,ChartPreVisitLib prescripeData, String account) throws IOException{
		waitForPageLoad(selenium);
		
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
		
		assertTrue(selenium.isTextPresent(prescripeData.patientName), ""+ "Patient Name Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(providerName.toUpperCase()), ""+ "Provider Name Not Present", selenium, ClassName,	MethodName);

					
				
		assertTrue(selenium.isTextPresent(prescripeData.refillMethod), ""+ "Refill Method Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(prescripeData.unit), ""+ "Unit Not Present", selenium, ClassName,	MethodName);

		
		assertTrue(selenium.isTextPresent(prescripeData.refillQuantity), ""+ "Refill Quantity Not Present", selenium, ClassName,	MethodName);
	
		
		if(account.equalsIgnoreCase(CAAccount)){
			assertTrue(selenium.isTextPresent(prescripeData.routeCa), ""+ "Route Not Present", selenium, ClassName,	MethodName);

		
			assertTrue(selenium.isTextPresent(prescripeData.frequencyCa), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);

			
		}
		else{
			assertTrue(selenium.isTextPresent(prescripeData.route), ""+ "Route Not Present", selenium, ClassName,	MethodName);
	
		
			assertTrue(selenium.isTextPresent(prescripeData.frequency), ""+ "Frequency Not Present", selenium, ClassName,	MethodName);

		}
		
		assertTrue(selenium.isTextPresent(prescripeData.usage), ""+ "Usage Not Present", selenium, ClassName,	MethodName);

		
		
		assertTrue(selenium.isTextPresent(prescripeData.unitList), ""+ "Unit List Not Present", selenium, ClassName,	MethodName);

		
		
		
		click(selenium,btnEdit);
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
		if(!getValue(selenium,ajxMethod).trim().contains(prescripeData.refillMethod.trim())){
			return false;
		}
		
		if(!getValue(selenium,ajxUnit).trim().contains(prescripeData.unit.trim())){
			return false;
		}
		
		if(!getValue(selenium,ajxQuantity).trim().contains(prescripeData.refillQuantity.trim())){
			return false;
		}
		
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,ajxRoute).trim().contains(prescripeData.routeCa.trim())){
				return false;
			}
			if(!getValue(selenium,ajxFrequency).trim().contains(prescripeData.frequencyCa.trim())){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxRoute).trim().contains(prescripeData.route.trim())){
				return false;
			}
			if(!getValue(selenium,ajxFrequency).trim().contains(prescripeData.frequency.trim())){
				return false;
			}
		
		}
	
		
		if(!getValue(selenium,ajxDuration).trim().contains(prescripeData.duration.trim())){
			return false;
		}
		if(!getValue(selenium,ajxUsage).trim().contains(prescripeData.usage.trim())){
			return false;
		}	
	
		return true;
	}
}

