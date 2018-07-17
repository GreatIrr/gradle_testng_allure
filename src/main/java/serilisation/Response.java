package serilisation;

/**
 * Created by Iryna_Bartnytska on 7/3/2018.
 */
public class Response {
    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    private Data data;
    private Links links;
    private Meta meta;


}
