package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class PracticeLibraryPage extends SeleniumWebDriver{

	public PracticeLibraryPage()
	{
		 PageFactory.initElements(TestBaseClass.driver, this);	
			SeleniumWebDriver.isElementPresent(readyLocator);
	}
	private By readyLocator=By.id("createCustomTmplbtn");
	private By ajxTemplateType=By.id("templateSuggestBoxsuggestBox");
	
	
	
	public boolean navigateToMangaedCareTemplate(WebDriver driver)throws Exception
	{
		assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Managed Care"),"Could not select template type", driver, className, methodName);
		waitForPageLoad(driver);
		return true;
	}
	
	
	
	
	
}
