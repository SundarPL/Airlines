package Objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderObjects {
	@FindBy(xpath="//div[@class='grey-hide ng-star-inserted']//following::ol[@class='carousel-indicators ng-star-inserted']//following::li[contains(@id,'ngb-slide-')]")
	public static List<WebElement> heroImage;
	@FindBy(xpath="//div[@class='col-xs-12 col-md-6 col-lg-4 showtwo-tile-Left mb-2 ng-star-inserted']")
	public static WebElement move;

}
