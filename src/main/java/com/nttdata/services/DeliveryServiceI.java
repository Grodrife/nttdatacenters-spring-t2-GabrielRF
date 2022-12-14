package com.nttdata.services;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;
import com.nttdata.utiles.ZoneIndicator;

/**
 * Interfaz para el servicio general de envio
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface DeliveryServiceI {

	/**
	 * Metodo para crear un pedido segun la zona de envio
	 * 
	 * @param id
	 * @param recipient
	 * @param deliveryAddress
	 * @return
	 */
	public Order createOrder(Long id, String recipient, String deliveryAddress);

	/**
	 * Metodo para anyadir un producto a un pedido
	 * 
	 * @param product
	 * @param order
	 */
	public void addProductToAnOrder(Product product, Order order);

	/**
	 * Metodo para cancelar un pedido
	 * 
	 * @param order
	 */
	public void breakdownOrder(Order order);
}
