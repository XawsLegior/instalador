package com.worrigan.instalador.install;

import com.worrigan.instalador.ut.Json;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InstallApplication {
    private static Stage installApp;

    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InstallApplication.class.getResource("/com/worrigan/instalador/installWindow/InstallWindow.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle(Json.get("titulo"));
        stage.show();
        installApp = stage;
    }
}
