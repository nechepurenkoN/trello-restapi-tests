package service;

import requests.builders.BoardRequestBuilder;
import requests.builders.ListsRequestBuilder;

public class TrelloRestService {

    private TrelloRestService() {
    }

    public static BoardRequestBuilder boards() {
        return new BoardRequestBuilder();
    }

    public static ListsRequestBuilder lists() {
        return new ListsRequestBuilder();
    }
}
