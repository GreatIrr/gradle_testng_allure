import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Iryna_Bartnytska on 7/13/2018.
 */
public class Testdev52 {
    @Test
    public void test() {
        browser = "chrome";
        Selenide.open("https://dev52-storefront.aws.gha.kfplc.com/departments/dewalt-cordless-18v-1-5ah-li-ion-combi-drill-2-batteries-dcd785c2sf-gb/163847_BQ.prd");
        WebElement add = $(By.xpath("//*[@class = 'product-addtocart-buttons']/input[@class='btn btn-primary addtobasket-analytics']"));
        add.click();
//        try {
//            browser.wa(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        $(By.xpath("//*[@id='content']/div[1]/div/div/div[2]/a[2]")).click();

//        try {
//            browser.wait(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        $(By.xpath("//*[@id='baskets-form-id']/div[1]/div/input[3]")).click();

//        try {
//            browser.wait(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        $(By.xpath("//*[@id='email-address-reg']")).sendKeys("test1@irr.com");
        $(By.xpath("//*[@id='content']/form/div[5]/input[1]")).click();

        String ttt = "//*[@id='singlePageCheckoutContainer']/form/div[2]/p[1]";
       $(By.xpath(ttt)).waitUntil(Condition.visible, 5000);

        System.out.println("hereeeeeeee =" + $(By.xpath(ttt)).getText());

    }

}
