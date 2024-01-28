module org.cyl.translatejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires okhttp3;
    requires okio;
    requires com.google.gson;

    opens org.cyl.translatejavafx to javafx.fxml;
    exports org.cyl.translatejavafx;
}