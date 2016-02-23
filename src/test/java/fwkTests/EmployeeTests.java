package fwkTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesObjects.EmployeesPage;
import pagesObjects.LoginPage;

public class EmployeeTests extends BaseSetUpTest {
	
	 private LoginPage loginPage;
	 private EmployeesPage employeePage;
	 
	 @BeforeClass
	 public void setUp()
	    {
	        driver = getDriver();
	        loginPage = new LoginPage(driver);
	        employeePage = new EmployeesPage(driver);
	    }
	 
	 @Test
	 public void createNewEmployee(){
		 loginPage.authentication("gap-automation-test@mailinator.com","12345678");
		 employeePage.goToCreateEmployee();
		 employeePage.createEmployee("James", "Smith", "jsmith@testmail.com", "1234567890", "juanito", "2010", "January", "21");
		 Assert.assertEquals(employeePage.getEmployeeCreationMsg(),"Employee was successfully created.");
		 employeePage.backToEmployeeInformation();
		// Assert.assertEquals(employeePage.getIfEmployeeNameExists("James"), true);
	 }
	 
	 @Test 
	 public void deleteEmployee(){
		 employeePage.deleteEmployee("James");
		 Assert.assertEquals(employeePage.getIfEmployeeNameExists("James"), false);
	 }
	 
	 

}
