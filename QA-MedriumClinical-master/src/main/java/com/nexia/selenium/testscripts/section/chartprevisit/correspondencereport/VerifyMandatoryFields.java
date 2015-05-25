package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMandatoryFields extends AbstractChartPreVisit{

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the MandatoryFields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_003";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	 /***************************************************************************************************
     * @purpose To verify the search functionality in Correspondence TAb
     * @author Aspire QA
     * @throws IOException
     * @state Developing
     * @useraccount Both (US and Canada)
     * @since Oct 28, 2014
     ***************************************************************************************************/
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			//Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CorresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Navigate to file document
			//--------------------------------------------------------------------//
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3:Add correspondence report
			//--------------------------------------------------------------------//
			File dir1 = new File(".");
			String strBasePath = null;
			String file = null;
			String xmlName = "Medica_Report.doc";
			String sectionName = "chartprevisit";
			strBasePath = dir1.getCanonicalPath();
			file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
			waitForPageLoad(selenium);
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "
					+ corresData.switchRole, "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			corresData.Receivingprovider = providerName;
			assertTrue(click(selenium, btnUploadFile),		"Could not click upload btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtBrowseFile, file),	"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Robot robot = null;
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchFileToPatient,corresData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
			
			assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForElement(selenium, txtSearchFileToPatient, 30000);
			assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ corresData.patientId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtpatient).toLowerCase(new java.util.Locale("en", "US")).trim().contains(corresData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, txtpatient),"Could not select the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,corresData.DocumentType),		"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Verify Mandatory fields
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);	
			assertTrue(click(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);		
			waitForPageLoad(selenium);
			selenium.mouseOver(ajxReport);
			selenium.mouseOver(ajxRProvider);
			selenium.mouseOver(txtSender);
			waitForPageLoad(selenium);	
			assertTrue(selenium.isTextPresent("Report Type cannot be empty"),"could not find the warning message ",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Receiving Provider cannot be empty"),"could not find the warning message ",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Sender cannot be empty"),"could not find the warning message ",selenium, ClassName, MethodName);			
			
		}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
	}
	return true;	
	}
	
}
