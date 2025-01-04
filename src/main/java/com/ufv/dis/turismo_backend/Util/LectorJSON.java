package com.ufv.dis.turismo_backend.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ufv.dis.turismo_backend.Model.TurismoComunidad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LectorJSON {
    public ArrayList<TurismoComunidad> leeFicheroJson(String ruta){
        try {
            // lee un fichero que le damos y lo pasa carga en un reader
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (getClass().getClassLoader().getResourceAsStream
                            ("TurismoComunidades.json")));

            ArrayList<TurismoComunidad> listaComunidades = new Gson().fromJson
                    (reader, new TypeToken<ArrayList<TurismoComunidad>>() {}.getType());
            reader.close();
            return listaComunidades;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>(); // Si no ha leido nada, devuelve el array vacio.
        }
    }
}