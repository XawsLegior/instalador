package com.worrigan.instalador.politicas;

import com.worrigan.instalador.MainApplication;
import com.worrigan.instalador.ut.Json;
import javafx.fxml.FXML;
import javafx.scene.Node;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.web.WebView;

public class PoliticaController {
    @FXML public WebView htmLicence;
    public StringBuilder conteudoInicial;

    public void onVoltar() {
        MainApplication.show();
        PoliticaApplication.close();
    }

    public void initialize() throws IOException, URISyntaxException {
        Node[] nodes = htmLicence.lookupAll(".tool-bar").toArray(new Node[0]);
        for(Node node: nodes){
            node.setVisible(false);
            node.setManaged(false);
        }
        URL f = PoliticaApplication.class.getResource("/com/worrigan/instalador/software/licenca.html");
        BufferedReader licenca = new BufferedReader(new InputStreamReader(f.openStream()));
        Object[] linhas = licenca.lines().toArray();
        if(linhas.length <= 1){
            htmLicence.getEngine().loadContent("<p>Não há políticas definidas!</p>");
            return;
        }
        StringBuilder conteudo = new StringBuilder();
        for(Object linha: linhas){
            String dado = new String(String.valueOf(linha).getBytes(), StandardCharsets.UTF_8);
            dado = tratarLinkElementos(dado);
            conteudo.append(dado);
            System.out.println(dado);
        }
        conteudoInicial = conteudo;
        Json.add("licenca", String.valueOf(conteudo));
        htmLicence.getEngine().loadContent(String.valueOf(conteudo));
        htmLicence.getEngine().getLoadWorker().stateProperty().addListener(new Requests(htmLicence));
    }

    /* TRATAR LINKS DOS ELEMENTOS, EXEMPLO:
    * <img src="{chip.png}"> por <img src="file:/com/worrigan/instalador/chip.png">
    * Seguindo essa lógica, para adicionar uma imagem que esteja dentro de uma pasta apenas defina a tag como:
    * {pasta/arquivo.extensao}
    */
    private String tratarLinkElementos(String htmlSource){
        if(Pattern.compile("\\{[\\S]+}").matcher(htmlSource).find()){
            String path = "/com/worrigan/instalador/";
            Matcher key = Pattern.compile("\\{[\\S]+}").matcher(htmlSource);
            key.find();
            String content = path + key.group().replaceAll("[{}]", "");
            return htmlSource.replaceAll("\\{[\\S]+}", MainApplication.class.getResource(content).toExternalForm());
        }
        else{
            return htmlSource;
        }
    }
}
