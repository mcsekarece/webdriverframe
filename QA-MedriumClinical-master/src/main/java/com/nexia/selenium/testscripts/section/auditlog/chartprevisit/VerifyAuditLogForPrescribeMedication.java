package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForPrescribeMedication extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void prescribeMedicationWithFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib prescribeData = new AuditLogLib();
		prescribeData.workSheetName = "AuditLogForPrescribeMedication";
		prescribeData.testCaseId = "TC_ALPM_001";
		prescribeData.fetchHomeTestData();
		prescibeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void prescribeMedicationWithFreeFormWithRefills(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib prescribeData = new AuditLogLib();
		prescribeData.workSheetName = "AuditLogForPrescribeMedication";
		prescribeData.testCaseId = "TC_ALPM_002";
		prescribeData.fetchHomeTestData();
		prescibeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * prescibeMedication
	 * function to verify audit log on prescribing Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Feb 26, 2012
	 */
	
	public boolean prescibeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, AuditLogLib prescribeData){
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
			Assert.assertTrue(switchRole(selenium,prescribeData.switchRole));
			waitForPageLoad(selenium);
			
			//-------------------------------------------//
			//  Step-3: Advanced search with Patient ID  //
			//-------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToPrescribe(selenium),"Could not click the link");
			waitForPageLoad(selenium);
			//--------------------------------//
			//  Step-4: Delete All Allergies  //
			//--------------------------------//
			selectValueFromAjaxList(selenium,"providerListSuggestBoxsuggestBox",prescribeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"locationListSuggestBoxsuggestBox",prescribeData.location);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"xpath=(//button[@type='button'])[9]"),"Could not click override button"+prescribeData.toString());
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
			String patId="";
			Assert.assertTrue(verifyStoredValuePrescribe(selenium, prescribeData,patId),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether External Providers gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForPrescribeMedication(selenium,prescribeData)){
				Assert.fail("User details not saved properly; More Details :"+ prescribeData.toString());
				returnValue=false;
			}
			int count=1;
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(prescribeData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(prescribeData.section)){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div");
					break;
				}
				count++;
				if(count>20)
					Assert.fail("Program details not found;More details:"+prescribeData.toString());
			}
			waitForPageLoad(selenium);
			int count1=1;
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div").contains(prescribeData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div").contains(prescribeData.section1)){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count1+"]/td/div/span/div");
					break;
				}
				count1++;
				if(count1>20)
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
		if(idGroupData.testCaseId.equals("TC_ALPM_002"))
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