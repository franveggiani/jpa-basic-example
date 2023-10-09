package com.utn.ejercicio1.repositorios;

import com.utn.ejercicio1.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
