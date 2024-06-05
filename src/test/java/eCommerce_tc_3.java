import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_3 extends BaseTest{

    @Test
    public void FillForm() throws InterruptedException
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Abah");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        // Define the product names
//        String[] products = {"Jordan 6 Rings", "Jordan Lift Off"};
//
//        // Loop through the products and add to cart
//        for (String product : products) {
//            // Scroll to the product
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+product+"\"));"
//            ));
//
//            // Find the product element and click "Add to Cart"
//            int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//            for (int i = 0; i < productCount; i++) {
//                String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//
//                if (productName.equalsIgnoreCase(product)) {
//                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//                    break; // Break the loop once the product is found and added to cart
//                }
//            }
//        }

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        //String lastPage = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        //Assert.assertEquals(lastPage,"Jordan 6 Rings");

        //ambil semua text product price simpan di list
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

        //count list berapa isinya
        int count = productPrices.size();
        //buat var untuk total pricesnya
        double totalSum = 0;

        //perulangan , akses setiap isi di List
        for(int i=0; i < count; i++){

            String amountString = productPrices.get(i).getText();

            //hilangkan tanda $ di depan dan buat jadi type data double
            Double price = Double.parseDouble(amountString.substring(1));
            //Double price = formattefdAmount(amountString);

            totalSum += price;
        }

        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        //String displaySum = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")).getText();
        //Double formatSum = formattefdAmount(displaySum);
        Double formatSum = Double.parseDouble(displaySum.substring(1));

        Assert.assertEquals(totalSum,formatSum);
        Thread.sleep(2000);
    }
}
