package testCases;

import pages.*;
import pojo.Credentials;
//import pages.Home;
import configuration.appConfig;
import io.qameta.allure.Description;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends appConfig {
	LoginPage objLogin;
	appConfig basePage;
	Properties prop;
	Credentials credentials;

	@BeforeTest
	public void setUp() {
		basePage = new appConfig();
		prop = basePage.init_prop();
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}	
	@Description("verify app login Test")

	@Test(priority = 1, enabled = true, description = "To verify login functionality")
	public void loginValid() throws InterruptedException {
		Thread.sleep(1500);
		objLogin = new LoginPage(driver);		
		objLogin.inputLoginDetails(credentials);
		}
	
	
	
	
}
