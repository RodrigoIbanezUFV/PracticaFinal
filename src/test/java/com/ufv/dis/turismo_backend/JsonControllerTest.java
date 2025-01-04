package com.ufv.dis.turismo_backend;

import com.ufv.dis.turismo_backend.App.JsonController;
import com.ufv.dis.turismo_backend.Model.TurismoComunidad;
import com.ufv.dis.turismo_backend.Util.BorrarJson;
import com.ufv.dis.turismo_backend.Util.EditJson;
import com.ufv.dis.turismo_backend.Util.LectorJSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = JsonController.class)
public class JsonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LectorJSON lectorJSON;

    @Mock
    private EditJson editJson;

    @Mock
    private BorrarJson borrarJson;

    @InjectMocks
    private JsonController jsonController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetComunidades() throws Exception {
        ArrayList<TurismoComunidad> mockComunidades = new ArrayList<>();
        mockComunidades.add(new TurismoComunidad(1, null, null, null, 5000));
        mockComunidades.add(new TurismoComunidad(2, null, null, null, 3000));

        when(lectorJSON.leeFicheroJson(anyString())).thenReturn(mockComunidades);

        mockMvc.perform(get("/api/comunidades") // Ajusta la ruta
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    public void testAddComunidad() throws Exception {
        String nuevaComunidadJson = "{" +
                "\"id\": 3," +
                "\"origen\": null," +
                "\"destino\": null," +
                "\"periodo\": null," +
                "\"total\": 4000" +
                "}";

        doNothing().when(editJson).agregarEntrada(any(TurismoComunidad.class));

        mockMvc.perform(post("/api/comunidad") // Ajusta la ruta
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(nuevaComunidadJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateComunidad() throws Exception {
        String comunidadActualizadaJson = "{" +
                "\"id\": 1," +
                "\"origen\": null," +
                "\"destino\": null," +
                "\"periodo\": null," +
                "\"total\": 7000" +
                "}";

        doNothing().when(editJson).actualizarEntrada(anyString(), any(TurismoComunidad.class));

        mockMvc.perform(put("/api/comunidad/1") // Ajusta la ruta
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(comunidadActualizadaJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteComunidad() throws Exception {
        when(borrarJson.eliminarEntrada(anyString(), anyInt())).thenReturn(true);

        mockMvc.perform(delete("/api/comunidad/1") // Ajusta la ruta
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
