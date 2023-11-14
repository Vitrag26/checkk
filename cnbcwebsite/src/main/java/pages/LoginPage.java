package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.Credentials;
import util.ElementActions;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	ElementActions elementActions;

	static String languagetest = "";

	// Login Objects

	By username = By.name("email");
	By password = By.name("password");
	By login = By.name("signin");
	By signup = By.xpath("//div[@class='SignInMenu-signInMenu']/a");
	By check = By.xpath("//span[@class='Checkboxes-checkmark']");
	By errorMesg = By.xpath("h5.private-alert__title");
	By errorMesg1 = By.xpath("//div[@class='AuthForms-miscellaneousError']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void inputLoginDetails(Credentials credentials) throws InterruptedException {
		System.out.println("credentials are : " + credentials.getEmailID()  + " " + credentials.getPassword());
		driver.findElement(signup).click();
		Thread.sleep(2000);
		driver.findElement(username).sendKeys(credentials.getEmailID());
		driver.findElement(password).sendKeys(credentials.getPassword());
		driver.findElement(check).click();
		driver.findElement(login).click();

	}

}
