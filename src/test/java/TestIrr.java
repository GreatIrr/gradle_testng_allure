import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import serilisation.Response;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * Created by Iryna_Bartnytska on 7/17/2018.
 */
public class TestIrr {
    @Step
    @Description("Irr description")
    @Feature("feature")
    @Test
    public void test() {

        String url = "http://demo6192171.mockable.io/v1/content/SFXUK/marketingChannels";
        String url_nasa = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=AYPyqHfLdecyfpdvTYkxk23f7H1Fbh6l7sYPAhQX&camera=FHAZ";
        given()
                .contentType("JSON").
                when()
                .get(url).
                then()
                .statusCode(HttpStatus.SC_OK);
        //.statusCode(503);

        Response response1 = when().get(url).as(Response.class);
        System.out.println("ID = " + response1.getData().getId());
        System.out.println("Label email =" + response1.getData().getAttributes().getChannels()[0].getAttributes().getLabel());


        io.restassured.response.Response response3 = when().get(url_nasa);
        System.out.println(response3.body().jsonPath().get().toString());

        browser = "chrome";
        Selenide.open("https://www.google.com");
        //Selenide.getElement(By.id("lst-ib")).sendKeys("Selenide tutorial");
        WebElement find = Selenide.getElement(By.id("lst-ib"));
        find.sendKeys("Selenide tutorial for Ira from kits");
        find.submit();
        $(By.id("lst-ib")).should(Condition.exist);

    }
}
