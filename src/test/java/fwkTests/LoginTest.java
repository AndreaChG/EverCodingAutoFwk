package fwkTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesObjects.EmployeesPage;
import pagesObjects.LoginPage;

public class LoginTest extends BaseSetUpTest{
	
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
    public void testSignInUser(){
        System.out.println("User authentication...");
        loginPage.authentication("gap-automation-test@mailinator.com","12345678");
        Assert.assertEquals(employeePage.getSignInMessage(),"Signed in successfully.");

    }

}
