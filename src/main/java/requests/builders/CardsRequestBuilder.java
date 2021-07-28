package requests.builders;

import constants.Endpoints;
import constants.Fields;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import requests.RestRequest;

public class CardsRequestBuilder extends BaseRequestBuilder<CardsRequestBuilder> implements RequestBuilder {
    private static final String ENDPOINT = Endpoints.CARDS;
    private String id;
    private String entity;

    @Override
    public RestRequest buildRequest() {
        return new RestRequest(constructUrl(), requestMethod, parameters);
    }

    public CardsRequestBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CardsRequestBuilder setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public CardsRequestBuilder setName(String name) {
        this.parameters.put(Fields.NAME, name);
        return this;
    }

    public CardsRequestBuilder setDescription(String description) {
        this.parameters.put(Fields.DESCRIPTION, description);
        return this;
    }

    private String constructUrl() {
        return Stream.of(TRELLO_API_BASE, ENDPOINT, id, entity, "")
                     .filter(Objects::nonNull)
                     .collect(Collectors.joining("/"));
    }

    public CardsRequestBuilder setListId(String id) {
        this.parameters.put(Fields.LIST_ID, id);
        return this;
    }
}
