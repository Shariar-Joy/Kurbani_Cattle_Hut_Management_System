module com.group9.kurbani_cattle_hut_management_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group9.kurbani_cattle_hut_management_system to javafx.fxml;
    exports com.group9.kurbani_cattle_hut_management_system;
    exports com.group9.kurbani_cattle_hut_management_system.Joy;
    opens com.group9.kurbani_cattle_hut_management_system.Joy to javafx.fxml;
}