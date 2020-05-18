package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Oneway_Objects {
	@FindBy(xpath="//label[@for='radio-oneWay']")
	public static WebElement onewayTrip;
	@FindBy(xpath="//input[@id='flight-OriginStationCode']")
	public static WebElement fromPlace;
	@FindBy(xpath="//input[@id='flight-DestinationStationCode']")
	public static WebElement toPlace;
	@FindBy(xpath="//input[@id='flight-Date']")
	public static WebElement flightDate;
	@FindBy(xpath="//input[@id='passengers']")
	public static WebElement passengers;
	@FindBy(xpath="(//i[@class='icon-add-circle'])[1]")
	public static WebElement addAdult;
	@FindBy(xpath="(//i[@class='icon-add-circle'])[2]")
	public static WebElement addChild;
	@FindBy(id="dateOfBirth1")
	public static WebElement childDOB;
	@FindBy(xpath="(//span[contains(text(),'2013')])[2]")
	public static WebElement childYear;
	@FindBy(xpath="//span[contains(text(),'January')]")
	public static WebElement childMonth;
	@FindBy(xpath="(//span[contains(text(),'9')])[1]")
	public static WebElement childDay;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	public static WebElement childSubmit;
	@FindAll({@FindBy(xpath="//button[@type='submit']"),
		@FindBy(xpath="//button[contains(text(),' Search Flights ')]")})
	public static WebElement submit;
	
}
