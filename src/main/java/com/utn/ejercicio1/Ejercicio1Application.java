package com.utn.ejercicio1;

import com.utn.ejercicio1.entidades.*;
import com.utn.ejercicio1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class Ejercicio1Application {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);

		System.out.println("Estoy funcando");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo){
		return args -> {
			System.out.println("Esto está corriendo en un Bean");

			//Definición Cliente
			Cliente cliente1 = new Cliente();

			cliente1.setNombre("Franco");
			cliente1.setApellido("Veggiani");
			cliente1.setTelefono("+123456789");

			//Definición Domicilios
			Domicilio domicilio1 = new Domicilio();
			domicilio1.setCalle("Calle 123");
			domicilio1.setNumero("123");
			domicilio1.setLocalidad("localidad loca");

			cliente1.addDomicilio(domicilio1);

			Domicilio domicilio2 = new Domicilio();

			domicilio2.setCalle("Calle 123");
			domicilio2.setNumero("123");
			domicilio2.setLocalidad("localidad loca");

			cliente1.addDomicilio(domicilio2);

			//Definición pedido
			Pedido pedido1 = new Pedido();

			LocalDate fechaEjemplo = LocalDate.of(2023, 9, 7);

			pedido1.setEstado("Iniciado");
			pedido1.setFecha(LocalDate.of(2023, 9, 7));
			pedido1.setTipoEnvio("Delivery");
			pedido1.setTotal(525.5);

			cliente1.addPedido(pedido1);

			//Definición factura
			Factura factura1 = new Factura();

			factura1.setNumero(1);
			factura1.setFecha(LocalDate.of(2023, 9, 7));
			factura1.setFormaDePago("MP");
			factura1.setTotal(2550);
			factura1.setDescuento(2550 * 0.25);

			pedido1.setFactura(factura1);

			//Definición DetallePedido
			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(5);
			detallePedido.setSubtotal(25.0);

			pedido1.addDetallePedido(detallePedido);

			DetallePedido detallePedido1 = new DetallePedido();

			detallePedido1.setCantidad(5);
			detallePedido1.setSubtotal(25.0);

			pedido1.addDetallePedido(detallePedido1);

			//Definición Producto
			Producto producto = new Producto();

			producto.setTipo("Manufacturado");
			producto.setTiempoEstimadoCocina(25);
			producto.setDenominacion("Hamburguesa Primavera");
			producto.setPrecioVenta(1000.50);
			producto.setPrecioCompra(500);
			producto.setStockActual(50);
			producto.setStockMinimo(20);
			producto.setUnidadMedida("Unidades");
			producto.setReceta("Pan, lechuga, huevo, tomate, rucula, queso, carne");

			detallePedido.setProducto(producto);

			detallePedido1.setProducto(producto);

			//Definición Rubro
			Rubro rubro = new Rubro();

			rubro.setDenominacion("Hamburguesas");
			rubro.addProducto(producto);

			productoRepository.save(producto);
			rubroRepository.save(rubro);
			facturaRepository.save(factura1);
			pedidoRepository.save(pedido1);
			clienteRepository.save(cliente1);

		};
	}



}