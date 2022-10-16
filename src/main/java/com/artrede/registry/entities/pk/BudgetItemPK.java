package com.artrede.registry.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.artrede.registry.entities.Budget;
import com.artrede.registry.entities.Casement;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BudgetItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "budget_id")
	private Budget budget;
	
	@ManyToOne
	@JoinColumn(name = "casement_id")
	private Casement casemente;
	
	
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public Casement getCasement() {
		return casemente;
	}
	public void setCasement(Casement casemente) {
		this.casemente = casemente;
	}
	@Override
	public int hashCode() {
		return Objects.hash(budget, casemente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BudgetItemPK other = (BudgetItemPK) obj;
		return Objects.equals(budget, other.budget) && Objects.equals(casemente, other.casemente);
	}
	
	
}
