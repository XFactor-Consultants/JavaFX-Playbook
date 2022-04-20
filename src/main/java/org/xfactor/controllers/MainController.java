package org.xfactor.controllers;

import java.net.MalformedURLException;
import java.net.URL;

import org.xfactor.MainApp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.web.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class MainController {

    @FXML
    private WebView webView;

    @FXML
    private Button back;
    @FXML
    private TextField address;
    @FXML
    private Button refresh;
    @FXML
    private Button forward;

    public void initialize() {
        String url = MainApp.class.getResource("index.html").toExternalForm();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url);
        address.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent k) {
                if(k.getCode().equals(KeyCode.ENTER)) {
                    try {
                        URL addressURL = new URL(address.getText());
                        webEngine.load(addressURL.toString());
                    }
                    catch(MalformedURLException ex) {
                        System.out.println("Malformed URL");
                    }
                }
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                webEngine.getHistory().go(-1);
            }
        });
        forward.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                webEngine.getHistory().go(1);
            }
        });
        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                webEngine.reload();
            }
        });
    }
}
