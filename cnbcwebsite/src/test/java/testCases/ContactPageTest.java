package testCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pojo.Contacts;

import configuration.appConfig;
import io.qameta.allure.Description;
import pages.ContactPage;
import pages.Home;
import pojo.Credentials;
import util.AppConstants;
import util.ExcelUtil;

public class ContactPageTest extends appConfig {
	Properties prop;
	ContactPage contactsPage;
	appConfig basePage;
	HomePage homePage;
	Credentials credentials;
	Contacts contacts;
	
	@BeforeTest
	public void setUp() {
		basePage = new appConfig();
		prop = basePage.init_prop();
		//driver = basePage.appStart(prop);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}	
		

    @DataProvider(name="getContactsData")
	public Iterator<Object[]> getContactsData() {
ArrayList<Object[]> testdata=ExcelUtil.getDataFromExcel();	
return testdata.iterator();
	}
	@Description("verify Contact Page ")

	@Test(priority = 1, dataProvider = "getContactsData",description = "To verify contact  page functionality")

	public void createNewContactsTest(String firstName, String lastName, String email,String oldpwd,String newpwd,String confirmpwd)
			throws InterruptedException {
		contactsPage = new ContactPage(driver);
	
	contactsPage.createContact(firstName, lastName, email, oldpwd, newpwd, confirmpwd);
	


	
	}
	
		
		
		

	}

