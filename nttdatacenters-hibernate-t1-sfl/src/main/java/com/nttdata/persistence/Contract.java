package com.nttdata.persistence;

import java.time.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Contract")
public class Contract extends AbstractEntity{

	public Contract(LocalDate vigencyDate, LocalDate expiracyDate, long price, Client client) {
		this.vigencyDate = vigencyDate;
		this.expiracyDate = expiracyDate;
		this.price = price;
		this.client = client;
	}

	public Contract() {
		
	}
	
	

	/** ID contrato (PK) */
	@Id
	@Column(name = "contractId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** Fecha de vigencia */
	@Column(name = "vigencyDate")
	@DateTimeFormat(pattern ="dd/MM/yyyy")
	private LocalDate vigencyDate;
	
	/** Fecha de expiración */
	
	@Column(name = "expiracyDate")
	@DateTimeFormat(pattern ="dd/MM/yyyy")
	private LocalDate expiracyDate;
	
	
	/** Precio */
	@Column(name = "price")
	private long price;
	
	/** Cliente (FK) */
	@ManyToOne
	@JoinColumn(name="client")
	private Client client;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getVigencyDate() {
		return vigencyDate;
	}

	public void setVigencyDate(LocalDate vigencyDate) {
		this.vigencyDate = vigencyDate;
	}

	public LocalDate getExpiracyDate() {
		return expiracyDate;
	}

	public void setExpiracyDate(LocalDate expiracyDate) {
		this.expiracyDate = expiracyDate;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id) + " " + vigencyDate.toString() + " " + expiracyDate.toString() + " " + String.valueOf(price) + " " + String.valueOf(client.getId()); 
	}
}
