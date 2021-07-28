package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import beans.Board;
import beans.Card;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
import providers.CardsProvider;
import service.BoardService;
import service.CardService;
import service.ListService;

public class CardsTest implements CleanBoards {
    @Test(
        dataProviderClass = CardsProvider.class,
        dataProvider = "listAndNewCardName"
    )
    public void cardsCanBeAddedToTheList(beans.List emptyList, List<String> cardNames) {
        assertThat(ListService.getAllCards(emptyList)).hasSize(0);

        cardNames.forEach(name -> CardService.createCardByName(emptyList, name));
        List<Card> allCards = ListService.getAllCards(emptyList);

        assertThat(allCards.stream().map(Card::getName).collect(Collectors.toList()))
            .hasSize(cardNames.size())
            .hasSameElementsAs(cardNames);
    }

    @Test(
        dataProviderClass = CardsProvider.class,
        dataProvider = "listWithCards"
    )
    public void cardsCanBeDeletedFromTheList(beans.List listWithCards) {
        assertThat(ListService.getAllCards(listWithCards)).hasSizeGreaterThan(0);

        ListService.deleteAllCards(listWithCards);

        assertThat(ListService.getAllCards(listWithCards)).isEmpty();
    }

    @Test
    public void cardNameCanBeEmpty() {
        Board defaultTodoBoard = BoardService.createDefaultTodoBoard();

        assertThatCode(() -> {
            Card cardWithEmptyName = CardService.createCardByName(
                BoardService.getAllListsByBoard(defaultTodoBoard).get(0),
                ""
            );
            assertThat(cardWithEmptyName.getName()).isEqualTo("");
        }).doesNotThrowAnyException();
    }

    @Test
    public void deletedCardFromListCanBeFetchedDirectlyById() {
        Board defaultTodoBoard = BoardService.createDefaultTodoBoard();
        beans.List list = BoardService.getAllListsByBoard(defaultTodoBoard).get(0);
        String cardName = "Card to be deleted";

        Card cardToBeDeleted = CardService.createCardByName(
            list,
            cardName
        );
        ListService.deleteAllCards(list);

        assertThatCode(() -> {
            Card cardById = CardService.getCardById(cardToBeDeleted.getId());
            assertThat(cardById.getName()).isEqualTo(cardName);
        }).doesNotThrowAnyException();
    }
}
