package com.example.demo.model;

import java.util.Date;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//@Entity
public class Person {

	// @Id
	// @GeneratedValue
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private Date birth;

	private String address;

	private String phone;

	private String email;

	private String profession;

	public Person() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", profession=" + profession + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Object[] loadSaveParameters() {
		return new Object[] { this.name, this.birth, this.address, this.phone, this.email, this.profession };
	}

	public Object[] loadUpdateParameters() {
		return new Object[] { this.name, this.birth, this.address, this.phone, this.email, this.profession, this.id };
	}
}
