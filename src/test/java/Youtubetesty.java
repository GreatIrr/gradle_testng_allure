import com.codeborne.selenide.Selenide;
import lastfmserilisation.topArtist.TopArtistResponse;
import lastfmserilisation.topArtistTracks.TopArtistTrackResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import youtubeSerilisation.Items;
import youtubeSerilisation.YoutubeResponce;

import java.util.Arrays;
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

        String last_fm = "http://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&tag=russian&api_key=last_fm&format=json&page=1";
        String lastFmResponseString = when().get(last_fm).getBody().prettyPrint();

        TopArtistResponse lastFmResponse = JsonParser.fromJson(lastFmResponseString, TopArtistResponse.class);

        String chooseArtist = lastFmResponse.getTopartists().getArtist().get(rand.nextInt(lastFmResponse.getTopartists().getArtist().size())).getName();



        String last_fm_track = "http://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&api_key=a279739ea5aedd3e58eac7b34dbba8bc&format=json&artist=" + chooseArtist;
        String lastFMTrack = when().get(last_fm_track).getBody().prettyPrint();

        TopArtistTrackResponse topArtistTrackResponse = JsonParser.fromJson(lastFMTrack, TopArtistTrackResponse.class);

        String chooseTrack = " " + topArtistTrackResponse.getTopTracks().getTrackList().get(rand.nextInt(topArtistTrackResponse.getTopTracks().getTrackList().size())).getName();

        chooseArtist += chooseTrack;

        System.out.println("We choose " + chooseArtist);

        YouTubeAPI youTubeAPI = new YouTubeAPI(chooseArtist, "short");
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
