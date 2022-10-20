package com.worrigan.instalador;

import com.worrigan.instalador.ut.Json;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import com.worrigan.instalador.politicas.PoliticaApplication;

public class MainController {
    @FXML private Text titulo;
    @FXML private Text rodape;
    @FXML private Text descricao;

    @FXML
    protected void onbtnAvancar() {

    }

    public void showPoliticaWindow() throws Exception {
        try {
            PoliticaApplication.show();
            MainApplication.close();
        }
        catch (Exception e){
            titulo.setText(String.valueOf(e));
        }
    }

    public void initialize() {
        titulo.setText(Json.get("titulo"));
        descricao.setText(Json.get("descricao"));
        rodape.setText(Json.get("rodape"));
    }

}