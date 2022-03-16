package org.openjfx.controllers;

import javafx.scene.control.TableView;
// import javafx.scene.control.TableColumn;
import javafx.fxml.FXML;

import org.openjfx.WeatherResult;
import org.openjfx.lib.FetchData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


class GeoCodingResult {
    public String lat;
    public String lon;
    GeoCodingResult(){
        
    }
}



class OneCallResult {
    public WeatherResult[] hourly;
    public WeatherResult current;

    OneCallResult(){
        
    }
}

public class TableController {
    private static final ObservableList<WeatherResult> tableData = FXCollections.observableArrayList();

    @FXML
    private TableView<WeatherResult> table;

    public void updateTable(OneCallResult data) throws Exception{
        tableData.setAll(data.hourly);
        table.setItems(tableData);
    }
    
}
