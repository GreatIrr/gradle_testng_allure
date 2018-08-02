import com.codeborne.selenide.Selenide;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import youtubeSerilisation.Items;
import youtubeSerilisation.YoutubeResponce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Configuration.browser;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * Created by Iryna_Bartnytska on 8/2/2018.
 */
public class Youtubetesty {

    @Test
    public void checkApiYoutube() throws InterruptedException {

        //List<String> famousRockBands = new ArrayList<>("Queen", "Opeth");

        YouTubeAPI youTubeAPI = new YouTubeAPI("Smells Like Teen Spirit", "medium");
        String url = youTubeAPI.getUrl();
        System.out.println("URL = " + url);

        given()
                .contentType("JSON").
                when()
                .get(url)
                .then()
                .statusCode(HttpStatus.SC_OK);


        YoutubeResponce response = when().get(url).as(YoutubeResponce.class);
        Random rand = new Random();
        Items item = Arrays.asList(response.getItems()).get(rand.nextInt(response.getItems().length));
        String videoId = item.getId().getVideoId();
        System.out.println("videoId = " + videoId);
        String newYoutubeUrl = "https://www.youtube.com/watch?v=" + videoId;
        browser = "chrome";
        Selenide.open(newYoutubeUrl);
        wait(100000);

    }
}
