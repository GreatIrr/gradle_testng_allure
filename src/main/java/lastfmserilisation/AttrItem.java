package lastfmserilisation;

import com.google.gson.annotations.SerializedName;

public class AttrItem {

    @SerializedName("rank")
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}
