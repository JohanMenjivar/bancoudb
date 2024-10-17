package com.udb.productosBancarios.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nombreCompleto;
    private String fotografiaCarnet;
    private String fotografiaSelfie;
    private String informacionDireccion;
    private String telefono;
    private String idParaNotificacionPush;
    private Long idPaquete;

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
}