package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteDepartment extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteNewDepartment(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib deptData = new AuditLogLib();
		deptData.workSheetName = "AuditLogForCreateDepartment";
		deptData.testCaseId = "TC_ALD_001";
		deptData.fetchHomeTestData();
		deleteDepartment(seleniumHost, seleniumPort, browser, webSite, deptData,userAccount);
	}
	/**
	 * createDepartment
	 * function to create Department
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */

	public boolean deleteDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib deptData,String userAccount) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, deptData.userAccount, deptData.userName, deptData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,deptData.switchRole));
			waitForPageLoad(selenium);
			
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing program          //
			//--------------------------------------------------------------------//
			int counter=1;
			while(getText(selenium,"//div[3]/div[2]/div/div").contains(deptData.department)){
				if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span",10000).contains(deptData.department)){
					click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,"yesButton");
					waitForPageLoad(selenium);
				}
				else counter++;
				if(counter>10)
					break;
			}
			
			//---------------------------------------------------------------------//
			//  Step-3: Create a new program                                      //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"addDepartment"),"Could not click on add a department link:" + deptData .toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createDepartment(selenium,deptData,uniqueName),"Practice Creation Failed");
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-3: Delete Department                                    //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			int count=1;
			while(getText(selenium,"//div[3]/div[2]/div/div").contains(deptData.department)){
				if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td/div/span",10000).contains(deptData.department)){
					click(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,"yesButton");
					waitForPageLoad(selenium);
				}
				else count++;
				if(counter>10)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, deptData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, deptData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, deptData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			returnValue= true;
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + deptData.toString());
		}
		return returnValue;
	}
}
