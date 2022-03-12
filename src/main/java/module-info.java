module weatherapp{
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controllers to javafx.fxml;
    exports org.openjfx;
}
