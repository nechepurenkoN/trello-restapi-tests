package requests.builders;

import constants.Endpoints;
import constants.Fields;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import requests.Request;
import requests.RestRequest;

public class ListsRequestBuilder extends BaseRequestBuilder<ListsRequestBuilder> implements RequestBuilder {
    private static final String ENDPOINT = Endpoints.LISTS;
    private String id;
    private String entity;

    public ListsRequestBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ListsRequestBuilder setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public ListsRequestBuilder setName(String name) {
        this.parameters.put(Fields.NAME, name);
        return this;
    }

    @Override
    public Request buildRequest() {
        return new RestRequest(constructUrl(), requestMethod, parameters);
    }

    private String constructUrl() {
        return Stream.of(TRELLO_API_BASE, ENDPOINT, id, entity, "")
                     .filter(Objects::nonNull)
                     .collect(Collectors.joining("/"));
    }

    public ListsRequestBuilder setBoardId(String id) {
        this.parameters.put(Fields.BOARD_ID, id);
        return this;
    }
}
