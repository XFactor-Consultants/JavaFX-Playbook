package org.openjfx.controllers;

import org.openjfx.lib.FetchData;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private TextField zip;
    @FXML
    private TextField country;
    @FXML
    private Button search;
    @FXML
    private TableController tableViewController;
    @FXML
    private WeatherChartController weatherChartController;

    private String location;

    private void updateLocation(){
        if(zip.getText().length() == 5 && country.getText().length() == 2) {
            search.setDisable(false);
            search.setText("Search");
            location = zip.getText()+","+country.getText();
            
        }
        if(zip.getText().length() != 5) {
            search.setText("ZIP must be 5 characters");
        }
        if(country.getText().length() != 2) {
            search.setText("Country must be 2 characters");
        }
    }

    public void initialize() {
        search.setDisable(true);
        zip.textProperty().addListener((observable, oldVal, newVal)-> {
            updateLocation();
        });
        country.textProperty().addListener((observable, oldVal, newVal)-> {
            updateLocation();
        });
        search.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
            try {
                GeoCodingResult geoData = FetchData.readJsonFromUrl("https://api.openweathermap.org/geo/1.0/zip?zip="+location, GeoCodingResult.class);
                System.out.println(geoData.toString());
                OneCallResult data = FetchData.readJsonFromUrl("https://api.openweathermap.org/data/2.5/onecall?lat="+geoData.lat+"&lon="+geoData.lon, OneCallResult.class);
                System.out.println(data.hourly[0].getTemp());
                tableViewController.updateTable(data);
                weatherChartController.updateChart(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
