package com.modal;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long carId;

	@Column(name = "brand")
	private String brand;

	@Column(name = "model")
	private String model;

	@Column(name = "registration_number", unique = true)
	private String registrationNumber;

	@Column(name = "launch_date")
	@CreationTimestamp
	private LocalDateTime launchDate;

	@ManyToOne
	@JoinColumn(name = "fuel_type_id", nullable = false)
	private FuelType fuelType;

	@Column(name = "mileage")
	private Double mileage;

	@Column(name = "air_bags_count")
	private Integer airBagsCount;

	@Column(name = "status")
	private Boolean isActive;

	@OneToOne
	@JoinColumn(name = "rental_rate_id", nullable = false)
	private RentalRate rentalRate;

}
