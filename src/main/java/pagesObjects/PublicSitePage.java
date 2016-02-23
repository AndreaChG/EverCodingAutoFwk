package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublicSitePage extends BasePage{

	private By publicSiteMessage = By.cssSelector("#content h1");
	private By employeeIdField = By.id("employee_identification");
	private By findEmployeeButton = By.cssSelector(".actions>input");
	
	public PublicSitePage(WebDriver driver) {
		super(driver);
	}
	
	public String getSiteTitle(){
		return driver.findElement(publicSiteMessage).getText();
	}
	
	public void findEmployee(String strEmployeeIdentification){
		System.out.println("Proceed to find an employee by Id...");
		this.fillEmployeeIdField(strEmployeeIdentification);
		this.clickOnFindEmployeeButton();
	}

	private void clickOnFindEmployeeButton() {
		driver.findElement(findEmployeeButton).click();
		
	}

	private void fillEmployeeIdField(String strEmployeeIdentification) {
		driver.findElement(employeeIdField).sendKeys(strEmployeeIdentification);		
	}

}
