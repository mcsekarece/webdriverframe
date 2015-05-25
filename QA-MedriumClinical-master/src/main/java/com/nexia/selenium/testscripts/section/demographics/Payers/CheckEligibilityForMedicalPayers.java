package com.nexia.selenium.testscripts.section.demographics.Payers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CheckEligibilityForMedicalPayers extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify passed Check Eligibility Status For MedicalPayers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCheckEligibilityPassedForMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CheckEligibility(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Failed Check Eligibility Status For MedicalPayers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCheckEligibilityFailedForMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_004";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CheckEligibility(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Cancel Check Eligibility Status For MedicalPayers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCheckEligibilityCancelForMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_007";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CheckEligibility(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	
	/*************************************************************************************************** 
	* @purpose        CheckEligibilityForMedicalPayers
	* @action 		  Test for Verify Check Eligibility Status For MedicalPayers
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 25, 2013
	***************************************************************************************************/
	public boolean CheckEligibility(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,payerData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectPractice(selenium),"Unable to swith the practice",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_007";
			patientData.fetchChartPreVisitTestData();		
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MMMdd,yyyyHHmm:ss");
		
		    date=dateFormat.format(cal1.getTime());
			patientData.lastName=patientData.lastName+date;
			payerData.patientId = patientData.lastName;
		
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient),"Could not click on Clinical Lists",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6: Check Eligibility //
			//--------------------------------------------------------------------//
			
		/*	assertTrue(click(selenium,vfyPayerDetails),"Could not click the Expand Arrow", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(selectCheckEligibility(selenium,payerData),"Select check Eligibility failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
		
			if(!selenium.isTextPresent("This payer does not support real time eligibility checks ")){
				return false;
			}
			
			assertTrue(click(selenium, ajxEligibilityStatus), "Could not click link Status  ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(payerData.testCaseId.equals("TC_CP_001")){
			assertTrue(click(selenium, ajxPassedStatus), "Could not click link Passed Status  ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium, ajxFailedStatus), "Could not click link Failed Status  ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		
			assertTrue(enterDate(selenium,txtEligibilityCheckDate,date), "Could not enter Check Eligibility Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		    assertTrue(type(selenium,txtComment,payerData.comment), "Could not type the comments", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(payerData.testCaseId.equals("TC_CP_007")){
				assertTrue(click(selenium, btnlnkCancel), "Could not click Cancel  button for  Check Eligibility ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnCheckEligibility), "Could not click button Check Eligibility ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!getValue(selenium,ajxEligibilityStatus).contains("Failed"),"Verify Check Eligibility Cancel For Medical Payers", selenium, ClassName, MethodName);
			    assertTrue(!getText(selenium,txtPayerStartDate).contains(date),"Verify Check Eligibility Cancel For Medical Payers", selenium, ClassName, MethodName);
				assertTrue(!getText(selenium,txtComment).contains(payerData.comment),"Verify Check Eligibility Cancel For Medical Payers", selenium, ClassName, MethodName);
	    		return true;
			}

		    assertTrue(click(selenium,btnlnkSaveEligiblity), "Could not click save button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-7: Verify the Eligibility //
			//--------------------------------------------------------------------//
			
			 assertTrue(verifyCheckEligibility(selenium,payerData,userAccount), "verify Check Eligibility failed", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyCheckEligibility(Selenium selenium, HomeLib payerData,String account) throws IOException{

		String date = null;
		vfyCheckEligibility="//div[@class='visits-list-item-expanded-details-container']";
		
		assertTrue(click(selenium,vfyPayerDetailsExpand),"Could not click the Expand Arrow", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM dd, yyyy");
		  	date=DateFormat1.format(cal.getTime());
		//	assertTrue(getText(selenium,vfyCheckEligibility).contains(date),"Could not get text", selenium, ClassName, MethodName);
	    }else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat1.format(cal.getTime());
				//assertTrue(getText(selenium,vfyCheckEligibility).contains(date),"Could not get text", selenium, ClassName, MethodName);
		}
		assertTrue(getText(selenium,vfyCheckEligibility).contains(payerData.eligibilityStatus),"Could not get text", selenium, ClassName, MethodName);
	   
		if(payerData.testCaseId.equals("TC_CP_001")){
			assertTrue(click(selenium,lnkViewDetailsPassed), "Could not click view details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 assertTrue(selenium.isTextPresent("passed"),"Could not get text Passed failed", selenium, ClassName, MethodName);
		}else{
		assertTrue(click(selenium,lnkViewDetailsFailed), "Could not click view details", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
		// assertTrue(getText(selenium,popupViewDetails2).contains(payerData.payerName),"Could not get text Failed failed", selenium, ClassName, MethodName);
	    assertTrue(selenium.isTextPresent("failed"),"Could not get text Failed failed", selenium, ClassName, MethodName);
		
		}
		return true;
	}

}
