package com.modal;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fuel_type")
@Getter
@Setter
public class FuelType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fuel_type_id")
	private Long fuelTypeId;

	// Petrol , Diesel , Electric , CNG
	@Column(name = "type", unique = true)
	private String type;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private Boolean isActive;

	@OneToMany(mappedBy = "fuelType", cascade = CascadeType.ALL)
	private List<Car> cars;

}
