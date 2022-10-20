module com.worrigan.instalador {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.worrigan.instalador to javafx.fxml;

    exports com.worrigan.instalador;
    exports com.worrigan.instalador.politicas;
    exports com.worrigan.instalador.ut;
    //opens com.worrigan.instalador.ut to javafx.fxml;
}