package main;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name ="codigo")
	private Integer id;
	
	@Column(name ="nome", nullable = false)
	private String name;
	
	@Column(name ="usuario", nullable = false)
	private String userName;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
	private List<Vehicle> veiculos = new ArrayList<>();
	
	public List<Vehicle> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Vehicle> veiculos) {
		this.veiculos = veiculos;
	}

	@Column(name ="senha", nullable = false)
	private String password;
	
	
	public void addVeicle(Vehicle vehicle) {
		veiculos.add(vehicle);
		vehicle.setOwner(this);
	}
	
	public User() {
		
	}

	public User(Integer id, String name, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
