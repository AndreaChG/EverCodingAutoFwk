package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeesPage extends BasePage{

	    private By loginValidationMsg = By.cssSelector(".flash_notice");
	    private By createNewEmployeeLink = By.linkText("Create a new employee");
	    private By firstNameField = By.id("employee_first_name");
	    private By lastNameField = By.id("employee_last_name");
	    private By emailField = By.id("employee_email");
	    private By identificationField = By.id("employee_identification");
	    private By leaderNameField = By.id("employee_leader_name");
	    private By startWorkingYearList = By.id("employee_start_working_on_1i");
	    private By startWorkingMonthList = By.id("employee_start_working_on_2i");
	    private By startWorkingDayList = By.id("employee_start_working_on_3i");
	    private By createEmployeeButton = By.cssSelector("input[value='Create Employee']");
	    private By employeeCreationMsg = By.id("notice");

	    public EmployeesPage(WebDriver driver) {
	        super(driver);
	    }

	    public String getSignInMessage(){
	    	System.out.println("Page Title:"+ driver.getTitle());
	        WebElement validationMsg = driver.findElement(loginValidationMsg);
	        return validationMsg.getText();
	    }
	    
	    public void goToCreateEmployee(){
	    	driver.findElement(createNewEmployeeLink).click();
	    }
	    
	    public void createEmployee(String strFirstName, String strLastName, String strEmail, String strIdentification, String strLeaderName, String strStartWorkingYear, String strStartWorkingMonth, String strStartWorkingDay){
	    	System.out.println("Fill new employee information...");
	    	this.fillFirstNameField(strFirstName);
	    	this.fillLastNameField(strLastName);
	    	this.fillEmailField(strEmail);
	    	this.fillIdentificationField(strIdentification);
	    	this.fillLeaderNameField(strLeaderName);
	    	this.selectStartWorkingYear(strStartWorkingYear);
	    	this.selectStartWorkingMonth(strStartWorkingMonth);
	    	this.selectStartWorkingDay(strStartWorkingDay);
	    }
	    
	    public void clickOnCreateEmployee(){
	    	System.out.println("Proceed to create new employee");
	    	driver.findElement(createEmployeeButton).click();
	    }
	    
	    public String getEmployeeCreationMsg(){
	    	return driver.findElement(employeeCreationMsg).getText();
	    }
	    
	    private void fillFirstNameField(String strFirstName){
	    	driver.findElement(firstNameField).sendKeys(strFirstName);
	    }
	    
	    private void fillLastNameField(String strLastName){
	    	driver.findElement(lastNameField).sendKeys(strLastName);
	    }
	    
	    private void fillEmailField(String strEmail){
	    	driver.findElement(emailField).sendKeys(strEmail);
	    }
	    
	    private void fillIdentificationField(String strIdentification){
	    	driver.findElement(identificationField).sendKeys(strIdentification);
	    }
	    
	    private void fillLeaderNameField(String strLeaderName){
	    	driver.findElement(leaderNameField).sendKeys(strLeaderName);
	    }
	    
	    private void selectStartWorkingYear(String strStartWorkingYear){
	    	driver.findElement(startWorkingYearList).sendKeys(strStartWorkingYear);
	    }
	    
	    private void selectStartWorkingMonth(String strStartWorkingMonth){
	    	driver.findElement(startWorkingMonthList).sendKeys(strStartWorkingMonth);
	    }
	    
	    private void selectStartWorkingDay(String strStartWorkingDay){
	    	driver.findElement(startWorkingDayList).sendKeys(strStartWorkingDay);
	    }
	         
}
