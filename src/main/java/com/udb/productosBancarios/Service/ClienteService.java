package com.udb.productosBancarios.Service;
import org.springframework.stereotype.Service;

import com.udb.productosBancarios.Entity.Cliente;
import com.udb.productosBancarios.Repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}