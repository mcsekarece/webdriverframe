package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditPendingMedicationFromQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for editing pending medication in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPendingMedicationFromQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_105";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * editPendingMedication
	 * Function to edit pending medication from meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 17, 2012
	 */
	public boolean editPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not delete the pending medications", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the search button;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,showPickList,"Pending");
			waitForPageLoad(selenium);
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;

			if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)
					||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
				selenium.clickAt(lnkOption, "");
				selenium.focus(lnkOption);
				selenium.fireEvent(lnkOption, "keyPress");
				assertTrue(click(selenium,"//div[6]/div/div/div"),"Could not click move to History button ", selenium, ClassName, MethodName);
		
			}
			else{
				while(count>=counter){
					if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeCa)
							||getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
						selenium.clickAt("//td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div", "");
						selenium.focus("//td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div");
						selenium.fireEvent("//td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div", "keyPress");
						assertTrue(click(selenium,"//div[6]/div/div/div"),"Could not click the move to history button", selenium, ClassName, MethodName);
						break;
					}else
					counter++;
					if(counter>7)
						break;
					}
				}
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			System.out.println(prescribeData.providerName);
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: Add to Pending Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddToPending),"Could not click the Add to Pending button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtRxPatientSearch,prescribeData.patientId),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtRxPatientSearch, "\\13");
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxProvider,prescribeData.providerName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly", selenium, ClassName, MethodName);
			int count1=(Integer)selenium.getXpathCount(lblMedsQueue);
			int counter1=2;
			
			
			if(getText(selenium,lblMedsQueue1).contains(prescribeData.patientId)){
				assertTrue(click(selenium,lblMedsQueue1),"Could not click on the patient medication", selenium, ClassName, MethodName);
				
				waitForPageLoad(selenium);
			}
		
			else{
				while(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div").contains(prescribeData.patientName)){
					if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div["+counter1+"]/div/div").contains(prescribeData.patientName)){
						assertTrue(click(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div["+counter1+"]/div/div"),"Could not click on the patient medication", selenium, ClassName, MethodName);
						break;
					}
					counter1++;
					if(count1<counter1)
						break;
				}
			
			}	
/*			waitForPageLoad(selenium);
			int count2=(Integer)selenium.getXpathCount("//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div");
			int counter2=2;
		
			if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div").contains(prescribeData.prescribeCa)
					||getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div").contains(prescribeData.prescribeName)){
				assertTrue(click(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div"),"Could not click on the edit button", selenium, ClassName, MethodName);	
			}else{			
				while(getText(selenium,"//div[5]/table/tbody/tr[2]/td[2]").contains(prescribeData.prescribeNameCa)||getText(selenium,"//div[5]/table/tbody/tr[2]/td[2]").contains(prescribeData.prescribeName)){
					if(getText(selenium,"//div[2]/div/div/div["+counter2+"]/div/div").contains(prescribeData.prescribeNameCa)
							||getText(selenium,"//div[2]/div/div/div["+counter2+"]/div/div").contains(prescribeData.prescribeName))
						assertTrue(click(selenium,"//div[2]/div/div/div["+counter2+"]/div/div"),"Could not click on the edit button", selenium, ClassName, MethodName);
					counter2++;
					if(count2<counter2)
						break;
					}
				}*/
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnRegistrationEdit),"Could not click on the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_105";
			prescribeData.fetchChartPreVisitTestData();
			
			prescribeData.provider = pName;
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddToPending),"Could not click the Add to Pending button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtRxPatientSearch,prescribeData.patientId),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtRxPatientSearch, "\\13");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show),"Could not search the aptient:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int count3=(Integer)selenium.getXpathCount(lblMedsQueue);
			int counter3=2;
			
			
			if(getText(selenium,lblMedsQueue1).contains(prescribeData.patientId)){
				assertTrue(click(selenium,lblMedsQueue1),"Could not click on the patient medication", selenium, ClassName, MethodName);
			}
			else{
				while(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div").contains(prescribeData.patientName)){
					if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div["+counter3+"]/div/div").contains(prescribeData.patientName)){
						assertTrue(click(selenium,"//div/div/div[2]/div/div/div/div["+counter3+"]/div/div[2]/div/div/div/div[2]"),"Could not click on the patient medication", selenium, ClassName, MethodName);
						break;
					}
					counter3++;
					if(count3<counter3)
						break;
				}
			
			}	
			waitForPageLoad(selenium);
			int count4=(Integer)selenium.getXpathCount("//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div");
			int counter4=2;
			              
			if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div").contains(prescribeData.prescribeNameCa)
					||getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div").contains(prescribeData.prescribeName)){
				assertTrue(click(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div"),"Could not click on the edit button", selenium, ClassName, MethodName);	
			}
			else{			
				while(getText(selenium,"//div[5]/table/tbody/tr[2]/td[2]").contains(prescribeData.prescribeNameCa)
						||getText(selenium,"//div[5]/table/tbody/tr[2]/td[2]").contains(prescribeData.prescribeName)){
					if(getText(selenium,"//div[2]/div/div/div["+counter4+"]/div/div").contains(prescribeData.prescribeNameCa)
							||getText(selenium,"//div[2]/div/div/div["+counter4+"]/div/div").contains(prescribeData.prescribeName))
						assertTrue(click(selenium,"//div["+counter4+"]/div/span/button"),"Could not click on the edit button", selenium, ClassName, MethodName);
					counter4++;
					if(count4<counter4)
						break;
					}
				}
			
			assertTrue(click(selenium,btnRegistrationEdit),"Could not click on the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyEditValues(selenium,prescribeData,userAccount),"The Edit values are not stored properly", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData, String account) throws IOException{
		
		String  date = null; 
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMMMM dd, yyyy");
	     date=DateFormat.format(cal.getTime());
		
		if(account.equals(CAAccount)){
	
			assertTrue(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the edit button", selenium, ClassName, MethodName);
		}else{
			assertTrue(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the edit button", selenium, ClassName, MethodName);
			
			
		}
		System.out.println(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")));
		
		System.out.println(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US")));
	
		assertTrue(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the edit button", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblMedsQueue1).trim().contains("On "+date.trim()),"Could not get the text value", selenium, ClassName, MethodName);
		
	  return true;
	  
	  
	  
	  
	}	
	public boolean verifyEditValues(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		
		
		if(account.equals(CAAccount)){
			assertTrue(getValue(selenium,ajxUnitList).trim().contains(prescribeData.unitListCA.trim()),"Could not click on the edit button", selenium, ClassName, MethodName);
		}else{
			assertTrue(getValue(selenium,ajxUnitList).trim().contains(prescribeData.unitList.trim()),"Could not click on the edit button", selenium, ClassName, MethodName);
		}
			System.out.println(getValue(selenium,ajxProvider));
			System.out.println(prescribeData.providerName.trim().toLowerCase(new java.util.Locale("en","US")));
			//assertTrue(getValue(selenium,ajxProvider).trim().contains(prescribeData.providerName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get the text value", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajxLoaction).trim().contains(prescribeData.loaction.trim()),"Could not get the text value", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtDirectionNotes).trim().contains(prescribeData.direction.trim()),"Could not get the text value", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtDispense).trim().contains(prescribeData.dispense.trim()),"Could not get the text value", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtNotesToPharmacy).trim().contains(prescribeData.notesToPharmacy.trim()),"Could not get the text value", selenium, ClassName, MethodName);
	
		return true;
	}	
}
