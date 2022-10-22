package com.worrigan.instalador.politicas;

import com.worrigan.instalador.ut.Json;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebView;

import java.util.EventListener;

public class Requests implements ChangeListener<Worker.State>, EventListener {
    private final WebView WebLicence;

    public Requests(WebView htmLicence) {
        WebLicence = htmLicence;
    }

    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        try {
            String link = WebLicence.getEngine().getLoadWorker().getMessage().trim();
            if(link.contains("http") || link.contains("https")){
                link = link.replace("Loading", "");
                WebLicence.getEngine().getLoadWorker().cancel();
                WebLicence.getEngine().loadContent(Json.get("licenca"));
                Runtime.getRuntime().exec("cmd /c start " + link);
            }
        }
        catch (Exception ignored){}
    }
}
