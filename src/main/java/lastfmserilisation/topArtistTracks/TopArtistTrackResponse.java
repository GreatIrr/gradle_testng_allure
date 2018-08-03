package lastfmserilisation.topArtistTracks;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iryna_Bartnytska on 8/3/2018.
 */
public class TopArtistTrackResponse {

    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }

    @SerializedName("toptracks")
    private TopTracks topTracks;
}
