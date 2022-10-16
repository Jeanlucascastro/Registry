package com.artrede.registry.entities.enums;

import org.hibernate.metamodel.relational.IllegalIdentifierException;

public enum BudgetStatus {
	
	PENDENT(1),
	DONE(2),
	WAITING_PAYMENT(3),
	CANCELED(4);
	
	private int code;
	
	private BudgetStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static BudgetStatus valueOf(int code) {
		for (BudgetStatus value : BudgetStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalIdentifierException("Codigo Invalido");
	}
}
