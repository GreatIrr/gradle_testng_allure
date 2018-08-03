package lastfmserilisation.topArtist;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iryna_Bartnytska on 8/2/2018.
 */
public class TopArtistResponse {


    @SerializedName("topartists")
    private Topartists topartists;

    public Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }


}
