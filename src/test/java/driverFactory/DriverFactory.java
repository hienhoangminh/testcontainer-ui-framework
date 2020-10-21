package driverFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;


public class DriverFactory {


    private static final Map<String, Supplier<BrowserWebDriverContainer>> driverMaps = new HashMap<>();


    private static final Supplier<BrowserWebDriverContainer> chromeSupplier = () -> {
        return new BrowserWebDriverContainer()
                .withCapabilities(new ChromeOptions().addArguments("--icognito"))
                .withRecordingMode(RECORD_ALL, new File("./target/"));
    };

    private static final Supplier<BrowserWebDriverContainer> firefoxSupplier = () -> {
        return new BrowserWebDriverContainer()
                .withCapabilities(new FirefoxOptions().addArguments("-private"))
                .withRecordingMode(RECORD_ALL, new File("./target"));
    };


    static {
        driverMaps.put(DriverType.CHROME.name().toLowerCase(), chromeSupplier);
        driverMaps.put(DriverType.FIREFOX.name().toLowerCase(), firefoxSupplier);
    }

    public static final BrowserWebDriverContainer getDriver(String type) {
        return driverMaps.get(type).get();
    }
}
