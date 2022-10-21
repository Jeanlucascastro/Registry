package com.artrede.registry.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.artrede.registry.entities.enums.BudgetStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_budget")
public class Budget implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;	
	private String person;
	private String contact;
	
	private Integer budgetStatus;

	@ManyToOne
	@JoinColumn(name = "place_id")
	private Suite place;
	
	@OneToMany(mappedBy = "id.budget")
	private Set<BudgetItem> items = new HashSet<>();
	

	@OneToOne(mappedBy = "budget", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Budget() {

	}

	public Budget(Long id, Instant moment, BudgetStatus budgetStatus, String person, String contact, Suite place) {
		super();
		this.id = id;
		this.moment = moment;
		setBudgetStatus(budgetStatus);
		this.person = person;
		this.contact = contact;
		this.place = place;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}
	

	public BudgetStatus getBudgetStatus() {
		return BudgetStatus.valueOf(budgetStatus) ;
	}

	public void setBudgetStatus(BudgetStatus budgetStatus) {
		if (budgetStatus != null) {
			this.budgetStatus = budgetStatus.getCode();
		}
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Suite getPlace() {
		return place;
	}

	public void setPlace(Suite place) {
		this.place = place;
	}
	
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<BudgetItem> getItems() {
		return items;
	}

	public Double getTotal() {
		double sum = 0.0;
		for (BudgetItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(budgetStatus, contact, id, moment, person, place);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Budget other = (Budget) obj;
		return Objects.equals(budgetStatus, other.budgetStatus) && Objects.equals(contact, other.contact)
				&& Objects.equals(id, other.id) && Objects.equals(moment, other.moment)
				&& Objects.equals(person, other.person) && Objects.equals(place, other.place);
	}

	
	
}
