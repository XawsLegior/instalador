package com.worrigan.instalador;

import com.worrigan.instalador.ut.Json;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException{
        Json.carregar();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/worrigan/instalador/MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(Json.get("titulo"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(MainApplication.class.getResource("/com/worrigan/instalador/icone.png").openStream()));
        stage.show();
        mainStage = stage;
    }

    public static void main(String[] args){
        launch();
    }

    public static void close(){
        mainStage.close();
    }
    public static void show(){
        mainStage.show();
    }
}
