module com.lqm.fxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.lqm.fxenglishapp to javafx.fxml;
    exports com.lqm.fxenglishapp;
}
