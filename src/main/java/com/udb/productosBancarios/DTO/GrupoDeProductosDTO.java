package com.udb.productosBancarios.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDeProductosDTO {
    private Long idPaquete;
    private String nombrePaquete;
    private String descripcion;

    // Getters y Setters
}