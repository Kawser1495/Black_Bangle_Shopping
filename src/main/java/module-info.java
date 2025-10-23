module com.mycompany.shoeshopsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.shoeshopsystem to javafx.fxml;
    exports com.mycompany.shoeshopsystem;
    exports com.mycompany.shoeshopsystem.data;
    exports com.mycompany.shoeshopsystem.model;
}
