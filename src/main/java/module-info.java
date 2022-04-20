module noteapp{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive javafx.graphics;
    
    opens org.xfactor to javafx.fxml;
    opens org.xfactor.controllers to javafx.fxml;
    exports org.xfactor;
}
