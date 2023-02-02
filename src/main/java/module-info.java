module com.r0r5chach {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.r0r5chach to javafx.fxml;
    opens com.r0r5chach.pages to javafx.base;
    opens com.r0r5chach.controllers to javafx.fxml;
    exports com.r0r5chach;
    exports com.r0r5chach.competitor;
    exports com.r0r5chach.competitor.r6;
    exports com.r0r5chach.competitor.valorant;
}
