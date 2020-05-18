package Testcases;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flight_Status_Test {
	@FindBy(id="flightstatus")
	public static WebElement flight_Status_Click;
	@FindBy(xpath="//label[@for='radio-fs1']")
	public static WebElement check_By_Destination;
	@FindBy(id="OriginStationCode")
	public static WebElement fromPlace;
	@FindBy(id="DestinationStationCode")
	public static WebElement toPlace;
	@FindBy(id="Date01")
	public static WebElement date;
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement checkStatus;
	
	

}
