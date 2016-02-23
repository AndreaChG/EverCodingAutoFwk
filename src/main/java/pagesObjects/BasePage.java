package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected WebDriver driver;
	private By logOutButton = By.cssSelector("#user_information a");
	private By logoLink = By.cssSelector("logo_text a img");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnLogOut(){
		driver.findElement(logOutButton);
	}
	
	public void clickOnLogoLink(){
		driver.findElement(logoLink);
	}

}
