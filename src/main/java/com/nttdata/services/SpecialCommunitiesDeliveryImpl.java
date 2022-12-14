package com.nttdata.services;

import org.springframework.stereotype.Service;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;
import com.nttdata.utiles.ZoneIndicator;

/**
 * Implementacion del servicio de envio para los pedidos de las comunidades especiales(Ceuta,
 * Melilla, Canarias)
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@Service("specialCommunityDelivery")
public class SpecialCommunitiesDeliveryImpl implements DeliveryServiceI {

	@Override
	public Order createOrder(Long id, String receiver, String deliveryAddress) {
		return new Order(id, receiver, deliveryAddress, ZoneIndicator.COMUNIDAD_ESPECIAL);
	}

	@Override
	public void addProductToAnOrder(Product product, Order order) {
		product.setPvpPrice(product.getFreeTaxPrice() * 1.04);
		order.addProduct(product);
	}

	@Override
	public void breakdownOrder(Order order) {
		order.setIncidentDescription("El pedido ha sido cancelado.");
		order.removeProducts();
		System.out.println("El pedido con id " + order.getId() + " ha sido cancelado");
	}

}
