package org.xfactor;

import java.util.List;
import java.util.stream.IntStream;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<String> grid;

    @FXML
    private Button shuffle;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        String[] numbers = IntStream.range(1, 100).mapToObj(String::valueOf).toArray(String[]::new);
        // grid.setCellFactory(new CardFactory());
        grid.getItems().addAll(numbers);
        grid.setOrientation(Orientation.HORIZONTAL);
        shuffle.setOnMouseClicked(e-> {
            javafx.collections.FXCollections.shuffle(grid.getItems());
        });
        grid.getItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> change) {
                while (change.next()) {
                    List<? extends String> oldList = change.getRemoved();
                    List<? extends String> newList = change.getList();
                    for (int i = 0; i < oldList.size(); i++) {
                        int newIndex = newList.indexOf(oldList.get(i));
                        System.out.println("index change: "+i+" --> "+newIndex);
                    }
                }
            }
        });
    }

    
}
