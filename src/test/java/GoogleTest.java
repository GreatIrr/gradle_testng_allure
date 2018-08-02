import org.testng.annotations.Test;
import steps.GoogleSteps;

/**
 * Created by Iryna_Bartnytska on 7/6/2018.
 */
public class GoogleTest {

    private GoogleSteps googleSteps = new GoogleSteps();

    @Test
    public void checkPicture() {
        googleSteps.newRequest("Selenide tutorial");
    }

}
