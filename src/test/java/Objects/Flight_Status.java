package Objects;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.test.Base;
import org.testng.annotations.Test;

import Testcases.Flight_Status_Test;

public class Flight_Status extends Base {
	@Test
	public void flightStatus() throws IOException {
		test=reports.createTest("Flight_Status");
		PageFactory.initElements(driver, Flight_Status_Test.class);
		Flight_Status_Test.flight_Status_Click.click();
		Flight_Status_Test.check_By_Destination.click();
		property1();
		String Fromstatus = property1.getProperty("Fromstatus");
		Flight_Status_Test.fromPlace.click();
		Flight_Status_Test.fromPlace.sendKeys(Fromstatus);
		String Tostatus = property1.getProperty("Tostatus");
		Flight_Status_Test.toPlace.click();
		Flight_Status_Test.toPlace.sendKeys(Tostatus);
		Select s=new Select(Flight_Status_Test.date);
		s.selectByVisibleText("Saturday, May 23, 2020");
		Flight_Status_Test.checkStatus.click();
		

	}

}
