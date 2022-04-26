package org.xfactor;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CardFactory implements Callback<ListView<Card>, ListCell<Card>>  {
    @Override
    public ListCell<Card> call(ListView<Card> param) {
        return new ListCell<Card>(){
            @Override
            public void updateItem(Card card, boolean empty) {
                super.updateItem(card, empty);
                if (empty || card == null) {
                    setText(null);
                } else  {
                    setText(card.toString());
                }
            }
        };
    }
}
