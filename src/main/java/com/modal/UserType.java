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
@Table(name = "user_type")
@Getter
@Setter
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_type_id")
	private Long userTypeId;

	@Column(name = "type", unique = true)
	private String type;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private Boolean isActive;

	@OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
	private List<User> users;

}
