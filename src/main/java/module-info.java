module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.google.gson;
    
    opens org.openjfx to javafx.fxml, com.google.gson;
    opens org.openjfx.controllers to javafx.fxml, com.google.gson, javafx.base;
    exports org.openjfx;
}
