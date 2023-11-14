package pages;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import listeners.Log;

public class Home {
	WebDriver driver;
	WebDriverWait wait;

	By loggedInUserName = By.xpath("//button[@class='SignInMenu-accountMenu']");
	By profile = By.xpath("//a[@title='profile']");

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnMyAccount() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(loggedInUserName).click();
		Thread.sleep(2000);

		driver.findElement(profile).click();

	}

}
