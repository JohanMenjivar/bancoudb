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

    // Getters y Setters
}