package com.worrigan.instalador.ut;

import com.worrigan.instalador.MainApplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Json {
    private static final HashMap<String, String> json = new HashMap<>();

    public static void carregar() {
        try{
            URL f = MainApplication.class.getResource("software/config.ini");
            BufferedReader dados = new BufferedReader(new InputStreamReader(f.openStream()));
            Object[] linhas = dados.lines().toArray();
            for(Object dadosLinha: linhas){
                String dado = new String(String.valueOf(dadosLinha).getBytes(), StandardCharsets.UTF_8);
                if(dado == null || dado.startsWith("#")){
                    continue;
                }
                dado = dado.replaceAll("[\"]", "");
                String[] item = dado.split(":");
                item[0] = item[0].replaceFirst(" ", ""); //index
                item[1] = item[1].replaceFirst(" ", ""); //valor
                if(item[0].equals("titulo")){
                    item[1] = item[1].toUpperCase();
                }
                json.put(item[0], item[1]);
            }
        }
        catch (Exception ignored){}

    }

    public static void add(String index, String valor){
        json.put(index, valor);
    }
    public static HashMap<String, String> get(){
        return json;
    }

    public static String get(String index){
        return json.get(index);
    }
}
