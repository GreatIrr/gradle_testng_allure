import com.codeborne.selenide.Selenide;
import lastfmserilisation.LastFmResponse;
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

        Random rand = new Random();
        String last_fm = "http://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&tag=hard rock&api_key=a279739ea5aedd3e58eac7b34dbba8bc&format=json&page=1";
        String lastFmResponseString = when().get(last_fm).getBody().prettyPrint();
        System.out.println(lastFmResponseString);
        LastFmResponse lastFmResponse = JsonParser.fromJson(lastFmResponseString, LastFmResponse.class);

        String chooseArtist = lastFmResponse.getTopartists().getArtist().get(rand.nextInt(lastFmResponse.getTopartists().getArtist().size())).getName();

        System.out.println("We choose " + chooseArtist);

        YouTubeAPI youTubeAPI = new YouTubeAPI(chooseArtist, "medium");
        String url = youTubeAPI.getUrl();
        System.out.println("URL = " + url);

        given()
                .contentType("JSON").
                when()
                .get(url)
                .then()
                .statusCode(HttpStatus.SC_OK);


        YoutubeResponce response = when().get(url).as(YoutubeResponce.class);

        Items item = Arrays.asList(response.getItems()).get(rand.nextInt(response.getItems().length));
        String videoId = item.getId().getVideoId();
        System.out.println("videoId = " + videoId);
        String newYoutubeUrl = "https://www.youtube.com/watch?v=" + videoId;
        browser = "chrome";
        Selenide.open(newYoutubeUrl);
        Thread.sleep(100000);



    }
}
