package pagesObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
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
	    private By createEmployeeButton = By.cssSelector("[value='Create Employee']");
	    private By employeeCreationMsg = By.id("notice");
	    private By backLinkButton = By.xpath(".//*[@id='content']/a[contains(text(),'Back')]");

	    public EmployeesPage(WebDriver driver) {
	        super(driver);
	    }

	    public String getSignInMessage(){
	    	System.out.println("User is authenticated");
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
	    	this.clickOnCreateEmployeeButton();
	    }
	    
	    public void backToEmployeeInformation(){
	    	driver.findElement(backLinkButton).click();
	    }
	    
	    public void deleteEmployee(String strFirstName){
	    	System.out.println("Proceed to delete employee...");
	    	By deleteEmployeeButton = By.xpath(".//td[contains(text(),'"+strFirstName+"')]/following-sibling::td[last()]/a");
	    	driver.findElement(deleteEmployeeButton).click();
	    	System.out.println("Proceed to delete confirmation employee...");
	    	Alert myAlert = driver.switchTo().alert();
	    	myAlert.accept();
	    }
	    
	    public String getEmployeeCreationMsg(){
	    	return driver.findElement(employeeCreationMsg).getText();
	    }
	    
	    public boolean getIfEmployeeNameExists(String strFirstName){
	    	boolean elementExists;
	    	try{
	    		driver.findElement(By.xpath(".//td[contains(text(),'"+ strFirstName +"')]"));
	    		elementExists = true;
	    	} catch(Exception e){
	    		elementExists = false;
	    	}
			return elementExists;
	    }
	    
	    public void goToCreateNewEmployee(){
	    	System.out.println("Go to new employee creation link ");
	    	driver.findElement(createNewEmployeeLink).click();
	    }
	    
	    private void clickOnCreateEmployeeButton(){
	    	System.out.println("Proceed to create new employee");
	    	driver.findElement(createEmployeeButton).click();
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
