package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAssociationForPrograms extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying association for programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssociation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "CreateAssociateDepartment";
		deptData.testCaseId = "TC_CD_001";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAssociationProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	/**
	 * veriyAssociationProgram
	 * function to verify Association Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	    June 05, 2010
	 */
	public void verifyAssociationProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws Exception{
		
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,deptData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Org Structure //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			// -----------Step-3: Create Department And Program-------------------//
			//--------------------------------------------------------------------//
			assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddDepartment),"Could not Click the Add button;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
		    assertTrue(createAssociateDepartment(selenium,deptData, uniqueName),"Create Assosicate failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Count no of programs//
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium,txtSearchTextBox2)&&!(isElementPresent(selenium,txtDepartmentSearch)))
			{
			int proCount=1;
			while(isElementPresent(selenium,"//div[@id='programs']/table/tbody/tr["+proCount+"]/td/div/div")){
				proCount++;
				if(proCount>20)
					break;
			}
			proCount=proCount-1;
			//--------------------------------------------------------------------//
			// -----------Step-5: Delete Department-------------------//
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,lblNormalSize)){
				waitForPageLoad(selenium);
				click(selenium,"//div[3]/div/div/div[4]/div/div[2]/table/tbody/tr/td[2]/div/a");
				waitForPageLoad(selenium);
			}
			
			int count=1;
			while(isElementPresent(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td")){
				String deptcode=getText(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td");
				System.out.println(deptcode);
				if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td").contains(uniqueName)){
					break;
				}
				count++;
				if(count>20)
					break;
			}
			if(isElementPresent(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td[2]/div/a")){
				assertTrue(click(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td[2]/div/a"),"Could not delete on departments;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				click(selenium,btnYes);
				waitForPageLoad(selenium);  
			}
			//--------------------------------------------------------------------//
			//  Step-6: Verify programs count after department deletion //
			//--------------------------------------------------------------------//
			int proCountafterDeletion=1;
			while(isElementPresent(selenium,"//div[@id='programs']/table/tbody/tr["+proCountafterDeletion+"]/td/div/div")){
				proCountafterDeletion++;
				if(proCountafterDeletion>20)
					break;
			}
			proCountafterDeletion=proCountafterDeletion-1;
			if((proCount-proCountafterDeletion)!=1){
				Assert.fail("Associated program is not deleted");
			}
			}
			
			else
			{
				assertTrue(type(selenium,txtDepartmentSearch,uniqueName),"unable to type text in the department search box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDepartmentSearchWithSearchText),"unable to click the department search box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,departmentListDelete),"unable to find the delete button",selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnYesbutton),"unable to click the yes button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click on Org Structures Link;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtSearchTextBox2,uniqueName),"unable to type text in the programs search box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,programsSearchBox),"unable to click the programs search box",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(!getText(selenium,programsListItem).trim().contains(uniqueName),"search list didn't show what we search",selenium,ClassName,MethodName);
				
			}
			
			//--------------------------------------------------------------------------------------//
			// -----------Step-7: Verifying deleted department from program list-------------------//
			//------------------------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProgram),"Could not click the add button;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,uniqueName);
			assertTrue(type(selenium,typeProgramName ,uniqueName),"Could not type the program;More Deatils:"+deptData.toString(), selenium, ClassName, MethodName);
	     	assertTrue(type(selenium,txtdescription,deptData.description),"Could not type the description;More Deatils:"+deptData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1)){
				Assert.fail("Deleted depatment is still present!");
			}else{
				assertTrue(click(selenium,btnCancel),"Could not click on cancel button;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------------------------//
			// -----------Step-8: Verifying association between program and departments------------//
			//------------------------------------------------------------------------------------//
			
			assertTrue(click(selenium,chkIncludeInactivescheckbox),"Could not click include Inactives check box;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int progCount=1;
			while(isElementPresent(selenium,"//div[@id='programs']/table/tbody/tr["+progCount+"]/td/div/div")){
				if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+progCount+"]/td/div/div").contains(deptData.program)){
					assertTrue(click(selenium,"//div[@id='programs']/table/tbody/tr["+progCount+"]/td[2]/div/a"),"Could not click the save button;More Details:"+deptData.toString(), selenium, ClassName, MethodName);
					if(isElementPresent(selenium,btnErrorClose))
					{
						click(selenium,btnErrorClose);
					}
					else
						Assert.fail("Able to activate associated program without actiavting the corresponding department");
				}
				else
				progCount++;
				if(progCount>20)
					Assert.fail("UnExpected Failure");
					break;
			}
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + deptData.toString(), selenium, ClassName, MethodName);
			}
		}
	}
