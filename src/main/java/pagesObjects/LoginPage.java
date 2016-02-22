package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	private By signInButton = By.cssSelector(".submit");
    private By userName = By.id("user_email");
    private By userPassword = By.id("user_password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Setting the user name
    private void fillUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    //Setting the password
    private void fillUserPassword(String strUserPassword){
        driver.findElement(userPassword).sendKeys(strUserPassword);
    }

    //Clicking on sign in button
    private void clickSignIn(){
        driver.findElement(signInButton).click();
    }

    public void authentication(String srtUserName, String strUserPassword) {
    	System.out.println("Page Title:"+ driver.getTitle());
    	this.fillUserName(srtUserName);
        this.fillUserPassword(strUserPassword);
        this.clickSignIn();
    }
}
