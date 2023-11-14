package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.Contacts;
import util.ElementActions;

public class ContactPage {
	WebDriver driver;
	WebDriverWait wait;
	ElementActions elementActions;

	By name = By.name("firstname");
	By lastname = By.name("lastname");
	By email = By.name("email");
	By save = By.xpath("//button[@class='ProfileForm-saveChangeButton']");
	By oldpwd1 = By.name("oldPassword");
	By newpwd1 = By.name("newPassword");
	By connewpwd = By.name("newPasswordConfirmation");
	By submit = By.name("signup");

	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstName() throws InterruptedException {
		Thread.sleep(2000);
		WebElement uName = driver.findElement(name);
		uName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		uName.sendKeys("jet");

	}

	public void setLasttName() throws InterruptedException {
		Thread.sleep(2000);
		WebElement lName = driver.findElement(lastname);
		lName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		lName.sendKeys("jet12131");

	}

	public void setEmail() throws InterruptedException {
		Thread.sleep(2000);
		WebElement EName = driver.findElement(email);
		EName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		EName.sendKeys("jet12131@gmail.com");
	}

	public void save() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(save).click();

	}

	public void OldPwd() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(oldpwd1).sendKeys("Test@12345");

	}

	public void NewPwd() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(newpwd1).sendKeys("Test@123456");

	}

	public void confirmPwd() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(connewpwd).sendKeys("Test@123456");

	}

	public void submit() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(submit).click();

	}

	public void createContact(String firstName, String lastName, String temail,String oldpwd,String newpwd,String confirmpwd) throws InterruptedException {
		System.out.println("elementactiionbnkdnkdnqkd"+elementActions);
		Thread.sleep(2000);
		WebElement uName = driver.findElement(name);
		uName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		uName.sendKeys(firstName);
		Thread.sleep(2000);

		WebElement lName = driver.findElement(lastname);
		lName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		lName.sendKeys(lastName);
		Thread.sleep(2000);

		WebElement eEmail = driver.findElement(email);
		eEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		eEmail.sendKeys(temail);
		Thread.sleep(2000);

		driver.findElement(save).click();
		
		Thread.sleep(2000);

		WebElement olp = driver.findElement(oldpwd1);
		olp.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		olp.sendKeys(oldpwd);
		
		
		WebElement nPwd = driver.findElement(newpwd1);
		nPwd.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		nPwd.sendKeys(newpwd);
		Thread.sleep(2000);

		WebElement cPwd = driver.findElement(connewpwd);
		cPwd.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cPwd.sendKeys(confirmpwd);
		Thread.sleep(2000);

		
		Thread.sleep(2000);

		driver.findElement(submit).click();

	}

}
