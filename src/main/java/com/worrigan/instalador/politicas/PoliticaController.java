package com.worrigan.instalador.politicas;

import com.worrigan.instalador.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javafx.scene.web.WebView;

public class PoliticaController {
    @FXML public WebView htmLicence;

    public void onVoltar(){
        MainApplication.show();
        PoliticaApplication.close();
    }

    public void initialize() throws IOException {
        Node[] nodes = htmLicence.lookupAll(".tool-bar").toArray(new Node[0]);
        for(Node node: nodes){
            node.setVisible(false);
            node.setManaged(false);
        }
        URL f = getClass().getResource("/com/worrigan/instalador/software/licença.ini");
        BufferedReader licenca = new BufferedReader(new InputStreamReader(f.openStream()));
        Object[] linhas = licenca.lines().toArray();
        if(linhas.length <= 1){
            htmLicence.getEngine().loadContent("<p>Não há políticas definidas!</p>");
            return;
        }
        StringBuilder conteudo = new StringBuilder();
        for(Object linha: linhas){
            String dado = new String(String.valueOf(linha).getBytes(), StandardCharsets.UTF_8);
            conteudo.append(dado);
        }
        htmLicence.getEngine().loadContent(String.valueOf(conteudo));
    }
}
