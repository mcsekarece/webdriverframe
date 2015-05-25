package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.sharedlibrary.ReadFromExcel;
import com.thoughtworks.selenium.Selenium;

public class CreateNewPatientAndPayerFourthFlow extends AbstractHomeTest{
	public String workBookName = "TestData_Home.xls";		
	public String sectionName = "home";

	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default","BeforeCreatePatientAndPayerFourth" }, description = "Test for Adding a New patient and Medical Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatientDataWith022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_023";
		PatientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewPatientWithMandatoryFields(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify create a New Patient entry With Mantory Fileds
	* @action 		  verifying create a New Patient entry With Mantory Fileds
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean createNewPatientWithMandatoryFields (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		boolean returnValue = false;
		Selenium selenium = null;
		String date = null;
		int columPossition = 5;
		int rowPossition;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Create New Patient
			createNewPatient(selenium,patientData);				
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Create three medical payer and one other payer			//
			//--------------------------------------------------------------------//
			
			
			ReadFromExcel wD = new ReadFromExcel();
			
			
			// create First medical payer
			
			//Patient A
			
				assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				HomeLib payerData = new HomeLib();
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_033";
				rowPossition = 33;
				wD.writeDataToExcel(sectionName, workBookName,payerData.workSheetName, rowPossition, columPossition, patientData.lastName);
				payerData.fetchHomeTestData();
		
			
			
			
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				  	cal.add(Calendar.DATE,-2);
					date = DateFormat1.format(cal.getTime());
			    }else {
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						cal.add(Calendar.DATE,-2);
						date = DateFormat1.format(cal.getTime());
				}
			
			
			
				if(!selenium.isTextPresent(payerData.payerName)){
					assertTrue(createEndToEndPayerList(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(!verifyPayerDetails(selenium,payerData )){
						Assert.fail("Payer Details are not saved Properly");
					}else
						returnValue = true;
				}
				
				//Create second Medical Payer
				HomeLib payerData2 = new HomeLib();
				payerData2.workSheetName = "AddPayers";
				payerData2.testCaseId = "TC_CP_034";
				rowPossition = 34;
				wD.writeDataToExcel(sectionName, workBookName,payerData.workSheetName, rowPossition, columPossition, patientData.lastName);
				
				payerData2.fetchHomeTestData();

				if(!selenium.isTextPresent(payerData2.payerName)){
					assertTrue(createEndToEndPayerList(selenium,payerData2,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(!verifyPayerDetails(selenium,payerData2 )){
						Assert.fail("Payer Details are not saved Properly");
					}else
						returnValue = true;
				}
			
			
			
			
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyPayerDetails(Selenium selenium,HomeLib payerData) throws IOException{
		
		assertTrue(selenium.isTextPresent(payerData.payerName), ""	+ "Payer Name Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
		
	}
	
	
	/**
	 * createNewPatient
	 * function to create a New Patient entry
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     Jan 17, 2013
	 */	
	
	
	public boolean createNewPatient(Selenium selenium, HomeLib patientData) throws Exception{
	
		boolean returnValue = false;
		
		try{				
											
			//--------------------------------------------------------------------//
			//---------------  Step-3: Navigate to system setting   --------------//
			//--------------------------------------------------------------------//	

							
			assertTrue(click(selenium, txtSearchPatientBox),"", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium),"",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-5: Click New Patient Check-in   --------------//
			//--------------------------------------------------------------------//
			
	
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//assertTrue(createPatient(selenium,patientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//assertTrue(goEncounter(selenium),"Could not click the link", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}

	
}
