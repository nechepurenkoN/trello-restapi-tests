package constants;

import java.io.IOException;
import java.util.Properties;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Credentials {
    private final String CREDENTIALS_PATH = "/credentials/auth.properties";
    public final String API_KEY_PARAM = "key";
    public final String API_TOKEN_PARAM = "token";
    public final String API_KEY;
    public final String API_TOKEN;

    static {
        Properties props = new Properties();
        try {
            props.load(Credentials.class.getResourceAsStream(CREDENTIALS_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        API_KEY = props.getProperty(API_KEY_PARAM);
        API_TOKEN = props.getProperty(API_TOKEN_PARAM);
    }
}
