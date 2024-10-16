package com.udb.productosBancarios.Controller;

import com.udb.productosBancarios.DTO.GrupoDeProductosDTO;
import com.udb.productosBancarios.Entity.GrupoDeProductos;
import com.udb.productosBancarios.Service.GrupoDeProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos-de-productos")
public class GrupoDeProductosController {

    @Autowired
    private GrupoDeProductosService grupoDeProductosService;

    @PostMapping
    public ResponseEntity<GrupoDeProductos> createGrupoDeProductos(@RequestBody GrupoDeProductosDTO grupoDeProductosDTO) {
        // Convertir DTO a entidad
        GrupoDeProductos grupoDeProductos = new GrupoDeProductos();
        grupoDeProductos.setNombrePaquete(grupoDeProductosDTO.getNombrePaquete());
        grupoDeProductos.setDescripcion(grupoDeProductosDTO.getDescripcion());

        GrupoDeProductos savedGrupo = grupoDeProductosService.saveGrupoDeProductos(grupoDeProductos);
        return ResponseEntity.ok(savedGrupo);
    }
    
    
    @GetMapping
    public ResponseEntity<List<GrupoDeProductos>> getAllGruposDeProductos() {
        List<GrupoDeProductos> grupos = grupoDeProductosService.getAllGrupos();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoDeProductos> getGrupoDeProductosById(@PathVariable Long id) {
        GrupoDeProductos grupo = grupoDeProductosService.getGrupoById(id);
        if (grupo != null) {
            return ResponseEntity.ok(grupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}