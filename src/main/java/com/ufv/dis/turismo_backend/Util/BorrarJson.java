package com.ufv.dis.turismo_backend.Util;

import com.ufv.dis.turismo_backend.Model.TurismoComunidad;

import java.util.ArrayList;

public class BorrarJson {
    private final LectorJSON lector = new LectorJSON();
    private final WriteJson escritor = new WriteJson();
    private final String ruta = "TurismoComunidades.json";

    public boolean eliminarEntrada(String id, int i){          // Elimina entradas por id
        try {
            ArrayList<TurismoComunidad> comunidades = lector.leeFicheroJson(ruta);
            boolean eliminado = comunidades.removeIf(comunidad -> comunidad.getId() == Integer.parseInt(id));
            if (!eliminado) {
                throw new IllegalArgumentException("ID no encontrado: " + id);
            }
            escritor.escribirJson(comunidades, ruta); // Editamos el JSON
        }catch (Exception ex){
            System.out.println("Error eliminando entrada: " + ex.getMessage());
        }
        return false;
    }
}
