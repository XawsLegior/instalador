package com.worrigan.instalador.install;


import com.worrigan.instalador.MainApplication;
import com.worrigan.instalador.ut.Json;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.worrigan.instalador.install.instalacao.Instalar.instalar;

public class InstallController {
    @FXML public Text tamanhoNecessario;
    @FXML public TextArea localDeInstalacao;
    @FXML public Tab tabSelecionarLocal;
    @FXML public Tab tabInstalar;
    @FXML public TabPane tabPane;
    @FXML public ListView<String> statusInstalacao;
    @FXML public Button btnFechar;
    private URL zipURL;

    public void onFechar(){
        Platform.exit();
    }
    public void onSelectLocal(){
        try {
            DirectoryChooser directoryDialog = new DirectoryChooser();
            File selectedDirectory = directoryDialog.showDialog(InstallApplication.getStage());
            String caminho = selectedDirectory.toString().replace("file:/", "");
            localDeInstalacao.setText(caminho + Json.get("nome") + "\\");
        }
        catch (Exception ignored){}
    }

    public void onInstalar() throws IOException {
        String caminho = localDeInstalacao.getText();
        if(caminho == null || caminho.equals("")){
            Alert warn = new Alert(Alert.AlertType.INFORMATION);
            warn.setTitle("Aviso");
            warn.setHeaderText("Defina um caminho válido!");
            warn.show();
            return;
        }
        if(!caminho.endsWith("\\")){
            caminho = caminho + "\\";
        }
        instalar(caminho, this);
    }

    public void initialize(){
        localDeInstalacao.setText("C:\\" + Json.get("nome"));
        try {
            URL zipUrl = MainApplication.class.getResource("/com/worrigan/instalador/software/software.zip");
            zipURL = zipUrl;
            ZipInputStream zip = new ZipInputStream(zipUrl.openStream());
            int tamEmByte = 0;
            ZipEntry zipEntry = zip.getNextEntry();
            while(zipEntry != null){
                tamEmByte+= zipEntry.getSize();
                zipEntry = zip.getNextEntry();
            }

            double tamanhoEmMb;
            String tamanho = "Tamanho aproximado ";
            if (tamEmByte >= 1000000) {
                tamanhoEmMb = (double) (tamEmByte / 1024) / 1024;
                tamanho += String.format("%.2f", tamanhoEmMb) + " MB";
            } else {
                tamanho += tamEmByte + " KB";
            }
            tamanhoNecessario.setText(tamanho);
        }
        catch (Exception e){
            Alert erro = new Alert(Alert.AlertType.ERROR, String.valueOf(e));
            erro.show();
        }
    }
}
