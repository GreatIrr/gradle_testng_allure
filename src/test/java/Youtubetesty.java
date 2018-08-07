import com.codeborne.selenide.Selenide;
import lastfmserilisation.topArtist.TopArtistResponse;
import lastfmserilisation.topArtistTracks.TopArtistTrackResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import youtubeSerilisation.Items;
import youtubeSerilisation.YoutubeResponce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Configuration.browser;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * Created by Iryna_Bartnytska on 8/2/2018.
 */
public class Youtubetesty {

    @Test(invocationCount = 10)
    public void checkApiYoutube() throws InterruptedException {

        HashMap<String, String> test = new HashMap<>();
        test.put("test",null);
        test.put("test1", "");

        //System.out.println("test :" + test.get("test"));
        if(!test.containsKey("test2") || test.get("test2").isEmpty()) {
            System.out.println("hurrah");
        }

        Random rand = new Random();

        List<String> genres = Arrays.asList("thrash rock", "alternative rock", "progressive rock", "hard rock",
                "classic rock", "rock", "progressive rock", "hardcore",
                "psychedelic rock",  "indie rock", "chillout","post-rock"//,
//                "70s",
//                "thrash metal", "metal", "metalcore",
//                "heavy metal", "80s", "blues", "psychedelic",
//                "guitar", "jazz", "acoustic", "folk",
//                "electronic", "indie", "pop", "chill", "punk",
//                "Hip-Hop", "instrumental", "soul",
//                "Classical", "industrial", "punk rock", "japanese","power metal",
//                 "german", "funk", "hip hop", "russian", "synthwave"
        );

        String genre = genres.get(rand.nextInt(genres.size()));


        String last_fm = "http://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&api_key=key&format=json&limit=25&tag=" + genre;
        String lastFmResponseString = when().get(last_fm).getBody().prettyPrint();

        TopArtistResponse lastFmResponse = JsonParser.fromJson(lastFmResponseString, TopArtistResponse.class);

        String chooseArtist = lastFmResponse.getTopartists().getArtist().get(rand.nextInt(lastFmResponse.getTopartists().getArtist().size())).getName();



        String last_fm_track = "http://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&api_key=a279key739ea5aedd3e58eac7b34dbba8bc&format=json&limit=25&artist=" + chooseArtist;
        String lastFMTrack = when().get(last_fm_track).getBody().prettyPrint();

        TopArtistTrackResponse topArtistTrackResponse = JsonParser.fromJson(lastFMTrack, TopArtistTrackResponse.class);

        String chooseTrack = " " + topArtistTrackResponse.getTopTracks().getTrackList().get(rand.nextInt(topArtistTrackResponse.getTopTracks().getTrackList().size())).getName();

        chooseArtist += chooseTrack;


        YouTubeAPI youTubeAPI = new YouTubeAPI(chooseArtist, "any");
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
        System.out.println("Genre : " + genre);
        System.out.println("We choose " + chooseArtist);
        System.out.println("video url = " + "https://www.youtube.com/watch?v=" + videoId);
        String newYoutubeUrl = "https://www.youtube.com/watch?v=" + videoId;
        browser = "chrome";
        Selenide.open(newYoutubeUrl);
        Thread.sleep(240000);
        Selenide.close();


    }
}
