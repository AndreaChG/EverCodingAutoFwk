package fwkTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetUpTest {

	 protected WebDriver driver;

	    public WebDriver getDriver(){
	        return driver;
	    }

	    public void setUpDriver(String appURL){
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to(appURL);
	    }

	    @Parameters({ "appURL" })
	    @BeforeClass
	    public void initializeTestBaseSetup(String appURL) {
	        System.out.println("Mi URL:"+ appURL);
	    	try {
	            setUpDriver(appURL);

	        } catch (Exception e) {
	            System.out.println("Error....." + e.getStackTrace());
	        }
	    }

		@AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
