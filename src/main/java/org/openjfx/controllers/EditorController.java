package org.openjfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class EditorController {

    @FXML
    private TextArea editor;

    public void initialize() {
       
    }

    public void setText(String text) {
        editor.setText(text);
    }

    public TextArea getEditor() {
        return editor;
    }
}
