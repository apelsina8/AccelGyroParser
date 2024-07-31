module ru.lab.lab2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens ru.lab.lab2 to javafx.fxml;
    exports ru.lab.lab2;
}