package com.worrigan.instalador.install.instalacao;

import com.worrigan.instalador.install.InstallController;
import com.worrigan.instalador.ut.Json;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.SingleSelectionModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Instalar {
    private static InstallController parent;

    public static void instalar(String caminho, InstallController self) throws IOException {
        parent = self;
        parent.tabInstalar.setDisable(false);
        parent.tabSelecionarLocal.setDisable(true);
        SingleSelectionModel<?> tabFocus = parent.tabPane.getSelectionModel();
        tabFocus.select(1);
        parent.statusInstalacao.getItems().add("Iniciando instalação...");
        extrairSofware(caminho);
    }

    private static void extrairSofware(String caminho) throws IOException {
        URL soft = InstallController.class.getResource("/com/worrigan/instalador/software/software.zip");
        ZipInputStream zip = new ZipInputStream(soft.openStream());
        new File(caminho).mkdir();
        try {
            thread(zip, caminho);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* PRINTAR STATUS ATUAL (QUAL ARQUIVO ESTÁ SENDO EXTRAIDO) */
    private static void status(String texto){
        Platform.runLater(()->{
            parent.statusInstalacao.getItems().add(texto);
            parent.statusInstalacao.scrollTo(parent.statusInstalacao.getItems().size());
        });
    }

    /* MOSTRAR MENSAGEM AO FINALIZAR A INSTALAÇÃO */
    private static void instalacaoFinalizada(String caminho){
        Platform.runLater(()->{
            try {
                /* CRIAR ATALHO */
                String desktop = "C:/users/" + System.getenv("USERNAME") + "/desktop/" + Json.get("nome") + ".exe";
                String programa = caminho + Json.get("nome") + ".exe";
                Files.createSymbolicLink(Path.of(desktop), Path.of(programa));
            } catch (IOException ignored) {}

            parent.btnFechar.setDisable(false);
            Alert fim = new Alert(Alert.AlertType.INFORMATION, "Instalação finalizada!");
            fim.setHeaderText("Você já pode fechar essa janela!");
            fim.setTitle("Instalação finalizada!");
            fim.show();
        });
    }

    /* THREAD QUE VAI FAZER O PROCESSO DE EXTRAÇÃO */
    private static void thread(ZipInputStream zip, String installIn){
        new Thread(()->{
            try {
                ZipEntry zipEntry = zip.getNextEntry();
                while (zipEntry != null) {
                    if (zipEntry.isDirectory()) {
                        new File(installIn + zipEntry.getName()).mkdirs();
                        zipEntry = zip.getNextEntry();
                        continue;
                    }
                    File newfile = new File(installIn + zipEntry.getName());
                    status("Extraindo " + newfile);
                    OutputStream file = new FileOutputStream(newfile);
                    file.write(zip.readAllBytes());
                    file.close();
                    zipEntry = zip.getNextEntry();
                    Thread.sleep(30);
                }
                status("Instalação finalizada!");
                instalacaoFinalizada(installIn);

            } catch (Exception e) {
                status("Um erro ocorreu: " + e);
            }
        }).start();
    }
}
