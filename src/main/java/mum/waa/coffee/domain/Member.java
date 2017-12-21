package mum.waa.coffee.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	@NotEmpty
	@Email
	private String email;

	private String phone;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	@Valid
	UserCredentials userCredentials;

	public Member() {
	}

	public Member(String username, String firstName, String lastName, String email, String phone, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + ", address=" + address + ", phone='" + phone + '\'' + '}';
	}
}
