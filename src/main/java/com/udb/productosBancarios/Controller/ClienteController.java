package com.udb.productosBancarios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.udb.productosBancarios.DTO.ClienteDTO;
import com.udb.productosBancarios.Entity.Cliente;
import com.udb.productosBancarios.Entity.GrupoDeProductos;
import com.udb.productosBancarios.Service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombreCompleto(clienteDTO.getNombreCompleto());
        cliente.setFotografiaCarnet(clienteDTO.getFotografiaCarnet());
        cliente.setFotografiaSelfie(clienteDTO.getFotografiaSelfie());
        cliente.setInformacionDireccion(clienteDTO.getInformacionDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setIdParaNotificacionPush(clienteDTO.getIdParaNotificacionPush());
        cliente.setGrupoDeProductos(new GrupoDeProductos(clienteDTO.getIdPaquete()));

        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }
    
 // Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteService.getClienteById(id);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        clienteExistente.setNombreCompleto(clienteDTO.getNombreCompleto());
        clienteExistente.setFotografiaCarnet(clienteDTO.getFotografiaCarnet());
        clienteExistente.setFotografiaSelfie(clienteDTO.getFotografiaSelfie());
        clienteExistente.setInformacionDireccion(clienteDTO.getInformacionDireccion());
        clienteExistente.setTelefono(clienteDTO.getTelefono());
        clienteExistente.setIdParaNotificacionPush(clienteDTO.getIdParaNotificacionPush());
        clienteExistente.setGrupoDeProductos(new GrupoDeProductos(clienteDTO.getIdPaquete()));

        return ResponseEntity.ok(clienteService.saveCliente(clienteExistente));
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Cliente clienteExistente = clienteService.getClienteById(id);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/activar")
    public ResponseEntity<Cliente> activarCliente(@PathVariable Long id, @RequestParam boolean activado) {
        Cliente clienteExistente = clienteService.getClienteById(id);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        clienteExistente.setActivado(activado);
        return ResponseEntity.ok(clienteService.saveCliente(clienteExistente));
    }
}