package com.udb.productosBancarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udb.productosBancarios.Entity.GrupoDeProductos;

public interface GrupoDeProductosRepository extends JpaRepository<GrupoDeProductos, Long> {
}