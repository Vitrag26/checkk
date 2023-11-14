package testCases;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.appConfig;
import io.qameta.allure.Description;
import pages.Home;
import pages.LoginPage;
import pojo.Credentials;

public class HomePage extends appConfig {
	Home homePage;
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
	@Description("verify Home Page ")

	@Test(priority = 1, enabled = true, description = "To verify Home page functionality")
	public void HomeSetup() throws InterruptedException {
		Thread.sleep(2000);
		homePage = new Home(driver);
		homePage.ClickOnMyAccount();

	}
}
