package lastfmserilisation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Iryna_Bartnytska on 8/2/2018.
 */
public class Topartists {

    @SerializedName("artist")
    private List<Artist> artist;

    @SerializedName("@attr")
    private Attr attr;

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }
}
