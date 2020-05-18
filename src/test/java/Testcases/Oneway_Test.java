package Testcases;


import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.test.Base;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.Oneway_Objects;

public class Oneway_Test extends Base {
	
	
	
	@Test(expectedExceptions = StaleElementReferenceException.class)
	public void oneway() throws IOException, InterruptedException {
		test=reports.createTest("Verify_Oneway");
		PageFactory.initElements(driver, Oneway_Objects.class);
		Oneway_Objects.onewayTrip.click();
		property1();
		//String from = property1.getProperty("FromPlace");
		//String to = property1.getProperty("ToPlace");
		String date = property1.getProperty("Date");
		Oneway_Objects.fromPlace.click();
		Oneway_Objects.fromPlace.clear();
		Oneway_Objects.fromPlace.sendKeys("Los Angeles, CA (LAX)");
		Oneway_Objects.fromPlace.click();
		Oneway_Objects.toPlace.clear();
		Oneway_Objects.toPlace.sendKeys("Indianapolis, IN (IND)");
		Oneway_Objects.fromPlace.click();
		Oneway_Objects.flightDate.clear();
		Oneway_Objects.flightDate.sendKeys(date);
		Oneway_Objects.passengers.click();
		Oneway_Objects.addAdult.click();
		Oneway_Objects.addChild.click();
		Oneway_Objects.submit.click();
		Oneway_Objects.childDOB.click();
		Oneway_Objects.childYear.click();
		Oneway_Objects.childMonth.click();
		Oneway_Objects.childDay.click();
		Oneway_Objects.childSubmit.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("argument[0].click()", Oneway_Objects.submit);
		//Oneway_Objects.submit.click();
		
	}



}
