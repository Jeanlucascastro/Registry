package com.artrede.registry.entities;

import java.io.Serializable;
import java.util.Objects;

import com.artrede.registry.entities.pk.BudgetItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_budget_item")
public class BudgetItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BudgetItemPK id = new BudgetItemPK();
	
	private Integer quantity;
	private Double price;
	
	public BudgetItem() {
		
	}

	public BudgetItem(Budget budget, Casement casement, Integer quantity, Double price) {
		super();
		id.setBudget(budget);
		id.setCasement(casement);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Budget getBudget() {
		return id.getBudget();
	}
	
	public void setBudget(Budget budget) {
		id.setBudget(budget);
	}
	
	public Casement getCasement() {
		return id.getCasement();
	}
	
	public void setCasement(Casement casement) {
		id.setCasement(casement);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Double getSubTotal() {
		return quantity * price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BudgetItem other = (BudgetItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
