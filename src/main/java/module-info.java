module com.r0r5chach {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.r0r5chach to javafx.fxml;
    exports com.r0r5chach;
    exports com.r0r5chach.r6;
    exports com.r0r5chach.valorant;
}
