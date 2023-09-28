package main;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Veiculo")
public class Vehicle {
	
	@Id
	@GeneratedValue
	@Column(name ="codigo")
	private Integer id;
	
	@Column(name ="modelo", nullable = false)
	private String model;
	
	@Column(name ="fabricante", nullable = false)
	private String manufactorer;
	
	@Column(name ="plate", nullable = false)
	private String plate;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
	private User owner;
	
	@OneToOne(mappedBy = "veiculos")
	private ParkingSpace parkingSpace;
	
	public Vehicle() {
		
	}

	
	public Vehicle(Integer id, String model, String manufactorer, String plate) {
		super();
		this.id = id;
		this.model = model;
		this.manufactorer = manufactorer;
		this.plate = plate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufactorer() {
		return manufactorer;
	}

	public void setManufactorer(String manufactorer) {
		this.manufactorer = manufactorer;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}


}
