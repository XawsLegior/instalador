package com.worrigan.instalador.install;


import com.worrigan.instalador.MainApplication;
import com.worrigan.instalador.ut.Json;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipInputStream;

public class InstallController {
    @FXML public Text tamanhoNecessario;


    public void onSelectLocal(){
        System.out.println("xxx");
    }

    public void initialize() throws IOException, URISyntaxException {
        URL zipUrl = MainApplication.class.getResource("software/software.zip");
        Integer tamEmByte = Files.readAllBytes(Path.of(zipUrl.toURI())).length;
        Double tamanhoEmMb = 0.0;
        String tamanho = "Tamanho aproximado ";
        if(tamEmByte >= 100024000){
            tamanhoEmMb = (double) (tamEmByte / 1024) / 1024;
            tamanho+= String.format("%.2f", tamanhoEmMb) + " MB";
        }
        else if(tamEmByte > 13.78){
            tamanhoEmMb = (double) (tamEmByte / 1024) / 1024 + 13.78;
            tamanho+= String.format("%.2f", tamanhoEmMb) + " MB";
        }
        else{
            tamanho+= tamEmByte + " KB";
        }
        tamanhoNecessario.setText(tamanho);
    }
}
