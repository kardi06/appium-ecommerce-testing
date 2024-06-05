import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    public static final Logger logger = LoggerFactory.getLogger(AppiumBasic.class);

    public Double formattefdAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    @BeforeClass
    public void ConfigureAppium()
    {
        // Configure the Appium service
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\NITRO 5\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")  // Increase log level to debug
                .build();
        service.start();
        //logger.info("Starting Appium service...");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android API 34");
        //options.setApp("C:\\Users\\NITRO 5\\IdeaProjects\\AppiumTest\\src\\test\\resources\\ApiDemos-debug.apk");
        options.setApp("C:\\Users\\NITRO 5\\IdeaProjects\\AppiumTest\\src\\test\\resources\\General-Store.apk");

        // Initialize the AndroidDriver
        //logger.info("Creating AndroidDriver...");
        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }catch (URISyntaxException | MalformedURLException e) {
            logger.error("Error occurred: ", e);
        }

    }

    public void LongClick(WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", 2000
        ));
    }

    public void SwipeAction(WebElement ele, String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
        service.stop();
    }

}
