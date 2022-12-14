package com.nttdata.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.nttdata.utiles.ZoneIndicator;

/**
 * Clase Order
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class Order {

	// Identificador del pedido
	private Long id;

	// Destinatario del pedido
	private String receiver;

	// Direccion de entrega del pedido
	private String deliveryAddress;

	// Indicador de la zona de envio
	private ZoneIndicator zoneIndicator;

	// Descripcion de la incidencia en caso de cancelacion, lo que provoca el
	// vaciado de la lista de productos
	private String incidentDescription;

	// Productos asociados a este pedido
	private List<Product> products;

	/**
	 * Metodo constructor de Order
	 * 
	 * @param id
	 * @param receiver
	 * @param deliveryAddress
	 * @param zoneIndicator
	 */
	public Order(Long id, String receiver, String deliveryAddress, ZoneIndicator zoneIndicator) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.deliveryAddress = deliveryAddress;
		this.zoneIndicator = zoneIndicator;
		this.incidentDescription = "";
		this.products = new ArrayList<>();
	}

	/**
	 * Metodo Get del id de pedido
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo Set del id de pedido
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo Get del destinatario de pedido
	 * 
	 * @return
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Metodo Set del destinatario de pedido
	 * 
	 * @param receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Metodo Get de la direccion de pedido
	 * 
	 * @return
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * Metodo Set del la direccion de pedido
	 * 
	 * @param deliveryAddress
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * Metodo Get del indicador de la zona de pedido
	 * 
	 * @return
	 */
	public ZoneIndicator getZoneIndicator() {
		return zoneIndicator;
	}

	/**
	 * Metodo Set del indicador de la zona de pedido
	 * 
	 * @param zoneIndicator
	 */
	public void setZoneIndicator(ZoneIndicator zoneIndicator) {
		this.zoneIndicator = zoneIndicator;
	}

	/**
	 * Metodo Get de la descripcion de incidencia de pedido
	 * 
	 * @return
	 */
	public String getIncidentDescription() {
		return incidentDescription;
	}

	/**
	 * Metodo Set de la descripcion de incidencia de pedido
	 * 
	 * @param incidentDescription
	 */
	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	/**
	 * Metodo Get de la lista de productos vinculados al pedido
	 * 
	 * @return
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Metodo Set de la lista de productos vinculados al pedido
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * Metodo para anyadir producto a la lista de productos de pedido
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		if (!this.products.contains(product)) {
			this.products.add(product);
		}

	}

	/**
	 * Metodo para obtener el valor total del pedido
	 * 
	 * @return
	 */
	public Double getTotalPrice() {
		Double totalPrice = 0.0;
		for (Product p : this.getProducts()) {
			totalPrice += p.getPvpPrice();
		}
		return totalPrice;
	}

	/**
	 * Metodo para vaciar la lista de productos
	 */
	public void removeProducts() {
		this.products.clear();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", receiver=" + receiver + ", deliveryAddress=" + deliveryAddress
				+ ", zoneIndicator=" + zoneIndicator + ", incidentDescription=" + incidentDescription + ", products="
				+ products + "]";
	}

}
