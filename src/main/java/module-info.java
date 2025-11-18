module com.group9.kurbani_cattle_hut_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;



    opens com.group9.kurbani_cattle_hut_management_system to javafx.fxml;
    exports com.group9.kurbani_cattle_hut_management_system;
    exports com.group9.kurbani_cattle_hut_management_system.Joy;
    opens com.group9.kurbani_cattle_hut_management_system.Joy to javafx.fxml;
    exports com.group9.kurbani_cattle_hut_management_system.Ishmam;
    opens com.group9.kurbani_cattle_hut_management_system.Ishmam to javafx.fxml;
}