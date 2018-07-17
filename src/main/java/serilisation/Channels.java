package serilisation;

import serilisation.channels.Attributes;

/**
 * Created by Iryna_Bartnytska on 7/3/2018.
 */
public class Channels {
    private String type;
    private String id;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Attributes attributes;

}
