package utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import constants.CastOptions;
import io.restassured.response.Response;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Caster {
    public static <T, U> U cast(Response response, Class<T> clazz) {
        return cast(response, clazz, CastOptions.LIST);
    }

    public static <T, U> U cast(Response response, Class<T> clazz, CastOptions opt) {
        Gson gson = new Gson(); // can not use the conventional way due to type erasure
        JsonElement jsonElement = JsonParser.parseString(response.asString().trim());
        List<T> list = null;
        if (jsonElement.isJsonArray()) {
            list = StreamSupport.stream(
                jsonElement.getAsJsonArray().spliterator(), true
            ).map(el -> gson.fromJson(el, clazz)).collect(Collectors.toList());
        } else {
            list = Collections.singletonList(gson.fromJson(jsonElement, clazz));
        }

        if (opt.equals(CastOptions.LIST)) {
            return castHelper(list);
        }
        assertThat ("We expect to get one answer, but got " + list.size(), list, hasSize(1));
        return castHelper(list.get(0));
    }

    private static <T, U> U castHelper(T obj) {
        return (U) obj;
    }
}
