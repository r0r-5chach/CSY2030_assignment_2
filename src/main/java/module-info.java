module com.r0r5chach {
    requires transitive javafx.graphics;

    requires javafx.controls;
    requires javafx.fxml;

    opens com.r0r5chach to javafx.fxml;
    exports com.r0r5chach;
}
