package com.utn.ejercicio1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String denominacion;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Producto> productos = new ArrayList();

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }
}
