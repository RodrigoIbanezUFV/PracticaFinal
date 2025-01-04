package com.ufv.dis.turismo_backend.Util;

import com.ufv.dis.turismo_backend.Model.TurismoComunidad;

import java.util.ArrayList;
import java.util.UUID;

public class EditJson {
    private final LectorJSON lector = new LectorJSON();
    private final WriteJson escritor = new WriteJson();
    private final String ruta = "TurismoComunidades.json";

    public void agregarEntrada(TurismoComunidad nuevaComunidad) {
        try {
            ArrayList<TurismoComunidad> comunidades = lector.leeFicheroJson(ruta);
            nuevaComunidad.setId(Integer.parseInt(UUID.randomUUID().toString())); // Generar ID único
            comunidades.add(nuevaComunidad);
            escritor.escribirJson(comunidades, ruta);
        } catch (Exception ex) {
            System.out.println("Error agregando entrada: " + ex.getMessage());
        }
    }

    public void actualizarEntrada(String id, TurismoComunidad comunidadActualizada) {
        try {
            ArrayList<TurismoComunidad> comunidades = lector.leeFicheroJson(ruta);
            boolean actualizado = false;
            for (int i = 0; i < comunidades.size(); i++) {
                if (comunidades.get(i).getId() == Integer.parseInt(id)) {
                    comunidadActualizada.setId(Integer.parseInt(id)); // Mantener el mismo ID
                    comunidades.set(i, comunidadActualizada);
                    actualizado = true;
                    break;
                }
            }
            if (!actualizado) {
                throw new IllegalArgumentException("ID no encontrado: " + id);
            }
            escritor.escribirJson(comunidades, ruta);
        } catch (Exception ex) {
            System.out.println("Error actualizando entrada: " + ex.getMessage());
        }
    }
}
