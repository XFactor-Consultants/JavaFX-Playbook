module cardapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens org.xfactor to javafx.fxml;
    exports org.xfactor;
}
