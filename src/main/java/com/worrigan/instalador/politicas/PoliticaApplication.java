package com.worrigan.instalador.politicas;

import com.worrigan.instalador.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PoliticaApplication{
    private static Stage politicaStage;

    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/worrigan/instalador/politicas/PoliticasWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Politicas");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        politicaStage = stage;
    }

    public static void close(){
        politicaStage.close();
    }

}
