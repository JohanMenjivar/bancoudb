package com.udb.productosBancarios.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDeProductos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaquete;

    private String nombrePaquete;
    private String descripcion;

    @OneToMany(mappedBy = "grupoDeProductos")
    @JsonBackReference
    private List<Cliente> clientes;

    public GrupoDeProductos(Long idPaquete) {
        this.idPaquete = idPaquete;
    }
}