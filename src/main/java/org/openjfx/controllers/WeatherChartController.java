package org.openjfx.controllers;

import org.openjfx.WeatherResult;

import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class WeatherChartController {

    @FXML
    private LineChart<Long, Float> lineChart;

    @FXML

    public void updateChart(OneCallResult data){
        Series<Long, Float> series = new Series<Long, Float>();
        for(int i=0; i < data.hourly.length; i++){
            
            WeatherResult hour = data.hourly[i];
            series.getData().add(new Data<Long, Float>(hour.getDtFloat(), hour.getTempFloat()));
        }
        lineChart.getData().add(series);
    }
    
}
