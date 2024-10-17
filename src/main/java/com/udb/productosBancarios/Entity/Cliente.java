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

    // Campos de ingresos
    private double salario;
    private double negocioPropio;
    private double pensiones;
    private double remesas;
    private double ingresosVarios;

    // Campos de egresos
    private double alquilerHipoteca;
    private double canastaBasica;
    private double financiamientos;
    private double transporte;
    private double serviciosPublicos;
    private double saludSeguro;
    private double egresosVarios;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    @JsonManagedReference
    private GrupoDeProductos grupoDeProductos;
    private boolean activado=false;
}