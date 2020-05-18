package Objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterObjects {
	@FindBy(xpath="//a[contains(text(),'Trip Plan')]")
	public static WebElement tripPlan;
	@FindBy(xpath="(//div[@class='ng-star-inserted'])[4]//following::ul[@class='cities']//following::li[@class='ng-star-inserted']//following::a[contains(@href,'https://www.spirit.com/en/flights-to-')]")
	public static List<WebElement> allFooterLinks;
	@FindBy(xpath="//div[@class='row inner-pencil']")
	public static WebElement lowView;

}
