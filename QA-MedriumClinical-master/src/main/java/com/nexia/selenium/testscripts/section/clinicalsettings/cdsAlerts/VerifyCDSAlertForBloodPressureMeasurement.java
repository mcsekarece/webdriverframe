package com.nexia.selenium.testscripts.section.clinicalsettings.cdsAlerts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCDSAlertForBloodPressureMeasurement extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying CDS alert for patient with Blood pressure measurement")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCDSAlertForBloodPressureMeasurement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateProblemList";
		cdsData.testCaseId = "TC_CPL_014";
		cdsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying CDS alert not present for patient with Blood pressure measurement with cancel functionality")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelledCDSAlertForBloodPressureMeasurement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateProblemList";
		cdsData.testCaseId = "TC_CPL_015";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying CDS alert not present for patient with Blood pressure measurement with cancel functionality")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCDSAlertForBPMWithResolved(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateProblemList";
		cdsData.testCaseId = "TC_CPL_012";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
	/**
	 * verifyCdsAlert
	 * Function to verify CDS alert
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifyCdsAlert(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to CDS and uncheck all the rules//
			//--------------------------------------------------------------------//
			
			navigateToCDSUncheck(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search for a patient//
			//--------------------------------------------------------------------//
			
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_013";
			PatientData.fetchHomeTestData();
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientForBPM(selenium,PatientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patId = getText(selenium, btnPatientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientChartView), "Could not click on patient chart link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create first encounter
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium, ajxProvider1, cdsData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "08/08/2011"),"could not enter", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"could not click sign button",selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium, ajxProvider1, cdsData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "08/08/2011"),"could not enter", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"could not click sign button",selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Count the number of encounters present//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"could not click encounter tab",selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblEncounterChoosePanel)){
				if(isElementPresent(selenium,lnkStartNewWncouter)){
					assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
					assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);}
				else {	
					assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
					waitForPageLoad(selenium);}
				}
				
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkStartNewWncouter)){
						assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);}
					else {
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);}
					}
					
				
			int count=0,count1=0;
			if(isElementPresent(selenium,lblUnsignedEncounterList))
				count=1;
			if(isElementPresent(selenium,lblSignedEncounterList))
				count1=1;
			while(isElementPresent(selenium,"//div[2]/div/div[2]/table/tbody/tr["+count+"]/td[2]/div/div")){
				count++;
				
				if(count>15)
					break;
			}
			
			while(isElementPresent(selenium,"//div[2]/div[2]/div/div[2]/table/tbody/tr["+count1+"]/td[2]/div/div")){
				count1++;
				
				if(count1>15)
					break;
			}
			
			int counter=count+count1;
			
			if(counter-1==1){
				assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkStartNewWncouter)){
						assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
						waitForPageLoad(selenium);}
					else {
						//assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
						waitForPageLoad(selenium);}
					}
					
					waitForPageLoad(selenium);
			}
			else if(counter==0){
				assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkStartNewWncouter)){
						assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
						waitForPageLoad(selenium);}
					else {
						//assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
							
						waitForPageLoad(selenium);}
					}
					
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					if(isElementPresent(selenium,lblEncounterChoosePanel)){
						if(isElementPresent(selenium,lnkStartNewWncouter)){
							assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
						
							waitForPageLoad(selenium);}
						else {
							//assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);	
							waitForPageLoad(selenium);}
						}
						
						waitForPageLoad(selenium);
			}
			
			
					waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			/*assertTrue(deleteAllProblemList(selenium, cdsData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			
			selectValueFromAjaxList(selenium,txtMedicatl,cdsData.medicalCondition1);
			String date="";
			if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			assertTrue(enterDate(selenium,txtOnset,date),"Could not enter the Admin on ;More Details:"+cdsData.toString(),selenium, ClassName, MethodName);
			}else{
				Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal1.getTime());
			assertTrue(enterDate(selenium,txtOnset,date),"Could not enter the Admin on ;More Details:"+cdsData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxItem,cdsData.itemStatus);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details:"+cdsData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveProblemList),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCreatedProblemListEntry)){
				returnValue=true;
			}else
				returnValue=false;
				
				ChartPreVisitLib cdsData1 = new ChartPreVisitLib();
				
					cdsData1.workSheetName = "CreateVitals";
					cdsData1.testCaseId = "TC_CV_002";
					cdsData1.fetchChartPreVisitTestData();
				
					assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Add Vitals												  //
				//--------------------------------------------------------------------//
				assertTrue(addVitalsForCds(selenium,cdsData1),"Vitals Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				click(selenium,btnVitalsDone);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Select the CDS Alert rule//
				//--------------------------------------------------------------------//
				if(cdsData1.testCaseId.equals("TC_CV_013")){	
					navigateToCDSCheckCancel(selenium);
					waitForPageLoad(selenium);
				}
				else{
				navigateToCDSCheck(selenium);
				waitForPageLoad(selenium);
				}
				//--------------------------------------------------------------------//
				//  Step-6: Verify CDS Alerts//
				//--------------------------------------------------------------------//
				
				if(!verifyCDSAlert(selenium,cdsData,cdsData1,patId)){
				Assert.fail("CDS alert is not displayed as expected: More Details :"+ cdsData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCDSAlert(Selenium selenium,ChartPreVisitLib cdsData,ChartPreVisitLib cdsData1, String patId) throws IOException{
		boolean returnValue=true;
		
		click(selenium,btnBack);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium,txtsearchbox,patId),"Could not type patient id", selenium, ClassName, MethodName);
		selenium.keyPress(txtsearchbox, "\\13");
		waitForElement(selenium,lblsearchResult,10000);
		assertTrue(selenium.isElementPresent(lblsearchResult),"Search Results are not displayed for the patient with ID :-"+cdsData.patientId, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblsearchResult).contains(patId),"", selenium, ClassName, MethodName);
		click(selenium,lblsearchResult);
		waitForPageLoad(selenium);
		
		if(cdsData1.testCaseId.equals("TC_CV_013")){	
			assertTrue(isElementPresent(selenium,lblpatientname),"Patient Name not present", selenium, ClassName, MethodName);
		}
		if(cdsData.testCaseId.equals("TC_CPL_012")){	
			if(!getText(selenium,lblcdsAlert).contains("Blood Pressure Measurement:")){
			returnValue=true;
			}
		}
		else{	
			assertTrue(isElementPresent(selenium,lblcdsAlert),"cds alert not present", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
