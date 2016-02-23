package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected WebDriver driver;
	private By logOutButton = By.cssSelector("#user_information span a");
	private By logoLink = By.cssSelector("#logo_text a img");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnLogOut(){
		System.out.println("Login out from system...");
		driver.findElement(logOutButton).click();;
	}
	
	public void clickOnLogoLink(){
		System.out.println("Returning to home page");
		driver.findElement(logoLink).click();;
	}

}
