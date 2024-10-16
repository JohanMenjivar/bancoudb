package com.udb.productosBancarios.Service;

import org.springframework.stereotype.Service;

import com.udb.productosBancarios.Entity.GrupoDeProductos;
import com.udb.productosBancarios.Repository.GrupoDeProductosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class GrupoDeProductosService {
    @Autowired
    private GrupoDeProductosRepository grupoDeProductosRepository;

    public GrupoDeProductos saveGrupoDeProductos(GrupoDeProductos grupoDeProductos) {
        return grupoDeProductosRepository.save(grupoDeProductos);
    }

    public List<GrupoDeProductos> getAllGrupos() {
        return grupoDeProductosRepository.findAll();
    }
    
    public GrupoDeProductos getGrupoById(Long id) {
        return grupoDeProductosRepository.findById(id).orElse(null);
    }
}