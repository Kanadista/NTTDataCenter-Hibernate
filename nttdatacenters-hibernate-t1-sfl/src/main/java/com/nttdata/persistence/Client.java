package com.nttdata.persistence;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Client")
public class Client extends AbstractEntity{

	/** ID cliente (PK) */
	@Id
	@Column(name = "clientId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	/** Nombre cliente */
	@Column(name = "clientName")
	private String clientName;

	/** Apellido cliente */
	@Column(name = "lastName")
	private String lastName;

	/** DNI cliente */
	@Column(name = "dni",nullable = false, unique=true, length=9)
	private String dni;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<Contract> contractList;

	public Client(String name, String lastName, String dni) {
		this.clientName = name;
		this.lastName = lastName;
		this.dni = dni;
	}

	public Client() {
	
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return clientName;
	}

	public void setName(String name) {
		this.clientName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return clientName + " " + lastName + " " + dni;
	}
}
