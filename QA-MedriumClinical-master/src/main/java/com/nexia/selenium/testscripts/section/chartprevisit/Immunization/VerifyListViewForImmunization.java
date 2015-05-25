package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListViewForImmunization extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify List View For Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyListViewForImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_045";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyListView(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * verifyListView
	 * function to verify List View
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 01, 2012
	 */
	
	public boolean verifyListView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		String time=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,immunizationData)," Could not delete all encounters", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Immunization//
			//--------------------------------------------------------------------//
			 
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			 
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			assertTrue(verifyCollapseViewForImmunization(selenium,immunizationData,userAccount),"Could not find the details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Expand View View//
			//--------------------------------------------------------------------//
			assertTrue(verifyExpandViewForImmunization(selenium,immunizationData,userAccount),"Could not find the details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-8: Verify time stamp//
			//--------------------------------------------------------------------//
			System.out.println(getText(selenium,lblImmExpendTime));
			System.out.println(date);
			//assertTrue(verifyTimeStampForProviderPage(selenium, lblImmExpendTime, date, time), "Time stamp is not displayed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCollapseView(Selenium selenium,ChartPreVisitLib immunizationData) throws IOException{
			
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(immunizationData.vaccine.toUpperCase()), " "+ "immunization vaccine Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selenium.isTextPresent(immunizationData.reaction), " "+ "immunization reaction Not Present", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(immunizationData.comment), " "+ "immunization comment Not Present", selenium, ClassName,	MethodName);
		
	return true;	
	}
	
	
}
