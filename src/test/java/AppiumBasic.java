import io.appium.java_client.AppiumBy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppiumBasic extends BaseTest{

//    private static final Logger logger = LoggerFactory.getLogger(AppiumBasic.class);

    @Test
    public void AppiumTest(){

//        try {
            // Start the Appium service
            //logger.info("Starting Appium service...");
            //service.start();

            // Set the timeout to allow the server enough time to start
//            Thread.sleep(15000); // Increase the timeout if needed

//            UiAutomator2Options options = new UiAutomator2Options();
//            options.setDeviceName("Android API 34");
//            options.setApp("C:\\Users\\NITRO 5\\IdeaProjects\\AppiumTest\\src\\test\\resources\\ApiDemos-debug.apk");
//
//            // Initialize the AndroidDriver
//            logger.info("Creating AndroidDriver...");
//            AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);

            // Your test code here
            driver.findElement(AppiumBy.accessibilityId("Preference")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
            driver.findElement(By.id("android:id/checkbox")).click();
            driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
            String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
            Assert.assertEquals(alertTitle,"WiFi settings");
            driver.findElement(By.id("android:id/edit")).sendKeys("Test punya siapa bebas");
            driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
            //kalau x path bisa seperti ini
            //driver.findElement(By.xpath("sdas"))
            // Quit the driver
//            driver.quit();

//        } catch (URISyntaxException | MalformedURLException | InterruptedException e) {
//            logger.error("Error occurred: ", e);
//        } finally {
//            // Stop the Appium service
//            logger.info("Stopping Appium service...");
//            //service.stop();
//        }
    }
}