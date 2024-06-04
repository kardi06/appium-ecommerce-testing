import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Misc extends BaseTest{

//    private static final Logger logger = LoggerFactory.getLogger(AppiumBasic.class);

    @Test
    public void MiscTest()
    {

//            driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

            //Activity
            ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                    "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
            ));
            driver.findElement(By.id("android:id/checkbox")).click();
            //Orientation to landscape
            DeviceRotation landscape = new DeviceRotation(0,0,90);
            driver.rotate(landscape);

            driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
            String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
            Assert.assertEquals(alertTitle,"WiFi settings");

            //copy paste
            //copy to clipboard - paste it
            driver.setClipboardText("Test punya siapa bebas");
            driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
            //Enter button
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

            //back button
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            //home button
            driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}