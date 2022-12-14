package com.nttdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;
import com.nttdata.services.DeliveryServiceI;
import com.nttdata.utiles.ZoneIndicator;

@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {

	// Creacion del servicio de envio para peninsula
	@Autowired
	@Qualifier("peninsularDelivery")
	private DeliveryServiceI peninsularService;

	// Creacion del servicio de envio para comunidades especiales
	@Autowired
	@Qualifier("specialCommunityDelivery")
	private DeliveryServiceI specialCommunityService;

	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creacion de pedidos
		Order o1 = peninsularService.createOrder(1L, "Manuel Gutierrez", "Calle Imaginaria 2");
		Order o2 = specialCommunityService.createOrder(2L, "Lucia Benitez", "Calle Sierpes 6");

		// Creacion de productos
		Product p1 = new Product(1L, "Teclado", 16.43);
		Product p2 = new Product(2L, "Cable USB", 1.54);
		Product p3 = new Product(3L, "Auriculares", 13.32);
		Product p4 = new Product(4L, "Raton", 25.43);

		// Gestion del precio segun la zona de envio
		calculatePrice(o1, p1);
		calculatePrice(o1, p3);
		calculatePrice(o2, p2);
		calculatePrice(o2, p4);

		// Muestra de los precios totales de cada pedido
		System.out.println(o1.getTotalPrice());
		System.out.println(o2.getTotalPrice());

		// Reporte de incidencia en un pedido
		specialCommunityService.breakdownOrder(o2);
	}

	/**
	 * Metodo para calcular el precio de venta al publico de un producto segun su
	 * zona de envio
	 * 
	 * @param order
	 * @param product
	 */
	public void calculatePrice(Order order, Product product) {
		if (order.getZoneIndicator().equals(ZoneIndicator.PENINSULA)) {
			peninsularService.addProductToAnOrder(product, order);
		} else {
			specialCommunityService.addProductToAnOrder(product, order);
		}
	}
}
