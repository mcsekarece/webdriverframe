package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyElectroinDataImportMedication extends AbstractSystemSettingsTest {
	String fName=null;
	String lName=null;


	String medicationSig[]=new String[10];
	String medicationStopped[]=new String[10];
	String timing[]=new String[10];
	String frequency[]=new String[10];
	String interval[]=new String[10];
	String duration[]=new String[10];
	String route[]=new String[10];
	String dose[]=new String[10];
	String site[]=new String[10];
	String restriction[]=new String[10];
	String unit[]=new String[10];
	String deliveryMethod[]=new String[10];
	String product[]=new String[10];


	String brand[]=new String[10];
	String productName[]=new String[10];
	String brandName[]=new String[10];
	String manufacturer[]=new String[10];
	String concentration[]=new String[10];
	String type[]=new String[10];
	String status[]=new String[10];
	String indication[]=new String[10];
	String patientInstruction[]=new String[10];
	String reaction[]=new String[10];
	String vehicle[]=new String[10];
	String doseIndicator[]=new String[10];
	String orderNumber[]=new String[10];



	String refills[]=new String[10];
	String qtyOrder[]=new String[10];
	String orderExpiration[]=new String[10];
	String PrescribedOn[]=new String[10];
	String PrescribedBy[]=new String[10];
	String Comments[]=new String[10];
	String history[]=new String[10];
	String prescribNumber[]=new String[10];
	String Provider[]=new String[10];
	String Location[]=new String[10];
	String DispenseDate[]=new String[10];
	String fillNumber[]=new String[10];
	String fillStatus[]=new String[10];



	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying cancel functionality In patient import")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyPatientImport(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_005";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite,userAccount, mandData);
	}
	/**
	 * verifyCancel
	 * Function to verify Cancel in patient import
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @since  	    Dec 26, 2012
	 */

	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, SystemSettingsLib mandData) throws IOException, InterruptedException{
		Selenium selenium=null;

		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium,userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//----------------------------//
			// Step-2:Change Switch Role  //
			//----------------------------//
			assertTrue(switchRole(selenium,mandData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//-------------------------------------//
			//  Step-3: Navigate to import section //
			//-------------------------------------//
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the qucik action link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImportPatientAction),"Could not click the import link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//-------------------------------------//
			//  Step-4: Import and Verify the file //
			//-------------------------------------//
			File dir1 = new File (".");
			String strBasePath = null;
			String file = null;
			String xmlName = "EP_JaneAndrews_CCR.xml";		
			String sectionName = "SystemSetting";
			strBasePath=dir1.getCanonicalPath();

			file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + xmlName;
			assertTrue(type(selenium,txtPatientSearch,file),"Could not browse the patient fie;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Thread.sleep(30000);
			waitForElement(selenium, txtFstNameImpPatient, WAIT_TIME);

			fName=selenium.getText(txtFstNameImpPatient);
			lName=selenium.getText(txtLstNameImpPatient);

			int validProblemList=0;
			for(int count=1;count<=10;count++){

				if(getText(selenium,"//label[contains(text(),'Medications')]/parent::span/following-sibling::div/div["+count+"]").contains("Medication Sig")){
					if(!(getText(selenium,"//label[contains(text(),'Medications')]/parent::span/following-sibling::div/div["+count+"]").contains("Failed to map"))){
						validProblemList=validProblemList+1;

						medicationSig[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div/div/div[2]");
						medicationStopped[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[2]/div/div[2]");
						timing[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[3]/div/div[2]");
						frequency[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[4]/div/div[2]");
						interval[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[5]/div/div[2]");
						duration[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[6]/div/div[2]");
						route[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[7]/div/div[2]");
						dose[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[8]/div/div[2]");
						site[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[9]/div/div[2]");
						restriction[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[10]/div/div[2]");
						unit[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[11]/div/div[2]");
						deliveryMethod[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[12]/div/div[2]");
						product[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[13]/div/div[2]");


						brand[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[14]/div/div[2]");
						productName[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[15]/div/div[2]");
						brandName[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[16]/div/div[2]");
						manufacturer[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[17]/div/div[2]");
						concentration[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[18]/div/div[2]");
						type[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[19]/div/div[2]");
						status[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[20]/div/div[2]");
						indication[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[21]/div/div[2]");
						patientInstruction[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[22]/div/div[2]");
						reaction[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[23]/div/div[2]");
						vehicle[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[24]/div/div[2]");
						doseIndicator[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[25]/div/div[2]");
						orderNumber[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[26]/div/div[2]");


						refills[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[27]/div/div[2]");
						qtyOrder[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[28]/div/div[2]");
						orderExpiration[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[29]/div/div[2]");
						PrescribedOn[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[30]/div/div[2]");
						PrescribedBy[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[31]/div/div[2]");
						Comments[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[32]/div/div[2]");
						history[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[33]/div/div[2]");
						prescribNumber[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[34]/div/div[2]");
						Provider[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[35]/div/div[2]");
						Location[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[36]/div/div[2]");
						DispenseDate[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[37]/div/div[2]");
						fillNumber[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[38]/div/div[2]");
						fillStatus[validProblemList]=selenium.getText("//div[4]/div/div["+count+"]/div/div[39]/div/div[2]");

					}
				}
				else{
					break;
				}
			}

			assertTrue(click(selenium,btnImport),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			//Search for recently imported patient
			assertTrue(type(selenium,txtSearchPatientBox,fName+" "+lName),"Could not browse the patient fie;More Details:", selenium, ClassName, MethodName);
			selenium.typeKeys(txtSearchPatientBox, "\b");
			waitForPageLoad(selenium);
			click(selenium,lblPatientResult);
			//assertTrue(click(selenium,lnkImpPatient),"Could not click on the link");
			waitForPageLoad(selenium);


			//Navigate to export chart section
			assertTrue(click(selenium,lnkPatientOptions),"Could not Click on patient Options"+ mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblPatientOptionsExportChart),"Could not Click on Export chart option"+ mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//If all the problem list is not valid, Then we set the default allergy value to the allergy details
			if(validProblemList==0){


				medicationSig[1]="-";
				medicationStopped[1]="-";
				timing[1]="-";
				frequency[1]="-";
				interval[1]="-";
				duration[1]="-";
				route[1]="-";
				dose[1]="-";
				site[1]="-";
				restriction[1]="-";
				unit[1]="-";
				deliveryMethod[1]="-";
				product[1]="-";

				brand[1]="-";
				productName[1]="-";
				brandName[1]="-";
				manufacturer[1]="-";
				concentration[1]="-";
				type[1]="-";
				status[1]="-";
				indication[1]="-";
				patientInstruction[1]="-";
				reaction[1]="-";
				vehicle[1]="-";
				doseIndicator[1]="-";
				orderNumber[1]="-";



				refills[1]="-";
				qtyOrder[1]="-";
				orderExpiration[1]="-";
				PrescribedOn[1]="-";
				PrescribedBy[1]="-";
				Comments[1]="-";
				history[1]="-";
				prescribNumber[1]="-";
				Provider[1]="-";
				Location[1]="-";
				DispenseDate[1]="-";
				fillNumber[1]="-";
				fillStatus[1]="-";



				validProblemList=1;
			}

			assertTrue(verifyExportChartVAlue(selenium,validProblemList),"Could not match with imported patient information"+ mandData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	private boolean verifyExportChartVAlue(Selenium selenium,int validAllergy) throws IOException {

		if(selenium.isElementPresent("saveBtn")){
			for(int count=1;count<=validAllergy;count++){

				assertTrue( (selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div/div/div[2]").equalsIgnoreCase(medicationSig[count])),
					    "Not able to find text " +medicationSig[count] , selenium, ClassName, MethodName);			
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[2]/div/div[2]").equalsIgnoreCase(medicationStopped[count]),
					    "Not able to find text " +medicationStopped[count] , selenium, ClassName, MethodName);				
				
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[3]/div/div[2]").equalsIgnoreCase(timing[count]))){
					return false;
				}*/
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[4]/div/div[2]").equalsIgnoreCase(frequency[count]))){
					return false;
				}*/				
				
				assertTrue( (selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[5]/div/div[2]").equalsIgnoreCase(interval[count])),
					    "Not able to find text " +interval[count] , selenium, ClassName, MethodName);				
				
				assertTrue( (selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[6]/div/div[2]").equalsIgnoreCase(duration[count])),
					    "Not able to find text " +duration[count] , selenium, ClassName, MethodName);				
				
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[7]/div/div[2]").equalsIgnoreCase(route[count]))){
					return false;
				}*/
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[8]/div/div[2]").equalsIgnoreCase(dose[count]),
					    "Not able to find text " +dose[count] , selenium, ClassName, MethodName);				

				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[9]/div/div[2]").equalsIgnoreCase(site[count]),
					    "Not able to find text " +site[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[10]/div/div[2]").equalsIgnoreCase(restriction[count]),
					    "Not able to find text " +restriction[count] , selenium, ClassName, MethodName);				
				
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[11]/div/div[2]").equalsIgnoreCase(unit[count]))){
					return false;
				}*/

				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[12]/div/div[2]").equalsIgnoreCase(deliveryMethod[count]),
					    "Not able to find text " +deliveryMethod[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[13]/div/div[2]").equalsIgnoreCase(product[count]),
					    "Not able to find text " +product[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[14]/div/div[2]").equalsIgnoreCase(brand[count]),
					    "Not able to find text " +brand[count] , selenium, ClassName, MethodName);				
								
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[15]/div/div[2]").equalsIgnoreCase(productName[count]),
					    "Not able to find text " +productName[count] , selenium, ClassName, MethodName);				
				
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[16]/div/div[2]").equalsIgnoreCase(brandName[count]))){
					return false;
				}*/
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[17]/div/div[2]").equalsIgnoreCase(manufacturer[count]),
					    "Not able to find text " +manufacturer[count] , selenium, ClassName, MethodName);			
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[18]/div/div[2]").equalsIgnoreCase(concentration[count]),
					    "Not able to find text " +concentration[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[19]/div/div[2]").equalsIgnoreCase(type[count]),
					    "Not able to find text " +type[count] , selenium, ClassName, MethodName);				
				
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[20]/div/div[2]").equalsIgnoreCase(status[count]))){
					return false;
				}*/
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[21]/div/div[2]").equalsIgnoreCase(indication[count]),
					    "Not able to find text " +indication[count] , selenium, ClassName, MethodName);				
				
				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[22]/div/div[2]").equalsIgnoreCase(patientInstruction[count]))){
					return false;
				}*/
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[23]/div/div[2]").equalsIgnoreCase(reaction[count]),
					    "Not able to find text " +reaction[count] , selenium, ClassName, MethodName);				
								
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[24]/div/div[2]").equalsIgnoreCase(vehicle[count]),
					    "Not able to find text " +vehicle[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[25]/div/div[2]").equalsIgnoreCase(doseIndicator[count]),
					    "Not able to find text " +doseIndicator[count] , selenium, ClassName, MethodName);

				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[26]/div/div[2]").equalsIgnoreCase(orderNumber[count]),
					    "Not able to find text " +orderNumber[count] , selenium, ClassName, MethodName);				

				/*if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[27]/div/div[2]").equalsIgnoreCase(refills[count]))){
					return false;
				}*/
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[28]/div/div[2]").equalsIgnoreCase(qtyOrder[count]),
					    "Not able to find text " +qtyOrder[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[29]/div/div[2]").equalsIgnoreCase(orderExpiration[count]),
					    "Not able to find text " +orderExpiration[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[30]/div/div[2]").equalsIgnoreCase(PrescribedOn[count]),
					    "Not able to find text " +PrescribedOn[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[31]/div/div[2]").equalsIgnoreCase(PrescribedBy[count]),
					    "Not able to find text " +PrescribedBy[count] , selenium, ClassName, MethodName);				
				
				if(!(selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[32]/div/div[2]").equalsIgnoreCase(Comments[count]))){
					return false;
				}
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[32]/div/div[2]").equalsIgnoreCase(Comments[count]),
					    "Not able to find text " +Comments[count] , selenium, ClassName, MethodName);				
				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[33]/div/div[2]").equalsIgnoreCase(history[count]),
					    "Not able to find text " +history[count] , selenium, ClassName, MethodName);				
				
				assertTrue( selenium.getText("//div[2]/div/div/div[4]/div/div["+count+"]/div[34]/div/div[2]").equalsIgnoreCase(prescribNumber[count]),
					    "Not able to find text " +prescribNumber[count] , selenium, ClassName, MethodName);				


			}

		}
		return true;
	}

}
