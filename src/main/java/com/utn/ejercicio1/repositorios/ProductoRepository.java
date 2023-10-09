package com.utn.ejercicio1.repositorios;

import com.utn.ejercicio1.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
