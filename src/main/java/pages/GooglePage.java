package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Configuration.browser;

/**
 * Created by Iryna_Bartnytska on 7/6/2018.
 */


public class GooglePage {

    private final String url = "https://www.google.com";

    @FindBy(id = "lst-ib")
    WebElement find;

    public void openGoogle() {
        browser = "chrome";
        Selenide.open("https://www.google.com");
    }

    public void findWords(final String... words ) {

        String result = Arrays.asList(words).stream().map(String::toString).collect(Collectors.joining(""));
        find.sendKeys(result);
        find.submit();
    }


}
