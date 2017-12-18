package org.hareram.springboot.pricemodule.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory_tbl")
public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="item_code")
	private int itemCode;
	@Column(name="hsn_code")
	private int hsnCode;
	@Column(name="item_desc")
	private String itemDesc;
	@Column(name="quantity")
	private double quantity;
	@Column(name="item_type")
	private String itemType;
	@Column(name="wholesale_price")
	private double wholesalePrice;
	@Column(name="brand_name")
	private String brandName;
	@Column(name="brand_disp_order")
	private int brandDispOrder;
	@Column(name="item_disp_order")
	private int itemDispOrder;

	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public int getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(int hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public double getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getBrandDispOrder() {
		return brandDispOrder;
	}
	public void setBrandDispOrder(int brandDispOrder) {
		this.brandDispOrder = brandDispOrder;
	}
	public int getItemDispOrder() {
		return itemDispOrder;
	}
	public void setItemDispOrder(int itemDispOrder) {
		this.itemDispOrder = itemDispOrder;
	}
	
}
