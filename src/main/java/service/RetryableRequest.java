package service;

import io.restassured.response.Response;
import java.util.List;
import lombok.SneakyThrows;

public class RetryableRequest implements Request {
    private final int times;
    private final int delay;
    private final List<Integer> onCodes;
    private final Request request;

    public RetryableRequest(int times, int delay, List<Integer> onCodes, Request request) {
        this.times = times;
        this.delay = delay;
        this.onCodes = onCodes;
        this.request = request;
    }

    @SneakyThrows
    @Override
    public Response send() {
        if (times <= 0) {
            throw new IllegalArgumentException("Times param should be positive");
        }

        int timesCounter = times;
        while (timesCounter > 0) {
            --timesCounter;
            Response response = request.send();
            if (!onCodes.contains(response.statusCode())) {
                return response;
            }
            Thread.sleep(delay);
        }

        throw new RuntimeException(String.format(
            "Sent request %d times, but every response contained a code in onCodesList",
            times
        ));
    }
}
