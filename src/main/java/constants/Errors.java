package constants;

import lombok.experimental.UtilityClass;
import org.apache.http.HttpStatus;

@UtilityClass
public class Errors {
    public final String BAD_REQUEST = String.format("Expected status code <%d> but was <%d>",
        HttpStatus.SC_OK,
        HttpStatus.SC_BAD_REQUEST);

    public final String BAD_CONTENT_TYPE = "Expected content-type \"JSON\" doesn't match actual content-type";
}
