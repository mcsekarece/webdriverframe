package com.nexia.selenium.testscripts.section.chartprevisit.PatientHandOuts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientHandoutWithAssessment extends AbstractChartPreVisit {
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientorderDataWithAssessment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();	
		orderData.workSheetName = "PatientHandouts";
		orderData.testCaseId = "TC_PH_001";
		orderData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		

		verifyHandout(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientorderDataWithEmptyAssessment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();	
		orderData.workSheetName = "PatientHandouts";
		orderData.testCaseId = "TC_PH_002";
		orderData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		

		verifyHandout(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewHamdsOutWithAssessment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();	
		orderData.workSheetName = "PatientHandouts";
		orderData.testCaseId = "TC_PH_003";
		orderData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		

		verifyViewHandout(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	/**
	 * verifyHandout
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 11, 2012
	 */
	public boolean verifyHandout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch the role" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, orderData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing Assessments//
			//--------------------------------------------------------------------//
			assertTrue(deleteAssessment(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create Assessment//
			//--------------------------------------------------------------------//
			
			if(orderData.testCaseId.equals("TC_PH_001") ||orderData.testCaseId.equals("TC_PH_003") ){
				assertTrue(createAssessment(selenium,orderData,userAccount),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate To Patient Handouts//
			//--------------------------------------------------------------------//
			
			selenium.focus(elementPatienHandOutLink);
			selenium.clickAt(elementPatienHandOutLink, "");
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Patient handouts for assessment//
			//--------------------------------------------------------------------//
			if(orderData.testCaseId.equals("TC_PH_001")|| orderData.testCaseId.equals("TC_PH_003")){
				String date=null;
				if(!getText(selenium,elementPatientHandoutAssessmentEntry).toLowerCase(new java.util.Locale("en","Us")).trim().contains(orderData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","Us")))){
				returnValue=false;
				}
					if(userAccount.equals(CAAccount)){
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
						date=DateFormat1.format(cal.getTime());
					}else{
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						date=DateFormat1.format(cal.getTime());
					}
				if(!getText(selenium,elementPatientHandoutAssessmentEntry).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","Us")))){
				returnValue=false;
				}
			}else {
				if(!getText(selenium,elementNoAssessmentLabel).toLowerCase(new java.util.Locale("en","Us")).trim().contains("No problem list added".trim().toLowerCase(new java.util.Locale("en","Us")))){
					returnValue=false;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * verifyViewHandout
	 * function verifyViewHandout
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Jan 02, 2013
	 */
	public boolean verifyViewHandout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch the role" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib patientData = new ChartPreVisitLib();	
			
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium,"patientID");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing Assessments//
			//--------------------------------------------------------------------//
			assertTrue(deleteAssessment(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create Assessment//
			//--------------------------------------------------------------------//
			assertTrue(createAssessment(selenium,orderData,userAccount),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate To Patient Handouts//
			//--------------------------------------------------------------------//
			selenium.focus(elementPatienHandOutLink);
			selenium.clickAt(elementPatienHandOutLink, "");
			//assertTrue(click(selenium,elementPatienHandOutLink ), "Could not click on patient handouts link");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: click on Patient Handout link //
			//--------------------------------------------------------------------//
			//div[2]/div/div/div/div/div/span/span
			while(getText(selenium,lblHandsMedicalCondition).toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
				if(getText(selenium,lblHandsMedicalCondition).toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","US")))){
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkViewHandout),"", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					break;
				}
			}
			Thread.sleep(10000);
			
			String st1[]=selenium.getAllWindowNames();
			
			Thread.sleep(10000);
			switchto(st1[1]);
			Thread.sleep(10000);
			selenium.selectWindow(st1[1]);
			Thread.sleep(10000);
			selenium.windowFocus();
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkDurgs)){
				returnValue=true;
			}else
				returnValue=false;
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	private void switchto(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
