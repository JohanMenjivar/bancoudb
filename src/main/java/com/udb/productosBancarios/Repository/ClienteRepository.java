package com.udb.productosBancarios.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.udb.productosBancarios.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}


