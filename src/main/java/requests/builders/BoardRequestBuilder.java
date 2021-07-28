package requests.builders;

import constants.Endpoints;
import constants.Fields;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import requests.RestRequest;

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

    public BoardRequestBuilder setName(String name) {
        this.parameters.put(Fields.NAME, name);
        return this;
    }

    public BoardRequestBuilder setDescription(String description) {
        this.parameters.put(Fields.DESCRIPTION, description);
        return this;
    }

    private String constructUrl() {
        return Stream.of(TRELLO_API_BASE, ENDPOINT, id, entity, "")
                     .filter(Objects::nonNull)
                     .collect(Collectors.joining("/"));
    }

    public BoardRequestBuilder setDefaultLists(boolean needDefaults) {
        this.parameters.put(Fields.DEFAULT_LISTS, String.valueOf(needDefaults));
        return this;
    }
}
