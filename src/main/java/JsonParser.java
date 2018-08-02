import com.google.gson.Gson;

public abstract class JsonParser {
    public static <T extends Object> T fromJson(final String json, final Class<T> classTo) {
        return new Gson().fromJson(json, classTo);
    }
}
