package com.ufv.dis.turismo_backend.App;

import com.ufv.dis.turismo_backend.Model.TurismoComunidad;
import com.ufv.dis.turismo_backend.Util.BorrarJson;
import com.ufv.dis.turismo_backend.Util.EditJson;
import com.ufv.dis.turismo_backend.Util.LectorJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Prefijo común para todas las rutas
public class JsonController {

    @Autowired
    private LectorJSON lectorJSON;

    @Autowired
    private EditJson editJson;

    @Autowired
    private BorrarJson borrarJson;

    @GetMapping("/comunidades")
    public List<TurismoComunidad> getComunidades() {
        return lectorJSON.leeFicheroJson("TurismoComunidades.json");
    }

    @PostMapping("/comunidad")
    public ResponseEntity<Void> addComunidad(@RequestBody TurismoComunidad nuevaComunidad) {
        editJson.agregarEntrada(nuevaComunidad);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/comunidad/{id}")
    public ResponseEntity<Void> updateComunidad(@PathVariable String id, @RequestBody TurismoComunidad comunidadActualizada) {
        editJson.actualizarEntrada(id, comunidadActualizada);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comunidad/{id}")
    public ResponseEntity<Void> deleteComunidad(@PathVariable String id) {
        borrarJson.eliminarEntrada(id, 1);
        return ResponseEntity.ok().build();
    }
}
