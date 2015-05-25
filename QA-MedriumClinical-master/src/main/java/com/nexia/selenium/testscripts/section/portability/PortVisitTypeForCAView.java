package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;

import com.thoughtworks.selenium.Selenium;

public class PortVisitTypeForCAView extends AbstractSchedulingTest{
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_001";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_002";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_003";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_004";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_005";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_006";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_007";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_008";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_009";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_010";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_011";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_012";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_013";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_014";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_015";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_016";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_017";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_018";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_019";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_020";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_021";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit022(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_022";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit023(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_023";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit024(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_024";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit025(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_025";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit062(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_026";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit027(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_027";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit028(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_028";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit029(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_029";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit030(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_030";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit031(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_031";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit032(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_032";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionCA","Review","firefox", "iexplore", "safari", "default" , "BeforePortVisitGroup"}, description = "Adding New Visit Type if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewVisit033(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "PortVisitTypeCAView";
		visitType.testCaseId = "TC_PVT_033";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		visitType.fetchSchedulingTestData();
		checkVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify create New Visit Type
	* @action 		  verifying Create Function  for Visit Type 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 20, 2013
	***************************************************************************************************/
	public boolean checkVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib visitType) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		boolean verifyCreatedVisitType=false;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitType.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitType.userName, visitType.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                          //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitType.switchRole),"Could not switch role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to Scheduling Setting                                  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"could not go to scheduling",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search Visit Type                                         //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVisitType),"Could not click the Visit Type Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-5: Create New Visit Type   -------------------//
			//--------------------------------------------------------------------//
			if(!searchCurrentVisitType(selenium,visitType )){
				assertTrue(createVisitType(selenium,visitType),"Could not created the visit type",selenium,ClassName,MethodName);
			
			}else{
				if(!verifyStoreValue(selenium,visitType)){
					Assert.fail("The Details are not saved Properly");
				}else
					return returnValue;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return verifyCreatedVisitType;
	}
	
	public boolean searchCurrentVisitType(Selenium selenium,SchedulingTestLib visitType) throws IOException{
	
		assertTrue(type(selenium,txtSearchType,visitType.visitName),"Could not Type the visit name",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		selenium.keyPress(txtSearchType, "\\13");
		waitForPageLoad(selenium);
		int counter=(Integer) selenium.getXpathCount("//div[@id='VisitTypeList']/table/tbody/tr/td/div/span/div");
		
			
			for(int count =1; count<=counter;count++){
				if(getText(selenium,"//div[@id='VisitTypeList']/table/tbody/tr["+counter+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(visitType.visitName.toLowerCase(new java.util.Locale("en","US")).trim())){
					assertTrue(click(selenium,btnEdit),"Could not click on the edit button",selenium,ClassName,MethodName);
				break;
				}
			}
			if(isElementPresent(selenium,chkInclude)){
				assertTrue(click(selenium,chkInclude),"Could not click the check box",selenium,ClassName,MethodName);
				while (isElementPresent(selenium,"//div[@id='VisitTypeList']/table/tbody/tr["+counter+"]/td/div/span/div")){
				if(getText(selenium,"//div[@id='VisitTypeList']/table/tbody/tr["+counter+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(visitType.visitName.toLowerCase(new java.util.Locale("en","US")).trim())){
					assertTrue(click(selenium,lnkActivate),"Could not click on the Activate button",selenium,ClassName,MethodName);
					assertTrue(click(selenium,btnYesButton),"could not click the yes button",selenium,ClassName,MethodName);
					assertTrue(click(selenium,btnEdit),"Could not click on the edit button",selenium,ClassName,MethodName);
					break;
				}
				else
					counter++;
				}
			
		}
		return true;
	}
	
	
	public boolean createVisitType(Selenium selenium,SchedulingTestLib visitType){
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-5: Create Visit Type//
			//--------------------------------------------------------------------//
			try {
				assertTrue(createVisitTypePortability(selenium,visitType),"Could not created the visit type",selenium,ClassName,MethodName);
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-6: verify Store Value   -------------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click on the edit button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
				if(!verifyStoreValue(selenium,visitType)){
					Assert.fail("The Details are not saved Properly");
				}else
					returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	public boolean verifyStoreValue(Selenium selenium,SchedulingTestLib  visitType){
		
		if(!getValue(selenium,txtvisitType).contains(visitType.visitName)){
			return false;
		}
		if(!getValue(selenium,txtduration).contains(visitType.duration)){
			return false;
		}
		if(!getValue(selenium,txtCannotRepeat).contains(visitType.cannotRepeat)){
			return false;
		}
		return true;
	}
}
