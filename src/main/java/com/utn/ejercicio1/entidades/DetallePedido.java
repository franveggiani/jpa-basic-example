package com.utn.ejercicio1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cantidad;
    private double subtotal;
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;
}
