package com.nexia.selenium.genericlibrary.smoketest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class AbstractSmokeTest extends AbstractChartPreVisit {
	
	public String imghelp="helpIcon";
	public String txtAftyear4="xpath=(//input[@type='text'])[79]";
	
	public String lblPopup="css=div.popupContent";
	public String lnkAboutNexia="link=About NightingaleEHR";
	public String lnkSystemSetting="systemSettingsAction";
	public String lnkOrgStructures="!adminOrgStructureLists";
	public String lnkDeleteUser = "//a[starts-with(@id,'DeleteUserSMOKE')]";
	public String btnClose="css=a.close-x";
	public String btnSearch="xpath=(//button[@type='button'])[10]";
	public String lbldescription="description";
	public String btnCancel="cancelButton";
	public String txtSearchBox="searchTextBoxUserView";
	public String txtProviderSearchBox="searchTextBoxProviderView";
	public String btnProviderSearch="searchButtonProviderView";
	public String lnkProviderListFirst="xpath=(//div[contains(@id,'providerListItemMainContent')])[1]";
	public String txtUserSearch="searchTextBoxUserView";
	public String btnUserSearch="searchButtonUserView";
	public String txtLastname="lastName";
	public String txtFirstname="firstName";
	public String txtUsername="userName";
	public String txtMaxmum="maximumFTESuggestBoxsuggestBox";
	public String txtCredentials="credentials";
	public String lnkLabReport="!chartLabReportsFlowSheet";
	public String btnAddForMatchAll="clinicalPatientListDoNotIncludeAddNew";
	public String btnAddNewCriteria="xpath=(//button[@type='button'])[4]";
	public String btnAddNewCriteria1="clinicalPatientListMatchOneAddNew";
	public String lnkNewSearch ="clinicalPatientListMatchAllAddNew";
	public String ajxPblmDiag1="xpath=(//input[@id='problemListSuggestBoxsuggestBox'])[3]";
	public String ajxSex1CondtionForMatchAll="xpath=(//input[@id='sexConditionSuggestBoxsuggestBox'])[2]";
	public String ajxTimeCondtion="xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[3]";
	
	public String ajxProvider = "providerListSuggestBoxsuggestBox";
	public String ajxTitle="titlesuggestBox";
	public String ajxExternalemr="externalEmrsuggestBox";
	public String ajxUserRole="userRolesuggestBox";
	
	
	 public String btnPracticeName ="practiceName";
	 public String btnTaxId ="taxId";
	 public String txtAddr1   = "addr1";
	 public String txtBoxPractice   = "practiceSuggestBox1-1suggestBox";
	 public String txtAddr2 ="addr2";
	 public String txtCity =  "city";
	 public String ajxStateSuggestBoxSuggestBox =  "stateSuggestBoxsuggestBox";
	 public String ajxPracticeType = "practiceTypeSuggestBoxsuggestBox";
	 public String txtZip =  "zip";
	 public String ajxStateCountryBoxSuggestBox =  "countrySuggestBoxsuggestBox";
	 public String btnDonePratice= "xpath=(//button[@type='button'])[3]";
	 
	 public String txtProvider = "searchTextBoxProviderView";	 
	 public String btnSearchProvider = "xpath=(//button[@type='button'])[8]";
	 public String vfyDeleteProvider ="//td[2]/div/div/div/div[4]/div/div";
	 
	public String btnSearchClinicalList = "css=button.secondary-button";
	 
	 
	 
	/**
	 * goToNewPatientCheckIn
	 * function to navigate to new patient check in page
	 * @since  	     Feb 08, 2012
	 */	
	 public boolean goToNewPatientCheckIn(Selenium selenium) {
         if(waitForElement(selenium, "newPatientCheckIn", WAIT_TIME*2)){
        	 click(selenium, "newPatientCheckIn");
        	 waitForPageLoad(selenium);
         }
         return waitForElement(selenium, "chartNumber", WAIT_TIME);
	 }
	 
	 /**
		 * orderNewReferral
		 * Function to order New Di
	 * @throws IOException 
		 * @since	Nov 15, 2012
		 */
		public boolean orderNewReferral_smoke(Selenium selenium, ChartPreVisitLib orderData) {
			try{
				
				/*Assert.assertTrue(click(selenium,"labTestNameSuggestBox" ), "Could not click on test name suggest box");
				Assert.assertTrue(type(selenium,"labTestNameSuggestBox", orderData.labTestName), "Could not click on test name suggest box");
				waitForPageLoad(selenium);*/
				
				if(orderData.testCaseId.equals("TC_OR_004")){
					assertTrue(click(selenium,"referPatientSaveButton"), "Could not click on save button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(getText(selenium,"css=div.large.dark").toLowerCase(new java.util.Locale("en","US")).trim().contains("You need to select one test at least for saving the report!".trim().toLowerCase(new java.util.Locale("en","US")))){
						return true;
					}
					else return false;
				}
				if(orderData.testCaseId.equals("TC_OR_003")){
					waitForPageLoad(selenium);
					assertTrue(selectValueFromAjaxList(selenium, "referralSearchBox",orderData.referral), "Could not click on save button",selenium, ClassName, MethodName);
					//Assert.assertTrue(type(selenium,"referralSearchBox",orderData.referral1));
					//selenium.keyPress("referralSearchBox", "\\13");
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,"referPatientSaveButton"), "Could not click on save button",selenium, ClassName, MethodName);
					return true;
				}
				
				//waitForPageLoad(selenium);
				//selectValueFromAjaxList(selenium, "referralSearchBox",orderData.referral);
				//Assert.assertTrue(type(selenium,"referralSearchBox",orderData.referral1));
				//selenium.keyPress("referralSearchBox", "\\13");
				waitForPageLoad(selenium);
				
			assertTrue(type(selenium, "referralNoteText", orderData.referralNoteText), "Could not type referral Notes",selenium, ClassName, MethodName);
				assertTrue(type(selenium, "referralAuthCodeText", orderData.authorization), "Could not type comments",selenium, ClassName, MethodName);
				if(orderData.testCaseId.equals("TC_OR_005")){
			assertTrue(click(selenium,"referPatientSign"), "Could not click on sign button",selenium, ClassName, MethodName);
					return true;
				}
		assertTrue(click(selenium,"referPatientSaveButton"), "Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			catch(RuntimeException e){
				Assert.fail("Failed due to the Exception; \n Exception details: "+e.getMessage());
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;


		}
		
		
		public boolean deleteAllPendingMedication_smoke(Selenium selenium) throws IOException{
			boolean medDeleted=true;
			int medCount=0;
			
			
			
			try{
				/*assertTrue(click(selenium, lnkMore),"Could not click on More link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
				assertTrue(selenium.isVisible(lnkMedicationTab1),"link is not visible",selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,lnkMedicationTab1),"Could not click the encounter tab", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxRxShow, "pending");
				waitForPageLoad(selenium);
	
				waitForElement(selenium,lnkOption, WAIT_TIME);
				waitForPageLoad(selenium);
				//selectValueFromAjaxList(selenium, ajxRxShow, prescribeData.show);
				
				while((Integer) selenium.getXpathCount(lnkOption) > 0&& selenium.isTextPresent("Pending Sign Off")){
					
						medCount=(Integer) selenium.getXpathCount(lnkOption);
						
						click(selenium,lnkOption);
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						click(selenium,lnkDelete);
						waitForPageLoad(selenium);
						type(selenium,txtDeleteReaseon , "nothing");						
						click(selenium,btnContinue);
						waitForPageLoad(selenium);
						if(medCount == (Integer) selenium.getXpathCount(lnkOption)){
							medDeleted = false;
							break;
					}
						waitForPageLoad(selenium);
				}
				
			}catch(RuntimeException e){
				e.printStackTrace();
			}
			return medDeleted;
		}
	 
		/**
		 * navigateTofileReport
		 * function to navigate To file Report
		 * @throws IOException 
		 * @since  	    Dec 07, 2012
		 */	
		public boolean navigateTofileReport(Selenium selenium, SmokeTestLib labData) throws IOException{
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on error",selenium, ClassName, MethodName);
			try {
				assertTrue(click(selenium,lnkPatientOption ), "Could not click on patient options link",selenium, ClassName, MethodName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				assertTrue(click(selenium,lnkLabReportLink ), "Could not click on file new report link",selenium, ClassName, MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		
		
		/**
		 * fileReportWithMandatory
		 * function to file Report With Mandatory
		 * @throws  
		 * @since  	    Dec 07, 2012
		 */	
		public boolean fileReportWithMandatory(Selenium selenium, SmokeTestLib labData) {
		
			try {
				assertTrue(click(selenium,lnkEnterData),"Could not find enter data link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRProvider, labData.rProvider);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxOProvider, labData.oProvider);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLabName, labData.labName);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,elementCdate,labData.cDate),"Could not enter the collrction Date;More Details:"+labData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementCtime, labData.cTime), "Could not type time",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxLabTestName, labData.testName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,elementResult, labData.result), "Could not type results",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave2),"Could not find save button",selenium, ClassName, MethodName);
				
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
			
		}
		
		/**
		 * deletelabReport
		 * function to delete lab report
		 * @since  	    Dec 07, 2012
		 */	
		public boolean deletelabReport_smoke(Selenium selenium, SmokeTestLib labData){
		try {
			/*assertTrue(click(selenium, lnkMore),
					"Could not click on More  link",selenium, ClassName, MethodName);*/
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabs),
					"Could not click on Lab Report link link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabListView),
					"Could not click the List view",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (selenium.isConfirmationPresent()) {
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
				//Assert.assertTrue(click(selenium, lnkLabReport), "Could not click on patient options link");
				//waitForPageLoad(selenium);
				while(isElementPresent(selenium,lnkActionsLink)){
					int count=1;
					click(selenium,lnkActionsLink);
					click(selenium,btnDeleteLab);
					assertTrue(type(selenium,txtdeleteReason,"Reason"), "Could not type reason",selenium, ClassName, MethodName);
					click(selenium,btnDeleteReason);
					waitForPageLoad(selenium);
					 if(isElementPresent(selenium, "errorCloseButton"))
							assertTrue(click(selenium, "errorCloseButton"),"Could not click on error",selenium, ClassName, MethodName);
					count++;
					if(count>15){
						break;
					}
				}
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
			
		}
		
		
	 
		/**
         * searchPatientNexiaForProviderHomePage
         * function for Searching a patient in the Nexia application   
          * @param            selenium
         * @param            patientID (Patient ID to be searched)
         
          * @since         Sep 29, 2012
         */
         public boolean searchPatientNexiaForProviderHomePage_smoke(Selenium selenium,String patientID){
   try {
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
	assertTrue(type(selenium,"searchPatientBox",patientID),"Could not type patient id",selenium, ClassName, MethodName);

    selenium.clickAt("searchPatientBox","");
    selenium.focus("searchPatientBox");                    
    selenium.fireEvent("searchPatientBox","keypress");                   
    
    //selenium.keyPress("searchPatientBox", "\\9");
    waitForElement(selenium,"id=patientInfoWidget",10000);
    assertTrue(selenium.isElementPresent("id=patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+patientID,selenium, ClassName, MethodName);
    //Assert.assertTrue(getText(selenium,"css=div.patientItem.borderBottom").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))));
    assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", selenium, ClassName,MethodName);
    click(selenium,"id=patientInfoWidget");
    waitForPageLoad(selenium);
    assertTrue(isElementPresent(selenium,"patientName"),"The searched patient information could not be loaded",selenium, ClassName, MethodName);       
    if(selenium.isConfirmationPresent()){
          System.out.println(selenium.getConfirmation());
          selenium.chooseOkOnNextConfirmation();
    }
    if(isElementPresent(selenium, "errorCloseButton"))
          assertTrue(click(selenium, "errorCloseButton"),"Could not click on error",selenium, ClassName, MethodName);
    /*click(selenium,"link=Full Details");
    waitForPageLoad(selenium);
    Assert.assertTrue(isElementPresent(selenium,"link=Full Details"),"The searched patient information could not be loaded");*/

  
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return true;
         
         }

		
	 
		public boolean createNewUser_smoke(Selenium selenium,SystemSettingsLib userData,String uniqueName){
			try{
				assertTrue(click(selenium,"addUser"),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtFirstname,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"userName",userData.userName1+uniqueName),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
				
				selectValueFromAjaxList(selenium,"suggestBox",userData.UserProvider);
				//Assert.assertTrue(type(selenium,"suggestBox",userData.UserProvider),"Could not type a Provider" + userData .toString());
				assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxExternalemr,userData.externalEmr);
				assertTrue(type(selenium,"password",userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"confirmPassword",userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"roleSuggestBox1suggestBox",userData.userRole);
				selectValueFromAjaxList(selenium,txtBoxPractice,userData.practise);
				click(selenium,"//div[3]/div/div/div/div/div");
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveRecallReason),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnEdit)){
					return true;
				}
				else{
					return false;
				}
				
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		
		/**
		 * createProviderWithMandatory
		 * function to create Provider With Mandatory
		 * @since  	     June 06, 2012
		 */	

		public boolean createProviderWithMandatory(Selenium selenium,SystemSettingsLib providerData, String userAccount ){
			try{
				selectValueFromAjaxList(selenium,"providerTypesuggestBox",providerData.providerType);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtFirstname,providerData.firstName),"Could not enter the  name"+ providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"maximumFTESuggestBoxsuggestBox",providerData.maximumFte);
				waitForPageLoad(selenium);
				
				
				if(!userAccount.equalsIgnoreCase(CAAccount)){
					
					if(providerData.billingInfoCheck.equals("Yes")){
						assertTrue(click(selenium,"signatureOnFilecheckbox"),"Could not click the signature file check box;More details:"+providerData.toString(),selenium, ClassName, MethodName);
						assertTrue(enterDate(selenium,"signatureDate",providerData.signatureDate),"Could not enter date; More Details:"+providerData.toString(),selenium, ClassName, MethodName);
					}
					if(providerData.billingInfoCheck.equals("No")){
						assertTrue(click(selenium,"signatureOnFilecheckbox"),"Could not click the signature file check box;More details:"+providerData.toString(),selenium, ClassName, MethodName);
						assertTrue(enterDate(selenium,"signatureDate",providerData.signatureDate),"Could not enter date; More Details:"+providerData.toString(),selenium, ClassName, MethodName);
					}					
			    }
				
				
				assertTrue(click(selenium,btnSaveRecallReason),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
				return true;
				/*if(isElementPresent(selenium,"//div[4]/div/div/div/div[2]/div/div/div/input")){
					return true;
				}
				else
				{
					return false;
				}*/
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * deleteProvider
		 * function to navigate to Add provider page
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    August 17, 2012
		 */	
		public boolean deleteProvider(Selenium selenium,SystemSettingsLib providerData){
			boolean returnValue=true;
			try{
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				String departCount=getText(selenium, "//div[4]/div/div/div/div/span/span");
				System.out.println(departCount);
				
		        String splitStr1 = departCount.replaceAll("[()]","");
		        waitForPageLoad(selenium);
		        int departmentCount = Integer.parseInt(splitStr1);
				int counter = 1;
				
				if(departmentCount<=10){
					while(getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]").contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div".toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.toLowerCase(new java.util.Locale("en","US")))){
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							
						}else{
							counter++;
						}
					}
					
				}else{
					
					assertTrue(type(selenium,txtProvider,providerData.firstName),"Could not enter the department name",selenium, ClassName, MethodName);
					assertTrue(click(selenium, btnSearchProvider),"Could not click the search button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					System.out.println(getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]".toLowerCase(new java.util.Locale("en","US"))));
					System.out.println(providerData.firstName.trim());
					while((getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]").toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						if((getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div").toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.toLowerCase(new java.util.Locale("en","US")))){
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							
						}
						//counter++;	
					}
					
				}
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returnValue;
		}
		
		/**
		 * deleteProvider (WebDriver)
		 * function to navigate to Add provider page
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    September 15, 2014
		 */	
		public boolean deleteProvider(WebDriver driver,SystemSettingsLib providerData){
			boolean returnValue=true;
			try{
				
				String proCount=driver.findElement(By.id("providerCount")).getText();
						
				System.out.println(proCount);
				
		        String splitStr1 = proCount.replaceAll("[()]","");
		        
		        int ProviderCount = Integer.parseInt(splitStr1);
				int counter = 1;
				
				/*if(ProviderCount<=10){
					while(getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]").contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
						if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div".toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.toLowerCase(new java.util.Locale("en","US")))){
							
							assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
				
							
						}else{
							counter++;
						}
					}
					
				}else{
					
					assertTrue(type(selenium,txtProvider,providerData.firstName),"Could not enter the department name",selenium, ClassName, MethodName);
					assertTrue(click(selenium, btnSearchProvider),"Could not click the search button",selenium, ClassName, MethodName);
				
					System.out.println(getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]".toLowerCase(new java.util.Locale("en","US"))));
					System.out.println(providerData.firstName.trim());
					while((getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]").toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
						
						if((getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div").toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.toLowerCase(new java.util.Locale("en","US")))){
					
							assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
							
						}
						//counter++;	
					}
					
				}*/
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returnValue;
		}
		
		
		
		/**
		 * deleteProvider
		 * function to navigate to Add provider page
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    August 17, 2012
		 */	
		public boolean deleteUser_smoke(Selenium selenium,SystemSettingsLib userData){
			
			boolean returnValue=true;
			
			try{
				
			if(isElementPresent(selenium,txtSearchBox)){
				
			assertTrue(type(selenium,txtSearchBox,userData.firstName),"Could not type first name;More deatils :"+userData.firstName,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSearch),"Could not click the serach button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int Counter=1;
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,lnkDeleteUser);
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(counter>5)
					break;
				}
			
			}
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return returnValue;
			
	}



		
	 /**
	 * createPatient
	 * function to create a new patient check-in
	 * @since  	     Feb 09, 2012
	 */	
		public boolean createPatient(Selenium selenium, HomeLib patientData){
			boolean returnValue = false;
			try{
				if(!patientData.patientIdchart.isEmpty())
					if(!patientData.patientIdchart.contains("N/A"))
						assertTrue(type(selenium,"chartNumber",patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart ,selenium, ClassName, MethodName);
				if(!patientData.primaryLocation.isEmpty())
					if(!patientData.primaryLocation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "primaryLocationSuggestBoxsuggestBox", patientData.primaryLocation))
							Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
				if(!patientData.responsibleProvider.isEmpty())
					if(!patientData.responsibleProvider.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider))
							Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
				if(!patientData.pcpCheck.isEmpty())
					if(!patientData.pcpCheck.contains("No"))
						assertTrue(check(selenium, "responsibleProvPCPcheckbox"), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck,selenium, ClassName, MethodName);
				
				if(!patientData.lastName.isEmpty())
					if(!patientData.lastName.contains("N/A"))
						assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName,selenium, ClassName, MethodName);
				if(!patientData.firstName.isEmpty())
					if(!patientData.firstName.contains("N/A"))
						assertTrue(type(selenium, txtFirstname, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName,selenium, ClassName, MethodName);
				if(!patientData.middleName.isEmpty())
					if(!patientData.middleName.contains("N/A"))
						assertTrue(type(selenium, "middleName", patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName,selenium, ClassName, MethodName);
				if(!patientData.title.isEmpty())
					if(!patientData.title.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title))	
							Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
				if(!patientData.suffix.isEmpty())
					if(!patientData.suffix.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix))
							Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
				if(!patientData.alias1.isEmpty())
					if(!patientData.alias1.contains("N/A"))
						assertTrue(type(selenium, "alias1", patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1,selenium, ClassName, MethodName);
				if(!patientData.alias2.isEmpty())
					if(!patientData.alias2.contains("N/A"))
						assertTrue(type(selenium, "alias2", patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2,selenium, ClassName, MethodName);
				if(!patientData.dob.isEmpty())
					if(!patientData.dob.contains("N/A"))
						assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
				click(selenium,"backButton");
				if(!patientData.estimatedCheck.isEmpty())
					if(!patientData.estimatedCheck.contains("No"))
						assertTrue(click(selenium, "dobEstimatedcheckbox"), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck,selenium, ClassName, MethodName);
				if(!patientData.prematureCheck.isEmpty())
					if(!patientData.prematureCheck.contains("No")){
						assertTrue(click(selenium, "prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
						if(!patientData.duration.isEmpty())
							if(!patientData.duration.contains("N/A"))
								assertTrue(type(selenium, "prematureDuration", patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration,selenium, ClassName, MethodName);
						if(!patientData.measure.isEmpty())
							if(!patientData.measure.contains("N/A"))
								if(!selectValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure))
									Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
									waitForPageLoad(selenium);
					}
				if(!patientData.sex.isEmpty())
					if(!patientData.sex.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex))
							Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
							waitForPageLoad(selenium);
				if(!patientData.maritalStatus.isEmpty())
					if(!patientData.maritalStatus.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus))
							Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
				if(!patientData.status.isEmpty())
					if(!patientData.status.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status))
							Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
				if(!patientData.statusDate.isEmpty())
					if(!patientData.statusDate.contains("N/A"))
						assertTrue(enterDate(selenium, "statusDate", patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(),selenium, ClassName, MethodName);
				if(patientData.status.equalsIgnoreCase("inactive"))
					if(!patientData.reasonForInactivation.isEmpty())
						if(!patientData.reasonForInactivation.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation))
								Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
				if(!patientData.residentialAddrStreet1.isEmpty())
					if(!patientData.residentialAddrStreet1.contains("N/A"))
						assertTrue(type(selenium, "residentialAddr1", patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
				if(!patientData.residentialAddrStreet2.isEmpty())
					if(!patientData.residentialAddrStreet2.contains("N/A"))
						assertTrue(type(selenium, "residentialAddr2", patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
				if(!patientData.residentialAddrcity.isEmpty())
					if(!patientData.residentialAddrcity.contains("N/A"))
						assertTrue(type(selenium, "residentialCity", patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity,selenium, ClassName, MethodName);
				if(!patientData.residentialAddrstate.isEmpty())
					if(!patientData.residentialAddrstate.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
				if(!patientData.residentialAddrzipCode.isEmpty())
					if(!patientData.residentialAddrzipCode.contains("N/A"))
						assertTrue(type(selenium, "residentialZip", patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress("commType1SuggestBoxsuggestBox", "\\9");
				click(selenium,btnYes);
				waitForElementToEnable(selenium,"residentialCity");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"residentialStatesuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"residentialCountrysuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"residentialCounty");
				waitForPageLoad(selenium);
				
				if(!patientData.telephoneType1.isEmpty())
					if(!patientData.telephoneType1.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1))
							Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
				if(!patientData.telephoneNo1.isEmpty())
					if(!patientData.telephoneNo1.contains("N/A"))
						assertTrue(type(selenium, "primaryPhone", patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
				if(!patientData.telephoneextnNo1.isEmpty())
					if(!patientData.telephoneextnNo1.contains("N/A"))
						assertTrue(type(selenium, "primaryPhoneExtension", patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
				if(!patientData.telephoneType2.isEmpty())
					if(!patientData.telephoneType2.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2))
							Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
				
				if(!patientData.telephoneNo2.isEmpty())
					if(!patientData.telephoneNo2.contains("N/A"))
						assertTrue(type(selenium, "ohterPhone1", patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2,selenium, ClassName, MethodName);
				if(!patientData.telephoneextnNo2.isEmpty())
					if(!patientData.telephoneextnNo2.contains("N/A"))
						assertTrue(type(selenium, "otherPhone1Extension", patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2,selenium, ClassName, MethodName);
				
				if(!patientData.telephoneType3.isEmpty())
					if(!patientData.telephoneType3.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3))
							Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
				
				if(!patientData.telephoneNo3.isEmpty())
					if(!patientData.telephoneNo3.contains("N/A"))
						assertTrue(type(selenium, "otherPhone2", patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
				if(!patientData.telephoneextnNo3.isEmpty())
					if(!patientData.telephoneextnNo3.contains("N/A"))
						assertTrue(type(selenium, "otherPhone2Extension", patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
				
				if(!patientData.email.isEmpty())
					if(!patientData.email.contains("N/A"))
						assertTrue(type(selenium, "email", patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email,selenium, ClassName, MethodName);
				
				if(!patientData.contactPreferences.isEmpty())
					if(!patientData.contactPreferences.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "//div[7]/div/div/div/div/div/div/input", patientData.contactPreferences))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
				
				if(!patientData.contactPreferences1.isEmpty())
					if(!patientData.contactPreferences1.contains("N/A"))
						assertTrue(click(selenium, "addButtonId"), "Could not click on add more button",selenium, ClassName, MethodName);
						if(!selectValueFromAjaxList(selenium, "//div[7]/div/div/div[2]/div/div/div/input", patientData.contactPreferences1))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences1);
				
				if(!patientData.contactPreferences2.isEmpty())
					if(!patientData.contactPreferences2.contains("N/A"))
						assertTrue(click(selenium, "addButtonId"), "Could not click on add more button",selenium, ClassName, MethodName);
						if(!selectValueFromAjaxList(selenium, "//div[3]/div/div/div/input", patientData.contactPreferences2))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences2);
				
				if(!patientData.contactPreferences4.isEmpty())
					if(!patientData.contactPreferences4.contains("N/A"))
						assertTrue(click(selenium, "addButtonId"), "Could not click on add more button",selenium, ClassName, MethodName);
							if(!selectValueFromAjaxList(selenium, "//div[4]/div/div/div/input", patientData.contactPreferences4))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences4);

				if(!patientData.sameAsResidentialAddressCheck.isEmpty()){
					if(!patientData.sameAsResidentialAddressCheck.contains("No"))
						assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressStreet1.isEmpty())
							if(!patientData.mailingAddressStreet1.contains("N/A"))
								assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
						if(!patientData.mailingAddressStreet2.isEmpty())
							if(!patientData.mailingAddressStreet2.contains("N/A"))
								assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
						if(!patientData.mailingAddressCity.isEmpty())
							if(!patientData.mailingAddressCity.contains("N/A"))
								assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
						if(!patientData.mailingAddressState.isEmpty())
							if(!patientData.mailingAddressState.contains("N/A"))
								selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState);
									
						if(!patientData.mailingAddressZipcode.isEmpty())
							if(!patientData.mailingAddressZipcode.contains("N/A"))
								assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
						waitForPageLoad(selenium);
						selenium.keyPress("comments", "\\9");
						click(selenium,btnYes);
						waitForElementToEnable(selenium,"mailingCity");
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,"mailingStatesuggestBox");
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,"mailingCountrysuggestBox");
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,"mailingCounty");
						waitForPageLoad(selenium);
						
				}
				else{
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
					
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selenium.keyPress("comments", "\\9");
					click(selenium,btnYes);
					waitForElementToEnable(selenium,"mailingCity");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingStatesuggestBox");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingCountrysuggestBox");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingCounty");
					waitForPageLoad(selenium);
			
				}
				if(!patientData.comments.isEmpty())
					if(!patientData.comments.contains("N/A"))
						assertTrue(type(selenium, "comments", patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments,selenium, ClassName, MethodName);			
				click(selenium,"saveButton");
				waitForPageLoad(selenium);
				returnValue = true;	
				waitForPageLoad(selenium);		
			}catch(RuntimeException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnValue;
	}


		public boolean createPatient(Selenium selenium, HomeLib patientData, String uniqueName){
			boolean returnValue = false;
			try{
				if(!patientData.patientIdchart.isEmpty())
					if(!patientData.patientIdchart.contains("N/A"))
						assertTrue(type(selenium,"chartNumber",patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart ,selenium, ClassName, MethodName);
				if(!patientData.primaryLocation.isEmpty())
					if(!patientData.primaryLocation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "primaryLocationSuggestBoxsuggestBox", patientData.primaryLocation))
							Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
				if(!patientData.responsibleProvider.isEmpty())
					if(!patientData.responsibleProvider.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider))
							Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
				if(!patientData.pcpCheck.isEmpty())
					if(!patientData.pcpCheck.contains("No"))
						assertTrue(check(selenium, "responsibleProvPCPcheckbox"), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck,selenium, ClassName, MethodName);
				
				if(!patientData.lastName.isEmpty())
					if(!patientData.lastName.contains("N/A"))
						assertTrue(type(selenium, txtLastName, patientData.lastName+uniqueName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName,selenium, ClassName, MethodName);
				if(!patientData.firstName.isEmpty())
					if(!patientData.firstName.contains("N/A"))
						assertTrue(type(selenium, txtFirstname, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName,selenium, ClassName, MethodName);
				if(!patientData.middleName.isEmpty())
					if(!patientData.middleName.contains("N/A"))
						assertTrue(type(selenium, "middleName", patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName,selenium, ClassName, MethodName);
				if(!patientData.title.isEmpty())
					if(!patientData.title.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title))	
							Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
				if(!patientData.suffix.isEmpty())
					if(!patientData.suffix.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix))
							Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
				if(!patientData.alias1.isEmpty())
					if(!patientData.alias1.contains("N/A"))
						assertTrue(type(selenium, "alias1", patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1,selenium, ClassName, MethodName);
				if(!patientData.alias2.isEmpty())
					if(!patientData.alias2.contains("N/A"))
						assertTrue(type(selenium, "alias2", patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2,selenium, ClassName, MethodName);
				if(!patientData.dob.isEmpty())
					if(!patientData.dob.contains("N/A"))
						assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
				click(selenium,"backButton");
				if(!patientData.estimatedCheck.isEmpty())
					if(!patientData.estimatedCheck.contains("No"))
						assertTrue(click(selenium, "dobEstimatedcheckbox"), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck,selenium, ClassName, MethodName);
				if(!patientData.prematureCheck.isEmpty())
					if(!patientData.prematureCheck.contains("No")){
						assertTrue(click(selenium, "prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
						if(!patientData.duration.isEmpty())
							if(!patientData.duration.contains("N/A"))
								assertTrue(type(selenium, "prematureDuration", patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration,selenium, ClassName, MethodName);
						if(!patientData.measure.isEmpty())
							if(!patientData.measure.contains("N/A"))
								if(!selectValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure))
									Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
									waitForPageLoad(selenium);
					}
				if(!patientData.sex.isEmpty())
					if(!patientData.sex.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex))
							Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
							waitForPageLoad(selenium);
				if(!patientData.maritalStatus.isEmpty())
					if(!patientData.maritalStatus.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus))
							Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
				if(!patientData.status.isEmpty())
					if(!patientData.status.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status))
							Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
				if(!patientData.statusDate.isEmpty())
					if(!patientData.statusDate.contains("N/A"))
						assertTrue(enterDate(selenium, "statusDate", patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(),selenium, ClassName, MethodName);
				if(patientData.status.equalsIgnoreCase("inactive"))
					if(!patientData.reasonForInactivation.isEmpty())
						if(!patientData.reasonForInactivation.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation))
								Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
				if(!patientData.residentialAddrStreet1.isEmpty())
					if(!patientData.residentialAddrStreet1.contains("N/A"))
						assertTrue(type(selenium, "residentialAddr1", patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
				if(!patientData.residentialAddrStreet2.isEmpty())
					if(!patientData.residentialAddrStreet2.contains("N/A"))
						assertTrue(type(selenium, "residentialAddr2", patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
				if(!patientData.residentialAddrcity.isEmpty())
					if(!patientData.residentialAddrcity.contains("N/A"))
						assertTrue(type(selenium, "residentialCity", patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity,selenium, ClassName, MethodName);
				if(!patientData.residentialAddrstate.isEmpty())
					if(!patientData.residentialAddrstate.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
				if(!patientData.residentialAddrzipCode.isEmpty())
					if(!patientData.residentialAddrzipCode.contains("N/A"))
						assertTrue(type(selenium, "residentialZip", patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress("commType1SuggestBoxsuggestBox", "\\9");
				click(selenium,btnYes);
				waitForElementToEnable(selenium,"residentialCity");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"residentialStatesuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"residentialCountrysuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"residentialCounty");
				waitForPageLoad(selenium);
				
				if(!patientData.telephoneType1.isEmpty())
					if(!patientData.telephoneType1.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1))
							Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
				if(!patientData.telephoneNo1.isEmpty())
					if(!patientData.telephoneNo1.contains("N/A"))
						assertTrue(type(selenium, "primaryPhone", patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
				if(!patientData.telephoneextnNo1.isEmpty())
					if(!patientData.telephoneextnNo1.contains("N/A"))
						assertTrue(type(selenium, "primaryPhoneExtension", patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
				if(!patientData.telephoneType2.isEmpty())
					if(!patientData.telephoneType2.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2))
							Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
				
				if(!patientData.telephoneNo2.isEmpty())
					if(!patientData.telephoneNo2.contains("N/A"))
						assertTrue(type(selenium, "ohterPhone1", patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2,selenium, ClassName, MethodName);
				if(!patientData.telephoneextnNo2.isEmpty())
					if(!patientData.telephoneextnNo2.contains("N/A"))
						assertTrue(type(selenium, "otherPhone1Extension", patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2,selenium, ClassName, MethodName);
				
				if(!patientData.telephoneType3.isEmpty())
					if(!patientData.telephoneType3.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3))
							Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
				
				if(!patientData.telephoneNo3.isEmpty())
					if(!patientData.telephoneNo3.contains("N/A"))
						assertTrue(type(selenium, "otherPhone2", patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
				if(!patientData.telephoneextnNo3.isEmpty())
					if(!patientData.telephoneextnNo3.contains("N/A"))
						assertTrue(type(selenium, "otherPhone2Extension", patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
				
				if(!patientData.email.isEmpty())
					if(!patientData.email.contains("N/A"))
						assertTrue(type(selenium, "email", patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email,selenium, ClassName, MethodName);
				
				if(!patientData.contactPreferences.isEmpty())
					if(!patientData.contactPreferences.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "//div[7]/div/div/div/div/div/div/input", patientData.contactPreferences))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
				
				if(!patientData.contactPreferences1.isEmpty())
					if(!patientData.contactPreferences1.contains("N/A"))
						assertTrue(click(selenium, "addButtonId"), "Could not click on add more button",selenium, ClassName, MethodName);
						if(!selectValueFromAjaxList(selenium, "//div[7]/div/div/div[2]/div/div/div/input", patientData.contactPreferences1))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences1);
				
				if(!patientData.contactPreferences2.isEmpty())
					if(!patientData.contactPreferences2.contains("N/A"))
						assertTrue(click(selenium, "addButtonId"), "Could not click on add more button",selenium, ClassName, MethodName);
						if(!selectValueFromAjaxList(selenium, "//div[3]/div/div/div/input", patientData.contactPreferences2))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences2);
				
				if(!patientData.contactPreferences4.isEmpty())
					if(!patientData.contactPreferences4.contains("N/A"))
						assertTrue(click(selenium, "addButtonId"), "Could not click on add more button",selenium, ClassName, MethodName);
							if(!selectValueFromAjaxList(selenium, "//div[4]/div/div/div/input", patientData.contactPreferences4))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences4);

				if(!patientData.sameAsResidentialAddressCheck.isEmpty()){
					if(!patientData.sameAsResidentialAddressCheck.contains("No"))
						assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressStreet1.isEmpty())
							if(!patientData.mailingAddressStreet1.contains("N/A"))
								assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
						if(!patientData.mailingAddressStreet2.isEmpty())
							if(!patientData.mailingAddressStreet2.contains("N/A"))
								assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
						if(!patientData.mailingAddressCity.isEmpty())
							if(!patientData.mailingAddressCity.contains("N/A"))
								assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
						if(!patientData.mailingAddressState.isEmpty())
							if(!patientData.mailingAddressState.contains("N/A"))
								selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState);
									
						if(!patientData.mailingAddressZipcode.isEmpty())
							if(!patientData.mailingAddressZipcode.contains("N/A"))
								assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
						waitForPageLoad(selenium);
						selenium.keyPress("comments", "\\9");
						click(selenium,btnYes);
						waitForElementToEnable(selenium,"mailingCity");
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,"mailingStatesuggestBox");
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,"mailingCountrysuggestBox");
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,"mailingCounty");
						waitForPageLoad(selenium);
						
				}
				else{
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
					
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selenium.keyPress("comments", "\\9");
					click(selenium,btnYes);
					waitForElementToEnable(selenium,"mailingCity");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingStatesuggestBox");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingCountrysuggestBox");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingCounty");
					waitForPageLoad(selenium);
			
				}
				if(!patientData.comments.isEmpty())
					if(!patientData.comments.contains("N/A"))
						assertTrue(type(selenium, "comments", patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments,selenium, ClassName, MethodName);			
				click(selenium,"saveButton");
				waitForPageLoad(selenium);
				returnValue = true;	
				waitForPageLoad(selenium);		
			}catch(RuntimeException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnValue;
	}

		
		
		
		/**
		 * verifyClearFieldInPatientInfo
		 * function to verify whether Empty fields exists .

		 * @since 	 Jun 15, 2012
		 */	
		public boolean verifyClearFieldInPatientInfo(Selenium selenium, HomeLib patientData){
			boolean returnValue = false;
			try{
			waitForPageLoad(selenium);
			if(!patientData.primaryLocation.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "suggestBox", patientData.primaryLocation);
			
			waitForPageLoad(selenium);
			if(!patientData.responsibleProvider.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium,"//div[@id='responsibleProvider']/div/div/input",patientData.responsibleProvider);
					
			
			if(!patientData.pcpCheck.contains("No"))
				assertTrue(check(selenium, "responsibleProvPCPcheckbox"), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck,selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			
			if(!patientData.lastName.contains("N/A"))
				assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName,selenium, ClassName, MethodName);
			
			if(!patientData.firstName.contains("N/A"))
				assertTrue(type(selenium, txtFirstname, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName,selenium, ClassName, MethodName);
			
			if(!patientData.middleName.contains("N/A"))
				assertTrue(type(selenium, "middleName", patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName,selenium, ClassName, MethodName);
			
			if(!patientData.title.contains("N/A"))
				click(selenium,"titleSuggestBoxsuggestBox");
				selectEmptyValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title);							
				
			              
			if(!patientData.suffix.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix);
					
			
			if(!patientData.alias1.contains("N/A"))
				assertTrue(type(selenium, "alias1", patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1,selenium, ClassName, MethodName);
			
			if(!patientData.alias2.contains("N/A"))
				assertTrue(type(selenium, "alias2", patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2,selenium, ClassName, MethodName);
			
			if(!patientData.dob.contains("N/A"))
				assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
			click(selenium,"backButton");
			if(!patientData.estimatedCheck.contains("No"))
				assertTrue(check(selenium, "dobEstimatedcheckbox"), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck,selenium, ClassName, MethodName);
			
			if(!patientData.prematureCheck.contains("No"))
			{
				if(!isChecked(selenium,"prematurecheckbox"))
				{
					assertTrue(click(selenium,"prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
					
					if(!patientData.duration.contains("N/A"))
						selectEmptyValueFromAjaxList(selenium,"prematureDurationsuggestBox", patientData.duration);
					
					if(!patientData.measure.contains("N/A"))
						selectEmptyValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure);
				}			
			}
			
			if(!patientData.sex.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex);
					
			
			if(!patientData.maritalStatus.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus);
									
			
			if(!patientData.status.contains("N/A"))
				selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status);
					
			
			if(!patientData.statusDate.contains("N/A"))
				assertTrue(enterDate(selenium, "statusDate", patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(),selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				
				if(!patientData.reasonForInactivation.contains("N/A"))
					selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation);
						
			
			if(!patientData.residentialAddrStreet1.contains("N/A"))
				assertTrue(type(selenium, "residentialAddr1", patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
			
			if(!patientData.residentialAddrStreet2.contains("N/A"))
				assertTrue(type(selenium, "residentialAddr2", patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
			
			if(!patientData.residentialAddrcity.contains("N/A"))
				assertTrue(type(selenium, "residentialCity", patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity,selenium, ClassName, MethodName);
			
			if(!patientData.residentialAddrstate.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate);
					
			if(!patientData.residentialAddrcountry.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "residentialCountrysuggestBox", patientData.residentialAddrcountry);
			
			if(!patientData.county.contains("N/A"))
				type(selenium, "residentialCounty", patientData.county);
					
			if(!patientData.residentialAddrzipCode.contains("N/A"))
				assertTrue(type(selenium, "residentialZip", patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
			/*waitForPageLoad(selenium);
			selenium.keyPress("commType1SuggestBoxsuggestBox", "\\9");
			click(selenium,btnYes);
			waitForElementToEnable(selenium,"residentialCity");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"residentialStatesuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"residentialCountrysuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"residentialCounty");
			waitForPageLoad(selenium);
			*/
			
			if(!patientData.telephoneType1.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1);
					
			
			if(!patientData.telephoneNo1.contains("N/A"))
				assertTrue(type(selenium, "primaryPhone", patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneextnNo1.contains("N/A"))
				assertTrue(type(selenium, "primaryPhoneExtension", patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
			
			
			if(!patientData.telephoneType2.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2);
					
			
			
			if(!patientData.telephoneNo2.contains("N/A"))
				assertTrue(type(selenium, "ohterPhone1", patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneextnNo2.contains("N/A"))
				assertTrue(type(selenium, "otherPhone1Extension", patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2,selenium, ClassName, MethodName);
			
			
			if(!patientData.telephoneType3.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3);
					
			
			
			if(!patientData.telephoneNo3.contains("N/A"))
				assertTrue(type(selenium, "otherPhone2", patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneextnNo3.contains("N/A"))
				assertTrue(type(selenium, "otherPhone2Extension", patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			
			
			if(!patientData.email.contains("N/A"))
				assertTrue(type(selenium, "email", patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email,selenium, ClassName, MethodName);
			
			
			if(!patientData.contactPreferences.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "//div[7]/div/div/div/div/div/div/input", patientData.contactPreferences);
					
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					if(isChecked(selenium,"mailingAsResidentialcheckbox"))
					{
						assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
				
					
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressState.contains("N/A"))
							selectEmptyValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState);
						
						if(!patientData.mailingAddressCountry.contains("N/A"))
							selectEmptyValueFromAjaxList(selenium, "mailingCountrysuggestBox", patientData.mailingAddressCountry);
						if(!patientData.mailingAddressCounty.contains("N/A"))
							type(selenium,"mailingCounty",patientData.mailingAddressCounty);
							
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(selectEmptyValueFromAjaxList(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
						waitForPageLoad(selenium);
						selenium.keyPress("comments", "\\9");
						click(selenium,btnYes);
					}
				}else{
				
				if(!patientData.mailingAddressStreet1.contains("N/A"))
					assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
			
				if(!patientData.mailingAddressStreet2.contains("N/A"))
					assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
			
				if(!patientData.mailingAddressCity.contains("N/A"))
					assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
			
				if(!patientData.mailingAddressState.contains("N/A"))
					selectEmptyValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState);
				
				if(!patientData.mailingAddressCountry.contains("N/A"))
					selectEmptyValueFromAjaxList(selenium, "mailingCountrysuggestBox", patientData.mailingAddressCountry);
				if(!patientData.mailingAddressCounty.contains("N/A"))
					type(selenium,"mailingCounty",patientData.mailingAddressCounty);
					
				if(!patientData.mailingAddressZipcode.contains("N/A"))
					assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
				waitForPageLoad(selenium);
				selenium.keyPress("comments", "\\9");
				click(selenium,btnYes);
				waitForElementToEnable(selenium,"mailingCity");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingStatesuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingCountrysuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingCounty");
				waitForPageLoad(selenium);
		
			}
			if(!patientData.primaryLocation.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, "suggestBox", patientData.primaryLocation);
				waitForPageLoad(selenium);
				selenium.clickAt("css=button.pictureButton","");
				waitForPageLoad(selenium);
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, "comments", patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments,selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				click(selenium,"saveButton");
				waitForPageLoad(selenium);
				returnValue = true;	
				waitForPageLoad(selenium);		
		}catch(RuntimeException e) 
			{
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return returnValue;
		}

		/**
		 * verifySelectOptionsPatientInfo
		 * function to verify the display of the selected option in the pick list 
		 * @since  	     July 05, 2012
		 */	
		public boolean verifySelectOptionsPatientInfo(Selenium selenium, HomeLib patientData)
		{
			boolean returnValue=true;
			try{
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"residentialCountrysuggestBox",patientData.residentialAddrcountry);
				waitForPageLoad(selenium);
				selenium.clickAt("residentialCountrysuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.residentialAddrcountry))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium, "primaryLocationSuggestBoxsuggestBox", patientData.primaryLocation);
				waitForPageLoad(selenium);
				selenium.clickAt("primaryLocationSuggestBoxsuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.primaryLocation))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider);
				waitForPageLoad(selenium);
				selenium.clickAt("responsibleProvSuggestBoxsuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.responsibleProvider))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title);
				waitForPageLoad(selenium);
				selenium.clickAt("titleSuggestBoxsuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.title))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix);
				waitForPageLoad(selenium);
				selenium.clickAt("suffixSuggestBoxsuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.suffix))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;
				if(!patientData.prematureCheck.isEmpty())
					if(!patientData.prematureCheck.contains("No")){
						assertTrue(click(selenium, "prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
						selectValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure);
						waitForPageLoad(selenium);
						selenium.clickAt("prematureMeasureUnitSuggestBoxsuggestBox","");
						waitForPageLoad(selenium);
						if(isElementPresent(selenium,"css=div.item-selected"))
						{
							if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.measure))
								if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
								{
									returnValue=true;
									click(selenium,"css=div.item-selected");
								}
						}
						else
							return false;
					}
			selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex);
			waitForPageLoad(selenium);
			selenium.clickAt("sexSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.sex))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus);
			waitForPageLoad(selenium);
			selenium.clickAt("maritalStatusSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.maritalStatus))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status);
			selenium.clickAt("statusSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.status))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			/*selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation);
			selenium.clickAt("statusInactivationReasonSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.reasonForInactivation))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;*/
			selectValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate);
			selenium.clickAt("residentialStatesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.residentialAddrstate))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1);
			selenium.clickAt("commType1SuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.telephoneType1))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2);
			selenium.clickAt("commType2SuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.telephoneType2))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3);
			selenium.clickAt("commType3SuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.telephoneType3))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			/*selectValueFromAjaxList(selenium, "//div[7]/div/div/div/div/div/div/input", patientData.contactPreferences);
			selenium.clickAt("//div[7]/div/div/div/div/div/div/input","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.contactPreferences))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;*/
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState);
				selenium.clickAt("mailingStatesuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.mailingAddressState))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;
			}
			selectValueFromAjaxList(selenium,"mailingCountrysuggestBox",patientData.mailingAddressCountry);
			selenium.clickAt("mailingCountrysuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(patientData.mailingAddressCountry))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return returnValue;
			
		}

	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, HomeLib patientData){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstname,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,"prematurecheckbox"),"Could not click prematurecheck box : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"prematureDurationSuggestBoxsuggestBox",patientData.duration);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"prematureMeasureUnitSuggestBoxsuggestBox",patientData.measure);
			selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",patientData.status);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"saveButton"),"Could not click Save button More Dateils"+patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * deleteAllMandatory
	 * function to delete All Mandatory
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllMandatory(Selenium selenium){
		boolean mandatoryDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, "//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a"),"could not click",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnYes),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a")){
					mandatoryDeleted = false;
					break;
				}
			}
			return mandatoryDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mandatoryDeleted;
	}
	/**
	 * createPatient_UnitTest
	 * function to create a new patient check-in for unit Test
	 * @since  	     Feb 09, 2012
	 */
	public boolean createPatient_UnitTest(Selenium selenium, HomeLibUnitTest patientData){
		boolean returnValue = false;
		try{	
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,"chartNumber",patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart,selenium, ClassName, MethodName );
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "primaryLocationSuggestBoxsuggestBox", patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, "responsibleProvPCPcheckbox"), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck,selenium, ClassName, MethodName);
			
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName,selenium, ClassName, MethodName);
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstname, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName,selenium, ClassName, MethodName);
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, "middleName", patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName,selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, "alias1", patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1,selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, "alias2", patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2,selenium, ClassName, MethodName);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
					
				
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, "dobEstimatedcheckbox"), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck,selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, "prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
							assertTrue(type(selenium, "prematureDuration", patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration,selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
				}
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					assertTrue(type(selenium, "statusDate", patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(),selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, "residentialAddr1", patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, "residentialAddr2", patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, "residentialCity", patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, "residentialZip", patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcountry.isEmpty())
				if(!patientData.residentialAddrcountry.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"residentialCountrysuggestBox",patientData.residentialAddrcountry))
						Assert.fail("Could not Enter Residential Addr Country, Expected value to be select"+patientData.residentialAddrcountry);
			if(!patientData.residentialAddrCounty.isEmpty())
				if(!patientData.residentialAddrCounty.contains("N/A"))
					assertTrue(type(selenium,"residentialCounty",patientData.residentialAddrCounty),"Could not Enter county Value, Expected value to be typed"+ patientData.residentialAddrCounty,selenium, ClassName, MethodName);
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, "primaryPhone", patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, "primaryPhoneExtension", patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, "ohterPhone1", patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, "otherPhone1Extension", patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, "otherPhone2", patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, "otherPhone2Extension", patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, "email", patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email,selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "contactPreferenceSuggestBoxId1suggestBox", patientData.contactPreferences))
						Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
			if(!patientData.preference2Present.isEmpty())
				if(!patientData.preference2Present.contains("N/A")){
					assertTrue(click(selenium,"addButtonId"), "Could not add a ne preference",selenium, ClassName, MethodName);
					if(!patientData.contactPreference2.isEmpty())
						if(!patientData.contactPreference2.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "//div[7]/div/div/div[2]/div/div/div/input", patientData.contactPreference2))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreference2);
				}
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
					
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState))
								Assert.fail("Could not Enter Mailing Addr State, Expected value to be select" + patientData.mailingAddressState);
					
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
				}
			else{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
				
				if(!patientData.mailingAddressState.isEmpty())
					if(!patientData.mailingAddressState.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState))
							Assert.fail("Could not Enter Mailing Address State, Expected value to be selected" + patientData.mailingAddressState);
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCountry.isEmpty())
					if(!patientData.mailingAddressCountry.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,"mailingCountrysuggestBox",patientData.mailingAddressCountry))
							Assert.fail("Could not Enter Mailing Addr Country,Expected value to be typed"+patientData.mailingAddressCountry);
			}
			
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, "comments", patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments,selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			click(selenium,"saveButton");
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}





	
	/**
	 * createNotesWithMandatory
	 * function to create a Notes With Mandatory
	 * @since  	    May 03, 2012
	 */	
	public boolean createNotesWithMandatory(Selenium selenium,HomeLib noteData){
		try{
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium,"noteDate",noteData.notedate),"Could not enter date; More Details:"+noteData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"suggestBox",noteData.category);
			assertTrue(type(selenium,"note",noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+noteData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * verifySelectOptionNotes
	 * function to verify the display of select option in notes
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionNotes(Selenium selenium,HomeLib noteData){
		boolean returnValue=false;
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"suggestBox",noteData.category);
			selenium.clickAt("suggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(noteData.category))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		}
		return returnValue;
	}
	
	
	/**
	 * goToCases
	 * function to create a Case
	 * @since  	     APR 09, 2012
	 */	
	public boolean goToCases(Selenium selenium){
		try{
			click(selenium,"!patientCasesList");
			waitForPageLoad(selenium);
			if(waitForElement(selenium, "css=span.buttons > button.gwt-Button", WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	/**
	 * deleteAllCases
	 * function to create a Case
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllCases(Selenium selenium){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a"),"could not click",selenium, ClassName, MethodName);
				click(selenium,btnYes);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caseDeleted;
	}
	
	
	/**
	 * Go To Add Case
	 * function to navigate to add case
	 * @since  	     APR 09, 2012
	 */
	public boolean goToAddCase(Selenium selenium){
		try{
			assertTrue(click(selenium,"css=span.buttons > button.gwt-Button"), "Could not click Add Case",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(waitForElement(selenium, "description", WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * createCases
	 * function to create a Case
	 * @since  	     APR 09, 2012
	 */	

	public boolean createCases(Selenium selenium, HomeLib casesData){
		
	try{		
			assertTrue(type(selenium,"description",casesData.description),"Could not enter Description ; More Details :"+casesData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"programIDSuggestBoxsuggestBox", casesData.program);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"reason",casesData.reason),"Could not enter Reason ; More Details :"+casesData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"referralList",casesData.referral);
			//Assert.assertTrue(type(selenium,"icdCode",casesData.icecode),"Could not icecode; More Details :" + casesData.toString());
			assertTrue(enterDate(selenium,"startDate",casesData.startdate),"Could not enter the date; More Details :" + casesData.toString(),selenium, ClassName, MethodName);
			if(casesData.casesstatus.equals("Terminated"))
			{
				selectValueFromAjaxList(selenium,"caseStatusSuggestBoxsuggestBox",casesData.casesstatus);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,"terminationDate",casesData.terminationDate),"Could not enter the date; More Details :" + casesData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"terminationDateReason",casesData.terminationReason),"Could not enter the Reason ; More Details :"+casesData.toString(),selenium, ClassName, MethodName);
			}
			
			click(selenium,"addCaseDates");
			if (isElementPresent(selenium, "dateTypeSuggestBoxsuggestBox")){
				selectValueFromAjaxList(selenium,"dateTypeSuggestBoxsuggestBox", casesData.datetype1);
				click(selenium,"//body/div[3]/div/div/div/div/div");
				assertTrue(enterDate(selenium,"date",casesData.date1),"Could not enter the date; More Details :" + casesData.toString(),selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + casesData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}

	
	/**
	 * verifySelectOptionsCases
	 * function to verify options in Cases
	  * @since  	     July 06, 2012
	 */	

	public boolean verifySelectOptionsCases(Selenium selenium, HomeLib casesData){
		boolean  returnValue=false;
		try{		
			
			selectValueFromAjaxList(selenium,"programIDSuggestBoxsuggestBox", casesData.program);
			selenium.clickAt("programIDSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(casesData.program))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,"caseStatusSuggestBoxsuggestBox",casesData.casesstatus);
			selenium.clickAt("caseStatusSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(casesData.casesstatus))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			click(selenium,"addCaseDates");
			if (isElementPresent(selenium, "dateTypeSuggestBoxsuggestBox")){
			selectValueFromAjaxList(selenium,"dateTypeSuggestBoxsuggestBox", casesData.datetype1);
			click(selenium,"//body/div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			selenium.clickAt("dateTypeSuggestBoxsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(casesData.datetype1))
				if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
			return false;
		}
		return returnValue;
	}

	/**
	 * createContact
	 * function to create a Contact
	 * @since  	     Feb 22, 2012
	 */	
	public boolean createContact(Selenium selenium, HomeLib ContactData){
		
		try{		
			
assertTrue(check(selenium, "subsDecisionMarkercheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			selectValueFromAjaxList(selenium, ajxTitle,ContactData.title);
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstname, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"suffixsuggestBox",ContactData.suffix);
			assertTrue(type(selenium, "email", ContactData.email),"Could not enter Email; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "languagesuggestBox",ContactData.languageSpoken);
			assertTrue(type(selenium, "comments", ContactData.comments), "Could not Enter comments, Expected value to be Selected" + ContactData.comments,selenium, ClassName, MethodName);
			assertTrue(type(selenium, "contactAddr1", ContactData.residentialAddrStreet1),"Could not enter Residential Address; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "contactAddr2", ContactData.residentialAddrStreet2),"Could not enter Residential Address; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "contactCity", ContactData.residentialAddrcity),"Could not enter City; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "contactStatesuggestBox",ContactData.residentialAddrstate);
			assertTrue(type(selenium, "contactZip", ContactData.residentialAddrzipCode),"Could not enter Zip; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selenium.keyPress("contactCountrysuggestBox", "\\9");
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactAddr1");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactAddr2");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactCity");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactStatesuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactCountrysuggestBox");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, "commType1suggestBox",ContactData.telephoneType1);
			assertTrue(type(selenium, "primaryPhone", ContactData.telephoneNo1),"Could not enter phone number; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "primaryPhoneExt", ContactData.telephoneextnNo1),"Could not enter extn number; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "commType2suggestBox",ContactData.telephoneType2);
			assertTrue(type(selenium, "secondaryPhone", ContactData.telephoneNo2),"Could not enter Phone number; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "secondaryPhoneExt", ContactData.telephoneextnNo2),"Could not enter extn number; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "commType3suggestBox",ContactData.telephoneType3);
			assertTrue(type(selenium, "tertiaryPhone", ContactData.telephoneNo3),"Could not enter Fax number; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "tertiaryPhoneExt", ContactData.telephoneextnNo3),"Could not enter extn number; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createContactWithMandatory
	 * function to create a Contact only With Mandatory fields
	  * @since  	     Apr 18, 2012
	 */	
	public boolean createContactWithMandatory(Selenium selenium, HomeLib ContactData){
		
		try{		
			if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_001"))
				assertTrue(check(selenium, "subsDecisionMarkercheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			else if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_004"))
				assertTrue(check(selenium, "guarantorcheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			else if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_005"))
				assertTrue(check(selenium, "emergencyContactcheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstname, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * deleteAllContact
	 * function to delete All Contact
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllContact(Selenium selenium){
		boolean contactDeleted = true;
		int contactCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a") > 0){
				contactCount = (Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a"),"could not click",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"colud not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(contactCount == (Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a")){
					contactDeleted = false;
					break;
				}
			}
			return contactDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactDeleted;
	}
	
	
	/**
	 * duplicateContact
	 * function to create a Contact only With Mandatory fields
	 * @since  	     Apr 18, 2012
	 */	
	public boolean duplicateContact(Selenium selenium, HomeLib ContactData){
		
		try{		
			if(ContactData.guarantor.equals("Yes")){
				assertTrue(check(selenium,"guarantorcheckbox"),"Could not check gurantor;More Details:"+ContactData.toString(),selenium, ClassName, MethodName);
			}
			if(ContactData.eContact.equals("Yes")){
				assertTrue(check(selenium,"emergencyContactcheckbox"),"Could not check eContact;More Details:"+ContactData.toString(),selenium, ClassName, MethodName);
			}
			if(ContactData.guardian.equals("Yes")){
				assertTrue(check(selenium,"guardiancheckbox"),"Could not check guardianr;More Details:"+ContactData.toString(),selenium, ClassName, MethodName);
			}
			if(ContactData.sdMarker.equals("Yes")){
				assertTrue(check(selenium,"subsDecisionMarkercheckbox"),"Could not check sdMaker;More Details:"+ContactData.toString(),selenium, ClassName, MethodName);
			}
			if(ContactData.other.equals("Yes")){
				assertTrue(check(selenium,"othercheckbox"),"Could not check gurantor;More Details:"+ContactData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstname, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * copyContactInfoFromHousehold
	 * function to verify copy information from household
	 * @since  	     Aor 17, 2012
	 */	
	public boolean copyContactInfoFromHousehold(Selenium selenium, HomeLib ContactData){
		
		try{
			if(isElementPresent(selenium, "patientcontactSearchBox"))
				type(selenium, "id=patientcontactSearchBox", ContactData.householdName);
			click(selenium,"css=div.inlineBlock.marginTop15 > span.buttons > button.gwt-Button");
			if(isElementPresent(selenium, "//div[@id='patientContactPopup']/div/div/div/div/div/div/div[4]"))
					click(selenium,"//div[@id='patientContactPopup']/div/div/div/div/div/div/div[4]");
			assertTrue(check(selenium, "guardiancheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * verifyContactWithSummaryPage
	 * function to verify Contact With Summary Page
	 * @since  	    July 02, 2012
	 */	
	public boolean verifyContactWithSummaryPage(Selenium selenium, HomeLib ContactData){
		
		try{		
			
			assertTrue(check(selenium, "emergencyContactcheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstname, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * verifySelectOptionsInContacts
	 * function to verify the select options in contacts
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionsInContacts(Selenium selenium, HomeLib ContactData){
		boolean returnValue=false;
		try{		
			
			assertTrue(check(selenium, "subsDecisionMarkercheckbox"), "Could not check the contact type, " + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			selenium.clickAt("relationshipsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.relationship))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium, ajxTitle,ContactData.title);
			selenium.clickAt(ajxTitle,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.title))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstname, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"suffixsuggestBox",ContactData.suffix);
			selenium.clickAt("suffixsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.suffix))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium, "languagesuggestBox",ContactData.languageSpoken);
			selenium.clickAt("languagesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.languageSpoken))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium, "contactStatesuggestBox",ContactData.residentialAddrstate);
			selenium.clickAt("contactStatesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				waitForPageLoad(selenium);
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.residentialAddrstate))
					waitForPageLoad(selenium);
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium, "commType1suggestBox",ContactData.telephoneType1);
			selenium.clickAt("commType1suggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.telephoneType1))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium, "commType2suggestBox",ContactData.telephoneType2);
			selenium.clickAt("commType2suggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.telephoneType2))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium, "commType3suggestBox",ContactData.telephoneType3);
			selenium.clickAt("commType3suggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(ContactData.telephoneType3))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createSocioEconomic
	 * function to create a Socio Economic
	 * @since  	     Feb 22, 2012
	 */	
	public boolean createSocioEconomic(Selenium selenium, HomeLib socioEconomicData){
		
		try{	
			selectValueFromAjaxList(selenium,"racesuggestBox",socioEconomicData.race);
			selectValueFromAjaxList(selenium,"ethnicitysuggestBox",socioEconomicData.ethnicity);
			selectValueFromAjaxList(selenium,"religionsuggestBox",socioEconomicData.religion);
			selectValueFromAjaxList(selenium,"citizenshipsuggestBox",socioEconomicData.citizenship);
			selectValueFromAjaxList(selenium,"countrysuggestBox",socioEconomicData.countryPanel);
			selectValueFromAjaxList(selenium,"languageSpokensuggestBox",socioEconomicData.languagespoken);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(enterDate(selenium,"dateOfArrival",socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"spokenLanguagesuggestBox",socioEconomicData.languagePanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("Yes")){
				if(isChecked(selenium, "interpreterRequiredcheckbox")){
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}else{
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}
			}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium, "interpreterRequiredcheckbox")){
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
				}
			}
			selectValueFromAjaxList(selenium,"parentEthnicitysuggestBox",socioEconomicData.parentEthnicityPanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"livingArrangementsuggestBox",socioEconomicData.livingArrangement);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"studentStatussuggestBox",socioEconomicData.studentStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"educationLevelsuggestBox",socioEconomicData.educationLevel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"householdIncomesuggestBox",socioEconomicData.householdIncome);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(type(selenium,"numPeopleText",socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"householdCompositionsuggestBox",socioEconomicData.householdComposition);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"homelesssuggestBox",socioEconomicData.homelessStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(click(selenium,"ssicheckbox"),"Could not check the ssi element, Expected value for check box:"+socioEconomicData.ssi,selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"employmentsuggestBox",socioEconomicData.employmentStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(type(selenium,"comments",socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);

			if(isElementPresent(selenium, "!patientSocialHistory")){
				return true;
			}else{
				return false;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createEnterPriseVariableNotes
	 * function to create EnterPrise Variable Notes
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariable_Socio(Selenium selenium,HomeLib epData){
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.livingType);
			click(selenium,"searchButtonId");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.livingType);
			waitForPageLoad(selenium);
			type(selenium,"variableValueTextFieldId",epData.livingArrangement);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * EditSocioEconomic
	 * function to edit a Socio Economic
	 * @since  	     Feb 22, 2012
	 */	
	public boolean editSocioEconomic(Selenium selenium, HomeLib socioEconomicData){
		
		try{	
			selectValueFromAjaxList(selenium,"racesuggestBox",socioEconomicData.race);
			
			selectValueFromAjaxList(selenium,"ethnicitysuggestBox",socioEconomicData.ethnicity);
			
			selectValueFromAjaxList(selenium,"religionsuggestBox",socioEconomicData.religion);
			
			selectValueFromAjaxList(selenium,"citizenshipsuggestBox",socioEconomicData.citizenship);
			
			selectValueFromAjaxList(selenium,"countrysuggestBox",socioEconomicData.countryPanel);
			
			selectValueFromAjaxList(selenium,"languageSpokensuggestBox",socioEconomicData.languagespoken);
			
			assertTrue(enterDate(selenium,"dateOfArrival",socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"spokenLanguagesuggestBox",socioEconomicData.languagePanel);
			
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("Yes")){
				if(isChecked(selenium, "interpreterRequiredcheckbox")){
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}else{
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}
			}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium, "interpreterRequiredcheckbox")){
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
				}
			}
			selectValueFromAjaxList(selenium,"parentEthnicitysuggestBox",socioEconomicData.parentEthnicityPanel);
			
			selectValueFromAjaxList(selenium,"livingArrangementsuggestBox",socioEconomicData.livingArrangement);
			
			selectValueFromAjaxList(selenium,"studentStatussuggestBox",socioEconomicData.studentStatus);
			
			selectValueFromAjaxList(selenium,"educationLevelsuggstBox",socioEconomicData.educationLevel);
			
			selectValueFromAjaxList(selenium,"householdIncomesuggestBox",socioEconomicData.householdIncome);
			
			assertTrue(type(selenium,"numPeopleText",socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"householdCompositionsuggestBox",socioEconomicData.householdComposition);
			
			assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"homelesssuggestBox",socioEconomicData.homelessStatus);
			
			assertTrue(click(selenium,"ssicheckbox"),"Could not check the ssi element, Expected value for check box:"+socioEconomicData.ssi,selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"employmentsuggestBox",socioEconomicData.employmentStatus);
			
			assertTrue(type(selenium,"comments",socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);

			if(isElementPresent(selenium, "!patientSocialHistory")){
				return true;
			}else{
				return false;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * verifySelectInSocio
	 * function to edit a Socio Economic
	 * @since  	     Feb 22, 2012
	 */	
	public boolean verifySelectInSocio(Selenium selenium, HomeLib socioEconomicData){
		boolean returnValue=false;
		try{	
			selectValueFromAjaxList(selenium,"racesuggestBox",socioEconomicData.race);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("racesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.race))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,"ethnicitysuggestBox",socioEconomicData.ethnicity);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("ethnicitysuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.ethnicity))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"religionsuggestBox",socioEconomicData.religion);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("religionsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.religion))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"citizenshipsuggestBox",socioEconomicData.citizenship);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("citizenshipsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.citizenship))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	

			selectValueFromAjaxList(selenium,"countrysuggestBox",socioEconomicData.countryPanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("countrysuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.countryPanel))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"languageSpokensuggestBox",socioEconomicData.languagespoken);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("languageSpokensuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.languagespoken))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	

			assertTrue(enterDate(selenium,"dateOfArrival",socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"spokenLanguagesuggestBox",socioEconomicData.languagePanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("spokenLanguagesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected"))
			{
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.languagePanel))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"parentEthnicitysuggestBox",socioEconomicData.parentEthnicityPanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("parentEthnicitysuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.parentEthnicityPanel))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			/*selectValueFromAjaxList(selenium,"livingArrangementsuggestBox",socioEconomicData.livingArrangement);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("livingArrangementsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(socioEconomicData.livingArrangement))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;*/	
			selectValueFromAjaxList(selenium,"studentStatussuggestBox",socioEconomicData.studentStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("studentStatussuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.studentStatus))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"educationLevelsuggestBox",socioEconomicData.educationLevel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("educationLevelsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.educationLevel))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"householdIncomesuggestBox",socioEconomicData.householdIncome);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("householdIncomesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.householdIncome))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,"householdCompositionsuggestBox",socioEconomicData.householdComposition);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("householdCompositionsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.householdComposition))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"homelesssuggestBox",socioEconomicData.homelessStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("homelesssuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.homelessStatus))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"employmentsuggestBox",socioEconomicData.employmentStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selenium.clickAt("employmentsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.currentItem.item-selected")){
				if(getText(selenium,"css=div.currentItem.item-selected").equalsIgnoreCase(socioEconomicData.employmentStatus))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.currentItem.item-selected");
					}
			}
			else
				return false;			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * createConsent
	 * function to verify the selected option in the select boxes
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionsConsents(Selenium selenium, HomeLib consentData){
		boolean returnValue = false;
		try{	
					
			selectValueFromAjaxList(selenium,"consentTypesuggestBox", consentData.consentType);
			click(selenium,"//div[4]/div/div/div/div/div");
			selenium.clickAt("consentTypesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(consentData.consentType))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;		
			selectValueFromAjaxList(selenium,"consentNamesuggestBox", consentData.consentName);
			selenium.clickAt("consentNamesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(consentData.consentName))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;		
			selectValueFromAjaxList(selenium,"statussuggestBox", consentData.status);
			selenium.clickAt("statussuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(consentData.status))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			if (isElementPresent(selenium, "reasonForInactivationsuggestBox"))
			selectValueFromAjaxList(selenium,"reasonForInactivationsuggestBox",consentData.inactivation);
			selenium.clickAt("statussuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(consentData.status))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			assertTrue(click(selenium,"//span[2]/input"),"Could not select the susbstitution maker; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
			waitForElementToEnable(selenium,"relationshipsuggestBox");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"relationshipsuggestBox",consentData.relationship);
			selenium.clickAt("statussuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(consentData.status))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			waitForPageLoad(selenium);
				
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	/**
	 * goToConsents
	 * function to create a Consents
	 * @since  	     APR 09, 2012
	 */	
	public boolean goToConsents(Selenium selenium){
		try{
			click(selenium,"!patientConsentsList");
			waitForPageLoad(selenium);
			if(waitForElement(selenium, "id=consentadd", WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * deleteAllConsents
	 * function to create a Consents
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllConsents(Selenium selenium){
		boolean consentsDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a"),"could not click ",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click the yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a")){
					consentsDeleted = false;
					break;
				}
			}
			return consentsDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consentsDeleted;
	}
	
	
	/**
	 * Go To Add Consents
	 * function to navigate to add consent
	 * @since  	     APR 09, 2012
	 */
	public boolean goToAddConsent(Selenium selenium){
		try{
			assertTrue(click(selenium,"consentadd"), "Could not click Add Consent",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(waitForElement(selenium, "consentTypesuggestBox", WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createEnterPriseForConsents
	 * function to Create EnterPrise For Consents
	 * @since  	    sep 21, 2012
	 */	
	public boolean createEnterPriseForConsents(Selenium selenium,HomeLib epData){
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on enterPrise Link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.consentType);
			click(selenium,"searchButtonId");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.consentValue);
			
			type(selenium,"variableValueTextFieldId",epData.consentType);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createSSConsents
	 * function to create SSConsents 
	 * @since  	     May 18, 2012
	 */	
	public boolean createSSConsents(Selenium selenium,HomeLib consentData){
		try{
			
			selectValueFromAjaxList(selenium,"consentTypeSuggestBoxsuggestBox",consentData.consentType);
			
			assertTrue(type(selenium,"consentName",consentData.consentName),"Could not enter the consent name; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"validForNumber",consentData.validFor),"Could not the valid for; More Details"+consentData.toString(),selenium, ClassName, MethodName);
			select(selenium,"validForType",consentData.validForType);
			
			selectValueFromAjaxList(selenium,"restrictionLevelSuggestBoxsuggestBox",consentData.restrictionLevel);
			
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ consentData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//td[2]/div/div/div/div")){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());		
			return false;
		}
	}
	
	/**
	 * verifyCreateConsents
	 * function to create consents
	 * @since  	    Feb 21, 2012
	 */	
	public boolean createConsent(Selenium selenium, HomeLib consentData){
		boolean returnValue = false;
		try{	
					
			selectValueFromAjaxList(selenium,"consentTypesuggestBox", consentData.consentType);
			
			selectValueFromAjaxList(selenium,"consentNamesuggestBox", consentData.consentName);
			
			selectValueFromAjaxList(selenium,"statussuggestBox", consentData.status);
			
			if (isElementPresent(selenium, "reasonForInactivationsuggestBox"))
			selectValueFromAjaxList(selenium,"reasonForInactivationsuggestBox",consentData.inactivation);
			assertTrue(enterDate(selenium,"dateSigned", consentData.dateSigned),"Could not enter date; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
			
			 if(consentData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,"//span[2]/input"),"Could not select the susbstitution maker; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,"relationshipsuggestBox");
				
				selectValueFromAjaxList(selenium,"relationshipsuggestBox",consentData.relationship);
			
				assertTrue(type(selenium,txtFirstname,consentData.firstName),"Could not enter the first name; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentData.lastName),"Could not enter last name; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }
			 else
				 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * createHealthCare
	 * function to create a HealthCare
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createHealthCare(Selenium selenium, HomeLib healthTestData,HomeLib epData){
		boolean returnValue = false;
		try{	
						
			selectValueFromAjaxList(selenium,"suggestBox",healthTestData.teamName);
			assertTrue(click(selenium,"searchButton"),"Could not click the Search button;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			if(healthTestData.itemCheckBox.equals("Yes")){
			assertTrue(click(selenium,"//span/input"),"Could not click Item check box ; More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			if(healthTestData.pcpCheckbox.equals("Yes")){
				assertTrue(click(selenium,"//div[@id='selectedMemberList']/div/div/span[2]/span/input"),"Could not click the pcp check box;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			if(healthTestData.teamLead.equals("Yes")){
				assertTrue(click(selenium,"//div[@id='selectedMemberList']/div/div/span[2]/span[2]/input"),"Could not click the Team Lead check box;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			if(healthTestData.duration.equals("End By")){
			selectValueFromAjaxList(selenium,"//div[2]/div/div/div[2]/div/div/div/div/div/input",healthTestData.duration);
			
			assertTrue(enterDate(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input",healthTestData.endDate),"could not enter the date; More Details :"+healthTestData.toString(),selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/input",epData.role);
			
			}else if(healthTestData.duration.equals("End After")){
			selectValueFromAjaxList(selenium,"//div[2]/div/div/div[2]/div/div/div/div/div/input",healthTestData.duration);
			
			assertTrue(type(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input[2]",healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"//div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/input",healthTestData.timeperiod);
			
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/input",epData.role);
			
			}else if(healthTestData.location.equals("locationSuggestBoxsuggestBox")){
				waitForElementToEnable(selenium,"locationSuggestBoxsuggestBox");
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"locationSuggestBoxsuggestBox",healthTestData.location);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"specialtySuggestBoxsuggestBox",healthTestData.specialty);
			}
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + healthTestData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * deleteAllHealthCareteam
	 * function to delete All Health Care team
	  * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllHealthCareteam(Selenium selenium,HomeLib epData){
		boolean hctTeamDeleted = true;
		int hctCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a") > 0){
				hctCount = (Integer) selenium.getXpathCount("//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a"),"could not click ",selenium, ClassName, MethodName);
				click(selenium, btnYes);
				selectValueFromAjaxList(selenium,"suggestBox",epData.reasonForDelete);
				if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
					click(selenium,"//div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				click(selenium,txtdeleteReason);
				waitForPageLoad(selenium);
				if(hctCount == (Integer) selenium.getXpathCount("//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a")){
					hctTeamDeleted = false;
					break;
				}
			}
			return hctTeamDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hctTeamDeleted;
	}


	
	/**
	 * deleteAllHealthCareteams_Unit
	 * function to deleteAllHealthCareteams_Unit
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllHealthCareteams_Unit(Selenium selenium,HomeLibUnitTest epData){
		boolean hctTeamDeleted = true;
		int hctCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a") > 0){
				hctCount = (Integer) selenium.getXpathCount("//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a"),"could not click",selenium, ClassName, MethodName);
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,"suggestBox",epData.reasonForDelete);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"//div[5]/div/div/div/div/div"))
					click(selenium,"//div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				click(selenium,txtdeleteReason);
				waitForPageLoad(selenium);
				if(hctCount == (Integer) selenium.getXpathCount("//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a")){
					hctTeamDeleted = false;
					break;
				}
			}
			return hctTeamDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hctTeamDeleted;
	}
	
	/**
	 * verifySelectOptionsHealthCare
	 * function to verify the select options in Health Care
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionsHealthCare(Selenium selenium, HomeLib healthTestData,HomeLib epData){
		boolean returnValue = false;
		try{	
						
			selectValueFromAjaxList(selenium,"suggestBox",healthTestData.teamName);
			selenium.clickAt("suggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(healthTestData.teamName))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle")){
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}else
				return false;
			
			
			assertTrue(click(selenium,"searchButton"),"Could not click the Search button;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(healthTestData.itemCheckBox.equals("Yes")){
			assertTrue(click(selenium,"//span/input"),"Could not click Item check box ; More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			
			if(healthTestData.duration.equals("End After")){
			selectValueFromAjaxList(selenium,"//div[2]/div/div/div[2]/div/div/div/div/div/input",healthTestData.duration);
			selenium.clickAt("//div[2]/div/div/div[2]/div/div/div/div/div/input","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(healthTestData.duration))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle")){
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			/*Assert.assertTrue(type(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input[2]",healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString());
			selectValueFromAjaxList(selenium,"//div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/input",healthTestData.timeperiod);
			selenium.clickAt("//div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/input","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected")){
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(healthTestData.timeperiod))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle")){
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}else
				return false;*/
			}
		}catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + healthTestData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * searchHealthCare
	 * function to search HealthCare
	 * @since  	    May 15, 2012
	 */	
	public boolean searchHealthCare(Selenium selenium, HomeLib healthTestData,HomeLib epData){
		boolean returnValue = false;
		try{	
						
			selectValueFromAjaxList(selenium,"suggestBox",healthTestData.teamName);
			
			assertTrue(type(selenium,"searchBox",healthTestData.searchName),"Could not type Name;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,"searchButton"),"Could not click the Search button;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(healthTestData.itemCheckBox.equals("Yes")){
			assertTrue(click(selenium,"//span/input"),"Could not click Item check box ; More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			if(healthTestData.pcpCheckbox.equals("Yes")){
				assertTrue(click(selenium,"//div[@id='selectedMemberList']/div/div/span[2]/span/input"),"Could not click the pcp check box;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			if(healthTestData.teamLead.equals("Yes")){
				assertTrue(click(selenium,"//div[@id='selectedMemberList']/div/div/span[2]/span[2]/input"),"Could not click the Team Lead check box;More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			if(healthTestData.duration.equals("End By")){
			selectValueFromAjaxList(selenium,"//div[2]/div/div/div[2]/div/div/div/div/div/input",healthTestData.duration);
			
			assertTrue(enterDate(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input",healthTestData.endDate),"could not enter the date; More Details :"+healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/input",epData.role);
			
			}else if(healthTestData.duration.equals("End After")){
			selectValueFromAjaxList(selenium,"//div[2]/div/div/div[2]/div/div/div/div/div/input",healthTestData.duration);
			
			assertTrue(type(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input[2]",healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"//div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/input",healthTestData.timeperiod);
			
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/input",epData.role);
		
			}else if(healthTestData.location.equals("locationSuggestBoxsuggestBox")){
				waitForElementToEnable(selenium,"locationSuggestBoxsuggestBox");
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"locationSuggestBoxsuggestBox",healthTestData.location);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"specialtySuggestBoxsuggestBox",healthTestData.specialty);
			}
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + healthTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + healthTestData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createEnterPriseVariable
	 * function to create EnterPriseVariable
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariable(Selenium selenium,HomeLib epData){
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.role);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.roleType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.role);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,"searchTextBox",epData.reasonForDelete);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.reasonForDeleteType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.reasonForDelete);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,"searchTextBox",epData.specialty);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.specialtyValue);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.specialty);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * createAdminEnterPriseVariable
	 * function to create Admin EnterPriseVariable
	 * @throws IOException 
	 * @since  	    Aug 21, 2012
	 */	
	public boolean createAdminEnterPriseVariable(Selenium selenium,HomeLib epData) throws IOException{
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium,"searchTextBox",epData.role);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.roleType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.role);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,"searchTextBox",epData.reasonForDelete);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.reasonForDeleteType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.reasonForDelete);
			click(selenium,btnSave);
			
			type(selenium,"searchTextBox",epData.reason);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.deleteValue);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.reason);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		}
	}
	
	/**
	 * deleteAllAdminHCT
	 * function to delete All Admin HCT
	  * @since  	     APR 09, 2012
	 */
	public boolean deleteAdminHCT(Selenium selenium,HomeLib epData){
		boolean adminHCTDeleted = true;
		int caseCount = 0;
		try{
			assertTrue(type(selenium,"searchTextBox",epData.teamName),"Could not type the first name; More Details"+epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"xpath=(//button[@type='button'])[2]"),"Could not click the search button"+epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForElement(selenium, "//div[@id='AdminHealthcareList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminHealthcareList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminHealthcareList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='AdminHealthcareList']/table/tbody/tr/td[3]/div/a"),"could not click",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"suggestBox",epData.reason);
				click(selenium,"//div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDeleteReason),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a")){
					adminHCTDeleted = false;
					break;
				}
			}
			return adminHCTDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminHCTDeleted;
	}
	
	/**
	 * createHealthCareTeam
	 * function to create a HealthCare Team 
	 * @since  	     May 21, 2012
	 */	
	
	public boolean createAdminHealthCareTeam(Selenium selenium,HomeLib epData,String uniqueName){
		
		try{
			if(epData.global.equals("Yes")){
				assertTrue(click(selenium,"//span/input"),"Could not click the globle ration button;More details:"+epData.toString(),selenium, ClassName, MethodName);
			}
			else{
					assertTrue(click(selenium,"//span[2]/input"),"Could no click the radio button: More details"+epData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,"teamName",epData.teamName+uniqueName), "Could not enter the Team Name;More deatils:"+epData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"notes",epData.notes),"Could not enter the Notes;More details:"+epData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,"css=div.controls.buttons > button.gwt-Button"),"Could not click the Add member button"+epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/div/div/input",epData.name);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"//div[2]/div/div/div/div/input",epData.role);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=button.gwt-Button"),"Could not click save button;More details:"+epData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	/**
	 * createEnterPriseVariable
	 * function to create EnterPriseVariable
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariable_HCT_UnitTest(Selenium selenium,HomeLibUnitTest epData){
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Enter Prise Variable link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.reasonForDelete);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.reasonForDeleteType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.reasonForDelete);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * createProgram
	 * function to create a Program
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createProgram(Selenium selenium, HomeLib programData){
		
		try{		
			selectValueFromAjaxList(selenium,"suggestBox", programData.program);
			
			assertTrue(enterDate(selenium,"fromDate", programData.fromdate),"Could not enter date; More Details :" + programData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"toDate",programData.todate),"Could not enter the date; More Details :" + programData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"priorState",programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"outcome",programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString(),selenium, ClassName, MethodName);
			if(programData.testCaseId.equals("TC_P_005")){
				selectValueFromAjaxList(selenium,"referralSourcesuggestBox", programData.refFrom);
				selectValueFromAjaxList(selenium,"referredTosuggestBox", programData.referredTo);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,"referralDate", programData.refDate),"Could not enter referral date; More Details :" + programData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + programData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "PatientContactList")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllPrograms(Selenium selenium){
		boolean programsDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//a[contains(text(),'Delete')]", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]") > 0){
				caseCount = (Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");
				assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"could not click"
						+ "",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could npot click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]")){
					programsDeleted = false;
					break;
				}
			}
			return programsDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return programsDeleted;
	}
	/**
	 * verifySelectOptionsInProgram
	 * function to verify select option in the pick lists of Programs
	 * @since  	    July 05, 2012
	 */	
	public boolean verifySelectOptionsInProgram(Selenium selenium, HomeLib programData){
		boolean returnValue=false;
		try{		
			 selectValueFromAjaxList(selenium,"suggestBox", programData.program);
				selenium.clickAt("suggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(programData.program))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;	
			 selectValueFromAjaxList(selenium,"referralSourcesuggestBox", programData.refFrom);
			 selenium.clickAt("referralSourcesuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(programData.refFrom))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;	
			 selectValueFromAjaxList(selenium,"referredTosuggestBox", programData.referredTo);
			 selenium.clickAt("referredTosuggestBox","");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.item-selected"))
				{
					if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(programData.referredTo))
						if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
						{
							returnValue=true;
							click(selenium,"css=div.item-selected");
						}
				}
				else
					return false;	
			 
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());		
			return false;
		}
		return returnValue;
	}



	/**
	 * createReferral
	 * function to create a Referral
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createReferral(Selenium selenium, HomeLib refData){
		
		try{		
			
			selectValueFromAjaxList(selenium,"referralTypesuggestBox", refData.refType);
			
			selectValueFromAjaxList(selenium,"referredFromsuggestBox", refData.refBy);
			
			waitForElementToEnable(selenium,"addresssuggestBox");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"addresssuggestBox", refData.addr);
			
			selectValueFromAjaxList(selenium,"referredTosuggestBox", refData.refTo);
			
			selectValueFromAjaxList(selenium,"referralSpecialtysuggestBox", refData.speciality);
			
			if(refData.testCaseId.equalsIgnoreCase("TC_CRL_007")){
				selenium.clickAt("referralDiagnosessuggestBox", "");
				waitForPageLoad(selenium);
				click(selenium, "//div[20]");
			}else
				selectValueFromAjaxList(selenium,"referralDiagnosessuggestBox", refData.diagCode);
			
			assertTrue(type(selenium,"referralReason",refData.referralReason),"Could not enter the referral Reason; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"referralDate", refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"referralEndDate",refData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"referralComments",refData.refComments),"Could not enter referral Comments; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,"addAuthorizationButton"),"Could not click on add Authorization Button; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"payerSuggestBox1suggestBox", refData.payer);
			assertTrue(type(selenium,"numVisits1",refData.numVisits1),"Could not enter numVisits1; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"numVisitTypeSuggestBox1suggestBox",refData.numVisitType);
			//Assert.assertTrue(type(selenium,"numVisitTypeSuggestBox1suggestBox",refData.numVisitType),"Could not enter numVisits Type; More Details :" + refData.toString());
			waitForElementToEnable(selenium,"requestDate1");
			waitForPageLoad(selenium);
			click(selenium,"requestDate1");
			assertTrue(enterDate(selenium,"requestDate1",refData.requestDate2),"Could not enter the request Date; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"approvalDate1");
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"approvalDate1"),"could not type",selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"approvalDate1",refData.approvalDate2),"Could not enter the approvalDate; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"authorizationNum1",refData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,"numAuthorizedVisits1",refData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"startDate1",refData.startDate2),"Could not enter the start Date; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"endDate1",refData.endDate2),"Could not enter the end Date; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"cptSuggestBox1-1suggestBox", refData.cptSuggestBox2);
			
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "!patientReferralList")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createReferralWithMandatory
	 * function to create a Referral
	 * @since  	     May 08, 2012
	 */	
	public boolean createReferralWithMandatory(Selenium selenium, HomeLib refData){
		
		try{		
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referralTypesuggestBox", refData.refType);
			
			selectValueFromAjaxList(selenium,"referredFromsuggestBox", refData.refBy);
			
			selectValueFromAjaxList(selenium,"referralDiagnosessuggestBox", refData.diagCode);
			
			assertTrue(enterDate(selenium,"referralDate", refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "!patientReferralList")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * deleteAllReferral
	 * function to delete All Referral
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllReferral(Selenium selenium){
		boolean referralDeleted = true;
		int referralCount = 0;
		try{
			waitForElement(selenium, "//div[@id='ReferralList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='ReferralList']/table/tbody/tr/td[3]/div/a") > 0){
				referralCount = (Integer) selenium.getXpathCount("//div[@id='ReferralList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='ReferralList']/table/tbody/tr/td[3]/div/a"),"could not click",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(referralCount == (Integer) selenium.getXpathCount("//div[@id='ReferralList']/table/tbody/tr/td[3]/div/a")){
					referralDeleted = false;
					break;
				}
			}
			return referralDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return referralDeleted;
	}
	
	/**
	 * verifySelectOptionsInReferral
	 * function to verify select options a Referral
	 * @since  	     July 05, 2012
	 */	
	public boolean verifySelectOptionsInPatientReferral(Selenium selenium, HomeLib refData){
		boolean returnValue=false;
		try{		
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referralTypesuggestBox", refData.refType);
			selenium.clickAt("referralTypesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.refType))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"referredFromsuggestBox", refData.refBy);
			selenium.clickAt("referredFromsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.refBy))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"addresssuggestBox", refData.addr);
			selenium.clickAt("addresssuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.addr))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"referredTosuggestBox", refData.refTo);
			selenium.clickAt("referredTosuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.refTo))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			/*selectValueFromAjaxList(selenium,"referralSpecialtysuggestBox", refData.speciality);
			selenium.clickAt("referralSpecialtysuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.speciality))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	*/
			
			selectValueFromAjaxList(selenium,"referralDiagnosessuggestBox", refData.diagCode);
			selenium.clickAt("referralDiagnosessuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.diagCode))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,"numVisitTypeSuggestBox1suggestBox", refData.numVisitType);
			selenium.clickAt("referralDiagnosessuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.numVisitType))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,"cptSuggestBox0-1suggestBox", refData.cptSuggestBox2);
			/*selenium.clickAt("referralSpecialtysuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(refData.cptSuggestBox2))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			waitForPageLoad(selenium);*/
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		}
		return returnValue;
	}


	public boolean isTextPresent(Selenium selenium,String ajaxElementName) {
		boolean present = selenium.isElementPresent(ajaxElementName);
		int wait = WAIT_TIME;
		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		while(!present && wait > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait -= 500;
			present = selenium.isTextPresent(ajaxElementName);
		}
		return present;
	}
	
	
	public boolean SearchPrescribeMed_smoke(Selenium selenium, SmokeTestLib prescribeData) throws IOException{
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();
		}
		
	//	selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
	//	waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,"link=Edit"),"Element not present",selenium, ClassName, MethodName);
		assertTrue(click(selenium,"link=Edit"),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		// For proceed Anyway Condition
		if ((!isElementPresent(selenium, btnOverride))&& isElementPresent(selenium, btnCancelButton)){
			assertTrue(click(selenium, btnCancelButton),
					"Could not Click Proceed Anyway button"+ prescribeData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}

		
		
		return true;
	
    }
	
	
	public boolean searchPharmacy(Selenium selenium, SmokeTestLib searchData,String userAccount) throws IOException{
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click ",selenium, ClassName, MethodName);
		
			if(userAccount.equalsIgnoreCase(CAAccount)){
				 searchData.zipcode="L3R 8H3";
			}
			else
			{
				 searchData.zipcode="10005";			}
		    waitForPageLoad(selenium);
		    waitForPageLoad(selenium);
		    assertTrue(click(selenium,"searchDatabase"), "" + "Could not click the Search Database button expected", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    waitForPageLoad(selenium);
		    assertTrue(type(selenium,"distance",searchData.searchWithinKM), "" + "Could not type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkSearchwithin),"Could no click the radio button: More details"+ searchData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"fromZipradio"),"Could no click the radio button: More details"+ searchData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"fromZipText",searchData.zipcode),"Could not type zip code;More Details:"+searchData.toString(),selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,"searchPharmacy"),"Could not click searchPharmacy button"+searchData.toString(),selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			
			
			return true;	
	    }
	
	
	/**
	 * goToClinicalLists
	 * Function to go to clinical Lists
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 21,2012
	 */
	public boolean goToClinicalLists(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "clinicalListsAction"), "Could not click on Clinical Lists", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "!advancedPatientSearchList"), "Could not click on custom Lists", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		if(isElementPresent(selenium, "addIdentifierType"))
			return true;
		else
			return false;
		}
	
	
	/**
	 * searchWithAll
	 * function to search with all search types
	 * @since  	    Nov 27, 2012
	 */	
	int possition=1;
	public boolean searchWithAll(Selenium selenium,SmokeTestLib searchData, String userAccount){
		
		try
		{
			if(searchData.testCaseId.equals("TC_VSA_003")){
				assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox", searchData.searchType1);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox", searchData.durationCondition1);
				assertTrue(type(selenium, String.valueOf(possition)+"excludedurationIntegerMaxTextBox", searchData.year1), "Could not enter minimum year",selenium, ClassName, MethodName);
			}
			
			else if(searchData.testCaseId.equals("TC_VSA_002")){
				assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox", searchData.searchType1);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox", searchData.durationCondition1);
				assertTrue(type(selenium, String.valueOf(possition)+"ordurationIntegerMaxTextBox", searchData.year1), "Could not enter minimum year",selenium, ClassName, MethodName);
			}
			else if(searchData.testCaseId.equals("TC_VSA_001")){
				assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox", searchData.searchType1);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox", searchData.durationCondition1);
				assertTrue(type(selenium, String.valueOf(possition)+"anddurationIntegerMax", searchData.year1), "Could not enter minimum year",selenium, ClassName, MethodName);
			}
			
			
			
			possition = possition+1;
			if(searchData.testCaseId.equals("TC_VSA_003")){
				assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType2);
			}
			
			else if(searchData.testCaseId.equals("TC_VSA_002")){
				assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType2);
			}
			else if(searchData.testCaseId.equals("TC_VSA_001")){
				assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType2);
			}
		
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,searchData.sex);
			possition = possition+1;
			if(searchData.testCaseId.equals("TC_VSA_003")){
				assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType3);
			}
			
			else if(searchData.testCaseId.equals("TC_VSA_002")){
				assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType3);
			}
			else if(searchData.testCaseId.equals("TC_VSA_001")){
				assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType3);
			}
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxPblmDiag1,searchData.prescribe);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxTimeCondtion,searchData.timeCondition1);
			
			possition = possition+1;
			
			if(searchData.testCaseId.equals("TC_VSA_003")){
				assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType4);
				waitForPageLoad(selenium);
			}
			
			else if(searchData.testCaseId.equals("TC_VSA_002")){
				assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType4);
				waitForPageLoad(selenium);
			}
			else if(searchData.testCaseId.equals("TC_VSA_001")){
				assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType4);
				waitForPageLoad(selenium);
			}
			
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='allergySuggestBox'])[4]",searchData.allergenCA);
				waitForPageLoad(selenium);
			}
			else{
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='allergySuggestBox'])[4]",searchData.allergen);
				waitForPageLoad(selenium);
		    }	
			
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[4]",searchData.timeCondition2);
			waitForPageLoad(selenium);
			
			possition = possition+1;
			
			if(searchData.testCaseId.equals("TC_VSA_003")){
				assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType5);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition2);
			}
			
			else if(searchData.testCaseId.equals("TC_VSA_002")){
				assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType5);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition2);
			}
			else if(searchData.testCaseId.equals("TC_VSA_001")){
				assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType5);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition2);
			}
			
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='labResultNameSuggestBoxsuggestBox'])[5]",searchData.labResult);
			waitForPageLoad(selenium);
		
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,"//div[5]/div/div/div/div[8]/div[2]/input[2]")){
			assertTrue(type(selenium, "//div[5]/div/div/div/div[8]/div[2]/input[2]", searchData.year2), "Could not enter minimum year",selenium, ClassName, MethodName);
			}else
				assertTrue(type(selenium, txtAftyear4, searchData.year2), "Could not enter minimum year",selenium, ClassName, MethodName);

				
			//selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div[8]/div[2]/input[2]",searchData.year2);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[5]",searchData.timeCondition3);
			
			possition = possition +1;
			if(searchData.testCaseId.equals("TC_VSA_003")){
				assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType6);
				waitForPageLoad(selenium);
			}
			
			else if(searchData.testCaseId.equals("TC_VSA_002")){
				assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType6);
				waitForPageLoad(selenium);
			}
			else if(searchData.testCaseId.equals("TC_VSA_001")){
				assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType6);
				waitForPageLoad(selenium);
			}
			
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='medicationSuggestBox'])[6]",searchData.medicalCA);
				waitForPageLoad(selenium);
				
		    }
			else{
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='medicationSuggestBox'])[6]",searchData.medical);
				waitForPageLoad(selenium);
		    }	
			
			
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[6]",searchData.timeCondition4);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		catch(Exception e)
		
		{Assert.fail("Failed due to Exception");
			
		}
		return false;
	
	}
	
	
	/**
	 *deleteAllergy
	 * function to delete  Allergy
	 * @throws IOException 
	 * @since  	    Oct 17, 2012
	 */	
	public boolean deleteAllAllergy(Selenium selenium ,SmokeTestLib allergyData){
		boolean historyDeleted=true;
		int historyCount=0;
		try{
			assertTrue(click(selenium,"includeInactivecheckbox"),"Could not click the show All recorded check box;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium,btnDeleteAllergy, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnDeleteAllergy) > 0){
				historyCount=(Integer) selenium.getXpathCount(btnDeleteAllergy);
				assertTrue(click(selenium,btnDeleteAllergy),"",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, allergyData.reason), "Could not type reason for deletion",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click Delete button;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(historyCount == (Integer) selenium.getXpathCount(btnDeleteAllergy)){
					historyDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyDeleted;
	}

	
	/**
	 * createAllergy
	 * function to create Allergy
	* @since  	    Sep 27, 2012
	 */	
	
	public boolean createAllergy(Selenium selenium,SmokeTestLib allergyData, String userAccount){
		try{
			if(allergyData.testCaseId.equals("TC_CA_004")){
				assertTrue(click(selenium,"//div[6]/div[2]/div/div/span[2]/input"),"Could not Intolernce radio button;More Details",selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxSearchAllergy,allergyData.allergenCA);
				waitForPageLoad(selenium);
		    }
			else{
				selectValueFromAjaxList(selenium,ajxSearchAllergy,allergyData.allergen);
				waitForPageLoad(selenium);
			}	
			
			
			
			selectValueFromAjaxList(selenium,"allergyReactionsuggestBox",allergyData.reaction);
			
			if(!allergyData.testCaseId.equals("TC_CA_001")){
				if(getText(selenium, lnkAllShowmore).equalsIgnoreCase("Show more details")){
					assertTrue(click(selenium,lnkAllergyShowmore),"Could not on show more button",selenium, ClassName, MethodName);
				}
				selectValueFromAjaxList(selenium,"severitysuggestBox",allergyData.severity);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",allergyData.status);
				assertTrue(click(selenium, "reactionLink"),"Could not on show more button",selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "1checkboxAllergyReaction"),	"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "multiSelectionCloseButton"),"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(userAccount.equalsIgnoreCase(CAAccount)){
					Calendar calCA=Calendar.getInstance();
					SimpleDateFormat DateFormatCA=new SimpleDateFormat("dd/MM/yyyy");
					String dateCA=DateFormatCA.format(calCA.getTime());
					assertTrue(enterDate(selenium,txtOnset,dateCA),"Could not enter the Admin on ;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
					
			    }
				else{
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
					String date=DateFormat.format(cal.getTime());
					assertTrue(enterDate(selenium,txtOnset,date),"Could not enter the Admin on ;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
					
			    }	
				
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"lifeStagesuggestBox",allergyData.lifeStage);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtcomment,allergyData.comment),"Could not enter the comment;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
			}if(allergyData.testCaseId.equalsIgnoreCase("TC_CA_005")){
				assertTrue(click(selenium,"xpath=(//button[@id='cancel'])[2]"),"Could not click the cancel button;More details:"+allergyData.toString(),selenium, ClassName, MethodName);
			}else
				assertTrue(click(selenium,"add"),"Could not click the add button;More details:"+allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *deleteSocialHistoryForEncounter
	 * function to delete FamilyHistory
	 * @since  	    Oct 04, 2012
	 */	
	public boolean deleteSocialHistoryForEncounter(Selenium selenium ,SmokeTestLib historyData){
		boolean historyDeleted=true;
		int historyCount=0;
		try{
			
			waitForElement(selenium,"//div[7]/div/div/span/span/span", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[7]/div/div/span/span/span") > 0){
				historyCount=(Integer) selenium.getXpathCount("//div[7]/div/div/span/span/span");
				assertTrue(click(selenium,"//div[7]/div/div/span/span/span"),"",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"delete"),"Could not click the delete button;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYes),"Could not click Yes button;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
				/*Assert.assertTrue(type(selenium,txtdeleteReason,historyData.reason),"Could not type the reason");
				waitForPageLoad(selenium);
				Assert.assertTrue(click(selenium,"//div[3]/span/button"));*/
				waitForPageLoad(selenium);
				if(historyCount == (Integer) selenium.getXpathCount("//div[7]/div/div/span/span/span")){
					historyDeleted = false;
					break;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyDeleted;
	}

	/**
	 * createSocialHistory
	 * function to create SocialHistory
	 * @since  	    Sep 28, 2012
	 */	
	
	public boolean createSocialHistory(Selenium selenium,SmokeTestLib proData){
		try{
			selectValueFromAjaxList(selenium,ajxType,proData.type);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",proData.status);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			if(proData.testCaseId.equals("TC_CSH_002") ||proData.testCaseId.equals("TC_CSH_003")){
			assertTrue(click(selenium,"//div[5]/div[3]/div[2]/div/div"),"Could not on show more button",selenium, ClassName, MethodName);
			assertTrue(type(selenium,"item",proData.item),"Could not enter the item;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDetailsNumBox,proData.detailsNum),"Could not enter the details Num ;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDetailsSmallBox,proData.detailsText),"Could not enter the details Text ;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPeriod,proData.period);
			assertTrue(type(selenium,txtYear,proData.year),"Could not enter the details year ;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtStartAge,proData.startAge),"Could not enter the start age ;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxStopped,proData.historyType);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			if(isElementPresent(selenium,"//body/div[5]/div/div/div/div/div[2]")){
			click(selenium,"//body/div[5]/div/div/div/div/div[2]");
			}
			if(isElementPresent(selenium,"//body/div[4]/div/div/div/div/div")){
				click(selenium,"//body/div[5]/div/div/div/div/div[2]");
			}
			selectValueFromAjaxList(selenium,ajxLifeStage,proData.lifeStage);
			click(selenium,"//body/div[5]/div/div/div/div/div[2]");
			if(isElementPresent(selenium,"//body/div[5]/div/div/div/div/div[2]")){
				click(selenium,"//body/div[5]/div/div/div/div/div[2]");
			}
			assertTrue(type(selenium,txtcomment,proData.comment),"Could not enter the comment;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			}
			if(proData.testCaseId.equals("TC_CSH_003")||proData.testCaseId.equals("TC_CSH_005")){
				assertTrue(click(selenium,"xpath=(//button[@id='save'])[2]"),"Could not click the save button;More details:"+proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			if(proData.testCaseId.equals("TC_CSH_004")){
				assertTrue(click(selenium,"xpath=(//button[@id='cancel'])[2]"),"Could not click the Cancel button;More details:"+proData.toString(),selenium, ClassName, MethodName);
				return true;
			}
			assertTrue(click(selenium,"add"),"Could not click the add button;More details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			return true;
			}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	
	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, HomeLib patientData,SmokeTestLib searchData ){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstname,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			if(searchData.testCaseId.equals("TC_VSS_001") || searchData.testCaseId.equals("TC_SWC_001")||searchData.testCaseId.equals("TC_SWC_002")|| searchData.testCaseId.equals("TC_SWC_003")||searchData.testCaseId.equals("TC_SWC_004")){
				selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox","Male");
			}
			if(searchData.testCaseId.equals("TC_VSS_002")){
				selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox","Female");
			}
			assertTrue(type(selenium, "dob", patientData.dob), "Could not type DOB",selenium, ClassName, MethodName);
			
			if(searchData.testCaseId.equals("TC_VSA_003")||searchData.testCaseId.equals("TC_VSS_003")){
				selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox","Female");
				assertTrue(type(selenium, "dob", "11/27/2000"), "Could not type DOB",selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			click(selenium,"backButton");
			assertTrue(click(selenium,"saveButton"),"Could not click Save button More Dateils"+patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	
	/**
	 * createNotes
	 * function to create a Notes
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createNotes(Selenium selenium,HomeLib noteData){
		try{
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium,"noteDate",noteData.notedate),"Could not enter date; More Details:"+noteData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"suggestBox",noteData.category);
			assertTrue(type(selenium,"note",noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+noteData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllNotes(Selenium selenium){
		boolean notesDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//div[@id='PatientNoteList']/table/tbody/tr/td[4]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientNoteList']/table/tbody/tr/td[4]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='PatientNoteList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientNoteList']/table/tbody/tr/td[4]/div/a"),"could not click",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click the button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientNoteList']/table/tbody/tr/td[4]/div/a")){
					notesDeleted = false;
					break;
				}
			}
			return notesDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notesDeleted;
	}
	
	/**
	 * createEnterPriseVariableNotes
	 * function to create EnterPrise Variable Notes
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariableNotes(Selenium selenium,HomeLib epData){
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.notesValue);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.notesType);
			
			type(selenium,"css=input.gwt-TextBox",epData.notesValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * enterPriseVariableNotes_UnitTest
	 * function to enterPriseVariableNotes_UnitTest
	 * @since  	    Aug 02, 2012
	 */	
	public boolean enterPriseVariableNotes_UnitTest(Selenium selenium,HomeLibUnitTest epData){
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.notesValue);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.notesType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.notesValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createIdentifiers
	 * function to create a Identifiers
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdentifier(Selenium selenium,HomeLib identifierData){
		try{
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,"groupsuggestBox",identifierData.group);
			
			selectValueFromAjaxList(selenium,"typesuggestBox",identifierData.type);
			
			
			assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(),selenium, ClassName, MethodName);
			/*if(identifierData.idType.contains("TestType1")){
				Assert.assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
			}*/
		    if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
			assertTrue(type(selenium,"expirationdate",identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(),selenium, ClassName, MethodName);
		    }
			assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * deleteAllIdentifersGroup
	 * function to deleteAllIdentifiersGroup
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiers(Selenium selenium){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a"),"could not click",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could npt click the button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caseDeleted;
	}
	/**
	 * createIdGroup
	 * function to create a createIdGroup
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdGroup(Selenium selenium,HomeLib identifierData){
		boolean caseDeleted = true;
		try{
			assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click on Identifier Group link:" + identifierData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int caseCount = 0;
			
				
				waitForElement(selenium, "//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
				while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a") > 0){
					caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a");
					assertTrue(click(selenium,"//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a"),"could not click the label",selenium, ClassName, MethodName);
					assertTrue(click(selenium,btnYes),"could not clicl button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a")){
						caseDeleted = false;
						break;
					}
				}
			assertTrue(click(selenium,"addIdentifierGroup"),"Could not click on Add Identifier Group link:" + identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,"groupFor",identifierData.groupFor);
			assertTrue(type(selenium,"group",identifierData.groupName),"Could not enter the group;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"description",identifierData.groupDescription),"Could not enter the group decription;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			if(identifierData.groupDefault.equals("yes")||identifierData.groupDefault.equals("Default")){
				assertTrue(click(selenium,"//span/input"),"Could not click the check box"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"addIdentifierGroup")){
				caseDeleted = true;
			}else{
				caseDeleted = false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caseDeleted;
		}

	/**
	 * deleteAllIdentifersGroup
	 * function to deleteAllIdentifiersGroup
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiersGroup(Selenium selenium){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a"),"could not click the button",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click the button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createIdGroupUnitTests
	 * function to create a createIdGroup
	  * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdGroupUnitTests(Selenium selenium,HomeLibUnitTest identifierData){
		try{
			
			assertTrue(click(selenium,"addIdentifierGroup"),"Could not click on Add Identifier Group link:" + identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,"groupFor",identifierData.groupFor);
			assertTrue(type(selenium,"group",identifierData.groupName),"Could not enter the group;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"description",identifierData.groupDescription),"Could not enter the group decription;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			if(identifierData.groupDefault.equals("yes")||identifierData.groupDefault.equals("Default")){
				assertTrue(click(selenium,"//span/input"),"Could not click the check box"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"addIdentifierGroup")){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		}
	/**
	 * createIdType 
	 * function to create a Id Type
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdType(Selenium selenium,HomeLib identifierData){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			assertTrue(click(selenium,"!adminIdentifierTypeList"),"Could not click on Identifier Group link:" + identifierData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium, "//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a"),"could not click ",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			assertTrue(click(selenium,"addIdentifierType"),"Could not click on Add Identifier Type link:" + identifierData.toString(),selenium, ClassName, MethodName);
			
			select(selenium,"groupFor",identifierData.groupFor);
		
			selectValueFromAjaxList(selenium, "suggestBox",identifierData.idGroup);
			
			assertTrue(type(selenium,"type",identifierData.idType),"Could not enter the group;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"description",identifierData.typeDescription),"Could not enter the group decription;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			if(!identifierData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"identifier",identifierData.identifier),"Could not enter the identifier;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,"addID"),"Could not click on add button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
			}
			type(selenium,"mask",identifierData.idTypeMask);
			if(identifierData.restricted.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='restricted']/input"),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			if(identifierData.expDate.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='endDateRequired']/input"),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			
			if(identifierData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='defaultType']/input"),"Could not click the defaultType check box;More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "addIdentifierType")){
				caseDeleted= true;
			}else{
				caseDeleted= false;
			}
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caseDeleted;
		}

	/**
	 * createIdTypeUnitTests
	 * function to create a Id Type
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdTypeUnitTests(Selenium selenium,HomeLibUnitTest identifierData){
		try{
			
			assertTrue(click(selenium,"addIdentifierType"),"Could not click on Add Identifier Type link:" + identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,"groupFor",identifierData.groupFor);
		
			selectValueFromAjaxList(selenium, "suggestBox",identifierData.idGroup);
		
			assertTrue(type(selenium,"type",identifierData.idType),"Could not enter the group;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"description",identifierData.typeDescription),"Could not enter the group decription;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
			if(!identifierData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"identifier",identifierData.identifier),"Could not enter the identifier;More details:"+identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,"addID"),"Could not click on add button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
			}
			type(selenium,"mask",identifierData.idTypeMask);
			if(identifierData.restricted.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='restricted']/input"),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			if(identifierData.expDate.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='endDateRequired']/input"),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			
			if(identifierData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='defaultType']/input"),"Could not click the defaultType check box;More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "addIdentifierType")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		}
	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiersTypes(Selenium selenium){
		boolean identiferDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a"),"could not click",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a")){
					identiferDeleted = false;
					break;
				}
			}
			return identiferDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * verifySelectOptionIdentifiers
	 * function to create a Identifiers
	 * @since  	     July 06 , 2012
	 */	
	
	public boolean verifySelectOptionIdentifiers(Selenium selenium,HomeLib identifierData){
		boolean returnValue=false;
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"groupsuggestBox",identifierData.group);
			selenium.clickAt("groupsuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(identifierData.group))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,"typesuggestBox",identifierData.type);
			selenium.clickAt("typesuggestBox","");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=div.item-selected"))
			{
				if(getText(selenium,"css=div.item-selected").equalsIgnoreCase(identifierData.type))
					if(isElementPresent(selenium,"css=div.gwt-PopupPanel.localizedSuggestBoxOracle"))
					{
						returnValue=true;
						click(selenium,"css=div.item-selected");
					}
			}
			else
				return false;
			
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		return returnValue;
		}

	
	/**
	 * editIdentifiers
	 * function to edit Identifiers
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean editIdentifiers(Selenium selenium,HomeLib identifierData){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"suggestBox",identifierData.group);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]",identifierData.type);
			/*if(identifierData.idType.contains("TestType1")){
				Assert.assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
			}
			    if(identifierData.idType.equalsIgnoreCase("TestType2")){
				
				Assert.assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
				Assert.assertTrue(enterDate(selenium,"expirationdate",identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString());
			}*/
			
			if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
				assertTrue(type(selenium,"expirationdate",identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(),selenium, ClassName, MethodName);
			 }assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifierData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		}





	
	
	/**
	 * createHousehold
	 * function to create Household
	 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createHousehold(Selenium selenium,HomeLib householdData){
		try{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=div.gwt-TabBarItem.rightTab > div.gwt-HTML"),"could not click search patients button; More Details:"+householdData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"familyMemberSearchBox",householdData.searchpatient),"Could not enter patientID ; More Details :"+householdData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,"search"),"could not click search button; More Details:"+householdData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//div[2]/div/span/input"),"could not click the check box; More Details:"+householdData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + householdData.toString());		
				return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * createReferral_UnitTest
	 * function to create a new patient check-in for unit Test
	 * @since  	    May 24, 2012
	 */	
	public boolean createReferral_UnitTest(Selenium selenium, HomeLibUnitTest refferalTestData){
		boolean returnValue = false;
		try{		
			selectValueFromAjaxList(selenium,"referralTypesuggestBox", refferalTestData.refType);
			selectValueFromAjaxList(selenium,"referredFromsuggestBox", refferalTestData.refBy);
			/*waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"addresssuggestBox");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"addresssuggestBox", refferalTestData.addr);*/
			selectValueFromAjaxList(selenium,"referredTosuggestBox", refferalTestData.refTo);
			selectValueFromAjaxList(selenium,"referralSpecialtysuggestBox", refferalTestData.speciality);
			selectValueFromAjaxList(selenium,"referralDiagnosessuggestBox", refferalTestData.diagCode);
			if(waitForElement(selenium, "id=errorCloseButton", 5000)){
				selenium.click("id=errorCloseButton");
			}
			assertTrue(type(selenium,"referralReason",refferalTestData.referralReason),"Could not enter the referral Reason; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"referralDate", refferalTestData.referralDate),"Could not enter referral date; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"referralEndDate",refferalTestData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"referralComments",refferalTestData.refComments),"Could not enter referral Comments; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,"addAuthorizationButton"),"Could not click on add Authorization Button; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"payerSuggestBox1suggestBox",refferalTestData.payer);
			assertTrue(type(selenium,"numVisits1",refferalTestData.numVisits1),"Could not enter numVisits1; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"numVisitTypeSuggestBox1suggestBox",refferalTestData.numVisitType);
			assertTrue(enterDate(selenium,"requestDate1",refferalTestData.requestDate2),"Could not enter the request Date; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"approvalDate1",refferalTestData.approvalDate2),"Could not enter the approvalDate; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"authorizationNum1",refferalTestData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"numAuthorizedVisits1",refferalTestData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"startDate1",refferalTestData.startDate2),"Could not enter the start Date; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,"endDate1",refferalTestData.endDate2),"Could not enter the end Date; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"cptSuggestBox1-1suggestBox", refferalTestData.cptSuggestBox2);
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refferalTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refferalTestData.toString());		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createIdType
	 * function to create an Identifier Group.
	 
	 * @since  	     May 17, 2012
	 */	
	public boolean createIdentifierType(Selenium selenium, HomeLib idTypeData) {
		
		try{
			selectValueFromAjaxList(selenium,"groupFor",idTypeData.groupFor);
			selectValueFromAjaxList(selenium, "suggestBox",idTypeData.idGroup);
			assertTrue(type(selenium,"type",idTypeData.idType),"Could not enter the group;More details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"description",idTypeData.typeDescription),"Could not enter the group decription;More details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			if(!idTypeData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"identifier",idTypeData.identifier),"Could not enter the identifier;More details:"+idTypeData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,"addID"),"Could not click on add button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
			}
			type(selenium,"mask",idTypeData.idTypeMask);
			if(idTypeData.restricted.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='restricted']/input"),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			if(idTypeData.expDate.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='endDateRequired']/input"),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			
			if(idTypeData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='defaultType']/input"),"Could not click the defaultType check box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "//a[contains(text(),'Edit')]")){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createIdType
	 * function to create an Identifier Group.
	 * @since  	     May 17, 2012
	 */	
	public boolean createIdentifierGroup(Selenium selenium, HomeLib idGroupData){
		try{
			select(selenium,"groupFor",idGroupData.groupFor);
			assertTrue(type(selenium,"group",idGroupData.idGroup),"Could not enter the group;More details:"+idGroupData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"description",idGroupData.groupDescription),"Could not enter the group decription;More details:"+idGroupData.toString(),selenium, ClassName, MethodName);
			//select(selenium,"status",idGroupData.groupFor);
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idGroupData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "//a[contains(text(),'Edit')]")){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createExternalProvider
	 * function to create an External Provider
	 * @since  	    May 17, 2012
	 */	
	public boolean createExternalProvider(Selenium selenium,HomeLib  providerData) {
		
		try{
			String referringCodeUnique=null;
			Random rg = new Random(); 
		    for (int idx = 17000; idx <= 18000; ++idx){
		      int random = rg.nextInt(18000); 
		      referringCodeUnique =Integer.valueOf(random).toString();
		    }
			assertTrue(type(selenium,"referringCode",referringCodeUnique),"Could not type referring code; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type last name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstname,providerData.firstName),"Could not type first name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"specialtySuggestBoxIdsuggestBox",providerData.specialty);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[2]/div/input",providerData.epstreet11),"Could not type street name1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[3]/div/input",providerData.epstreet12),"Could not type street name2; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[4]/div/input",providerData.epcity1),"Could not type city name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/input",providerData.epstate1);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[6]/div/input",providerData.epzipcode1),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			click(selenium,"noButton");			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div[7]/div/div/div/div/input",providerData.epcountry1);
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    if(isElementPresent(selenium, "css=button.floatRight.marginBottom10")){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean createAddressBook(Selenium selenium, HomeLib refByData) {
		try{
			if(refByData.contactLevel.equalsIgnoreCase("Global"))
			{
				assertTrue(click(selenium,"//span/input"), "could not click contact level",selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium,"//span[2]/input"), "could not click contact level",selenium, ClassName, MethodName);
			}
				
			selectValueFromAjaxList(selenium, "contactTypesuggestBox", refByData.contactType);
			
			assertTrue(type(selenium, "addressBookContactCompany", refByData.contactCompany),"Could not Enter the Company;More Details:"+refByData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitle,refByData.salutation);
			
			assertTrue(type(selenium, "addressBookLastName", refByData.lastName),"Could not enter Last Name; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookFirstName", refByData.firstName),"Could not enter First Name; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookMiddleName",refByData.middleName),"Could not enter the Middle name;More Details:"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "xpath=(//input[@type='text'])[10]",refByData.jobTitle),"Could not Enter the Job Name;More Details"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookDepartment", refByData.department),"Could not enter Department; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "id=commType1suggestBox",refByData.telephoneType1);
			assertTrue(type(selenium, "addressBookPrimaryPhone", refByData.telephoneNo1),"Could not enter primary phone number; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookPrimaryPhoneExt", refByData.telephoneextnNo1),"Could not enter primary extn number; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			/*selectValueFromAjaxList(selenium, "id=commType2suggestBox",providerData.telephoneType2);
			Assert.assertTrue(type(selenium, "addressBookSecondaryPhone", providerData.telephoneNo2),"Could not enter secondary  Phone number; More Details:" + providerData.toString());
			Assert.assertTrue(type(selenium, "addressBookSecondaryPhoneExt", providerData.telephoneextnNo2),"Could not enter secondary extn number; More Details:" + providerData.toString());
			selectValueFromAjaxList(selenium, "id=commType3suggestBox",providerData.telephoneType3);
			Assert.assertTrue(type(selenium, "addressBookTertiaryPhone", providerData.telephoneNo3),"Could not enter tertiary number; More Details:" + providerData.toString());
			Assert.assertTrue(type(selenium, "addressBookTertiaryPhoneExt", providerData.telephoneextnNo3),"Could not enter tertiary extn number; More Details:" + providerData.toString());
			*/assertTrue(type(selenium, "addressBookAddress1",refByData.address1),"Could not enter the Street1;More Details:"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookAddress2",refByData.address2),"Could not enter the Street2;More Details:"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookCity", refByData.city),"Colud not enter the city;More Details"+refByData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "addressBookStatesuggestBox",refByData.state);
			assertTrue(type(selenium, "addressBookZipCode", refByData.zipcode),"Could not enter Zip; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			selenium.keyPress("addressBookCountrysuggestBox", "\\9");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			//Assert.assertTrue(click(selenium,btnYes),"Could not click the yes button;More Details"+providerData.toString());
			selectValueFromAjaxList(selenium, "addressBookCountrysuggestBox",refByData.country);
			
			assertTrue(type(selenium, "addressBookEmail",refByData.email),"Could not Enter the Mail;More Details:"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "addressBookWebAddress",refByData.webAddress),"Could not enter the Web Address;Mor Details"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, "comments",refByData.comments),"Could not type the Comments; More Details"+refByData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, "addressBookSave"),"Could not find save button; More Details:" + refByData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			if(isElementPresent(selenium, "//td[2]/div/div/div/div")){
				return true;
			}else{
				return false;
				}
			}
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refByData.toString());
			return false;
		} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	/**
	 * createAddressBookWithMandatoryField
	 * function to create Address Book With Mandatory Field
	 * @since  	     May 21, 2012
	 */	
	public boolean enterPriseVariable_Addressbook(Selenium selenium, SystemSettingsLib epData){
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.contactValue);
			click(selenium,"xpath=(//button[@type='button'])[2]");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.contactType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",epData.contactValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createMandatoryUserfields
	 * function to create Mandatory User fields
	 * @throws IOException 
	 * @since  	     May 21, 2012
	 */	
	public boolean createMandatoryUserfields(Selenium selenium, HomeLibUnitTest mandatoryData) throws IOException {
		try{
			selectValueFromAjaxList(selenium,"unitsuggestBox",mandatoryData.unit);
			
			selectValueFromAjaxList(selenium,"fieldsuggestBox",mandatoryData.field);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+mandatoryData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//td[2]/div/div/div/div")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + mandatoryData.toString());
			return false;
		}
	}
	
	/**
	 * createMandatoryUserfields
	 * function to create Mandatory User fields
	 * @since  	    Jun	20, 2012
	 */	
	
	public boolean auditLog(Selenium selenium,HomeLib auditData ){
		try{
			selectValueFromAjaxList(selenium,"filterUserssuggestBox",auditData.filter);
			
			selectValueFromAjaxList(selenium,"filterActivitysuggestBox",auditData.filterActivity);
			
			assertTrue(click(selenium,"search"),"Could not click the search button;More Details:"+auditData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"filterUserssuggestBox")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + auditData.toString());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * createSocioEconomicCAView
	 * function to create a Socio EconomicCA view
	 * @since  	    june 20, 2012
	 */	
	public boolean createSocioEconomicCAView(Selenium selenium, HomeLib socioEconomicData){
		try{	
			selectValueFromAjaxList(selenium,"racesuggestBox",socioEconomicData.race);
			
			selectValueFromAjaxList(selenium,"ethnicitysuggestBox",socioEconomicData.ethnicity);
			
			selectValueFromAjaxList(selenium,"religionsuggestBox",socioEconomicData.religion);
			
			selectValueFromAjaxList(selenium,"citizenshipsuggestBox",socioEconomicData.citizenship);
			
			selectValueFromAjaxList(selenium,"countrysuggestBox",socioEconomicData.countryPanel);
			
			selectValueFromAjaxList(selenium,"spokenLanguagesuggestBox",socioEconomicData.languagePanel);
			
			assertTrue(enterDate(selenium,"dateOfArrival",socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"officialLangsuggestBox",socioEconomicData.officialLanguage);
			
			selectValueFromAjaxList(selenium,"languageSpokensuggestBox",socioEconomicData.languagespoken);
			
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("YES")){
				if(!isChecked(selenium,"interpreterRequiredcheckbox")){
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterService",socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}else{
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterService",socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}
				}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium,"interpreterRequiredcheckbox"))
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,"parentEthnicitysuggestBox",socioEconomicData.parentEthnicityPanel);
			
			selectValueFromAjaxList(selenium,"livingArrangementsuggestBox",socioEconomicData.livingArrangement);
			
			selectValueFromAjaxList(selenium,"studentStatussuggestBox",socioEconomicData.studentStatus);
			
			selectValueFromAjaxList(selenium,"educationLevelsuggestBox",socioEconomicData.educationLevel);
			
			selectValueFromAjaxList(selenium,"householdIncomesuggestBox",socioEconomicData.householdIncome);
			
			assertTrue(type(selenium,"numPeopleText",socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"householdCompositionsuggestBox",socioEconomicData.householdComposition);
			
			if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("Yes")){
				if(!isChecked(selenium,"homelessIndCheckboxcheckbox"))
					assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			}else if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("No")){
				if(isChecked(selenium,"homelessIndCheckboxcheckbox"))
					assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,"homelesssuggestBox",socioEconomicData.homelessStatus);
			
			assertTrue(check(selenium,"povertycheckbox"),"Could not check at risk population"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"ageGroupsuggestBox",socioEconomicData.ageGroupIndicator);
			
			selectValueFromAjaxList(selenium,"employmentsuggestBox",socioEconomicData.employmentStatus);
			
			if(socioEconomicData.employmentStatus.equalsIgnoreCase("Employed")){
			selectValueFromAjaxList(selenium,"jobCodessuggestBox",socioEconomicData.jobCode);
			
			//Assert.assertTrue(type(selenium,"occupation",socioEconomicData.occupation),"Could not type occupation; More Details"+socioEconomicData.toString());
			}
			assertTrue(type(selenium,"comments",socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);

			if(isElementPresent(selenium, "!patientSocialHistory")){
				return true;
			}else{
				return false;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * editSocioEconomicCAView
	 * function to edit a Socio EconomicCA View
	 * @since  	    june 20, 2012
	 */	
	public boolean editSocioEconomicCAView(Selenium selenium, HomeLib socioEconomicData){
		
		try{	
			selectValueFromAjaxList(selenium,"racesuggestBox",socioEconomicData.race);
			selectValueFromAjaxList(selenium,"ethnicitysuggestBox",socioEconomicData.ethnicity);
			selectValueFromAjaxList(selenium,"religionsuggestBox",socioEconomicData.religion);
			selectValueFromAjaxList(selenium,"citizenshipsuggestBox",socioEconomicData.citizenship);
			selectValueFromAjaxList(selenium,"countrysuggestBox",socioEconomicData.countryPanel);
			selectValueFromAjaxList(selenium,"languageSpokensuggestBox",socioEconomicData.languagespoken);
			assertTrue(enterDate(selenium,"dateOfArrival",socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"officialLangsuggestBox",socioEconomicData.officialLanguage);
			selectValueFromAjaxList(selenium,"spokenLanguagesuggestBox",socioEconomicData.languagePanel);
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("YES")){
				if(!isChecked(selenium,"interpreterRequiredcheckbox")){
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterService",socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}else{
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,"interpreterService",socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
				}
				}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium,"interpreterRequiredcheckbox"))
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired,selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,"parentEthnicitysuggestBox",socioEconomicData.parentEthnicityPanel);
			selectValueFromAjaxList(selenium,"livingArrangementsuggestBox",socioEconomicData.livingArrangement);
			selectValueFromAjaxList(selenium,"studentStatussuggestBox",socioEconomicData.studentStatus);
			selectValueFromAjaxList(selenium,"educationLevelsuggestBox",socioEconomicData.educationLevel);
			selectValueFromAjaxList(selenium,"householdIncomesuggestBox",socioEconomicData.householdIncome);
			assertTrue(type(selenium,"numPeopleText",socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"householdCompositionsuggestBox",socioEconomicData.householdComposition);
			if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("Yes")){
				if(!isChecked(selenium,"homelessIndCheckboxcheckbox"))
					assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			}else if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("No")){
				if(isChecked(selenium,"homelessIndCheckboxcheckbox"))
					assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck,selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,"homelesssuggestBox",socioEconomicData.homelessStatus);
			assertTrue(check(selenium,"ruralcheckbox"),"Could not check at risk population"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"ageGroupsuggestBox",socioEconomicData.ageGroupIndicator);
			selectValueFromAjaxList(selenium,"employmentsuggestBox",socioEconomicData.employmentStatus);
			if(socioEconomicData.employmentStatus.equalsIgnoreCase("Employed")){
			selectValueFromAjaxList(selenium,"jobCodessuggestBox",socioEconomicData.jobCode);
			}
			assertTrue(type(selenium,"comments",socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(),selenium, ClassName, MethodName);

			if(isElementPresent(selenium, "!patientSocialHistory")){
				return true;
			}else{
				return false;
			}
		
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createPatientCAView
	 * function to create Patient CA View
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createPatientCAView(Selenium selenium, HomeLib patientData,String uniqueName){
		boolean returnValue = false;
		try{
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,"chartNumber",patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart ,selenium, ClassName, MethodName);
			
			if(!patientData.canadianProvince.isEmpty())
				if(!patientData.canadianProvince.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"canadianProvincesuggestBox",patientData.canadianProvince))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.canadianProvince);
			
			
			
			if(!patientData.hCN.isEmpty())
				if(!patientData.hCN.contains("N/A"))
					assertTrue(type(selenium, "healthcardNumber", uniqueName), "Could not Enter Hcn, Expected value to be typed" + patientData.hCN,selenium, ClassName, MethodName);
			
			if(!patientData.reason.isEmpty())
				if(!patientData.reason.contains("N/A"))
					if(!selectValueFromAjaxListUsingTypeKeys(selenium, "reasonSuggestBoxsuggestBox", patientData.reason))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.reason);
			
			if(!patientData.expireDate.isEmpty())
				if(!patientData.expireDate.contains("N/A"))
					assertTrue(enterDate(selenium, txtexpiryDate, patientData.expireDate), "Could not Enter expireDate , Expected value to be typed" + patientData.expireDate,selenium, ClassName, MethodName);			
			
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "primaryLocationSuggestBoxsuggestBox", patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, "responsibleProvPCPcheckbox"), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck,selenium, ClassName, MethodName);
			
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName,selenium, ClassName, MethodName);
			
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstname, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName,selenium, ClassName, MethodName);
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, "middleName", patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName,selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, "alias1", patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1,selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, "alias2", patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2,selenium, ClassName, MethodName);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
			click(selenium,"backButton");
			waitForPageLoad(selenium);
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, "dobEstimatedcheckbox"), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck,selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, "prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
							assertTrue(type(selenium, "prematureDuration", patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration,selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
								waitForPageLoad(selenium);
				}
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
						waitForPageLoad(selenium);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					assertTrue(enterDate(selenium, "statusDate", patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(),selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, "residentialAddr1", patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, "residentialAddr2", patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, "residentialCity", patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, "residentialZip", patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcountry.isEmpty())
				if(!patientData.residentialAddrcountry.contains("N/A"))
					selectValueFromAjaxList(selenium, "residentialCountrysuggestBox", patientData.residentialAddrcountry);
			/*if(!patientData.county.isEmpty())
				if(!patientData.county.contains("N/A"))
					Assert.assertTrue(type(selenium, "residentialCounty", patientData.county), "Could not Enter zip code, Expected value to be typed" + patientData.county);*/
			/*waitForPageLoad(selenium);
			selenium.keyPress("commType1SuggestBoxsuggestBox", "\\9");
			click(selenium,btnYes);
			waitForElementToEnable(selenium,"residentialCity");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"residentialStatesuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"countrysuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"residentialCounty");
			waitForPageLoad(selenium);*/
			
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, "primaryPhone", patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, "primaryPhoneExtension", patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, "ohterPhone1", patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, "otherPhone1Extension", patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, "otherPhone2", patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, "otherPhone2Extension", patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, "email", patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email,selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "//div[7]/div/div/div/div/div/div/input", patientData.contactPreferences))
						Assert.fail("Could not Enter contact preference, Expected value to be Select" + patientData.contactPreferences);
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressState);
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
					/*if(!patientData.mailingAddressCountry.isEmpty())
						if(!patientData.mailingAddressCountry.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "mailingCountrysuggestBox", patientData.mailingAddressCountry))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressCountry);
					if(!patientData.mailingAddressCounty.isEmpty())
						if(!patientData.mailingAddressCounty.contains("N/A"))
							Assert.assertTrue(type(selenium, "mailingCounty", patientData.mailingAddressCounty), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressCounty);*/
					waitForPageLoad(selenium);
					selenium.keyPress("comments", "\\9");
					click(selenium,btnYes);
					waitForElementToEnable(selenium,"mailingCity");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingStatesuggestBox");
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,"mailingCountrysuggestBox");
					waitForPageLoad(selenium);
					
					
			}
			else
			{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressState.isEmpty())
					if(!patientData.mailingAddressState.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "mailingStatesuggestBox", patientData.mailingAddressState))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressState);
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCountry.isEmpty())
					if(!patientData.mailingAddressCountry.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "mailingCountrysuggestBox", patientData.mailingAddressCountry))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressCountry);
				/*if(!patientData.mailingAddressCounty.isEmpty())
					if(!patientData.mailingAddressCounty.contains("N/A"))
						Assert.assertTrue(type(selenium, "mailingCounty", patientData.mailingAddressCounty), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressCounty);*/					
				
				/*waitForPageLoad(selenium);
				selenium.keyPress("comments", "\\9");
				click(selenium,btnYes);
				waitForElementToEnable(selenium,"mailingCity");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingStateSuggestBoxsuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingCountrysuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingCounty");
				waitForPageLoad(selenium);*/
		
			}
			
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, "comments", patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments,selenium, ClassName, MethodName);			
			click(selenium,"saveButton");
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * editUserForAuditLog
	 * function to edit User For AuditLog
	 * @since  	     Feb 09, 2012
	 */	

	public boolean editUserForAuditLog(Selenium selenium,HomeLib userData){
		try{
			
			assertTrue(type(selenium,txtLastName,userData.lastName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstname,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"userName",userData.userName),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxExternalemr,userData.externalEmr);
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			if(userData.resetPswCheck.equalsIgnoreCase("Yes")){
				assertTrue(click(selenium,"resetPasswordcheckbox"),"could not click",selenium, ClassName, MethodName);
				assertTrue(type(selenium,"password",userData.resetPassword),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,"confirmPassword",userData.changedPassword),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click the save Button;More Deatils:"+userData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,"!adminOrgStructureLists");
			if(isElementPresent(selenium,"//div[3]/div[2]/div/div/div/span")){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createConsentsCAView
	 * function to create Consents CA View
	 * @since  	    Jun 26, 2012
	 */	
	public boolean createConsentsCAView(Selenium selenium,HomeLib consentsCAData){
		try{
			selectValueFromAjaxList(selenium,"consentTypesuggestBox", consentsCAData.consentType);
			selectValueFromAjaxList(selenium,"consentNamesuggestBox", consentsCAData.consentName);
			selectValueFromAjaxList(selenium,"statussuggestBox", consentsCAData.status);
			if (isElementPresent(selenium, "reasonForInactivationsuggestBox"))
			selectValueFromAjaxListUsingTypeKeys(selenium,"reasonForInactivationsuggestBox",consentsCAData.inactivation);
			assertTrue(enterDate(selenium,"dateSigned", consentsCAData.dateSigned),"Could not enter date; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
			if(consentsCAData.status.equals("Enrolled")){
				 selectValueFromAjaxList(selenium,"enrolementstatussuggestBox",consentsCAData.status);
				 
				 selectValueFromAjaxList(selenium,"enrolledTosuggestBox",consentsCAData.entrolled);
				 
				 assertTrue(enterDate(selenium,"enrolmentDate",consentsCAData.entrolledDate),"could not enter date",selenium, ClassName, MethodName);
				 assertTrue(type(selenium,"css=textarea.gwt-TextArea",consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(),selenium, ClassName, MethodName);
			 }
			else if(consentsCAData.status.equals("Ended")){
				selectValueFromAjaxList(selenium,"enrolementstatussuggestBox",consentsCAData.status);
				
				selectValueFromAjaxList(selenium,"enrolledTosuggestBox",consentsCAData.entrolled);
				assertTrue(enterDate(selenium,"enrolmentDate",consentsCAData.entrolledDate),"could not enter date",selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,"enrolmentEndDate",consentsCAData.endDate),"could not enter date",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"reasonForTerminationsuggestBox",consentsCAData.reason);
				assertTrue(type(selenium,"css=textarea.gwt-TextArea",consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(),selenium, ClassName, MethodName);
			}
			if(consentsCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,"//span[2]/input"),"Could not select the susbstitution maker; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,"relationshipsuggestBox");
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"relationshipsuggestBox",consentsCAData.relationship);
				
				assertTrue(type(selenium,txtFirstname,consentsCAData.firstName),"Could not enter the first name; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentsCAData.lastName),"Could not enter last name; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }
			 else
				 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * editConsentsCAView
	 * function to edit Consents CA View
	 * @since  	    Jun 26, 2012
	 */	
	public boolean editConsentsCAView(Selenium selenium,HomeLib consentsCAData){
		try{
			selectValueFromAjaxList(selenium,"consentTypesuggestBox", consentsCAData.consentType);
			selectValueFromAjaxList(selenium,"consentNamesuggestBox", consentsCAData.consentName);
			selectValueFromAjaxList(selenium,"statussuggestBox", consentsCAData.status);
			if (isElementPresent(selenium, "reasonForInactivationsuggestBox"))
			selectValueFromAjaxListUsingTypeKeys(selenium,"reasonForInactivationsuggestBox",consentsCAData.inactivation);
			assertTrue(enterDate(selenium,"dateSigned", consentsCAData.dateSigned),"Could not enter date; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
			if(consentsCAData.consentType.equals("Enrollment")){
				 waitForPageLoad(selenium);
				 selectValueFromAjaxList(selenium,"enrolledTosuggestBox",consentsCAData.entrolled);
				 assertTrue(enterDate(selenium,"enrolmentDate",consentsCAData.entrolledDate),"could not enter date",selenium, ClassName, MethodName);
				 assertTrue(type(selenium,"css=textarea.gwt-TextArea",consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(),selenium, ClassName, MethodName);
			 }
			 if(consentsCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,"//span[2]/input"),"Could not select the susbstitution maker; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,"relationshipsuggestBox");
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"relationshipsuggestBox",consentsCAData.relationship);
				assertTrue(type(selenium,txtFirstname,consentsCAData.firstName),"Could not enter the first name; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentsCAData.lastName),"Could not enter last name; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				if(consentsCAData.entrolled.equalsIgnoreCase("Ended")){
					assertTrue(enterDate(selenium,"enrolmentDate",consentsCAData.entrolledDate),"could not enter date",selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,"enrolmentEndDate",consentsCAData.endDate),"could not enter date",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,"reasonForTerminationsuggestBox",consentsCAData.reason);
				}
				assertTrue(type(selenium,"css=textarea.gwt-TextArea",consentsCAData.comments),"Could not type the comments",selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }
			 else
				 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(),selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createPatientCAView_UnitTest
	 * function to create Patient CA View Unit Test
	 * @since  	    June 27, 2012
	 */	
	
	public boolean createPatientCAView_UnitTest(Selenium selenium, HomeLibUnitTest patientData){
		boolean returnValue = false;
		try{	
			if(!patientData.rosteredCheck.isEmpty())
				if(!patientData.rosteredCheck.contains("No"))
					assertTrue(check(selenium,"rosteredcheckbox"),"Could not check the rostered check box,Expected value for the check box:"+patientData.rosteredCheck,selenium, ClassName, MethodName);
			
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,"chartNumber",patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart ,selenium, ClassName, MethodName);
			if(!patientData.canadianProvince.isEmpty())
				if(!patientData.canadianProvince.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"canadianProvincesuggestBox",patientData.canadianProvince))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.canadianProvince);
			
			if(!patientData.hCN.isEmpty())
				if(!patientData.hCN.contains("N/A"))
					assertTrue(type(selenium, "healthcardNumber", patientData.hCN), "Could not Enter Hcn, Expected value to be typed" + patientData.hCN,selenium, ClassName, MethodName);
			if(patientData.testCaseId.equals("TC_FLV_CA_030"))
			if(!patientData.reason.isEmpty())
				if(!patientData.reason.contains("N/A"))
					if(!selectValueFromAjaxListUsingTypeKeys(selenium, "reasonSuggestBoxsuggestBox", patientData.reason))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.reason);
			
			if(!patientData.expireDate.isEmpty())
				if(!patientData.expireDate.contains("N/A"))
					assertTrue(enterDate(selenium, txtexpiryDate, patientData.expireDate), "Could not Enter expireDate , Expected value to be typed" + patientData.expireDate,selenium, ClassName, MethodName);			
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "primaryLocationSuggestBoxsuggestBox", patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, "responsibleProvPCPcheckbox"), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck,selenium, ClassName, MethodName);
			
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName,selenium, ClassName, MethodName);
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstname, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName,selenium, ClassName, MethodName);
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, "middleName", patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName,selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "titleSuggestBoxsuggestBox", patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "suffixSuggestBoxsuggestBox", patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, "alias1", patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1,selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, "alias2", patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2,selenium, ClassName, MethodName);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, "dobEstimatedcheckbox"), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck,selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, "prematurecheckbox"), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck,selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
							assertTrue(type(selenium, "prematureDurationsuggestBox", patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration,selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "prematureMeasureUnitSuggestBoxsuggestBox", patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
				}
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox", patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "maritalStatusSuggestBoxsuggestBox", patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "statusSuggestBoxsuggestBox", patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					assertTrue(type(selenium, "statusDate", patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(),selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "statusInactivationReasonSuggestBoxsuggestBox", patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, "residentialAddr1", patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, "residentialAddr2", patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, "residentialCity", patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "residentialStatesuggestBox", patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, "residentialZip", patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcountry.isEmpty())
				if(!patientData.residentialAddrcountry.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"residentialCountrysuggestBox",patientData.residentialAddrcountry))
						Assert.fail("Could not Enter Residential Addr Country, Expected value to be select"+patientData.residentialAddrcountry);
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType1SuggestBoxsuggestBox", patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, "primaryPhone", patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, "primaryPhoneExtension", patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType2SuggestBoxsuggestBox", patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, "ohterPhone1", patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, "otherPhone1Extension", patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2,selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "commType3SuggestBoxsuggestBox", patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, "otherPhone2", patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, "otherPhone2Extension", patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3,selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, "email", patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email,selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "suggestBox", patientData.contactPreferences))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.contactPreferences);
			if(!patientData.preference2Present.isEmpty())
				if(!patientData.preference2Present.contains("N/A"))
				{
					assertTrue(click(selenium,"css=span.add"), "Could not add a ne preference",selenium, ClassName, MethodName);
					if(!patientData.contactPreference2.isEmpty())
						if(!patientData.contactPreference2.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "xpath=(//input[@id='suggestBox'])[2]", patientData.contactPreference2))
								Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.contactPreference2);
				}
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, "mailingAsResidentialcheckbox"), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
					
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "mailingStateSuggestBoxsuggestBox", patientData.mailingAddressState))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressState);
					
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);					
				}
			else{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, "mailingAddr1", patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, "mailingAddr2", patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, "mailingCity", patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity,selenium, ClassName, MethodName);
				
				if(!patientData.mailingAddressState.isEmpty())
					if(!patientData.mailingAddressState.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "mailingStateSuggestBoxsuggestBox", patientData.mailingAddressState))
							Assert.fail("Could not Enter Mailing Address State, Expected value to be selected" + patientData.mailingAddressState);
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, "mailingZip", patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCountry.isEmpty())
					if(!patientData.mailingAddressCountry.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,"mailingCountrysuggestBox",patientData.mailingAddressCountry))
							Assert.fail("Could not Enter Mailing Addr Country,Expected value to be typed"+patientData.mailingAddressCountry);
			}
			
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, "comments", patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments,selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			click(selenium,"saveButton");
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createNewPatientWithMandatoryCAView
	 * function to create New Patient With Mandatory CA view
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatoryCAView(Selenium selenium, HomeLib patientData){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"responsibleProvSuggestBoxsuggestBox",patientData.responsibleProvider);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstname,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",patientData.status);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"saveButton"),"Could not click Save button More Dateils"+patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * verifyAlertForConsents
	 * function to verify alert when there are some changes in consents 
	 * @since  	    September 11, 2012
	 */	
	public boolean verifyAlertForConsents(Selenium selenium,HomeLib consentData){
		boolean returnValue=false;
		try{
			selectValueFromAjaxList(selenium,"consentTypesuggestBox", consentData.consentType);
			selectValueFromAjaxList(selenium,"enrolementstatussuggestBox", consentData.status1);
			enterDate(selenium,"enrolmentDate", consentData.entrolledDate);
		    selectValueFromAjaxList(selenium,"enrolledTosuggestBox", consentData.entrolled);
			selectValueFromAjaxList(selenium,"enrolementstatussuggestBox", consentData.status);
			if(waitForElement(selenium, btnYes, WAIT_TIME)){
				assertTrue(click(selenium,btnYes), "Could no click the yes button",selenium, ClassName, MethodName);
				returnValue= true;
			}else{
				return false;
			}
			selectValueFromAjaxList(selenium,"enrolementstatussuggestBox", consentData.status2);
			
			selectValueFromAjaxList(selenium,"enrolledTosuggestBox", consentData.entrolled);
			enterDate(selenium,"enrolmentDate", consentData.entrolledDate);
			enterDate(selenium,"enrolmentEndDate", consentData.endDate);
			selectValueFromAjaxList(selenium,"reasonForTerminationsuggestBox", consentData.reason);
			selectValueFromAjaxList(selenium,"enrolementstatussuggestBox", consentData.status);
			if(waitForElement(selenium, btnYes, WAIT_TIME)){
				assertTrue(click(selenium,btnYes), "Could no click the yes button",selenium, ClassName, MethodName);
				returnValue= true;
			}else{
				return false;
			}
			selectValueFromAjaxList(selenium,"enrolementstatussuggestBox", consentData.status2);			
			selectValueFromAjaxList(selenium,"enrolledTosuggestBox", consentData.entrolled);
			enterDate(selenium,"enrolmentDate", consentData.entrolledDate);
			enterDate(selenium,"enrolmentEndDate", consentData.endDate);
			selectValueFromAjaxList(selenium,"reasonForTerminationsuggestBox", consentData.reason);
			selectValueFromAjaxList(selenium,"enrolementstatussuggestBox", consentData.status1);
			if(waitForElement(selenium, btnYes, WAIT_TIME)){
				assertTrue(click(selenium,btnYes), "Could no click the yes button",selenium, ClassName, MethodName);
				returnValue= true;
			}else{
				return false;
			}
				
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createNewUser
	 * function to create New User
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @since  	     May 17, 2012
	 */	
	public boolean createNewUser(Selenium selenium,HomeLib userData,String uniqueName){
		try{
			assertTrue(click(selenium,"addUser"),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstname,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"userName",userData.userName1+uniqueName),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxExternalemr,userData.externalEmr);
			assertTrue(type(selenium,"password",userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,"confirmPassword",userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"roleSuggestBox1suggestBox",userData.role);
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/div/div/input",userData.practise);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	/**
	 * DeleteAllEncounters
	 * function to DeleteallEncounters
	 * @throws IOException 
	 * @since  	    Jan 20, 2013
	 */	

	
	
	
	
   public boolean deleteAllEncounter(Selenium selenium,ChartPreVisitLib allergyData) throws IOException{
		
		
	// delete all medication
			//try{
			//	selenium.fireEvent("link=Medications", "click");
			//}catch(Exception e){
			//	selenium.fireEvent("link=Medications", "click");
			//}	
			
			assertTrue(click(selenium,lnkMedication1),"Could not click the Medication link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(deleteMedication(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);  
	   
	   
	// delete all Allergies
		try{
			selenium.fireEvent(lnkAllergy, "click");
		}catch(Exception e){
			selenium.fireEvent(lnkAllergy, "click");
		}
		
		waitForPageLoad(selenium);			
		assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		// delete all Family History			
		try{
			selenium.fireEvent(lnkFamilyHistory, "click");
		}catch(Exception e){
			selenium.fireEvent(lnkFamilyHistory, "click");
		}						
		assertTrue(deleteFamilyHistory(selenium),"Deletion Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		// Delete all Immunizations			
		try{
			selenium.fireEvent(lnkImmunization, "click");
		}catch(Exception e){
			selenium.fireEvent(lnkImmunization, "click");
		}				
		waitForPageLoad(selenium);			
		assertTrue(deleteImmunization(selenium),"Deletion Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//delete all Injections			
		try{
			selenium.fireEvent(lnkInjection, "click");
		}catch(Exception e){
			selenium.fireEvent(lnkInjection, "click");
		}		
		waitForPageLoad(selenium);			
		assertTrue(deleteInjection(selenium),"Delete Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		// delete all Medical and Surgical History			
		try{
			selenium.fireEvent(lnkProcedure, "click");
		}catch(Exception e){
			selenium.fireEvent(lnkProcedure, "click");
		}			
		
		waitForPageLoad(selenium);								
		assertTrue(deleteProcedure(selenium),"Could not delete the procedure",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		
		
		//delete all problem list
		try{
			selenium.fireEvent(lnkProblemList, "click");
		}catch(Exception e){
			selenium.fireEvent(lnkProblemList, "click");
		}			
		waitForPageLoad(selenium);			
		assertTrue(deleteAllProblemList(selenium),"seletion failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		// delete all Social History
		try{
			selenium.fireEvent("link=Social History", "click");
		}catch(Exception e){
			selenium.fireEvent("link=Social History", "click");
		}			
		waitForPageLoad(selenium);		
		assertTrue(deleteAllSocialHistory(selenium),"Deletion failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave), "Could not click on cancel",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

	   
	   
		return true;
	
    }
	
	
	
	
	
	public boolean deleteAllProblemList(Selenium selenium){
		boolean problemDeleted=true;
		int problemCount=0;
		try{
			
			waitForElement(selenium,"//div[@id='ProblemsList']/table/tbody/tr/td[3]", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='ProblemsList']/table/tbody/tr/td[3]") > 0){
				problemCount=(Integer) selenium.getXpathCount("//div[@id='ProblemsList']/table/tbody/tr/td[3]");
				assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"Could not delete",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(problemCount == (Integer) selenium.getXpathCount("//div[@id='ProblemsList']/table/tbody/tr/td[3]")){
					Assert.fail("Could not delete the entry");
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problemDeleted;
	}

	/**
	 *deleteOrders
	 * function to delete Orders
	 * @since  	    Nov 15, 2012
	 */	
	public boolean deleteOrders(Selenium selenium){
		boolean orderDeleted = true;
		int proCount = 0;
		try{
			waitForElement(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/div/div[4]/div/div/div[14]/div[2]/div/a[2]/span", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/div/div[4]/div/div/div[14]/div[2]/div/a[2]/span") > 0){
				proCount=(Integer) selenium.getXpathCount("//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/div/div[4]/div/div/div[14]/div[2]/div/a[2]/span");
				assertTrue(click(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/div/div[4]/div/div/div[14]/div[2]/div/a[2]/span"),"",selenium, ClassName, MethodName);
				assertTrue(click(selenium,"delete"),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYes),"Could not click Yes button;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(proCount == (Integer) selenium.getXpathCount("//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/div/div[4]/div/div/div[14]/div[2]/div/a[2]/span")){
					Assert.fail("Could not delete the entry");
					orderDeleted = false;
					break;
				}
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDeleted;
	}
	
	
	public boolean goToBeginEncounter(Selenium selenium) throws IOException {
		try {
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not clik",selenium, ClassName, MethodName);
			
			if (isElementPresent(selenium, btnBeginEncounter)) {
				assertTrue(click(selenium, btnBeginEncounter),"cpuld not click",selenium, ClassName, MethodName);

				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				// if (isElementPresent(selenium, lblEncounterChoosePanel)) {
				if (isElementPresent(selenium, lnkStartNewWncouter)) {
					waitForPageLoad(selenium);
					click(selenium, lnkStartNewWncouter);
				} else if (isElementPresent(selenium,
						"//body/div[4]/div/div/div[2]/div[2]")) {
					click(selenium, "//body/div[4]/div/div/div[2]/div[2]");
				} else if (isElementPresent(selenium,
						"//body/div[5]/div/div/div[2]/div[2]")) {
					click(selenium, "//body/div[5]/div/div/div[2]/div[2]");
				} else if (isElementPresent(selenium,
						"//div[4]/div/div/div[2]/div[2]")) {
					click(selenium, "//div[4]/div/div/div[2]/div[2]");
				} else {
					click(selenium, "//div[5]/div/div/div[2]/div[2]");
				}
				waitForPageLoad(selenium);
				// }
				/*
				if (isElementPresent(selenium, "done")) {
					selenium.clickAt("done", "");
				}*/

				if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					selenium.chooseOkOnNextConfirmation();
				}
				
				/*
				 * Assert.assertTrue(isElementPresent(selenium,"done"),
				 * "Could not click on done button"); waitForPageLoad(selenium);
				 * selenium.clickAt("done","");
				 */
				assertTrue(
						isElementPresent(selenium, lnkEncounterAction),
						"Sign button is not present",selenium, ClassName, MethodName);
				if(isElementVisible(selenium,"contactModesuggestBox"))
				{
					selectValueFromAjaxList(selenium,"contactModesuggestBox","Scheduled");	
				}
				
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * loginForNexiaToVerifyForcePwdReset
	 * This function will login to Nexia Site and to verify Force Password Reset
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 * @since  	     Mar 29, 2010
	 */
	public boolean loginForNexiaToVerifyForcePwdReset(Selenium selenium, String userAccount, String userName, String userPassword){            
        if(!waitForElement(selenium, "loginAccountText", WAIT_TIME*3)){
        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
        }
        type(selenium, "loginAccountText", userAccount);
        type(selenium, "loginUseridText", userName);
        type(selenium, "loginPasswordText", userPassword);
        click(selenium, "loginButton");
        //return true;
        
        if(waitForElement(selenium, "currentPassword", WAIT_TIME*3)){
            return true;
        }else{
            return false;
        }
        
      /*  if(isElementPresent(selenium, "css=h3", WAIT_TIME*2)){
               return true;
        }else{
               return false;
        }*/
	}
	
	
	/**
	 * LogoutofApplication
	 * Function to logoutofApplication
	 * @param 	selenium
	 * @throws  
	 * @throws  
	 * @since	Sep 03,2013
	 */
	
	public boolean logoutofApplication(Selenium selenium) {
		
		
		try {
			assertTrue(click(selenium, lnkTopMenu), "Could not click on TopMenu button",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkSignout), "Could not click on Signout button",selenium, ClassName, MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForPageLoad(selenium);
	
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,btnYes)){
			click(selenium,btnYes);
		}else if(isElementPresent(selenium,lnkBtnContinue)){
			click(selenium,lnkBtnContinue);
			if(isElementPresent(selenium,btnYes)){
				click(selenium,btnYes);
			}else{
				click(selenium,lnkBtnYes);
			}
		}else if(isElementPresent(selenium,lnkContinuelogout)){
			click(selenium,lnkContinuelogout);
			if(isElementPresent(selenium,btnYes)){
				click(selenium,btnYes);
			}else{
				click(selenium,lnkBtnYes);
			}
		}else{
			click(selenium,lnkBtnYes);
		}

	return true;	
	
	}
	
	
	public boolean deleteProcedure(Selenium selenium){
		boolean procedureDeleted=true;
		int procedureCount=0;
		try{
			
			waitForElement(selenium,lnkDeleteProcedure, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteProcedure) > 0){
				procedureCount=(Integer) selenium.getXpathCount(lnkDeleteProcedure);
				assertTrue(click(selenium,lnkDeleteProcedure),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtdeleteReason,"noreason"),"Could not type the reason; More Details:",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click the delete button;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(procedureCount == (Integer) selenium.getXpathCount(lnkDeleteProcedure)){
					procedureDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureDeleted;
	}
	
	
	/**
	 *deleteMedication
	 * function to delete Medication
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */	
	public boolean deleteMedication(Selenium selenium) {
		boolean medicationDeleted=true;
		int medicationCount=0;
		try{
			waitForElement(selenium,"//a[contains(text(),'Delete')]", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]") > 0){
				medicationCount=(Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");
				assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,"writtenReason","noreason"),"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium,"saveReason"),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(medicationCount == (Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]")){
					medicationDeleted = false;
					break;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicationDeleted;
	}
	
	
	/**
	 * deleteInjection
	 * function to create Injection
	 * @since  	    Sep 26, 2012
	 */	
	
	public boolean deleteInjection(Selenium selenium){
		boolean injectionDeleted=true;
		int injCount=0;
		try{
			
			assertTrue(click(selenium, "includeInactivecheckbox"), "Could not click on show all recorded items",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			while((Integer) selenium.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a") > 0){
				injCount=(Integer) selenium.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,"//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a"),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "noreason"), "Could not type reason for deletion",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(injCount == (Integer) selenium.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a")){
					injectionDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return injectionDeleted;
	}

	/**
	 *deleteFamilyHistory
	 * function to delete FamilyHistory
	 * @since  	    Oct 04, 2012
	 */
	
	
	public boolean deleteFamilyHistory(Selenium selenium){
		boolean historyDeleted=true;
		int historyCount=0;
		try{
			
			waitForElement(selenium,btnDFamilyDelete, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnDFamilyDelete) > 0){
				historyCount=(Integer) selenium.getXpathCount(btnDFamilyDelete);
				assertTrue(click(selenium,btnDFamilyDelete),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYes),"Could not click Yes button;More Details:",selenium, ClassName, MethodName);
				/*Assert.assertTrue(type(selenium,txtdeleteReason,historyData.reason),"Could not type the reason");
				waitForPageLoad(selenium);
				Assert.assertTrue(click(selenium,"//div[3]/span/button"));*/
				waitForPageLoad(selenium);
				if(historyCount == (Integer) selenium.getXpathCount(btnDFamilyDelete)){
					historyDeleted = false;
					break;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyDeleted;
	}
	
	
	
	
	/**
	 * deleteImmunization
	 * function to delete Immunization
	 * @throws IOException 
	 * @since  	    Sep 26, 2012
	 */	
	
	public boolean deleteImmunization(Selenium selenium) throws IOException{
		
		
		boolean immunizationDeleted=true;
		int immCount=0;
		try{
			
			waitForElement(selenium,btnDeleteAllergy, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnDeleteAllergy) > 0){
				immCount=(Integer) selenium.getXpathCount(btnDeleteAllergy);
				assertTrue(click(selenium,btnDeleteAllergy),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,"deleteReason","reason"),"could not type",selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//button[@id='deleteReason']"),"Could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(immCount == (Integer) selenium.getXpathCount(btnDeleteAllergy)){
					immunizationDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return immunizationDeleted;
	}
	
	
		
	public boolean deleteAllSocialHistory(Selenium selenium){
		boolean socialHistoryDeleted = true;
		int proCount = 0;
		try{
			waitForElement(selenium,btnDeleteSocial, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnDeleteSocial) > 0){
				proCount=(Integer) selenium.getXpathCount(btnDeleteSocial);
				assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"could not Click ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtdeleteReason,"NoReason"),"Could not enter the reason ;More Details:",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"could not click the delete button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(proCount == (Integer) selenium.getXpathCount(btnDeleteSocial)){
					Assert.fail("Could not delete the entry");
					socialHistoryDeleted = false;
					break;
				}
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socialHistoryDeleted;
	}	
	
	
	/**
	 * addPracticeWithMandatory
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @since  	    July 31, 2012
	 */	
	public boolean addAdminPracticeWithMandatory(Selenium selenium,SystemSettingsLib pracData,String account,String uniqueName){
		try{
			
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName+uniqueName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			/*selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			Assert.assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString());
			Assert.assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString());*/
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
			selectValueFromAjaxList(selenium,ajxPracticeType,pracData.practiceType);
			if(account.equals(CAAccount)){
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			assertTrue(click(selenium,btnDonePratice),"Could not click on save button"+ pracData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean gotoSystemSetting(Selenium selenium){
		
		
		try {
		  	  assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
		      waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,lnkAdminOrgStructureLists)){
			return true;
		}else
			return false;
		
	}


}
