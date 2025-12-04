//module com.group9.kurbani_cattle_hut_management_system {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires javafx.base;
//    requires javafx.graphics;
////    requires com.group9.kurbani_cattle_hut_management_system;
////    requires com.group9.kurbani_cattle_hut_management_system;
////    requires com.group9.kurbani_cattle_hut_management_system;
//
//
//    opens com.group9.kurbani_cattle_hut_management_system to javafx.fxml;
//    exports com.group9.kurbani_cattle_hut_management_system;
//    exports com.group9.kurbani_cattle_hut_management_system.Joy;
//    opens com.group9.kurbani_cattle_hut_management_system.Joy to javafx.fxml;
//    exports com.group9.kurbani_cattle_hut_management_system.Ishmam;
//    opens com.group9.kurbani_cattle_hut_management_system.Ishmam to javafx.fxml;
//}

module com.group9.kurbani_cattle_hut_management_system {
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.base;
        requires javafx.graphics;


//    requires com.group9.kurbani_cattle_hut_management_system;
//    requires com.group9.kurbani_cattle_hut_management_system;
//    requires com.group9.kurbani_cattle_hut_management_system;
//    requires com.group9.kurbani_cattle_hut_management_system;
//    requires com.group9.kurbani_cattle_hut_management_system;
//    requires com.group9.kurbani_cattle_hut_management_system;
//    requires com.group9.kurbani_cattle_hut_management_system;


        opens com.group9.kurbani_cattle_hut_management_system to javafx.fxml;
//    exports com.group9.kurbani_cattle_hut_management_system;
        exports com.group9.kurbani_cattle_hut_management_system.Joy;
        opens com.group9.kurbani_cattle_hut_management_system.Joy to javafx.fxml;
        exports com.group9.kurbani_cattle_hut_management_system.Ishmam;
        opens com.group9.kurbani_cattle_hut_management_system.Ishmam to javafx.fxml;
        exports com.group9.kurbani_cattle_hut_management_system.Utils;
        opens com.group9.kurbani_cattle_hut_management_system.Utils to javafx.fxml;
//    exports com.group9.kurbani_cattle_hut_management_system.MainController;
//    opens com.group9.kurbani_cattle_hut_management_system.MainController to javafx.fxml;
//    exports com.group9.kurbani_cattle_hut_management_system.CommonClass;
//    opens com.group9.kurbani_cattle_hut_management_system.CommonClass to javafx.fxml;
        exports com.group9.kurbani_cattle_hut_management_system;
        exports com.group9.kurbani_cattle_hut_management_system.Joy.Class;
        opens com.group9.kurbani_cattle_hut_management_system.Joy.Class to javafx.fxml;
        }