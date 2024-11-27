module com.study.home.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.study.home.demo2 to javafx.fxml;
    exports com.study.home.demo2;
}
