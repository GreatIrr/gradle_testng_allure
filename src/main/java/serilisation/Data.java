package serilisation;

/**
 * Created by Iryna_Bartnytska on 7/3/2018.
 */
public class Data {
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    private String type;
    private String id;
    private Attributes attributes;
}
