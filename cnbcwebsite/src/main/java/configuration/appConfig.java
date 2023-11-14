package configuration;


import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class appConfig {
	public static  WebDriver driver;
	public static WebDriverWait wait;
	public Properties prop;

	public static XSSFWorkbook workbook;
	public static Actions action;
	
	@BeforeSuite
	public void appStart() throws InvalidFormatException, IOException {
//		
		WebDriverManager.chromedriver().setup();

driver = new ChromeDriver();															 
		

		wait = new WebDriverWait(driver,10);
		action = new Actions(driver);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.navigate().to("https://www.cnbc.com/");		// Stagging URL
		driver.manage().window().maximize();
		
	}
	
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			if (env == null) {
				path = "./src/main/java/config/config.properties";
			} else {
				switch (env) {
				case "qa":
					path = "./src/main/java/config/config.qa.properties";
					break;
				case "stg":
					path = "./src/main/java/config/config.stg.properties";
					break;
				case "prod":
					path = "./src/main/java/config/config.properties";
					break;
				default:
					System.out.println("no env is passed");
					break;
				}
			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not foubd.....");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
}
