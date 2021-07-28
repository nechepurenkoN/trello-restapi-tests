package service;

import beans.Card;
import constants.CastOptions;
import io.restassured.http.Method;
import responses.ResponseSpecifications;
import utils.Caster;

public class CardService {
    public static Card createCardByName(beans.List list, String name) {
        return Caster.cast(
            TrelloRestService
                .cards()
                .setMethod(Method.POST)
                .setListId(list.getId())
                .setName(name)
                .buildRequest()
                .send()
                .then().assertThat()
                .spec(ResponseSpecifications.goodResponseSpecification())
                .and()
                .extract().response(),
            Card.class,
            CastOptions.SINGLE
        );
    }

    public static Card getCardById(String id) {
        return Caster.cast(
            TrelloRestService
                .cards()
                .setMethod(Method.GET)
                .setId(id)
                .buildRequest()
                .send()
                .then().assertThat()
                .spec(ResponseSpecifications.goodResponseSpecification())
                .and()
                .extract().response(),
            Card.class,
            CastOptions.SINGLE
        );
    }
}
