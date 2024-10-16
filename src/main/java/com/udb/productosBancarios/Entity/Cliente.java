package com.udb.productosBancarios.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombreCompleto;
    
    @Lob
    private String fotografiaCarnet; // Almacena la imagen en formato Base64
    
    @Lob
    private String fotografiaSelfie; // Almacena la imagen en formato Base64
    
    private String informacionDireccion;
    private String telefono;
    private String idParaNotificacionPush;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    @JsonManagedReference
    private GrupoDeProductos grupoDeProductos;
    private boolean activado=false;

    // Getters y Setters
}