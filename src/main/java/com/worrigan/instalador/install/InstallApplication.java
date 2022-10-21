package com.worrigan.instalador.install;

import com.worrigan.instalador.MainApplication;
import com.worrigan.instalador.ut.Json;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class InstallApplication {
    private static Stage installStage;

    public static void show() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/worrigan/instalador/installWindow/InstallWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(Json.get("titulo"));
            stage.setResizable(false);
            stage.show();
            installStage = stage;
        }
        catch (Exception e){
            Alert erro = new Alert(Alert.AlertType.ERROR, String.valueOf(e));
            erro.show();
        }
    }

    public static Stage getStage(){
        return installStage;
    }
}
