package serilisation;

/**
 * Created by Iryna_Bartnytska on 7/3/2018.
 */
public class Attributes {

    private String introductionText;

    public String getIntroductionText() {
        return introductionText;
    }

    public void setIntroductionText(String introductionText) {
        this.introductionText = introductionText;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getChannelsVersionId() {
        return channelsVersionId;
    }

    public void setChannelsVersionId(String channelsVersionId) {
        this.channelsVersionId = channelsVersionId;
    }

    public String getPrivacyNoticeVersionId() {
        return privacyNoticeVersionId;
    }

    public void setPrivacyNoticeVersionId(String privacyNoticeVersionId) {
        this.privacyNoticeVersionId = privacyNoticeVersionId;
    }

    public Channels[] getChannels() {
        return channels;
    }

    public void setChannels(Channels[] channels) {
        this.channels = channels;
    }

    private String summaryText;
    private String channelsVersionId;
    private String privacyNoticeVersionId;
    private Channels[] channels;
}
