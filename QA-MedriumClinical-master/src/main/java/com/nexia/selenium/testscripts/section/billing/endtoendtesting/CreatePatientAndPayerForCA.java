package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;

import com.thoughtworks.selenium.Selenium;

public class CreatePatientAndPayerForCA extends AbstractHomeTest{
	public String workBookName = "TestData_Home.xls";
	public String sectionName = "home";

	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default" ,"BeforeCreatePatientAndPayerCA"}, description = "Test for Adding a New patient and Medical Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatientDataWith019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_021";
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
	* @useraccount    CA
	* @since  	      Aug 26, 2014
	***************************************************************************************************/
	public boolean createNewPatientWithMandatoryFields (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		boolean returnValue = false;
		Selenium selenium = null;
		String date = null;
		String patientName="Mathewaaz";
		String providerName="ABBY ABRAHAM";

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

			//--------------------------------------------------------------------//
			//  Step-3:Associate Payer to provider								 //
			//--------------------------------------------------------------------//
			assertTrue(associateOHIPPayer(selenium,providerName), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Associate payer to patient									  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,patientName);

			// create First medical payer

			//Patient A
			if(patientData.testCaseId.equals("TC_NPC_021")){
				assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				HomeLib payerData = new HomeLib();
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_037";
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
				else
				{
					waitForPageLoad(selenium);
					returnValue = verifyInactivation(selenium);

				}

			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}




	public boolean verifyInactivation(Selenium selenium)
	{
	          int count=1;
	          boolean result=false;
	      
	    
	          int noOfBtn=(Integer) selenium.getXpathCount("xpath=(//a[contains(text(),'Activate')])[1]");


	          while(noOfBtn>=count)
	          {
	          if(!getText(selenium,"//div[@id='visitListItemDiv"+count+"']").trim().contains("OHIP"))
	          {
	        	  count++;
	          }
	          else
	          {
	        	  click(selenium,"xpath=(//a[contains(text(),'Activate')])"+"["+count+"]");
	              result=true;
	          }
	          }
	          return result;
	     
	}

	public boolean verifyPayerDetails(Selenium selenium,HomeLib payerData) throws IOException{

		assertTrue(selenium.isTextPresent(payerData.payerName), ""	+ "Payer Name Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;

	}

}
