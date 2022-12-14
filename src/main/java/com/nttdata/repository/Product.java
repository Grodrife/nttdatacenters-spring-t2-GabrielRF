package com.nttdata.repository;

import java.util.Objects;

/**
 * Clase Product
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class Product {

	// Identificador del producto
	private Long id;

	// Nombre del producto
	private String name;

	// Precio de venta del producto
	private Double pvpPrice;

	// Precio de venta sin impuesto del producto
	private Double freeTaxPrice;

	/**
	 * Metodo constructor de Product
	 * 
	 * @param id
	 * @param name
	 * @param freeTaxPrice
	 */
	public Product(Long id, String name, Double freeTaxPrice) {
		super();
		this.id = id;
		this.name = name;
		this.freeTaxPrice = freeTaxPrice;
	}

	/**
	 * Metodo Get del id del producto
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo Set del id del producto
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo Get del nombre del producto
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo Set del nombre del producto
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo Get del precio de venta del producto
	 * 
	 * @return
	 */
	public Double getPvpPrice() {
		return pvpPrice;
	}

	/**
	 * Metodo Set del precio de venta del producto
	 * 
	 * @param pvpPrice
	 */
	public void setPvpPrice(Double pvpPrice) {
		this.pvpPrice = pvpPrice;
	}

	/**
	 * Metodo Get del precio de venta sin impuestos del producto
	 * 
	 * @return
	 */
	public Double getFreeTaxPrice() {
		return freeTaxPrice;
	}

	/**
	 * Metodo Set del precio de venta sin impuestos del producto
	 * 
	 * @param freeTaxPrice
	 */
	public void setFreeTaxPrice(Double freeTaxPrice) {
		this.freeTaxPrice = freeTaxPrice;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", pvpPrice=" + pvpPrice + ", freeTaxPrice=" + freeTaxPrice
				+ "]";
	}

}
