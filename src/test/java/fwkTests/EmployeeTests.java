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
	 }
	 
	 @Test
	 public void indentifiyingEmployee(){
		 employeePage.clickOnLogOut();
		 loginPage.goToPublicSite();
		 Assert.assertEquals(publicSitePage.getSiteTitle(), "Hi GAP employee!");
	 }
	 
	 @Test 
	 public void deleteEmployee(){
		 employeePage.deleteEmployee("James");
		 Assert.assertEquals(employeePage.getIfEmployeeNameExists("James"), false);
	 }
	 
	 

}
