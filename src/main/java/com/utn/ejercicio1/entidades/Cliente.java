package com.utn.ejercicio1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Domicilio> domicilios = new ArrayList<>();

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Pedido> pedidos = new ArrayList<>();

    public void addDomicilio(Domicilio domicilio){
        this.domicilios.add(domicilio);
    }

    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

}
