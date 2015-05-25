package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class SearchTemplate extends AbstractCdmFlowSheets {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Search template with details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchTemplateUsingDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_031";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchTemplateByDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
		/*************************************************************************************************** 
		* @purpose        Search template using various details
		* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
		* @action 		  Verifying Click preview medication
		* @author         AspireQA
		* @throws 		  IOException 
		* @state          Developing user account Both
		* @since  	      Jun 25, 2014
		***************************************************************************************************/
		
		public boolean searchTemplateByDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
			Selenium selenium=null;
			boolean returnValue= true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mcTemplate.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mcTemplate.userName, mcTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Change the switch role 									  //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,mcTemplate.switchRole),"Could not change the switch role;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Navigate to Managed Care Template						  //
				//--------------------------------------------------------------------//
				assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Add Managed Care Template					      		  //
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				String uniqueName=dateFormat.format(cal.getTime());
				assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Template creation failed", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Search Template  using its details				          //
				//--------------------------------------------------------------------//
				assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Managed Care"),"Could not select template type", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(searchTempateUsingTemplateName(selenium,mcTemplate,uniqueName),"Could not search template using Template name", selenium, ClassName, MethodName);
				assertTrue(searchTextBox(selenium,txtSearchCareElement,mcTemplate.templateDescription),"Could not select template type", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblFirstResult),"Could not search template using second name", selenium, ClassName, MethodName);
				//Search using first and last Name
				String[] splitStr1 = getText(selenium, userName).split("\\s+");
				System.out.println(splitStr1[0]);
				String[] secondName=splitStr1[1].split(",");
				System.out.println(secondName[0]);
				assertTrue(searchTextBox(selenium,txtSearchCareElement,splitStr1[0]),"Could not type first name", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblFirstResult),"Could not search template using first name", selenium, ClassName, MethodName);
				assertTrue(searchTextBox(selenium,txtSearchCareElement,secondName[0]),"Could not type second name", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblFirstResult),"Could not search template using second name", selenium, ClassName, MethodName);
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}	
		return returnValue;
		}
	}

