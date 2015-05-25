package com.nexia.selenium.testscripts.section.demographics.Payers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditPatientDetails extends AbstractHomeTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit PatientDetails Medical Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditPatientDetailsMedicalPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_012";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit PatientDetails Other Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditPatientDetailsOtherPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_013";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To Verify Edited Patient Details Medical And Other Payers
	* @action 		  Edit Medical And Other Payers
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct  17, 2013
	***************************************************************************************************/
	
	public boolean editPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws Exception{
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
			
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNewPatientRegistration(selenium),"unable to navigate to patient registration page",selenium,ClassName,MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			assertTrue(createPatientMandatory(selenium,patientData),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientID=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			if(payerData.testCaseId.equals("TC_CP_012")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 
				assertTrue(click(selenium,btnAddNew),"Could not click on addnew Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}
			if(payerData.testCaseId.equals("TC_CP_013")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllOtherPayers(selenium),"Unable to delete the payers",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddNewOtherPayer),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(addNewOtherPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit Payers //
			//--------------------------------------------------------------------//
			if(payerData.testCaseId.equals("TC_CP_013")){
				assertTrue(click(selenium,btnEditOther), "Could not click Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else
			{
				assertTrue(click(selenium,btnEditMedicalPayer),"unable to click the edit button of medical payer",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			HomeLib payerEditData = new HomeLib();
			payerEditData.workSheetName = "PatientData";
			payerEditData.testCaseId = "TC_NPC_015";
			payerEditData.fetchHomeTestData();
			assertTrue(editPatientDetails(selenium,payerEditData,date),"Edit Relation  Patient Details failed" ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:verify Edited Values in PatientInfo //
			//--------------------------------------------------------------------//
			 
			assertTrue(click(selenium,lnkPatientInfoView), "Could not click lnk Patient Info View", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyEditedValuesinPatientInfo(selenium,payerEditData,date),"Verify Edited Values in PatientInfo failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
    	
	public boolean editPatientDetails(Selenium selenium, HomeLib payerData,String date) throws IOException {
		/*if(payerData.testCaseId.equals("TC_CP_012"))
		{
    	 assertTrue(type(selenium,txtRelationLastName,payerData.lastName),"Could not type  last name"+ payerData.toString(), selenium, ClassName, MethodName);
    	 assertTrue(type(selenium,txtRelationAddr1,payerData.residentialAddrcity),"Could not type Relation Addr one"+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtRelationAddr2,payerData.residentialAddrcity1),"Could not type Relation Address two "+ payerData.toString(), selenium, ClassName, MethodName);
       	 assertTrue(click(selenium, btnlnkSave), "Could not click Save button", selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		 click(selenium,btnOK);
		}*/
		/*if(payerData.testCaseId.equals("TC_CP_013"))
		{*/
		assertTrue(type(selenium,txtRelationLastName,payerData.lastName),"Could not type  last name"+ payerData.toString(), selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtRelationAddr1,payerData.residentialAddrcity),"Could not type Relation Addr one"+ payerData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtRelationAddr2,payerData.residentialAddrcity1),"Could not type Relation Address two "+ payerData.toString(), selenium, ClassName, MethodName);
	    assertTrue(click(selenium, btnlnkSave), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium,btnOK);
		/*}*/
		
	     return true;
   }		
	
    public boolean verifyEditedValuesinPatientInfo(Selenium selenium, HomeLib payerEditData,String date)throws IOException {
		 waitForPageLoad(selenium);
    	try{
    	
    	assertTrue(isTextPresent(selenium,payerEditData.lastName.trim()),"Verification failed", selenium, ClassName, MethodName);
    	assertTrue(isTextPresent(selenium,payerEditData.residentialAddrcity.trim()),"Verification failed", selenium, ClassName, MethodName);
    	assertTrue(isTextPresent(selenium,payerEditData.residentialAddrcity.trim()),"Verification failed", selenium, ClassName, MethodName);

      	}
        catch(Exception e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return true;
    }
}
