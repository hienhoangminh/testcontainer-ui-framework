package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage extends AbstractPage{

    private static By by = By.xpath("//div[contains(@class,'a-color-secondary')]/span[contains(@class,'a-text-normal')]");
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    private WebElement searchTitle;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public static SearchPage init(WebDriver driver) {
        return new SearchPage(driver);
    }

    @Override
    public boolean isAt(){
        return this.searchTitle.isDisplayed();
    }

}
