package steps;

import pages.GooglePage;

/**
 * Created by Iryna_Bartnytska on 7/6/2018.
 */
public class GoogleSteps {

    private GooglePage googlePage;

    public void newRequest(final String... request) {
        googlePage.findWords(request);
    }


}
