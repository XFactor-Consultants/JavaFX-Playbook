package org.xfactor;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CardFactory implements Callback<ListView<String>, ListCell<String>>  {
    @Override
    public ListCell<String> call(ListView<String> param) {
        return new ListCell<>(){
            @Override
            public void updateItem(String number, boolean empty) {
                super.updateItem(number, empty);
                if (empty || number == null) {
                    setText(null);
                } else {
                    setText(number);
                }
            }
        };
    }
}
