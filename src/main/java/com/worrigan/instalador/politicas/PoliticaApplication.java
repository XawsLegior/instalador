package com.worrigan.instalador.politicas;

import com.worrigan.instalador.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class PoliticaApplication {
    private static Stage politicaStage;

    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/worrigan/instalador/politicas/PoliticasWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Politicas");
        stage.setResizable(false);
        stage.getIcons().add(new Image(MainApplication.class.getResource("/com/worrigan/instalador/icone.png").openStream()));
        stage.show();
        politicaStage = stage;
}

    public static void close() {
        politicaStage.close();
    }

}
