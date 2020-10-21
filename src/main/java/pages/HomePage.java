package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public static HomePage init(WebDriver driver) {
        return new HomePage(driver);
    }

    public boolean isAt() {
        return this.signInLink.isDisplayed();
    }

    public HomePage clickOnSignInLink() {
        wait.until(ExpectedConditions.visibilityOf(this.signInLink));
        this.signInLink.click();
        return this;
    }

    public HomePage setSearchText(String value) {
        this.searchField.sendKeys(value);
        return this;
    }

    public HomePage clickOnSearchButton() {
        this.searchButton.click();
        return this;
    }

    public HomePage launch(String url){
        driver.get(url);
        return this;
    }

}
