package org.xfactor;

import java.util.List;
import java.util.stream.IntStream;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<Card> grid;

    @FXML
    private Button shuffle;

    public void initialize() {
        Card[] numbers =  IntStream.range(0, 99).mapToObj(v-> new Card(v,v,0)).toArray( Card[]::new);
        grid.setCellFactory(new CardFactory());
        grid.getItems().addAll(numbers);
        grid.setOrientation(Orientation.HORIZONTAL);
        shuffle.setOnMouseClicked(e-> {
            javafx.collections.FXCollections.shuffle(grid.getItems());
        });
        grid.getItems().addListener(new ListChangeListener<Card>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Card> change) {
                while (change.next()) {
                    List<? extends Card> oldList = change.getRemoved();
                    List<? extends Card> newList = change.getList();
                    for (int i = 0; i < oldList.size(); i++) {
                        int newIndex = newList.indexOf(oldList.get(i));
                        newList.get(newIndex).index = newIndex ;
                        newList.get(newIndex).deltaX = newIndex - i;
                        System.out.println("index change: "+i+" --> "+newIndex);
                    }
                }
            }
        });
    }

    
}
