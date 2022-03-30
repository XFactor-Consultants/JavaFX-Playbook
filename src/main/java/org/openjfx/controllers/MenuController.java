package org.openjfx.controllers;

import java.io.*;

import org.openjfx.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuController {

    @FXML
    private Button open;
    @FXML
    private Button newFile;
    @FXML
    private Button save;

    private TextArea editor;

    private String readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = "";
        String counter;
        while((counter = br.readLine()) != null) {
            if(counter.trim().length() == 0) {
                result += "\n";
            }
            result += counter;
        }
        br.close();
        return result;
    }

    private void writeFile(File file, String text) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(text);
        bw.close();
    }

    private void showEditor(String text) throws IOException {

        Stage editorStage = new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("scenes/editor.fxml"));

        Parent menu = loader.load();
        EditorController controller = loader.<EditorController>getController();
        controller.setText(text);
        editor = controller.getEditor();
        Scene menuScene = new Scene(menu);

        menuScene.getStylesheets().add(MainApp.class.getResource("styles.css").toExternalForm());
        editorStage.setTitle("NoteApp");
        editorStage.setScene(menuScene);
        editorStage.show();
    }

    public void initialize() {
        FileChooser chooser = new FileChooser();
        open.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                try {
                    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                    File file = chooser.showOpenDialog(stage);
                    String text = readFile(file);
                    showEditor(text);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
            }
        });
        newFile.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                try {
                    showEditor("New file!");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        save.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                if(editor == null) {
                    return;
                }
                Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                String text = editor.getText();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                chooser.getExtensionFilters().add(extFilter);
                File file = chooser.showSaveDialog(stage);
                if(file !=null){
                    try {
                        writeFile(file, text);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
