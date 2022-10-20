package com.worrigan.instalador;

import com.worrigan.instalador.install.InstallApplication;
import com.worrigan.instalador.ut.Json;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import com.worrigan.instalador.politicas.PoliticaApplication;

import java.io.IOException;

public class MainController {
    @FXML private Text titulo;
    @FXML private Text rodape;
    @FXML private Text descricao;

    @FXML
    protected void onbtnAvancar() throws IOException {
        InstallApplication.show();
        MainApplication.close();
    }

    public void showPoliticaWindow() throws Exception {
        PoliticaApplication.show();
        MainApplication.close();
    }

    public void initialize() {
        titulo.setText(Json.get("titulo"));
        descricao.setText(Json.get("descricao"));
        rodape.setText(Json.get("rodape"));
    }

}