package com.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "mobile", unique = true)
	private String mobile;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "status")
	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "user_type_id", nullable = false)
	private UserType userType;

	@Transient
	private Long userTypeId;

}
