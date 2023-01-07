module com.example.majorpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.majorpro to javafx.fxml;
    exports com.example.majorpro;
}