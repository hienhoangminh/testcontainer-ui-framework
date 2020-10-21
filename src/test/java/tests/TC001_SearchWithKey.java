package tests;

import driverFactory.DriverFactory;
import driverFactory.DriverType;
import org.junit.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import pages.HomePage;
import utils.PropertiesHelper;


import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TC001_SearchWithKey {

    private RemoteWebDriver driver;
    private HomePage homePage;

    @Before
    public void SeleniumContainerTest(){
        driver = chrome.getWebDriver();
    }

    @Rule
    public BrowserWebDriverContainer chrome = DriverFactory.getDriver(DriverType.CHROME.name().toLowerCase());

    @Test
    public void searchText() throws IOException {
        homePage = HomePage.init(driver).launch(PropertiesHelper.getPropertyByName("dev"));
        assertThat(homePage.isAt()).isEqualTo(true);

        homePage.setSearchText("dress")
                .clickOnSearchButton();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
