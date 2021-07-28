package builders;

import constants.Endpoints;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import service.RestRequest;

public class BoardRequestBuilder extends BaseRequestBuilder<BoardRequestBuilder> implements RequestBuilder {

    private static final String ENDPOINT = Endpoints.BOARDS;
    private String id;
    private String entity;

    @Override
    public RestRequest buildRequest() {
        return new RestRequest(constructUrl(), requestMethod, parameters);
    }

    public BoardRequestBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BoardRequestBuilder setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    private String constructUrl() {
        return Stream.of(TRELLO_API_BASE, ENDPOINT, id, entity)
                     .filter(Objects::nonNull)
                     .collect(Collectors.joining("/"));
    }
}
