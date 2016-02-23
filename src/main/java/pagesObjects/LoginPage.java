package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	private By signInButton = By.cssSelector(".submit");
    private By userName = By.id("user_email");
    private By userPassword = By.id("user_password");
    private By publicSiteLink = By.xpath(".//*[@id='content']/p/a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void authentication(String srtUserName, String strUserPassword) {
    	this.fillUserName(srtUserName);
        this.fillUserPassword(strUserPassword);
        this.clickSignIn();
    }
    
    public void goToPublicSite(){
    	driver.findElement(publicSiteLink).click();
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

}
