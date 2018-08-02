package pages;

import static com.codeborne.selenide.Configuration.browser;

/**
 * Created by Iryna_Bartnytska on 7/25/2018.
 */
public class AbstractPage {

    public AbstractPage() {
        browser = "chrome";
    }
}
