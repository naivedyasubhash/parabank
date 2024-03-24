package com.parabank.testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseTest {
	
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})

	public void setUp(String os, String browser) throws IOException {
		//driver initalization
		switch(browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
			default:
			System.out.println("Invalid Browser");
			return;
		}
	    //logger 
	    logger=LogManager.getLogger(this.getClass());
	    FileReader file=new FileReader(".//src/test/resources/config.properties");
	    p=new Properties();
	    p.load(file);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	
		
		
	}
	
	@AfterClass(groups= {"regression","sanity","master"})
	public void tearDown() {
		driver.close();
		
	}
	
	public String randomString() {
		String randomString=RandomStringUtils.randomAlphabetic(5);
		return randomString;
		}
	
	public String randomNumbers() {
		String numerics=RandomStringUtils.randomNumeric(10);
		return numerics;
		}
	
	public String randomAlphaNumeric() {
		String randomString=RandomStringUtils.randomAlphabetic(5);
		String numerics=RandomStringUtils.randomNumeric(3);
		return (randomString+"@"+numerics);
		}
	
	public String captureScreen(String tname) {
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+timestamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
	
	
		
		
	}
	
	


