package org.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {
	public static Properties property=null;
	public static Properties property1=null;
	public static WebDriver driver;
	public static String value;   
	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReports;
	public static ExtentTest test;
	public static Properties property() throws IOException {
		property=new Properties();
		FileInputStream fis=new FileInputStream("config.properties");
		property.load(fis);
		return property;

	}
	public static Properties property1() throws IOException {
		property1=new Properties();
		FileInputStream fis1=new FileInputStream("input.properties");
		property1.load(fis1);
		return property1;

	}
	public String excel(int rows,int colums) throws IOException {
		String excel = property.getProperty("Excel");
		FileInputStream fis=new FileInputStream(excel);
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j <row.getPhysicalNumberOfCells(); j++) {

				Cell cell = row.getCell(j);
				value = cell.getStringCellValue();


			}
		}
		return value;
	}
	@BeforeSuite
	public void extentReport() throws IOException {
		reports=new ExtentReports();
		property();
		String Extents = property.getProperty("Extents");
		htmlReports=new ExtentHtmlReporter(System.getProperty("user.dir")+Extents);
		htmlReports.config().setDocumentTitle("Spirit_Airlines");
		htmlReports.config().setReportName("Regression Testing");
		reports.attachReporter(htmlReports);

	}
	@AfterSuite
	public void extentRportClose() {
		reports.flush();

	}
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browse) throws IOException {
		property();
		String chromeKey = property.getProperty("Chromekey");
		System.out.println(chromeKey);
		String chromeValue = property.getProperty("Chromevalue");
		System.out.println(chromeValue);
		String Firefoxkey = property.getProperty("Firefoxkey");
		String Firefoxvalue = property.getProperty("Firefoxvalue");
		String url = property.getProperty("Url");
		if(browse.equalsIgnoreCase("chrome")) {

			System.setProperty(chromeKey, chromeValue);
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);

		}
		else if(browse.equalsIgnoreCase("firefox")) {

			System.setProperty(Firefoxkey, Firefoxvalue);
			driver=new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		}

	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"Failed testcase"+result.getName());
			test.log(Status.FAIL,"Failed testcase"+result.getThrowable());
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String output = property.getProperty("ouput");
			
			File dest=new File(output);
			FileUtils.copyFile(src, dest);
			test.addScreenCaptureFromPath(output);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,"Testcase"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,"Testcase"+result.getName());
		}
		driver.quit();
	}

}
