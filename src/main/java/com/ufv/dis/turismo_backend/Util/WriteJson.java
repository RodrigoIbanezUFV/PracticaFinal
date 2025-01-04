package com.ufv.dis.turismo_backend.Util;

import com.google.gson.Gson;
import com.ufv.dis.turismo_backend.Model.TurismoComunidad;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WriteJson {
    public void escribirJson(ArrayList<TurismoComunidad> lista, String ruta) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    getClass().getClassLoader().getResource(ruta).openConnection().getOutputStream()));
            new Gson().toJson(lista, writer);
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error escribiendo JSON: " + ex.getMessage());
        }
    }
}
