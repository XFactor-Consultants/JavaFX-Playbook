package org.xfactor;

import javafx.animation.FadeTransition;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.util.Duration;

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
                    FadeTransition ft = new FadeTransition(Duration.millis((card.index+1)*200), this);
                    this.setOpacity(0);
                    System.out.println("card: "+card.deltaX +", "+ this.getWidth());
                    ft.setToValue(1);
                    setText(card.toString());
                    ft.play();
                }
            }
        };
    }
}
