package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ModifyLetterTemplateGroupFields extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify modification of Letter template Group fields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void modifyLetterTemplateGroupFieldsTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_011";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		changeLetterTemplateGroupField(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	 * @purpose        Verify modification of letter template group field 
	 * @action 		   Create Group field 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       June 19, 2014	
	 ***************************************************************************************************/

	public boolean changeLetterTemplateGroupField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + letterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, letterTemplateTestData.userName, letterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,letterTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Letter templates page  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-4: Select Template to change, if the template not exits change it 						  //
			//--------------------------------------------------------------------//
			assertTrue(selectLetterTemplateToEdit(selenium, letterTemplateTestData),"Could not select letter template " +letterTemplateTestData.letterTemplateName+" for editing", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create specified Letter template fields    //
			//--------------------------------------------------------------------//
			assertTrue(createAllTemplateField(selenium, letterTemplateTestData.allTemplateFields), "Could not create all specified template field", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Modify Letter template group fields created above    //
			//--------------------------------------------------------------------//
			assertTrue(modifyTemplateFieldGroup(selenium, letterTemplateTestData), "Could not modify specified template field", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify if specified Letter template fields present    //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfTemplateFieldsPresent(selenium, letterTemplateTestData.allTemplateFields), "Modified template field not found", selenium, ClassName, MethodName);
			

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	private boolean modifyTemplateFieldGroup(Selenium selenium, ChartPreVisitLib letterTemplateTestData) {
		String fieldName;
		boolean result = true;
		String allTemplateFields = letterTemplateTestData.allTemplateFields;

		if( allTemplateFields.trim().isEmpty()) {
			System.out.println("No template fields supplied");
			return result;
		}

		try {	
			String[] templateField = allTemplateFields.split("&");			
			for (int i = 0; i < templateField.length; i++) {
				String[] templateFieldInfo = templateField[i].trim().split("=");
				fieldName = templateFieldInfo[0].trim();

				if ( !modifyTemplateField(selenium, fieldName,letterTemplateTestData ) ) {
					System.out.println("Error occurred while editing template field with name - " +fieldName);
					result = false;
				}
			}	

		}catch(Exception e) {
			System.out.println("Following error occured while editing template fields: \n");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	private boolean modifyTemplateField(Selenium selenium, String fieldName, ChartPreVisitLib letterTemplateTestData) throws IOException {
		String linkCurrentSelectedField = "";
		String fieldNameOfCurrentField = "";
		String objDraggableTemplateField = "";
		
		String groupFieldInfo = letterTemplateTestData.editTemplateFields;  
		boolean result = true;
		boolean fieldFound = false;

		int fieldsCount = (Integer) selenium.getXpathCount(linkSelectedTemplateFields);
		for (int i = 0; i <= fieldsCount-1; i++) {
			linkCurrentSelectedField = linkSelectedTemplateFields + "[" + (i+1)+ "]";
			fieldNameOfCurrentField = getText(selenium, linkCurrentSelectedField);
			if (fieldNameOfCurrentField.equals(fieldName)) {
				fieldFound = true;
				selenium.doubleClick(linkCurrentSelectedField);
				waitForPageLoad(selenium);
				//perform add field operation
				String[] elementsToselect  = groupFieldInfo.split("_");
				for (int j = 0; j < elementsToselect.length; j++) {
					objDraggableTemplateField = "//div[@class='gwt-Label' and text()='" +elementsToselect[j]+ "']";	
					if(elementsToselect[j].equals(".")||elementsToselect[j].equals(",") ||elementsToselect[j].equals("-")||elementsToselect[j].equals(":") 	||elementsToselect[j].equals(";")) {
						System.out.println("Found special symbol");
						selenium.doubleClick(objDraggableTemplateField);
					}else {			
					selenium.dragAndDropToObject(objDraggableTemplateField, objTemplateFieldsDropTarget);  
					waitForPageLoad(selenium);
					}
				}
				result = true;
				return result;
			}
		}

		if(!fieldFound){
			System.out.println("The field " +fieldName+ " not found");
			result = false;
		}

		return result;
	}

	
}
