package com.modal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rental_rate")
@Getter
@Setter
public class RentalRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_rate_id")
	private Long rentalRateId;

	@Column(name = "daily_rate")
	private Double dailyRate;

	@Column(name = "weekly_rate")
	private Double weeklyRate;

	@Column(name = "monthly_rate")
	private Double monthlyRate;

	@Column(name = "yearly_rate")
	private Double yearlyRate;

}
