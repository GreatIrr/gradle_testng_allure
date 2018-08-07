/**
 * Created by Iryna_Bartnytska on 8/2/2018.
 */
public class YouTubeAPI {

    private static final String URL_SEARCH = "https://www.googleapis.com/youtube/v3/search?";
    private static final String PART = "part=id&";
    private static final String API_KEY = "key=key&";
    private static final String ENDING = "type=video&maxResults=1&regionCode=UA";

    // q=blablabla
    private String searchWord;

    // videoDuration=short&videoDuration=medium
    private String videoDuration;

    // final url
    private String url = "";

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = "videoDuration=" + videoDuration + "&";
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = "q=" + searchWord + "&";
    }

    public void setUrl(String add) {
        this.url += add;
    }

    public String getUrl() {
        return this.url;
    }

    public YouTubeAPI(String searchWord, String videoDuration) {
        setUrl(URL_SEARCH);
        setUrl(PART);
        setUrl(API_KEY);
        setSearchWord(searchWord);
        setUrl(getSearchWord());
        setVideoDuration(videoDuration);
        setUrl(getVideoDuration());
        setUrl(ENDING);
    }

}
