package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEditPrescribeMedication extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying audit log of created free form medications")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib prescribeData = new AuditLogLib();
		prescribeData.workSheetName = "NewPatientCheckIn";
		prescribeData.testCaseId = "TC_NP_001";
		prescribeData.fetchHomeTestData();
		editMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying audit log of created free form medications with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithFreeFormWithRefills(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib prescribeData = new AuditLogLib();
		prescribeData.workSheetName = "NewPatientCheckIn";
		prescribeData.testCaseId = "TC_NP_002";
		prescribeData.fetchHomeTestData();
		editMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * editMedication
	 * function to verify audit log on editing prescribing Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Feb 27, 2012
	 */
	
	public boolean editMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, AuditLogLib prescribeData){
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ");
			
			//---------------------------//
			// Step-2:Change Switch Role //
			//---------------------------//
			Assert.assertTrue(switchRole(selenium,prescribeData.role));
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium, "link=Quick actions"), "Could not click on Quick actions link");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, "css=span.actionItemSpan"), "Could not select Register Patient");
			waitForPageLoad(selenium);
			Assert.assertTrue(createNewPatientWithMandatory(selenium,prescribeData),"Patient Checkin Failed");
			waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToPrescribe(selenium),"Could not click the link");
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			if(prescribeData.testCaseId.equals("TC_NP_001"))
			{
				prescribeData.workSheetName = "AuditLogForPrescribeMedication";
				prescribeData.testCaseId = "TC_ALPM_001";
				prescribeData.fetchHomeTestData();
			}else if(prescribeData.testCaseId.equals("TC_NP_002"))
			{
				prescribeData.workSheetName = "AuditLogForPrescribeMedication";
				prescribeData.testCaseId = "TC_ALPM_002";
				prescribeData.fetchHomeTestData();
			}
			//--------------------------------//
			//  Step-4: Delete All Allergies  //
			//--------------------------------//
			selectValueFromAjaxList(selenium,"providerListSuggestBoxsuggestBox",prescribeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"locationListSuggestBoxsuggestBox",prescribeData.location);
			waitForPageLoad(selenium);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			Assert.assertTrue(click(selenium,"xpath=(//button[@type='button'])[6]"),"Could not click override button"+prescribeData.toString());
			waitForPageLoad(selenium);
			
			//-----------------------//
			//  Step-5: Add prescribe medication  //
			//-----------------------//
			Assert.assertTrue(addPrescribeMedication(selenium,prescribeData),"Creation Failed");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"edit")){
				returnValue=true;
			}else
				returnValue=false;
			click(selenium,"print");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,lnkMedicationTab),"Could not click medications tab button"+prescribeData.toString());
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"suggestBox","Current");
			waitForPageLoad(selenium);
			int count=(Integer)selenium.getXpathCount("//span/div/div");
			int counter=2;
			if(getText(selenium,"//span/div/div/span").contains(prescribeData.prescribeName)){
				selenium.focus("//td/div/div[2]/table/tbody/tr/td[2]/div/div");;
				selenium.clickAt("//td/div/div[2]/table/tbody/tr/td[2]/div/div", "");
				//Assert.assertTrue(click(selenium,"//td/div/div[2]/table/tbody/tr/td[2]/div/div"),"Could not click options button");
				Assert.assertTrue(click(selenium,"//body/div[4]/div/div/div[2]"),"Could not click Edit button ");
			}
			else{
				while(count>=counter){
					if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
						selenium.focus("//td/div/div[2]/table/tbody//tr["+counter+"]/td[2]/div/div");
						selenium.clickAt("//td/div/div[2]/table/tbody//tr["+counter+"]/td[2]/div/div", "");
						
						//Assert.assertTrue(click(selenium,"//td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div"),"Could not click the options button");
						Assert.assertTrue(click(selenium,"//body/div[4]/div/div/div[2]"),"Could not click the Edit button");
						break;
					}
					counter++;
				}
			}
			if(prescribeData.testCaseId.equals("TC_ALPM_001"))
			{
				prescribeData.workSheetName = "AuditLogForPrescribeMedication";
				prescribeData.testCaseId = "TC_ALPM_003";
				prescribeData.fetchHomeTestData();
			}else if(prescribeData.testCaseId.equals("TC_ALPM_002"))
			{
				prescribeData.workSheetName = "AuditLogForPrescribeMedication";
				prescribeData.testCaseId = "TC_ALPM_004";
				prescribeData.fetchHomeTestData();
			}
			Assert.assertTrue(addPrescribeMedication(selenium,prescribeData),"Editing Failed");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,"edit")){
				returnValue=true;
			}else
				returnValue=false;
			Assert.assertTrue(click(selenium,"print"),"Could not click the print button;More Deatils:"+prescribeData.toString());
			if(selenium.isAlertPresent())
			selenium.chooseCancelOnNextConfirmation();
			waitForPageLoad(selenium);
			//-----------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-7: Verify Audit log for External Providers //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, prescribeData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValuePrescribe(selenium, prescribeData,patId),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether External Providers gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForPrescribeMedication(selenium,prescribeData)){
				Assert.fail("User details not saved properly; More Details :"+ prescribeData.toString());
				returnValue=false;
			}
			int count1=1;
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div").contains(prescribeData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div").contains(prescribeData.section)){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div");
					break;
				}
				count1++;
				if(count1>20)
					Assert.fail("Program details not found;More details:"+prescribeData.toString());
			}
			waitForPageLoad(selenium);
			int count2=1;
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count2+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count2+"]/td/div/span/div").contains(prescribeData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count2+"]/td/div/span/div").contains(prescribeData.section1)){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count2+"]/td/div/span/div");
					break;
				}
				count2++;
				if(count2>20)
					Assert.fail("Program details not found;More details:"+prescribeData.toString());
			}
			
			if(!verifyStoredValuesForPatientPrescription(selenium,prescribeData)){
				Assert.fail("User details not saved properly; More Details :"+ prescribeData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString());
		} 
		return returnValue;
		
	}
	private boolean verifyStoredValuesForPrescribeMedication(Selenium selenium,AuditLogLib idGroupData) {

		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(systemDate.trim())){
			return false; 
		} 
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.filter.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillMethod.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillQuantity.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.unit.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.duration.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.frequency.trim())){
			return false;
		}
	
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.usage.trim())){
			return false;
		}
		return true;
	}
	private boolean verifyStoredValuesForPatientPrescription(Selenium selenium,AuditLogLib idGroupData) {

		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(systemDate.trim())){
			return false; 
		} 
		if(!getText(selenium,"//div[2]/div/div[4]/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.userName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillMethod.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillQuantity.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.unit.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.duration.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.frequency.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.usage.trim())){
			return false;
		}
		if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.notesToPharmacy.trim())){
			return false;
		}
		if(idGroupData.testCaseId.equals("TC_ALPM_004"))
		{
			/*if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.refillUsage1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillMethod.trim())){
				return false;
			}
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillQuantity.trim())){
				return false;
			}
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillUnit.trim())){
				return false;
			}
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillRoute.trim())){
				return false;
			}
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillFrequency.trim())){
				return false;
			}
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.refillduration.trim())){
				return false;
			}
			if(!getText(selenium,"//div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[4]/div[2]").trim().contains(idGroupData.usage.trim())){
				return false;
			}
		}
		return true;
	}
}
