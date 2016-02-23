package fwkTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesObjects.EmployeesPage;
import pagesObjects.LoginPage;
import pagesObjects.PublicSitePage;

public class EmployeeTests extends BaseSetUpTest {
	
	 LoginPage loginPage;
	 EmployeesPage employeePage;
	 PublicSitePage publicSitePage;
	 
	 @BeforeClass
	 public void setUp()
	    {
	        driver = getDriver();
	        loginPage = new LoginPage(driver);
	        employeePage = new EmployeesPage(driver);
	        publicSitePage = new PublicSitePage(driver);
	    }
	 
	 @Test
	 public void createNewEmployee(){
		 loginPage.authentication("gap-automation-test@mailinator.com","12345678");
		 employeePage.goToCreateEmployee();
		 employeePage.createEmployee("James", "Smith", "jsmith@testmail.com", "1234567890", "juanito", "2010", "January", "21");
		 Assert.assertEquals(employeePage.getEmployeeCreationMsg(),"Employee was successfully created.");
		 employeePage.backToEmployeeInformation();
		 Assert.assertEquals(employeePage.getIfEmployeeNameExists("James"), true);
		 employeePage.clickOnLogOut();
	 }
	 
	 @Test
	 public void identifiyingEmployee(){
		 loginPage.goToPublicSite();
		 publicSitePage.findEmployee("1234567890");
		 Assert.assertEquals(publicSitePage.getSiteTitle(), "Hi James Smith,");
		 publicSitePage.clickOnLogoLink();
	 }
	 
	 @Test 
	 public void deleteEmployee(){
		 loginPage.authentication("gap-automation-test@mailinator.com","12345678");
		 employeePage.deleteEmployee("James");
		 Assert.assertEquals(employeePage.getIfEmployeeNameExists("James"), false);
		 employeePage.clickOnLogOut();
		 loginPage.goToPublicSite();
		 publicSitePage.findEmployee("1234567890");
		 Assert.assertEquals(publicSitePage.getSiteTitle(), "No Employee found with that identification"); 
	 }	 

}
