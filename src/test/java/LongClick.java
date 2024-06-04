import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LongClick extends BaseTest {

//    private static final Logger logger = LoggerFactory.getLogger(AppiumBasic.class);

    @Test
    public void LongClickTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        LongClick(ele);
//        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) ele).getId(),
//                "duration", 2000
//        ));
        String menuText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")).isDisplayed());
        //Thread.sleep(2000);
    }
}