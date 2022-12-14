package com.nttdata.services;

import org.springframework.stereotype.Service;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;
import com.nttdata.utiles.ZoneIndicator;

/**
 * Implementacion del servicio de envio para los pedidos de la peninsula
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@Service("peninsularDelivery")
public class PeninsularDeliveryImpl implements DeliveryServiceI {

	@Override
	public Order createOrder(Long id, String receiver, String deliveryAddress) {
		return new Order(id, receiver, deliveryAddress, ZoneIndicator.PENINSULA);
	}

	@Override
	public void addProductToAnOrder(Product product, Order order) {
		product.setPvpPrice(product.getFreeTaxPrice() * 1.21);
		order.addProduct(product);
	}

	@Override
	public void breakdownOrder(Order order) {
		order.setIncidentDescription("El pedido ha sido cancelado.");
		order.removeProducts();
		System.out.println("El pedido con id " + order.getId() + " ha sido cancelado");
	}

}
